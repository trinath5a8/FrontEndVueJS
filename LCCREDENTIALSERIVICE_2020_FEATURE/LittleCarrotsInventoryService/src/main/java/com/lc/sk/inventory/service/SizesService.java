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
import com.lc.sk.inventory.entities.Sizes;
import com.lc.sk.inventory.exception.subexception.DBInsertException;
import com.lc.sk.inventory.exception.subexception.NullRequestReceivedException;
import com.lc.sk.inventory.exception.subexception.SizeNotFoundException;
import com.lc.sk.inventory.repositories.SizesRepository;
import com.lc.sk.inventory.util.ConstantValues;
import com.lc.sk.inventory.util.HeaderComponent;
import com.lc.sk.inventory.util.SecurityHttpStatus;
import com.lc.sk.inventory.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(path = URLMapping.INVENTORY_ROOT_PATH)
public class SizesService {

	@Autowired
	SizesRepository sizesRepository;

	@Autowired
	HeaderComponent hearders;

	// Get size by id
	@GetMapping(path = URLMapping.SIZE_BY_ID)
	@ResponseBody
	public ResponseEntity<Optional<Sizes>> getsizebyid(@PathVariable long sizeid) {
		Optional<Sizes> sizes = sizesRepository.findById(sizeid);
		if (sizes.isPresent()) {
			return new ResponseEntity<Optional<Sizes>>(sizes, hearders.getHeader(), HttpStatus.ACCEPTED);
		} else {
			throw new SizeNotFoundException(ConstantValues.SIZES_NOT_FOUND_EXCEPTION);
		}

	}

	// Get list of Sizes
	@GetMapping(path = URLMapping.SIZES)
	@ResponseBody
	public ResponseEntity<List<Sizes>> getAllSizes() {
		List<Sizes> sizes = (List<Sizes>) sizesRepository.findAll();
		if (sizes.isEmpty()) {
			throw new SizeNotFoundException(ConstantValues.SIZES_NOT_FOUND_EXCEPTION);
		} else {
			return new ResponseEntity<List<Sizes>>(sizes, hearders.getHeader(), HttpStatus.ACCEPTED);
		}
	}	
	
	
	// Insert sizes
	@PostMapping(path = URLMapping.SIZES)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertsize(
			@RequestParam(name = ConstantValues.AGE_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) String ageid,
			@RequestParam(name = ConstantValues.GENDER, required = true, defaultValue = ConstantValues.DEFAULT_INT) String gender,
			@RequestParam(name = ConstantValues.SIZE_NO, required = true, defaultValue = ConstantValues.DEFAULT_INT) String sizeno,
			@RequestParam(name = ConstantValues.HEIGHT, required = true, defaultValue = ConstantValues.DEFAULT_INT) String height,
			@RequestParam(name = ConstantValues.WEIGHT, required = true, defaultValue = ConstantValues.DEFAULT_INT) String weight,
			@RequestParam(name = ConstantValues.CHEST, required = true, defaultValue = ConstantValues.DEFAULT_INT) String chest,
			@RequestParam(name = ConstantValues.WAIST, required = true, defaultValue = ConstantValues.DEFAULT_INT) String waist,
			@RequestParam(name = ConstantValues.HIP, required = true, defaultValue = ConstantValues.DEFAULT_INT) String hip) {
		System.err.println("In 44");
		if (ageid.equals(ConstantValues.DEFAULT_INT) || sizeno.equals(ConstantValues.DEFAULT_INT)
				|| height.equals(ConstantValues.DEFAULT_INT) || weight.equals(ConstantValues.DEFAULT_INT)
				|| chest.equals(ConstantValues.DEFAULT_INT) || hip.equals(ConstantValues.DEFAULT_INT) || gender.equals(ConstantValues.DEFAULT_INT)) {
			System.err.println("In 53");
			throw new NullRequestReceivedException(ConstantValues.RECEIVED_NULL_VALUES);
		} else {
			System.err.println("In 58");
			Sizes sizes = sizesRepository.save(new Sizes(ageid,gender, sizeno, height, weight, chest, waist, hip));

			if (sizes.getAgeid() == ageid) {
				ResponseBean responseBean = new ResponseBean(ConstantValues.DATA_INSERTED_IN_DB,
						SecurityHttpStatus.ACCEPTED, System.currentTimeMillis());
				return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
			} else {
				System.err.println("In 69");
				throw new DBInsertException(ConstantValues.DATA_NOT_INSERTED_IN_DB);
			}
		}

	}

	// Update by id
	@PutMapping(path = URLMapping.SIZES)
	@ResponseBody
	public ResponseEntity<ResponseBean> updatesize(
			@RequestParam(name = ConstantValues.SIZE_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long sizeid,
			@RequestParam(name = ConstantValues.AGE_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) String ageid,
			@RequestParam(name = ConstantValues.GENDER, required = true, defaultValue = ConstantValues.DEFAULT_INT) String gender,
			@RequestParam(name = ConstantValues.SIZE_NO, required = true, defaultValue = ConstantValues.DEFAULT_INT) String sizeno,
			@RequestParam(name = ConstantValues.HEIGHT, required = true, defaultValue = ConstantValues.DEFAULT_INT) String height,
			@RequestParam(name = ConstantValues.WEIGHT, required = true, defaultValue = ConstantValues.DEFAULT_INT) String weight,
			@RequestParam(name = ConstantValues.CHEST, required = true, defaultValue = ConstantValues.DEFAULT_INT) String chest,
			@RequestParam(name = ConstantValues.WAIST, required = true, defaultValue = ConstantValues.DEFAULT_INT) String waist,
			@RequestParam(name = ConstantValues.HIP, required = true, defaultValue = ConstantValues.DEFAULT_INT) String hip) {
		Optional<Sizes> sizes = sizesRepository.findById(sizeid);
		if (sizes.isPresent()) {
			sizes.get().setAgeid(ageid);
			sizes.get().setSizeno(sizeno);
			sizes.get().setHeight(height);
			sizes.get().setWeight(weight);
			sizes.get().setChest(chest);
			sizes.get().setWaist(waist);
			sizes.get().setHip(hip);
			sizes.get().setGender(gender);
			Sizes size = sizesRepository.save(sizes.get());

			if (size.getAgeid() == ageid) {
				ResponseBean responseBean = new ResponseBean(ConstantValues.DATA_UPDATED_IN_DB,
						SecurityHttpStatus.ACCEPTED, System.currentTimeMillis());
				return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
			} else {
				throw new DBInsertException(ConstantValues.DATA_NOT_UPDATED_IN_DB);
			}
		} else {
			throw new SizeNotFoundException(ConstantValues.SIZES_NOT_FOUND_EXCEPTION);
		}
	}



}
