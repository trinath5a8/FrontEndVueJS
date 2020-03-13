package com.lc.sk.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lc.sk.inventory.bean.ResponseBean;
import com.lc.sk.inventory.entities.Color;
import com.lc.sk.inventory.exception.subexception.ColorException;
import com.lc.sk.inventory.exception.subexception.DBInsertException;
import com.lc.sk.inventory.exception.subexception.NullRequestReceivedException;
import com.lc.sk.inventory.repositories.ColorRepository;
import com.lc.sk.inventory.util.ConstantValues;
import com.lc.sk.inventory.util.HeaderComponent;
import com.lc.sk.inventory.util.SecurityHttpStatus;
import com.lc.sk.inventory.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(path = URLMapping.INVENTORY_ROOT_PATH)
public class ColorService {

	@Autowired
	ColorRepository colorRepository;

	@Autowired
	HeaderComponent hearders;

	@GetMapping(path = URLMapping.COLOR_PATH)
	@ResponseBody
	public ResponseEntity<List<Color>> getAllColorList() {
		List<Color> colors = (List<Color>) colorRepository.findAll();
		if (!colors.isEmpty()) {

			return new ResponseEntity<List<Color>>(colors, hearders.getHeader(), HttpStatus.ACCEPTED);

		} else {
			throw new ColorException(ConstantValues.COLOR_DETAILS_NOT_FOUND);
		}

	}

	@GetMapping(path = URLMapping.COLOR_PATH_WITH_COLOR_ID)
	@ResponseBody
	public ResponseEntity<Optional<Color>> getAllColorList(@PathVariable long colorid) {
		Optional<Color> colors = colorRepository.findById(colorid);
		if (!colors.isPresent() || colors.get() == null) {
			throw new ColorException(ConstantValues.COLOR_DETAILS_NOT_FOUND);
		} else {
			return new ResponseEntity<Optional<Color>>(colors, hearders.getHeader(), HttpStatus.ACCEPTED);
		}
	}

	@PostMapping(path = URLMapping.COLOR_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertColor(
			@RequestParam(name = ConstantValues.COLOR_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String colorname,
			@RequestParam(name = ConstantValues.HASHCODE, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String hashcode
	) {
		if (colorname.equals(ConstantValues.DEFAULT_STRING) || hashcode.equals(ConstantValues.DEFAULT_STRING)) {
			throw new NullRequestReceivedException(ConstantValues.RECEIVED_NULL_VALUES);
		}

		else {
			Color col = colorRepository.save(new Color(colorname, hashcode));
			if (col.getColorname() == colorname) {
				ResponseBean responseBean = new ResponseBean(ConstantValues.DATA_INSERTED_IN_DB,
						SecurityHttpStatus.ACCEPTED, System.currentTimeMillis());

				return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
			} else {
				throw new DBInsertException(ConstantValues.DATA_NOT_INSERTED_IN_DB);
			}

		}
	}

	@PutMapping(path = URLMapping.COLOR_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateColorDetails(
			@RequestParam(name = ConstantValues.COLOR_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING) long colorid,
			@RequestParam(name = ConstantValues.COLOR_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String colorname,
			@RequestParam(name = ConstantValues.HASHCODE, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String hashcode) {
		Optional<Color> colors = colorRepository.findById(colorid);
		if (colors.isPresent()) {
			colors.get().setColorname(colorname);
			colors.get().setHashcode(hashcode);
			Color color1 =colorRepository.save(colors.get());

			if (color1.getColorid() == colorid) {
				ResponseBean responseBean1 = new ResponseBean(ConstantValues.DATA_UPDATED_IN_DB,
						SecurityHttpStatus.ACCEPTED, System.currentTimeMillis());
				return new ResponseEntity<ResponseBean>(responseBean1, hearders.getHeader(), HttpStatus.ACCEPTED);
			} else {
				throw new DBInsertException(ConstantValues.DATA_NOT_UPDATED_IN_DB);
			}

		} else {
			throw new ColorException(ConstantValues.COLOR_ID_DETAILS_NOT_FOUND);
		}
	}
}
