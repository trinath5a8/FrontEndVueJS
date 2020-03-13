/**
 * 
 */
package com.lc.sk.auth.service;

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

import com.lc.sk.auth.entities.Seller;
import com.lc.sk.auth.exceptions.subexceptions.DBValueInsertException;
import com.lc.sk.auth.exceptions.subexceptions.NullRequestReceivedException;
import com.lc.sk.auth.exceptions.subexceptions.SellerNotFoundException;
import com.lc.sk.auth.rbeans.ResponseBean;
import com.lc.sk.auth.repositories.SellerRepository;
import com.lc.sk.auth.util.ConstantVariables;
import com.lc.sk.auth.util.HeaderComponent;
import com.lc.sk.auth.util.SecurityHttpStatus;
import com.lc.sk.auth.util.URLMapping;

/**
 * @author Mastanvali Shaik LittleCarrotsAuthenticationService 2020
 */


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(path = URLMapping.AUTHORIZATION_ROOT_PATH)
public class SellerService {

	@Autowired
	SellerRepository sellerRepository;

	@Autowired
	private HeaderComponent headers;

	public SellerService() {
	}

	@PostMapping(URLMapping.SELLER_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertSeller(
			@RequestParam(name = ConstantVariables.SELLER_COMPANY_NAME, required = true, defaultValue = ConstantVariables.DEFAULT_STRING_VALUE) String sellercompanyname,
			@RequestParam(name = ConstantVariables.SELLER_NAME, required = true, defaultValue = ConstantVariables.DEFAULT_STRING_VALUE) String sellername,
			@RequestParam(name = ConstantVariables.PHONE_NUMBER, required = true, defaultValue = ConstantVariables.DEFAULT_INT_VALUE) long phonenumber,
			@RequestParam(name = ConstantVariables.EMAIL, required = true, defaultValue = ConstantVariables.DEFAULT_STRING_VALUE) String email,
			@RequestParam(name = ConstantVariables.ADDRESS, required = true, defaultValue = ConstantVariables.DEFAULT_STRING_VALUE) String address,
			@RequestParam(name = ConstantVariables.ISOCODE, required = true, defaultValue = ConstantVariables.DEFAULT_STRING_VALUE) String isocode,
			@RequestParam(name = ConstantVariables.STATUS, required = true, defaultValue = ConstantVariables.DEFAULT_BOOLEAN) boolean status) {
		ResponseBean responseBean = new ResponseBean();

		//System.out.println("CN:"+sellercompanyname+"\nSN:"+sellername+"\nph:"+phonenumber+"\nE:"+email+"\nAd:"+address+"\nIC:"+isocode+"\nStatus:"+status);
		if (sellercompanyname.equals(ConstantVariables.DEFAULT_STRING_VALUE)
				|| sellername.equals(ConstantVariables.DEFAULT_STRING_VALUE)
				|| phonenumber == new Long(ConstantVariables.DEFAULT_INT_VALUE).longValue()
				|| email.equals(ConstantVariables.DEFAULT_STRING_VALUE)
				|| address.equals(ConstantVariables.DEFAULT_STRING_VALUE)
				|| isocode.equals(ConstantVariables.DEFAULT_STRING_VALUE)
				) {
			throw new NullRequestReceivedException(ConstantVariables.NULL_VALUES_RECEIVED_FROM_CLIENT);
		} else {
			Seller seller = new Seller(sellername, sellercompanyname, phonenumber, address, email, isocode, status);
			seller = sellerRepository.save(seller);
			if (seller.getSellercompanyname().equals(sellercompanyname)) {
				responseBean.setMessage(ConstantVariables.NEW_SELLER_INSERTED_SUCCESS);
				responseBean.setResponsecode(SecurityHttpStatus.ACCEPTED);
				responseBean.setTiemstamp(System.currentTimeMillis());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			} else {
				throw new DBValueInsertException(ConstantVariables.NEW_SELLER_INSERTED_FAILED);
			}
		}

	}

	@GetMapping(URLMapping.SELLER_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<List<Seller>> getAllSellers() {
		List<Seller> sellers = (List<Seller>) sellerRepository.findAll();
		if (sellers.size() > 0) {
			return new ResponseEntity<List<Seller>>(sellers, headers.getHeader(), HttpStatus.ACCEPTED);
		} else {
			throw new SellerNotFoundException(ConstantVariables.SELLER_NOT_FOUND);
		}
	}

	@GetMapping(URLMapping.SELLER_MAPPING_PATH_PATH_VARIABLE)
	@ResponseBody
	public ResponseEntity<Optional<Seller>> getSelectedSellers(@PathVariable Long sellerid) {
		Optional<Seller> sellers = sellerRepository.findById(sellerid);
		if (!sellers.isPresent()||sellers.get().getSellercompanyname() == null) {
			throw new SellerNotFoundException(ConstantVariables.SELLER_NOT_FOUND);
			
		} else {
			return new ResponseEntity<Optional<Seller>>(sellers, headers.getHeader(), HttpStatus.ACCEPTED);
		}
	}

	@PutMapping(URLMapping.SELLER_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateSellers(
			@RequestParam(name = ConstantVariables.SELLER_ID, required = true, defaultValue = ConstantVariables.DEFAULT_STRING_VALUE) long sellerid,
			@RequestParam(name = ConstantVariables.SELLER_COMPANY_NAME, required = true, defaultValue = ConstantVariables.DEFAULT_STRING_VALUE) String sellercompanyname,
			@RequestParam(name = ConstantVariables.SELLER_NAME, required = true, defaultValue = ConstantVariables.DEFAULT_STRING_VALUE) String sellername,
			@RequestParam(name = ConstantVariables.PHONE_NUMBER, required = true, defaultValue = ConstantVariables.DEFAULT_INT_VALUE) long phonenumber,
			@RequestParam(name = ConstantVariables.EMAIL, required = true, defaultValue = ConstantVariables.DEFAULT_STRING_VALUE) String email,
			@RequestParam(name = ConstantVariables.ADDRESS, required = true, defaultValue = ConstantVariables.DEFAULT_STRING_VALUE) String address,
			@RequestParam(name = ConstantVariables.ISOCODE, required = true, defaultValue = ConstantVariables.DEFAULT_STRING_VALUE) String isocode,
			@RequestParam(name = ConstantVariables.STATUS, required = true, defaultValue = ConstantVariables.DEFAULT_BOOLEAN) boolean status) {
		ResponseBean responseBean = new ResponseBean();
		System.err.println("At 125");
		Optional<Seller> sellers = sellerRepository.findById(sellerid);
		System.err.println("At 127:"+sellers.get());
		if (sellers.get().getSellercompanyname() != null) {
			System.err.println("At 129");
			sellers.get().setSellername(sellername);
			sellers.get().setSellercompanyname(sellercompanyname);
			sellers.get().setPhone(phonenumber);
			sellers.get().setEmail(email);
			sellers.get().setAddress(address);
			sellers.get().setIsocode(isocode);
			sellers.get().setStatus(status);
System.err.println("Calling save function...137...");
			Seller seller = sellerRepository.save(sellers.get());
			if (seller.getSellercompanyname().equals(sellercompanyname)) {
				responseBean.setMessage(ConstantVariables.SELLER_UPDATE_SUCCESS);
				responseBean.setResponsecode(SecurityHttpStatus.ACCEPTED);
				responseBean.setTiemstamp(System.currentTimeMillis());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			else
			{
				throw new DBValueInsertException(ConstantVariables.SELLER_UPDATE_FAILED);
			}
		} else {
			throw new SellerNotFoundException(ConstantVariables.SELLER_NOT_FOUND);
		}
	}
}
