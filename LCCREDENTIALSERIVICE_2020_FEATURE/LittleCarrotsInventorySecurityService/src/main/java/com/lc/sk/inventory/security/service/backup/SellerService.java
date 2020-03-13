/**
 * 
 */
package com.lc.sk.inventory.security.service.backup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.beans.Seller;
import com.lc.sk.inventory.security.rest.SellerRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsInventorySecurityService
 * 2020
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.SELLER_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class SellerService {

	HttpHeaders header = new HttpHeaders();
	
	@Autowired
	private SellerRestService sellerRestService;
	
	@GetMapping(URLMapping.SELLER_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<Seller>> getAllSellers()
	{
		List<Seller> sellers = sellerRestService.getAllSellerDetails();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<Seller>>(sellers, header, HttpStatus.OK);
	}
	
	@GetMapping(URLMapping.SELLER_GET_PATH_WITH_VARIABLE)
	@ResponseBody
	public ResponseEntity<Seller> getAllSellers(Long sellerid)
	{
		Seller sellers = sellerRestService.getSellerById(sellerid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<Seller>(sellers, header, HttpStatus.OK);
	}
	
	@PostMapping(URLMapping.SELLER_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insert(
			@RequestParam(name = ConstantValues.SELLER_COMPANY_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String sellercompanyname,
			@RequestParam(name = ConstantValues.SELLER_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String sellername,
			@RequestParam(name = ConstantValues.PHONE_NUMBER, required = true, defaultValue = ConstantValues.DEFAULT_INT_VALUE) String phonenumber,
			@RequestParam(name = ConstantValues.EMAIL, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String email,
			@RequestParam(name = ConstantValues.ADDRESS, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String address,
			@RequestParam(name = ConstantValues.ISOCODE, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String isocode,
			@RequestParam(name = ConstantValues.STATUS, required = true, defaultValue = ConstantValues.DEFAULT_INT_VALUE) boolean status)
	{
		ResponseBean responseBean = sellerRestService.insertSeller(sellercompanyname, sellername, phonenumber, email, address, isocode, status);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
	
	@PutMapping(URLMapping.SELLER_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateSellerDetails(@RequestBody Seller seller)
	{
		ResponseBean responseBean = sellerRestService.updateSeller(seller.getSellerid()+"",seller.getSellercompanyname(), seller.getSellername(), seller.getPhone()+"", seller.getEmail(),
				seller.getAddress(), seller.getIsocode(), seller.getStatus()+"");
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.ACCEPTED);
	}
	
}
