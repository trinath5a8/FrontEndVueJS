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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lc.sk.inventory.security.beans.PricesTable;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.PricesTableRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class PricesTableService {
	
	@Autowired
	PricesTableRestService pricesTableRestService;
	HttpHeaders header = new HttpHeaders();
	
	@PostMapping(path = URLMapping.PRICES_TABLE_PATH)
	@ResponseBody	
	public ResponseEntity<ResponseBean> insertPrices(
			@RequestParam(name=ConstantValues.MRP, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String mrp,
			@RequestParam(name=ConstantValues.PRODUCT_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String productid,
			@RequestParam(name=ConstantValues.lC_PRICE, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String lcPrice,
			@RequestParam(name=ConstantValues.TAX, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String tax,
			@RequestParam(name=ConstantValues.SELLING_PRICE, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String sellingPrice,
			@RequestParam(name=ConstantValues.FINAL_PRICE, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String finalPrice)
			{
		ResponseBean responseBean = pricesTableRestService.insertprices(mrp, productid,lcPrice,tax,sellingPrice,finalPrice);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);	
	}
	
	@PutMapping(path = URLMapping.PRICES_TABLE_PATH)
	@ResponseBody	
	public ResponseEntity<ResponseBean> updatePrices(
			@RequestParam(name=ConstantValues.PRICE_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String priceId,
			@RequestParam(name=ConstantValues.MRP, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String mrp,
			@RequestParam(name=ConstantValues.PRODUCT_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String productid,
			@RequestParam(name=ConstantValues.lC_PRICE, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String lcPrice,
			@RequestParam(name=ConstantValues.TAX, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String tax,
			@RequestParam(name=ConstantValues.SELLING_PRICE, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String sellingPrice,
			@RequestParam(name=ConstantValues.FINAL_PRICE, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String finalPrice)
			{
		ResponseBean responseBean = pricesTableRestService.updateprices(priceId,mrp, productid,lcPrice,tax,sellingPrice,finalPrice);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);	
	}
	
	@GetMapping(URLMapping.PRICES_TABLE_PATH_WITH_ID)
	@ResponseBody
	public ResponseEntity<PricesTable> getById(@PathVariable String productid)
	{
		PricesTable prices = pricesTableRestService.getpricebyid(productid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<PricesTable>(prices, header, HttpStatus.OK);
	}
	
	@GetMapping(URLMapping.PRICES_TABLE_PATH)
	@ResponseBody
	public ResponseEntity<List<PricesTable>> getallprices()
	{
		List<PricesTable> prices = pricesTableRestService.getallprices();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<PricesTable>>(prices, header, HttpStatus.OK);
	}
}
