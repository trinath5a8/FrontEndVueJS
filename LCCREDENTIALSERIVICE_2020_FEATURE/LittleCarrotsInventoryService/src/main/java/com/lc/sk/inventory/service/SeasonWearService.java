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

import com.lc.sk.inventory.repositories.SeasonWearRepository;
import com.lc.sk.inventory.util.ConstantValues;
import com.lc.sk.inventory.util.HeaderComponent;
import com.lc.sk.inventory.util.SecurityHttpStatus;
import com.lc.sk.inventory.util.URLMapping;
import com.lc.sk.inventory.bean.ResponseBean;
import com.lc.sk.inventory.entities.SeasonWear;
import com.lc.sk.inventory.exception.subexception.DBInsertException;
import com.lc.sk.inventory.exception.subexception.NullRequestReceivedException;
import com.lc.sk.inventory.exception.subexception.SeasonWearNotFoundException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(path = URLMapping.INVENTORY_ROOT_PATH)
public class SeasonWearService {

	@Autowired
	SeasonWearRepository seasonWearRepository;

	@Autowired
	HeaderComponent hearders;

	// Get Season wear by id
	@GetMapping(path = URLMapping.SEASON_WEAR_BY_ID)
	@ResponseBody
	public ResponseEntity<Optional<SeasonWear>> getSeasonWearbyId(@PathVariable long seasonId) {
		Optional<SeasonWear> seasonWear = seasonWearRepository.findById(seasonId);
		if (seasonWear.isPresent()) {
			return new ResponseEntity<Optional<SeasonWear>>(seasonWear, hearders.getHeader(), HttpStatus.ACCEPTED);
		} else {
			throw new SeasonWearNotFoundException(ConstantValues.SEASONWEAR_NOT_FOUND_EXCEPTION);
		}
	}

	// Get all Season wears
	@GetMapping(path = URLMapping.SEASON_WEAR)
	@ResponseBody
	public ResponseEntity<List<SeasonWear>> getAllSeasonWear() {
		List<SeasonWear> seasonWear = (List<SeasonWear>) seasonWearRepository.findAll();
		if (seasonWear.isEmpty()) {
			throw new SeasonWearNotFoundException(ConstantValues.SEASONWEAR_NOT_FOUND_EXCEPTION);
		} else {
			return new ResponseEntity<List<SeasonWear>>(seasonWear, hearders.getHeader(), HttpStatus.ACCEPTED);
		}
	}

	// Insert season wear
	@PostMapping(path = URLMapping.SEASON_WEAR)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertSeasonWear(
			@RequestParam(name = ConstantValues.SUB_CAT_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long subcatId,
			@RequestParam(name = ConstantValues.SEASON, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String season) {
		if (subcatId == new Long(ConstantValues.DEFAULT_INT).longValue() || season.equals(ConstantValues.NULL_STRING)) {
			throw new NullRequestReceivedException(ConstantValues.RECEIVED_NULL_VALUES);
		} else {
			SeasonWear seasonWear = new SeasonWear(season, subcatId);
			seasonWear = seasonWearRepository.save(seasonWear);
			if (seasonWear.getSubcatId() == subcatId) {
				ResponseBean responseBean = new ResponseBean(ConstantValues.DATA_INSERTED_IN_DB,
						SecurityHttpStatus.ACCEPTED, System.currentTimeMillis());
				return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
			} else {
				throw new DBInsertException(ConstantValues.DATA_NOT_INSERTED_IN_DB);
			}
		}

	}

	// Update Season wear
	@PutMapping(path = URLMapping.SEASON_WEAR)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateSeasonWear(
			@RequestParam(name = ConstantValues.SEASON_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long seasonId,
			@RequestParam(name = ConstantValues.SUB_CAT_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long subcatId,
			@RequestParam(name = ConstantValues.SEASON, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String season) {
		Optional<SeasonWear> seasonWear = seasonWearRepository.findById(seasonId);
		if (seasonWear.isPresent()) {
			seasonWear.get().setSubcatId(subcatId);
			seasonWear.get().setSeason(season);
			SeasonWear wear = seasonWearRepository.save(seasonWear.get());

			if (wear.getSubcatId() == subcatId) {
				ResponseBean responseBean = new ResponseBean(ConstantValues.DATA_UPDATED_IN_DB,
						SecurityHttpStatus.ACCEPTED, System.currentTimeMillis());
				return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
			} else {
				throw new DBInsertException(ConstantValues.DATA_NOT_UPDATED_IN_DB);
			}

		} else {
			throw new SeasonWearNotFoundException(ConstantValues.SEASONWEAR_NOT_FOUND_EXCEPTION);
		}
	}

}
