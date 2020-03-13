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

import com.lc.sk.inventory.security.beans.NoOfPieces;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.NoOfPiecesRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class NoOfPiecesService {

	@Autowired
	NoOfPiecesRestService   noOfPiecesRestService;
	
HttpHeaders header = new HttpHeaders();
	
	@PostMapping(URLMapping.NO_OF_PIECES_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertNoOfPiecesList(
			@RequestParam(name = ConstantValues.PRODUCT_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String productid,
			@RequestParam(name = ConstantValues.NOOFSETS, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String noofset
			)
	{
		ResponseBean responseBean = noOfPiecesRestService.insertNoOfPiecesList(productid,noofset);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(URLMapping.NO_OF_PIECES_PATH)
	@ResponseBody
	public ResponseEntity<List<NoOfPieces>> getAllNoOfPieces(
			)
	{
		List<NoOfPieces> responseBean = noOfPiecesRestService.getAllNoOfPieces();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<NoOfPieces>>(responseBean, header, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(URLMapping.NO_OF_PIECES_PATH_WITH_ID)
	@ResponseBody
	public ResponseEntity<NoOfPieces> getNoOfPiecesId(@PathVariable String pieceid)
			
	{
		NoOfPieces responseBean = noOfPiecesRestService.getNoOfPiecesId(pieceid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<NoOfPieces>(responseBean, header, HttpStatus.ACCEPTED);
	}
	
	@PutMapping(URLMapping.NO_OF_PIECES_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> update(
			@RequestParam(name = ConstantValues.PIECE_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String pieceid,
			@RequestParam(name = ConstantValues.PRODUCT_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String productid,
			@RequestParam(name = ConstantValues.NOOFSETS, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String noofset)
	{
		ResponseBean responseBean = noOfPiecesRestService.update(pieceid,productid,noofset);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
