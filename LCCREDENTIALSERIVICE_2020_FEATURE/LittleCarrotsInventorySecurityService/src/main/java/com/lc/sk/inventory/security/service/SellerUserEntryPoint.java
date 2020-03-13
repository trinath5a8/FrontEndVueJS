package com.lc.sk.inventory.security.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lc.sk.inventory.security.beans.Authorization;
import com.lc.sk.inventory.security.beans.Batch;
import com.lc.sk.inventory.security.beans.Categories;
import com.lc.sk.inventory.security.beans.Color;
import com.lc.sk.inventory.security.beans.Countries;
import com.lc.sk.inventory.security.beans.Genders;
import com.lc.sk.inventory.security.beans.Materialcomposition;
import com.lc.sk.inventory.security.beans.Materialtypes;
import com.lc.sk.inventory.security.beans.NewBatch;

import com.lc.sk.inventory.security.beans.NewCategory;
import com.lc.sk.inventory.security.beans.NewColor;
import com.lc.sk.inventory.security.beans.NewMaterialtypes;
import com.lc.sk.inventory.security.beans.NewSellerBean;
import com.lc.sk.inventory.security.beans.NewSubCategory;
import com.lc.sk.inventory.security.beans.NoOfPieces;
import com.lc.sk.inventory.security.beans.NoOfPiecesPost;
import com.lc.sk.inventory.security.beans.OccasionalWear;
import com.lc.sk.inventory.security.beans.OccasionalWearBean;
import com.lc.sk.inventory.security.beans.Patterns;
import com.lc.sk.inventory.security.beans.PatternsPOSTBean;
import com.lc.sk.inventory.security.beans.PricesTable;
import com.lc.sk.inventory.security.beans.PricesTablePost;
import com.lc.sk.inventory.security.beans.ProductAge;
import com.lc.sk.inventory.security.beans.ProductDescriptions;
import com.lc.sk.inventory.security.beans.ProductDescriptionsPost;
import com.lc.sk.inventory.security.beans.ProductQuantities;
import com.lc.sk.inventory.security.beans.ProductQuantitiesPost;
import com.lc.sk.inventory.security.beans.ProductType;
import com.lc.sk.inventory.security.beans.ProductTypePost;
import com.lc.sk.inventory.security.beans.Products;
import com.lc.sk.inventory.security.beans.ProductsPost;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.beans.SeasonWear;
import com.lc.sk.inventory.security.beans.SeasonWearNew;
import com.lc.sk.inventory.security.beans.Seller;
import com.lc.sk.inventory.security.beans.SellerToWarehouseBean;
import com.lc.sk.inventory.security.beans.SellerUsers;
import com.lc.sk.inventory.security.beans.Sizes;
import com.lc.sk.inventory.security.beans.SizesNew;
import com.lc.sk.inventory.security.beans.SubCategories;
import com.lc.sk.inventory.security.beans.UrlsList;
import com.lc.sk.inventory.security.rest.AuthorizationRestService;
import com.lc.sk.inventory.security.rest.BatchRestService;
import com.lc.sk.inventory.security.rest.CategoriesRestService;
import com.lc.sk.inventory.security.rest.ColorRestService;
import com.lc.sk.inventory.security.rest.CountriesRestService;
import com.lc.sk.inventory.security.rest.GendersRestService;
import com.lc.sk.inventory.security.rest.MaterialcompositionRestService;
import com.lc.sk.inventory.security.rest.MaterialtypesRestService;
import com.lc.sk.inventory.security.rest.NoOfPiecesRestService;
import com.lc.sk.inventory.security.rest.OccasionalWearRestService;
import com.lc.sk.inventory.security.rest.PatternsRestService;
import com.lc.sk.inventory.security.rest.PricesTableRestService;
import com.lc.sk.inventory.security.rest.ProductAgeRestService;
import com.lc.sk.inventory.security.rest.ProductDescriptionsRestService;
import com.lc.sk.inventory.security.rest.ProductTypeRestService;
import com.lc.sk.inventory.security.rest.ProductquantitiesRestService;
import com.lc.sk.inventory.security.rest.ProductsRestService;
import com.lc.sk.inventory.security.rest.SalesSellerRestService;
import com.lc.sk.inventory.security.rest.SeasonWearRestService;
import com.lc.sk.inventory.security.rest.SellerRestService;
import com.lc.sk.inventory.security.rest.SellerToWarehouseRestService;
import com.lc.sk.inventory.security.rest.SizesRestService;
import com.lc.sk.inventory.security.rest.SubCategoriesRestService;

import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.HeaderComponent;
import com.lc.sk.inventory.security.util.URLMapping;
import com.lc.sk.inventory.security.util.SellerUserURLMapping;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = SellerUserURLMapping.SELLER_USER_ENTRY_POINT_ROOT_PATH+URLMapping.VERSION)
public class SellerUserEntryPoint {
	
	@Autowired
	private HeaderComponent header;
	@Autowired
	BatchRestService batchRestService;
	@Autowired
	CategoriesRestService categoriesRestService;
	@Autowired
	ColorRestService colorRestService;
	@Autowired
	CountriesRestService countriesRestService;
	@Autowired
	GendersRestService gendersRestService;
	@Autowired
	MaterialcompositionRestService materialcompositionRestService;
	@Autowired
	MaterialtypesRestService materialtypesRestService;
	@Autowired
	NoOfPiecesRestService   noOfPiecesRestService;
	@Autowired
	OccasionalWearRestService occasionalwearRestService;
	@Autowired
	PatternsRestService patternsRestService;
	@Autowired
	PricesTableRestService pricesTableRestService;
	@Autowired
	ProductAgeRestService   productAgeRestService;
	@Autowired
	ProductDescriptionsRestService productDescriptionsRestService;
	@Autowired
	ProductquantitiesRestService productquantitiesRestService;
	@Autowired
	ProductsRestService productsRestService;
	@Autowired
	ProductTypeRestService producttypeRestService;
	@Autowired
	private SalesSellerRestService salesSellerRestService;
	@Autowired
	SeasonWearRestService seasonwearRestService;
	@Autowired
	SellerToWarehouseRestService sellerToWarehouseRestService;
	@Autowired
	SizesRestService sizesRestService;
	@Autowired
	SubCategoriesRestService subcategoriesRestService;
	@Autowired
	private AuthorizationRestService authorizationRestService;
	@Autowired
	private SellerRestService sellerRestService;
	
	//Batches start here
	@PostMapping(SellerUserURLMapping.SELLER_BATCHES_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertNewBatch(@RequestBody NewBatch nb)
	{
		ResponseBean responseBean = batchRestService.insertBatch(nb.getWarehouseid(),  nb.getDateofpurchase(),  nb.getPurchasedby(),  nb.getInvamount(),
				 nb.getWhoinserted(),  nb.getStatus(),  nb.getIsocode(),  nb.getQty(), nb.getSellerid());
		return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
	}

	
	@GetMapping(SellerUserURLMapping.SELLER_BATCHES_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<Batch>> getAllBatchList()
	{
		List<Batch> batches = batchRestService.getAllBatchList();
		return new ResponseEntity<List<Batch>>(batches, header.getHeader(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(SellerUserURLMapping.SELLER_BATCHES_MAPPING_PATH_WITH_PATH_VARIABLE)
	@ResponseBody
	public ResponseEntity<Batch> getBatchById(@PathVariable String batchid)
	{
		Batch batch = batchRestService.getBatchById(batchid);
		return new ResponseEntity<Batch>(batch, header.getHeader(), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(SellerUserURLMapping.SELLER_BATCHID_PUT_PATH_WITH_VARIABLE)
    @ResponseBody
    public ResponseEntity<ResponseBean> updateBatch(@PathVariable String batchid, @PathVariable String status)
    {
           ResponseBean responseBean = batchRestService.updateBatch(batchid, status);
           return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
    }

	
	//Batches end here
	
	//Categories start here
	@PostMapping(SellerUserURLMapping.SELLER_CATEGORIES_MAPPING_PATH)
    @ResponseBody
    public ResponseEntity<ResponseBean> insertNewCategory(@RequestBody NewCategory nc)
    {
    	 ResponseBean responseBean = categoriesRestService.addCategory(nc.getCategory(), nc.getGender());
			return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);	
	 }

	@PutMapping(SellerUserURLMapping.SELLER_CATEGORIES_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> update(@RequestBody Categories cat)
	{
		ResponseBean responseBean = categoriesRestService.update(cat.getCatid()+"",cat.getCategory()+"",cat.getGender()+""); 
		return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
	}
	 
	    @GetMapping(SellerUserURLMapping.SELLER_CATEGORIES_MAPPING_PATH_WITH_ID)
		@ResponseBody
		public ResponseEntity<Categories> getById(@PathVariable String catid)
		{
		 Categories categories = categoriesRestService.getById(catid);
			return new ResponseEntity<Categories>(categories, header.getHeader(), HttpStatus.ACCEPTED);
		}
	 
	    @GetMapping(SellerUserURLMapping.SELLER_CATEGORIES_MAPPING_PATH)
		@ResponseBody
		public ResponseEntity<List<Categories>> getAllCategories()
		{
	    	List<Categories> categories = categoriesRestService.getAllCategories();
			return new ResponseEntity<List<Categories>>(categories, header.getHeader(), HttpStatus.ACCEPTED);
		}
	    
	  //Categories end here
	  //Color start here
	    @PostMapping(SellerUserURLMapping.SELLER_COLOR_PATH)
	  		@ResponseBody
	  		public ResponseEntity<ResponseBean> insertNewColor(@RequestBody NewColor nc)
	  		{
	  			ResponseBean responseBean = colorRestService.insertNewColor(nc.getColorname(), nc.getHashcode());
	  			return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
	  		}
		
	    @PutMapping(SellerUserURLMapping.SELLER_COLOR_PATH)
		@ResponseBody
		public ResponseEntity<ResponseBean> updateColor(@RequestBody Color color)
		{
			ResponseBean responseBean = colorRestService.updateColor(color.getColorid()+"",color.getColorname(),color.getHashcode());
			return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
		}
		
		@GetMapping(SellerUserURLMapping.SELLER_COLOR_PATH)
		@ResponseBody
		public ResponseEntity<List<Color>> getAllColors(
				)
		{
			List<Color> responseBean = colorRestService.getAllColors();
			return new ResponseEntity<List<Color>>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
		}
		
		
		@GetMapping(SellerUserURLMapping.SELLER_COLOR_PATH_WITH_COLOR_ID)
		@ResponseBody
		public ResponseEntity<Color> getColorById(@PathVariable String colorid)
				
		{
			Color responseBean = colorRestService.getColorById(colorid);
			return new ResponseEntity<Color>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
		}
		//Color end here
		/*Countries start here*/
		@GetMapping(SellerUserURLMapping.SELLER_COUNTRY_GET_PATH)
		@ResponseBody
		public ResponseEntity<List<Countries>> getAllCountries()
		{
			List<Countries> countries = countriesRestService.getAllCountries();
			return new ResponseEntity<List<Countries>>(countries, header.getHeader(), HttpStatus.ACCEPTED);
		}
		
		@GetMapping(SellerUserURLMapping.SELLER_COUNTRY_GET_PATH_WITH_VARIABLE)
		@ResponseBody
		public ResponseEntity<Countries> getCountryById(@PathVariable String isocode)
		{
			Countries country = countriesRestService.getCountryById(isocode);
			return new ResponseEntity<Countries>(country, header.getHeader(), HttpStatus.ACCEPTED);
		}
		//activecountries
		@GetMapping(SellerUserURLMapping.SELLER_COUNTRY_ACTIVE_GET)
		@ResponseBody
		public ResponseEntity<List<Countries>> getActivecountries()
		{
			List<Countries> countries = countriesRestService.getActiveCountries();
			return new ResponseEntity<List<Countries>>(countries, header.getHeader(), HttpStatus.ACCEPTED);
		}
		
		/*Countries end here*/
		//Gender start here
		@GetMapping(SellerUserURLMapping.SELLER_GENDERS_GET_PATH)
		@ResponseBody
		public ResponseEntity<List<Genders>> getAllGendersDetails()
		{
			List<Genders> genders = gendersRestService.getAllGendersDetails();
			return new ResponseEntity<List<Genders>>(genders, header.getHeader(), HttpStatus.ACCEPTED);
		}
		
		@GetMapping(SellerUserURLMapping.SELLER_GENDERS_MAPPING_PATH_WITH_PATH_VARIABLE)
		@ResponseBody
		public ResponseEntity<Genders> getGenderById(@PathVariable String genderid)
		{
			Genders genders = gendersRestService.getGenderById(genderid);
			return new ResponseEntity<Genders>(genders, header.getHeader(), HttpStatus.ACCEPTED);
		}
		//Gender end here
		//MaterialComposition start here
		@GetMapping(SellerUserURLMapping.SELLER_MATERIALCOMP_GET_PATH)
		@ResponseBody
		public ResponseEntity<List<Materialcomposition>> getAllMaterialcomposition()
		{
			List<Materialcomposition> materialcomposition = materialcompositionRestService.getAllMaterialcomposition();
			return new ResponseEntity<List<Materialcomposition>>(materialcomposition, header.getHeader(), HttpStatus.ACCEPTED);
		}
		
		@GetMapping(SellerUserURLMapping.SELLER_MATERIALCOMPOSITION_GET_PATH_WITH_VARIABLE)
		@ResponseBody
		public ResponseEntity<Materialcomposition> getMaterialcompositionById(@PathVariable String materialid)
		{
			Materialcomposition materialcomposition = materialcompositionRestService.getMaterialcompositionById(materialid);
			return new ResponseEntity<Materialcomposition>(materialcomposition, header.getHeader(), HttpStatus.ACCEPTED);
		}
		@PostMapping(SellerUserURLMapping.SELLER_MATERIALCOMP_GET_PATH)
		@ResponseBody
		public ResponseEntity<ResponseBean> insertMaterialcomposition(@RequestBody Materialcomposition matcomp)
						
		{
			ResponseBean responseBean = materialcompositionRestService.insertMaterialcomposition(matcomp.getMaterialid() +"", matcomp.getDescription()+"");
			return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
		}

		 @PutMapping(SellerUserURLMapping.SELLER_MATERIALCOMP_GET_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> updateMaterialcomposition(@RequestBody Materialcomposition matcomp)
			{
				ResponseBean responseBean = materialcompositionRestService.updateMaterialcomposition(matcomp.getMaterialid()+"",matcomp.getDescription());
				return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
			}
		//MaterialComposition end here
		//MaterialTypes start here
		@GetMapping(SellerUserURLMapping.SELLER_MATERIAL_GET_PATH)
		@ResponseBody
		public ResponseEntity<List<Materialtypes>> getAllMaterialtypes()
		{
			List<Materialtypes> materialtypes = materialtypesRestService.getAllMaterialtypes();
			return new ResponseEntity<List<Materialtypes>>(materialtypes, header.getHeader(), HttpStatus.ACCEPTED);
		}


		@GetMapping(SellerUserURLMapping.SELLER_MATERIALTYPE_GET_PATH_WITH_VARIABLE)
		@ResponseBody
		public ResponseEntity<Materialtypes> getMaterialtypeById(@PathVariable String materialid)
		{
			Materialtypes materialtypes = materialtypesRestService.getMaterialtypeById(materialid);
			return new ResponseEntity<Materialtypes>(materialtypes, header.getHeader(), HttpStatus.ACCEPTED);
		}
		
		@PostMapping(SellerUserURLMapping.SELLER_MATERIAL_GET_PATH)
		@ResponseBody
		public ResponseEntity<ResponseBean> insertMaterialtype(@RequestBody NewMaterialtypes mattypes)
						
		{
			ResponseBean responseBean = materialtypesRestService.insertMaterialtype(mattypes.getMaterialname() +"", mattypes.getDescription()+"",mattypes.getOcid()+"",mattypes.getSeasonid()+"",mattypes.getCatid()+"");
			return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
		}
		
		@PutMapping(SellerUserURLMapping.SELLER_MATERIAL_GET_PATH)
		@ResponseBody
		public ResponseEntity<ResponseBean> updateMaterialtype(@RequestBody Materialtypes mattypes)
		{
			ResponseBean responseBean = materialtypesRestService.updateMaterialtype(mattypes.getMaterialid()+"",mattypes.getMaterialname()+"" , mattypes.getDescription()+"",mattypes.getOcid()+"",mattypes.getSeasonid()+"",mattypes.getCatid()+"");
			return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
		}
		//MaterialTypes end here
	
		//NoOfPeices start here
		@PostMapping(SellerUserURLMapping.SELLER_NO_OF_PIECES_PATH)
		@ResponseBody
		public ResponseEntity<ResponseBean> insertNoOfPiecesList(@RequestBody NoOfPiecesPost npp)
		{
			ResponseBean responseBean = noOfPiecesRestService.insertNoOfPiecesList(npp.getProductid()+"",npp.getNoofset()+"");
			return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
		}
		
		@GetMapping(SellerUserURLMapping.SELLER_NO_OF_PIECES_PATH)
		@ResponseBody
		public ResponseEntity<List<NoOfPieces>> getAllNoOfPieces(
				)
		{
			List<NoOfPieces> responseBean = noOfPiecesRestService.getAllNoOfPieces();
			return new ResponseEntity<List<NoOfPieces>>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
		}
		
		@GetMapping(SellerUserURLMapping.SELLER_NO_OF_PIECES_PATH_WITH_ID)
		@ResponseBody
		public ResponseEntity<NoOfPieces> getNoOfPiecesId(@PathVariable String pieceid)
				
		{
			NoOfPieces responseBean = noOfPiecesRestService.getNoOfPiecesId(pieceid);
			return new ResponseEntity<NoOfPieces>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
		}
		
		@PutMapping(SellerUserURLMapping.SELLER_NO_OF_PIECES_PATH)
		@ResponseBody
		public ResponseEntity<ResponseBean> updatePeices(@RequestBody NoOfPieces np)
		{
			ResponseBean responseBean = noOfPiecesRestService.update(np.getPieceid()+"",np.getProductid()+"",np.getNoofset()+"");
			return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
		}
		//NoOfPeices end here
		//OcassionalWear starts here
				@GetMapping(SellerUserURLMapping.SELLER_OCCASIONALWEAR_PATH)
				@ResponseBody
				public ResponseEntity<List<OccasionalWear>> getAllOccasionalWearDetails()
				{
					List<OccasionalWear> occasionalwear = occasionalwearRestService.getAllOccasionalWearDetails();
					return new ResponseEntity<List<OccasionalWear>>(occasionalwear, header.getHeader(), HttpStatus.ACCEPTED);
				}
				
				
				@GetMapping(SellerUserURLMapping.SELLER_OCCASIONALWEAR_PATH_WITH_ID)
				@ResponseBody
				public ResponseEntity<OccasionalWear> getOccasionalWearById(@PathVariable String occasionid)
				{
					OccasionalWear occasionalwear = occasionalwearRestService.getOccasionalWearById(occasionid);
					return new ResponseEntity<OccasionalWear>(occasionalwear, header.getHeader(), HttpStatus.ACCEPTED);
				}
				
				@PostMapping(SellerUserURLMapping.SELLER_OCCASIONALWEAR_PATH)
				@ResponseBody
				public ResponseEntity<ResponseBean> insertOcassionalWear(@RequestBody OccasionalWearBean OWB)		
				{
					ResponseBean responseBean = occasionalwearRestService.InsertOccasionalWearDetails(OWB.getOccaname(),OWB.getSubcatid()+"");
					return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
				}
				
				@PutMapping(SellerUserURLMapping.SELLER_OCCASIONALWEAR_PATH)
				@ResponseBody
				public ResponseEntity<ResponseBean> update	(@RequestBody OccasionalWear OW)
				{
						ResponseBean responseBean = occasionalwearRestService.UpdateOccasionalWearDetails(OW.getOccasionid()+"",OW.getOccaname(),OW.getSubcatid()+"");
						return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
					}
				
				//OcassionalWear end here
		//PatternsService Start here
				@GetMapping(SellerUserURLMapping.SELLER_PATTERNS_PATH)
				@ResponseBody
				public ResponseEntity<List<Patterns>> getAllPatternsDetails()
				{
					List<Patterns>  patterns = patternsRestService.getAllPatternsDetails();
					return new ResponseEntity<List<Patterns>>( patterns, header.getHeader(), HttpStatus.ACCEPTED);
				}
				
				
				@GetMapping(SellerUserURLMapping.SELLER_PATTERNS_PATH_WITH_ID)
				@ResponseBody
				public ResponseEntity<Patterns> getPatternsById(@PathVariable String patid)
				{
					Patterns  patterns = patternsRestService.getPatternsById(patid);
					return new ResponseEntity<Patterns>( patterns, header.getHeader(), HttpStatus.ACCEPTED);
				}
				
				
				
				@PostMapping(SellerUserURLMapping.SELLER_PATTERNS_PATH)
				@ResponseBody
				public ResponseEntity<ResponseBean> insertPatternsService(@RequestBody PatternsPOSTBean PPB)
						
				{
					ResponseBean responseBean = patternsRestService.InsertPatternsDetails(PPB.getDescription(),PPB.getProductid()+"");
					return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
				}
				
				@PutMapping(SellerUserURLMapping.SELLER_PATTERNS_PATH)
				@ResponseBody
				public ResponseEntity<ResponseBean> updatePatternsService(@RequestBody Patterns PB)
				{
					ResponseBean responseBean = patternsRestService.UpdatePatternsDetails(PB.getPatid()+"",PB.getDescription(),PB.getProductid()+"");
					return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
				}
				//PatternsService end here
		//PricesTableService start here
				@PostMapping(path = SellerUserURLMapping.SELLER_PRICES_TABLE_PATH)
				@ResponseBody	
				public ResponseEntity<ResponseBean> insertPrices(@RequestBody PricesTablePost PTP)
						{
					ResponseBean responseBean = pricesTableRestService.insertprices(PTP.getMrp()+"",PTP.getProductid()+"",PTP.getLcPrice()+"",PTP.getTax()+"",PTP.getSellingPrice()+"",PTP.getFinalPrice()+"");
					return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);	
				}
				
				@PutMapping(path = SellerUserURLMapping.SELLER_PRICES_TABLE_PATH)
				@ResponseBody	
				public ResponseEntity<ResponseBean> updatePrices(@RequestBody PricesTable PT)
					{
					ResponseBean responseBean = pricesTableRestService.updateprices(PT.getPriceId()+"",PT.getMrp()+"",PT.getProductid()+"",PT.getLcPrice()+"",PT.getTax()+"",PT.getSellingPrice()+"",PT.getFinalPrice()+"");
					return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);	
				}
				
				@GetMapping(SellerUserURLMapping.SELLER_PRICES_TABLE_PATH_WITH_ID)
				@ResponseBody
				public ResponseEntity<PricesTable> getByIdPricesTableService(@PathVariable String productid)
				{
					PricesTable prices = pricesTableRestService.getpricebyid(productid);
					return new ResponseEntity<PricesTable>(prices, header.getHeader(), HttpStatus.ACCEPTED);
				}
				
				@GetMapping(SellerUserURLMapping.SELLER_PRICES_TABLE_PATH)
				@ResponseBody
				public ResponseEntity<List<PricesTable>> getallprices()
				{
					List<PricesTable> prices = pricesTableRestService.getallprices();
					return new ResponseEntity<List<PricesTable>>(prices, header.getHeader(), HttpStatus.ACCEPTED);
				}
				//PricesTableService end here
		//ProductAgeService start here
				@PostMapping(SellerUserURLMapping.SELLER_PRODUCTAGE_PATH)
				@ResponseBody
				public ResponseEntity<ResponseBean> addProductAge(@RequestBody ProductAge PA)
				{
					ResponseBean responseBean = productAgeRestService.addProductAge(PA.getAgeid()+"",PA.getDes());
					return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
				}
				
				
				@GetMapping(SellerUserURLMapping.SELLER_PRODUCTAGE_PATH)
				@ResponseBody
				public ResponseEntity<List<ProductAge>> getAll(
						)
				{
					List<ProductAge> responseBean = productAgeRestService.getAll();
					return new ResponseEntity<List<ProductAge>>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
				}
				
				@GetMapping(SellerUserURLMapping.SELLER_PRODUCTAGE_PATH_WITH_ID)
				@ResponseBody
				public ResponseEntity<ProductAge> getProductAgeById(@PathVariable String ageid)
						
				{
					ProductAge responseBean = productAgeRestService.getProductAgeById(ageid);
					return new ResponseEntity<ProductAge>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
				}
				
				
				
				@PutMapping(SellerUserURLMapping.SELLER_PRODUCTAGE_PATH)
				@ResponseBody
				public ResponseEntity<ResponseBean> updateProductAgeService(@RequestBody ProductAge PA)
				{
					ResponseBean responseBean = productAgeRestService.update(PA.getAgeid()+"",PA.getDes());
					return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
				}
				
						
				
				//ProductAgeService end here
		//ProductDescriptionsService start here
				@PostMapping(path = SellerUserURLMapping.SELLER_PRODUCTDESCRIPTION_MAPPING_PATH)
				@ResponseBody	
				public ResponseEntity<ResponseBean> insertion(@RequestBody ProductDescriptionsPost PDP)
				{
					ResponseBean responseBean = productDescriptionsRestService.insert(PDP.getDescription());
					return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);	
				}
				
				 @PutMapping(path = SellerUserURLMapping.SELLER_PRODUCTDESCRIPTION_MAPPING_PATH)
				 @ResponseBody
				 public ResponseEntity<ResponseBean> updateProductDescriptionsService(@RequestBody ProductDescriptions PD)
				{
					 ResponseBean responseBean = productDescriptionsRestService.update(PD.getDescriptionid()+"",PD.getDescription());
						return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);	
				 }
				
					
						
				
				 	@GetMapping(SellerUserURLMapping.SELLER_PRODUCTDESCRIPTION_MAPPING_PATH_WITH_ID)
					@ResponseBody
					public ResponseEntity<ProductDescriptions> getByIdProductDescriptionsService(@PathVariable String descriptionid)
					{
				 		ProductDescriptions productDescriptions = productDescriptionsRestService.getById(descriptionid);
						return new ResponseEntity<ProductDescriptions>(productDescriptions, header.getHeader(), HttpStatus.ACCEPTED);
					}
				 	
				 	@GetMapping(SellerUserURLMapping.SELLER_PRODUCTDESCRIPTION_MAPPING_PATH)
					@ResponseBody
					public ResponseEntity<List<ProductDescriptions>> getAllProductDescriptions()
					{
				    	List<ProductDescriptions> productDescriptions = productDescriptionsRestService.getAllProductDescriptions();
						return new ResponseEntity<List<ProductDescriptions>>(productDescriptions, header.getHeader(), HttpStatus.ACCEPTED);
					}
				//ProductDescriptionsService end here
		//ProductquantitiesService start here
				 	@GetMapping(SellerUserURLMapping.SELLER_PRODUCTQUANTITIES_GET_PATH)
					@ResponseBody
					public ResponseEntity<List<ProductQuantities>> getAllProductquantities()
					{
						List<ProductQuantities> productquantities = productquantitiesRestService.getAllProductQuantities();
						return new ResponseEntity<List<ProductQuantities>>(productquantities, header.getHeader(), HttpStatus.ACCEPTED);
					}
					
					@GetMapping(SellerUserURLMapping.SELLER_PRODUCTQUANTITIES_GET_PATH_WITH_VARIABLE)
					@ResponseBody
					public ResponseEntity<ProductQuantities> getProductQuantitiesById(@PathVariable String custid)
					{
						ProductQuantities productquantities = productquantitiesRestService.getProductQuantitiesById(custid);
						return new ResponseEntity<ProductQuantities>(productquantities, header.getHeader(), HttpStatus.ACCEPTED);
					}
					
					@PostMapping(SellerUserURLMapping.SELLER_PRODUCTQUANTITIES_GET_PATH)
					@ResponseBody
					public ResponseEntity<ResponseBean> insertProductquantitiesService(@RequestBody ProductQuantitiesPost PQT)
					{
						ResponseBean responseBean = productquantitiesRestService.insertProductQuantities(PQT.getQuantity()+"",PQT.getSizeid()+"");
						return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
					}
				
					
					@PutMapping(SellerUserURLMapping.SELLER_PRODUCTQUANTITIES_GET_PATH)
					@ResponseBody
					public ResponseEntity<ResponseBean> updateProductquantitiesService(@RequestBody ProductQuantities PQ)
					{
						ResponseBean responseBean = productquantitiesRestService.updateProductQuantities(PQ.getCustid()+"",PQ.getQuantity()+"",PQ.getSizeid()+"");
						
						return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
					}
				
					
					//ProductquantitiesService end here
		//ProductsService start here
					@PostMapping( SellerUserURLMapping.SELLER_PRODUCTS_MAPPING_PATH)
					@ResponseBody	
					public ResponseEntity<ResponseBean> insert(@RequestBody ProductsPost PBP)
					{
					
							ResponseBean responseBean = productsRestService.insert(PBP.getDescriptionid()+"",PBP.getBatchid()+"",PBP.getGenderid()+"",PBP.getCatid()+"",PBP.getSubcatid()+"",PBP.getSeasonid()+"",PBP.getOccasionid()+"",PBP.getAgeid()+"",PBP.getMaterialid()+"",PBP.getColorid()+"",PBP.getCustid()+"",PBP.getStatus());
							return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);	
						
					}
							

					@GetMapping(SellerUserURLMapping.SELLER_PRODUCTS_MAPPING_PATH_ID)
					@ResponseBody
					public ResponseEntity<Products> getByIdProductsService(@PathVariable String productid)
					{
						Products products = productsRestService.getbyid(productid);
						return new ResponseEntity<Products>(products, header.getHeader(), HttpStatus.ACCEPTED);
					}
					
					
					@GetMapping(SellerUserURLMapping.SELLER_PRODUCTS_MAPPING_PATH)
					@ResponseBody
					public ResponseEntity<List<Products>> getallProductsService()
					{
						List<Products> products = productsRestService.getall();
						return new ResponseEntity<List<Products>>(products, header.getHeader(), HttpStatus.ACCEPTED);
					}
					//ProductsService end here
		//ProductTypeService start here
					@GetMapping(SellerUserURLMapping.SELLER_PRODUCTTYPE_GET_PATH)
					@ResponseBody
					public ResponseEntity<List<ProductType>> getAllProductTypeDetails()
					{
						List<ProductType> producttype = producttypeRestService.getAllProductTypeDetails();
						return new ResponseEntity<List<ProductType>>(producttype, header.getHeader(), HttpStatus.ACCEPTED);
					}
					
					
					@GetMapping(SellerUserURLMapping.SELLER_PRODUCTTYPE_PATH_WITH_ID)
					@ResponseBody
					public ResponseEntity<ProductType> getProductTypeById(@PathVariable String protypeid)
					{
						ProductType producttype = producttypeRestService.getProductTypeById(protypeid);
						return new ResponseEntity<ProductType>(producttype, header.getHeader(), HttpStatus.ACCEPTED);
					}
					
					@PostMapping(SellerUserURLMapping.SELLER_PRODUCTTYPE_GET_PATH)
					@ResponseBody
					public ResponseEntity<ResponseBean> insertProductTypeService(@RequestBody ProductTypePost PTP)
					{
						ResponseBean responseBean = producttypeRestService.InsertProductType(PTP.getSubcatid()+"",PTP.getProducttypename());
						return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
					}
					
					@PutMapping(SellerUserURLMapping.SELLER_PRODUCTTYPE_GET_PATH)
					@ResponseBody
					public ResponseEntity<ResponseBean> updateProductTypeService(@RequestBody ProductType PT)		
					{
						ResponseBean responseBean = producttypeRestService.UpdateProductType(PT.getProtypeid()+"",PT.getSubcatid()+"",PT.getProducttypename());
						return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
					}
							
				
					//ProductTypeService end here
			//SalesSellerService start here
			@GetMapping(SellerUserURLMapping.SELLER_SALLER_SELLER_GET_PATH)
			@ResponseBody
			public ResponseEntity<List<SellerUsers>> getAllSalesUsers(HttpServletRequest request)
			{
				String rolename = (String) request.getSession().getAttribute(ConstantValues.SESSION_ROLENAME);
				System.out.println("Rolename:"+rolename);
				List<SellerUsers> salesUsers = salesSellerRestService.getAllSalesUsers();
				return new ResponseEntity<List<SellerUsers>>(salesUsers, header.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(SellerUserURLMapping.SELLER_SELLER_GET_PATH_WITH_VARIABLE)
			@ResponseBody
			public ResponseEntity<SellerUsers> getSalesUser(@PathVariable String username)
			{
				SellerUsers sallerUser = salesSellerRestService.getSalesUserByusername(username);
				return new ResponseEntity<SellerUsers>(sallerUser, header.getHeader(), HttpStatus.ACCEPTED);
			}
			//SalesSellerService end here
			//SeasonWearService start here
			@GetMapping(SellerUserURLMapping.SELLER_SEASON_WEAR)
			@ResponseBody
			public ResponseEntity<List<SeasonWear>> getAllSeasonWearDetails()
			{
				List<SeasonWear> seasonwear = seasonwearRestService.getAllSeasonWearDetails();
				return new ResponseEntity<List<SeasonWear>>(seasonwear, header.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(SellerUserURLMapping.SELLER_SEASON_WEAR_BY_ID)
			@ResponseBody
			public ResponseEntity<SeasonWear> getSeasonWearById(@PathVariable String seasonid)
			{
				SeasonWear seasonwear = seasonwearRestService.getSeasonWearById(seasonid);
				return new ResponseEntity<SeasonWear>(seasonwear, header.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@PostMapping(SellerUserURLMapping.SELLER_SEASON_WEAR)
			@ResponseBody
			public ResponseEntity<ResponseBean> insertSeasonWear(@RequestBody SeasonWearNew SWN)
			{
				ResponseBean responseBean = seasonwearRestService.InsertSeasonWearDetails(SWN.getSubcatId()+"",SWN.getSeason());
				return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@PutMapping(SellerUserURLMapping.SELLER_SEASON_WEAR)
			@ResponseBody
			public ResponseEntity<ResponseBean> updateSeasonWear(@RequestBody SeasonWear Sw)
			{
				ResponseBean responseBean = seasonwearRestService.UpdateSeasonWearDetails(Sw.getSeasonId()+"",Sw.getSubcatId()+"",Sw.getSeason());
				return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
			}
			//SeasonWearService end here
			
			//SellerToWarehouseService start here
			@PostMapping(SellerUserURLMapping.SELLER_WAREHOUSETOSELLER_POST)
			@ResponseBody	
			public ResponseEntity<ResponseBean> addList(@RequestBody SellerToWarehouseBean stwb)
		
					{
					ResponseBean responseBean = sellerToWarehouseRestService.addList(stwb.getWarehouseid()+"", stwb.getSellerid()+"");
				return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);	
			}
			
			//SellerToWarehouseService end here
			
			//SizesService start here
			@PostMapping(path = SellerUserURLMapping.SELLER_SIZES_MAPPING_PATH)
			@ResponseBody	
			public ResponseEntity<ResponseBean> insertSeasonWear(@RequestBody SizesNew SNB)
			{
				ResponseBean responseBean = sizesRestService.insertSeasonWear(SNB.getAgeid()+"",SNB.getSizeno()+"",SNB.getHeight()+"",SNB.getWeight()+"",SNB.getChest()+"",SNB.getWaist()+"",SNB.getHip());
				return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);	
			}
			
			@PutMapping(path = SellerUserURLMapping.SELLER_SIZES_MAPPING_PATH)
			@ResponseBody	
			public ResponseEntity<ResponseBean> updatesize(@RequestBody Sizes SB)
			{
				ResponseBean responseBean = sizesRestService.updatesize(SB.getSizeid()+"",SB.getAgeid()+"",SB.getSizeno()+"",SB.getHeight()+"",SB.getWeight()+"",SB.getChest()+"",SB.getWaist()+"",SB.getHip());
				return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);	
			}
			
			@GetMapping(SellerUserURLMapping.SELLER_SIZES_MAPPING_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<Sizes> getByIdSizesService(@PathVariable String sizeid)
			{
				Sizes sizes = sizesRestService.getsizebyid(sizeid);
				return new ResponseEntity<Sizes>(sizes, header.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(SellerUserURLMapping.SELLER_SIZES_MAPPING_PATH)
			@ResponseBody
			public ResponseEntity<List<Sizes>> getAllSizes()
			{
				List<Sizes> sizes = sizesRestService.getAllSizes();
				return new ResponseEntity<List<Sizes>>(sizes, header.getHeader(), HttpStatus.ACCEPTED);
			}
			//SizesService end here

			//SubCategoriesService start here
			@GetMapping(SellerUserURLMapping.SELLER_SUBCATEGORIES_GET_PATH)
			@ResponseBody
			public ResponseEntity<List<SubCategories>> getAllSubCategoriesDetails()
			{
				List<SubCategories> subcategories = subcategoriesRestService.getAllSubCategoriesDetails();
				return new ResponseEntity<List<SubCategories>>(subcategories, header.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(SellerUserURLMapping.SELLER_SUBCATEGORIES_MAPPING_PATH_WITH_VARIABLE )
			@ResponseBody
			public ResponseEntity<SubCategories> getSubCategoriesById(@PathVariable String subcatid)
			{
				SubCategories subcategories = subcategoriesRestService.getSubCategoriesById(subcatid);
				return new ResponseEntity<SubCategories>(subcategories, header.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@PostMapping(SellerUserURLMapping.SELLER_SUBCATEGORIES_GET_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> insertSubcategorytype(@RequestBody NewSubCategory newsubcat)	
					
			{
				ResponseBean responseBean = subcategoriesRestService.insertSubcategorytype(newsubcat.getCatid()+"",newsubcat.getCategoryname()+"");
				return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@PutMapping(SellerUserURLMapping.SELLER_SUBCATEGORIES_GET_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> SubCategoriesServiceupdate(@RequestBody SubCategories subcat)
			{
				ResponseBean responseBean = subcategoriesRestService.updateSubcategorytype(subcat.getSubcatid()+"", subcat.getCatid()+"", subcat.getCategoryname()+"");
				
				return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
			}
			//SubCategoriesService end here
			//AuthorizationSecurityService start here
			@GetMapping(SellerUserURLMapping.SELLER_PATH_1)
			@ResponseBody
			public ResponseEntity<List<Authorization>> method1(HttpSession session) {
				System.out.println("SESSION ID: " + session.getId() + " Admin");
				List<Authorization> authroizations = authorizationRestService.getAllRoleList();
				return new ResponseEntity<List<Authorization>>(authroizations, header.getHeader(), HttpStatus.ACCEPTED);
			}

			@GetMapping(SellerUserURLMapping.SELLER_PATH_2)
			@ResponseBody
			public ResponseEntity<Authorization> method2(HttpSession session, @PathVariable String rolename) {
				System.out.println("SESSION ID: " + session.getId() + " Admin");
				Authorization authroizations = authorizationRestService.getRoleByName(rolename);
				return new ResponseEntity<Authorization>(authroizations, header.getHeader(), HttpStatus.ACCEPTED);
			}
			//AuthorizationSecurityService end here
			//SellerService start here
			@PostMapping(SellerUserURLMapping.SELLER_SELLER_GET_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> insertNewSeller(@RequestBody NewSellerBean nsb)
			{
			ResponseBean responseBean = sellerRestService.insertSeller(nsb.getSellercompanyname(), nsb.getSellername(), nsb.getPhone()+"", nsb.getEmail(),
						nsb.getAddress(), nsb.getIsocode(), nsb.getStatus());
				return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@PutMapping(SellerUserURLMapping.SELLER_SELLER_GET_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> updateSellerDetails(@RequestBody Seller seller)
			{
				ResponseBean responseBean = sellerRestService.updateSeller(seller.getSellerid()+"",seller.getSellercompanyname(), seller.getSellername(), seller.getPhone()+"", seller.getEmail(),
						seller.getAddress(), seller.getIsocode(), seller.getStatus()+"");
				return new ResponseEntity<ResponseBean>(responseBean, header.getHeader(), HttpStatus.ACCEPTED);
			}

			//SellerService end here
			
			@GetMapping(SellerUserURLMapping.PATHLIST)
			@ResponseBody
			public ResponseEntity<List<UrlsList>> getAllUrlList()
			{
				List<UrlsList> list = new CopyOnWriteArrayList<>();
				list.add(new UrlsList(SellerUserURLMapping.SELLER_USER_ENTRY_POINT_ROOT_PATH, "GET", "No Parameter"));
				
				
				list.add(new UrlsList(SellerUserURLMapping.SELLER_BATCHES_GET_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_BATCHES_MAPPING_PATH_WITH_PATH_VARIABLE,"GET BY ID","Path Variable 'batchid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_BATCHID_PUT_PATH_WITH_VARIABLE, "PUT", "Path Variable,'batchid,'status'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_BATCHES_GET_PATH,"POST","Json:"+new NewBatch().toString()));
				
				
				list.add(new UrlsList(SellerUserURLMapping.SELLER_CATEGORIES_MAPPING_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_CATEGORIES_MAPPING_PATH_WITH_ID,"GET BY ID","Path Variable 'catid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_CATEGORIES_MAPPING_PATH,"PUT","Json:"+new Categories().toString()));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_CATEGORIES_MAPPING_PATH,"POST","Json:"+new NewCategory().toString()));
				
				
				list.add(new UrlsList(SellerUserURLMapping.SELLER_COLOR_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_COLOR_PATH_WITH_COLOR_ID,"GET BY ID","Path Variable 'colorid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_COLOR_PATH,"PUT","Json:"+new Color().toString()));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_COLOR_PATH,"POST","Json:"+new NewColor().toString()));
				
				list.add(new UrlsList(SellerUserURLMapping.SELLER_COUNTRY_GET_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_COUNTRY_GET_PATH_WITH_VARIABLE,"GET BY ID","Path Variable 'isocode'"));
				
				list.add(new UrlsList(SellerUserURLMapping.SELLER_GENDERS_GET_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_GENDERS_MAPPING_PATH_WITH_PATH_VARIABLE,"GET BY ID","Path Variable genderid"));
				
				
				list.add(new UrlsList(SellerUserURLMapping.SELLER_MATERIALCOMP_GET_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_MATERIALCOMPOSITION_GET_PATH_WITH_VARIABLE,"GET BY ID","Path Variable 'materialid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_MATERIALCOMP_GET_PATH,"PUT","Json:"+new Materialcomposition().toString()));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_MATERIALCOMP_GET_PATH,"POST","Json:"+new Materialcomposition().toString()));
				
				
				list.add(new UrlsList(SellerUserURLMapping.SELLER_MATERIAL_GET_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_MATERIALTYPE_GET_PATH_WITH_VARIABLE,"GET BY ID","Path Variable 'materialid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_MATERIAL_GET_PATH,"PUT","Json:"+new Materialtypes().toString()));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_MATERIAL_GET_PATH,"POST","Json:"+new NewMaterialtypes().toString()));
				
				
				list.add(new UrlsList(SellerUserURLMapping.SELLER_NO_OF_PIECES_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_NO_OF_PIECES_PATH_WITH_ID,"GET BY ID","Path Variable 'pieceid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_NO_OF_PIECES_PATH,"PUT","Json Dta:"+ new NoOfPieces().toString()));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_NO_OF_PIECES_PATH,"POST","Json Data:"+ new NoOfPiecesPost().toString()));
				
				
				list.add(new UrlsList(SellerUserURLMapping.SELLER_OCCASIONALWEAR_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_OCCASIONALWEAR_PATH_WITH_ID,"GET BY ID","Path Variable 'occasionid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_OCCASIONALWEAR_PATH,"PUT","JsonData ="+new OccasionalWear().toString()));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_OCCASIONALWEAR_PATH,"POST","JsonData ="+new OccasionalWearBean().toString()));
					
					
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PATTERNS_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PATTERNS_PATH_WITH_ID,"GET BY ID","Path Variable 'patid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PATTERNS_PATH,"PUT","JsonData ="+new Patterns().toString()));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PATTERNS_PATH,"POST","JsonData ="+new PatternsPOSTBean().toString()));
					
					
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRICES_TABLE_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRICES_TABLE_PATH_WITH_ID,"GET BY ID","Path Variable 'productid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRICES_TABLE_PATH,"PUT","JsonData ="+new PricesTable().toString()));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRICES_TABLE_PATH,"POST","JsonData ="+new PricesTablePost().toString()));
					
					
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTAGE_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTAGE_PATH_WITH_ID,"GET BY ID","Path Variable 'ageid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTAGE_PATH,"PUT","JsonData ="+new ProductAge().toString()));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTAGE_PATH,"POST","JsonData ="+new ProductAge().toString()));
					
					
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTDESCRIPTION_MAPPING_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTDESCRIPTION_MAPPING_PATH_WITH_ID,"GET BY ID","Path Variable 'descriptionid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTDESCRIPTION_MAPPING_PATH,"PUT","JsonData ="+new ProductDescriptions().toString()));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTDESCRIPTION_MAPPING_PATH,"POST","JsonData ="+new ProductDescriptionsPost().toString()));
					
					
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTQUANTITIES_GET_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTQUANTITIES_GET_PATH_WITH_VARIABLE,"GET BY ID","Path Variable 'custid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTQUANTITIES_GET_PATH,"PUT","JsonData ="+new ProductQuantities().toString()));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTQUANTITIES_GET_PATH,"POST","JsonData ="+new ProductQuantitiesPost().toString()));
					
					
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTS_MAPPING_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTS_MAPPING_PATH_ID,"GET BY ID","Path Variable 'productid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTS_MAPPING_PATH,"POST","JsonData ="+new ProductsPost().toString()));
					
					
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTTYPE_GET_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTTYPE_PATH_WITH_ID,"GET BY ID","Path Variable 'protypeid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTTYPE_GET_PATH,"PUT","JsonData ="+new ProductType().toString()));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PRODUCTTYPE_GET_PATH,"POST","JsonData ="+new ProductTypePost().toString()));
					
					
				list.add(new UrlsList(SellerUserURLMapping.SELLER_SEASON_WEAR,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_SEASON_WEAR_BY_ID,"GET BY ID","Path Variable 'seasonid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_SEASON_WEAR,"PUT","JsonData ="+new SeasonWear().toString()));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_SEASON_WEAR,"POST","JsonData ="+new SeasonWearNew().toString()));
					
				
				list.add(new UrlsList(SellerUserURLMapping.SELLER_WAREHOUSETOSELLER_POST,"POST","RequestParam ("+ConstantValues.WAREHOUSE_ID+","+ConstantValues.SELLER_ID));
				
				
				list.add(new UrlsList(SellerUserURLMapping.SELLER_SIZES_MAPPING_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_SIZES_MAPPING_PATH_WITH_ID,"GET BY ID","Path Variable 'sizeid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_SIZES_MAPPING_PATH,"PUT","JsonData ="+new Sizes().toString()));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_SIZES_MAPPING_PATH,"POST","JsonData ="+new SizesNew().toString()));
				
				
				list.add(new UrlsList(SellerUserURLMapping.SELLER_SUBCATEGORIES_GET_PATH,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_SUBCATEGORIES_MAPPING_PATH_WITH_VARIABLE,"GET BY ID","Path Variable 'subcatid'"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_SUBCATEGORIES_GET_PATH,"PUT","Json:"+new SubCategories().toString()));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_SUBCATEGORIES_GET_PATH,"POST","Json:"+new NewSubCategory().toString()));
				
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PATH_1,"GET","No parameter"));
				list.add(new UrlsList(SellerUserURLMapping.SELLER_PATH_2,"GET BY ID","Path Variable 'rolename'"));
				
				list.add(new UrlsList(SellerUserURLMapping.SELLER_SALLER_SELLER_GET_PATH,"GET","No parameter"));
				
			//  list.add(new UrlsList(SellerUserURLMapping.SELLER_SELLER_GET_PATH,"POST","Json:"+new NewSellerBean().toString()));
			//  list.add(new UrlsList(SellerUserURLMapping.SELLER_SELLER_GET_PATH,"PUT","Json:"+new Seller().toString()));
				
				return new ResponseEntity<List<UrlsList>>(list, header.getHeader(), HttpStatus.ACCEPTED);
				
				
			}
			
}
