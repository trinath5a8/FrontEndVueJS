package com.lc.sk.inventory.security.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import com.lc.sk.inventory.security.beans.AuthorizedUsers;
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
import com.lc.sk.inventory.security.beans.NewSubCategory;
import com.lc.sk.inventory.security.beans.NoOfPieces;
import com.lc.sk.inventory.security.beans.OccasionalWear;
import com.lc.sk.inventory.security.beans.OccasionalWearBean;
import com.lc.sk.inventory.security.beans.Patterns;
import com.lc.sk.inventory.security.beans.PricesTable;
import com.lc.sk.inventory.security.beans.ProductAge;
import com.lc.sk.inventory.security.beans.ProductDescriptions;
import com.lc.sk.inventory.security.beans.ProductQuantities;
import com.lc.sk.inventory.security.beans.ProductQuantitiesPost;
import com.lc.sk.inventory.security.beans.ProductType;
import com.lc.sk.inventory.security.beans.Products;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.beans.SeasonWear;
import com.lc.sk.inventory.security.beans.SeasonWearNew;
import com.lc.sk.inventory.security.beans.Seller;
import com.lc.sk.inventory.security.beans.SellerToWarehouse;
import com.lc.sk.inventory.security.beans.SellerUsers;
import com.lc.sk.inventory.security.beans.Sizes;
import com.lc.sk.inventory.security.beans.SizesNew;
import com.lc.sk.inventory.security.beans.SubCategories;
import com.lc.sk.inventory.security.beans.UrlsList;
import com.lc.sk.inventory.security.beans.Warehouses;
import com.lc.sk.inventory.security.rest.AuthorizationRestService;
import com.lc.sk.inventory.security.rest.AuthorizedUsersRestService;
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
import com.lc.sk.inventory.security.rest.WarehousesRestService;

import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.HeaderComponent;
import com.lc.sk.inventory.security.util.ManagerUserUrlMapping;
import com.lc.sk.inventory.security.util.URLMapping;



@RestController
@Validated
@RequestMapping(value = ManagerUserUrlMapping.MANAGER_USER_ENTRY_POINT_ROOT_PATH+URLMapping.VERSION)
public class ManagerUserEntryPoint {
	
	@Autowired
	private AuthorizedUsersRestService authorizedUsersRestService;
	@Autowired
	private AuthorizationRestService authorizationRestService;
	@Autowired
	private HeaderComponent headers;
	@Autowired
	BatchRestService batchRestService;
	@Autowired
	CategoriesRestService categoriesRestService;  
    @Autowired
	ColorRestService   colorRestService;
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
	private SellerRestService sellerRestService;
    @Autowired
	SellerToWarehouseRestService sellerToWarehouseRestService;
    @Autowired
	SizesRestService sizesRestService;
    @Autowired
    SubCategoriesRestService subcategoriesRestService;
    @Autowired
	WarehousesRestService warehousesRestService;
    
    //AUTHORIZED SECURITY SERVICE
    @GetMapping(ManagerUserUrlMapping.PATH_1_MANAGER)
	@ResponseBody
	public ResponseEntity<List<Authorization>> method1(HttpSession session) {
		System.out.println("SESSION ID: " + session.getId() + " Admin");
		List<Authorization> authroizations = authorizationRestService.getAllRoleList();
		return new ResponseEntity<List<Authorization>>(authroizations, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@GetMapping(ManagerUserUrlMapping.PATH_2_MANAGER)
	@ResponseBody
	public ResponseEntity<Authorization> method2(HttpSession session, @PathVariable String rolename) {
		System.out.println("SESSION ID: " + session.getId() + " Admin");
		Authorization authroizations = authorizationRestService.getRoleByName(rolename);
		return new ResponseEntity<Authorization>(authroizations, headers.getHeader(), HttpStatus.ACCEPTED);
	}
    
	
	// AUTHORIZED USER SECURITY
	@GetMapping(ManagerUserUrlMapping.AUTH_USER_GET_PATH_MANAGER)
	@ResponseBody
	public ResponseEntity<List<AuthorizedUsers>> getAllUsersList()
	{
		List<AuthorizedUsers> authorizedUsers = authorizedUsersRestService.getAllAuthorizedUsers();
		return new ResponseEntity<List<AuthorizedUsers>>(authorizedUsers, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping(ManagerUserUrlMapping.AUTH_USER_GET_WITH_PATH_VARIABLE_MANAGER)
	@ResponseBody
	public ResponseEntity<AuthorizedUsers> getUserByusername(@PathVariable String username)
	{
		AuthorizedUsers authorizedUser = authorizedUsersRestService.getAuthorizedUserByUsername(username);
		return new ResponseEntity<AuthorizedUsers>(authorizedUser, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	
	
	
	//BATCH CODE
	
	@GetMapping(ManagerUserUrlMapping.BATCHES_GET_PATH_MANAGER)
	@ResponseBody
	public ResponseEntity<List<Batch>> getAllBatchList()
	{
		List<Batch> batches = batchRestService.getAllBatchList();
		return new ResponseEntity<List<Batch>>(batches, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(ManagerUserUrlMapping.BATCHES_GET_PATH_MANAGER)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertNewBatch(@RequestBody NewBatch nb)
	{
		ResponseBean responseBean = batchRestService.insertBatch(nb.getWarehouseid(),  nb.getDateofpurchase(),  nb.getPurchasedby(),  nb.getInvamount(),
				 nb.getWhoinserted(),  nb.getStatus(),  nb.getIsocode(),  nb.getQty(), nb.getSellerid());
		return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping(ManagerUserUrlMapping.BATCHES_MAPPING_PATH_WITH_PATH_VARIABLE_MANAGER)
	@ResponseBody
	public ResponseEntity<Batch> getBatchById(@PathVariable String batchid)
	{
		Batch batch = batchRestService.getBatchById(batchid);
		return new ResponseEntity<Batch>(batch, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(ManagerUserUrlMapping.BATCHID_PUT_PATH_WITH_VARIABLE_MANAGER)
    @ResponseBody
    public ResponseEntity<ResponseBean> updateBatch(@PathVariable String batchid, @PathVariable String status)
    {
           ResponseBean responseBean = batchRestService.updateBatch(batchid, status);
           return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
    }
	
	//CATEGORIES
	
	 @PostMapping(ManagerUserUrlMapping.CATEGORIES_MAPPING_PATH_MANAGER)
		    @ResponseBody
		    public ResponseEntity<ResponseBean> insertNewCategory(@RequestBody NewCategory nc)
		    {
		    	 ResponseBean responseBean = categoriesRestService.addCategory(nc.getCategory(), nc.getGender());
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
			 }

		@PutMapping(ManagerUserUrlMapping.CATEGORIES_MAPPING_PATH_MANAGER)
		@ResponseBody
		public ResponseEntity<ResponseBean> update(@RequestBody Categories cat)
		{
			ResponseBean responseBean = categoriesRestService.update(cat.getCatid()+"",cat.getCategory()+"",cat.getGender()+""); 
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}
	
 
	    @GetMapping(ManagerUserUrlMapping.CATEGORIES_MAPPING_PATH_WITH_ID_MANAGER)
		@ResponseBody
		public ResponseEntity<Categories> getById(@PathVariable String catid)
		{
		 Categories categories = categoriesRestService.getById(catid);
			return new ResponseEntity<Categories>(categories, headers.getHeader(), HttpStatus.ACCEPTED);
		}
	 
	    @GetMapping(ManagerUserUrlMapping.CATEGORIES_MAPPING_PATH_MANAGER)
		@ResponseBody
		public ResponseEntity<List<Categories>> getAllCategories()
		{
	    	List<Categories> categories = categoriesRestService.getAllCategories();
			return new ResponseEntity<List<Categories>>(categories, headers.getHeader(), HttpStatus.ACCEPTED);
		}
	    
	//COLOR
	    @PostMapping(ManagerUserUrlMapping.COLOR_PATH_MANAGER)
		@ResponseBody
		public ResponseEntity<ResponseBean> insertNewColor(@RequestBody NewColor nc)
		{
			ResponseBean responseBean = colorRestService.insertNewColor(nc.getColorname(), nc.getHashcode());
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
		
	    @PutMapping(ManagerUserUrlMapping.COLOR_PATH_MANAGER)
		@ResponseBody
		public ResponseEntity<ResponseBean> updateColor(@RequestBody Color color)
		{
			ResponseBean responseBean = colorRestService.updateColor(color.getColorid()+"",color.getColorname(),color.getHashcode());
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
		
		@GetMapping(ManagerUserUrlMapping.COLOR_PATH_MANAGER)
		@ResponseBody
		public ResponseEntity<List<Color>> getAllColors(
				)
		{
			List<Color> responseBean = colorRestService.getAllColors();
			return new ResponseEntity<List<Color>>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
		
		@GetMapping(ManagerUserUrlMapping.COLOR_PATH_WITH_COLOR_ID_MANAGER)
		@ResponseBody
		public ResponseEntity<Color> getColorById(@PathVariable String colorid)
				
		{
			Color responseBean = colorRestService.getColorById(colorid);
			return new ResponseEntity<Color>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
/*
		@GetMapping(ManagerUserUrlMapping.COLOR_ACTIVE_PATH_MANAGER)
		@ResponseBody
		public ResponseEntity<List<Color>> getActiveColors()
		{
			List<Color> responseBean = colorRestService.getActiveColors();
			return new ResponseEntity<List<Color>>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}
*/	
		//COUNTRIES
		@GetMapping(ManagerUserUrlMapping.COUNTRY_GET_PATH_MANAGER)
		@ResponseBody
		public ResponseEntity<List<Countries>> getAllCountries()
		{
			List<Countries> countries = countriesRestService.getAllCountries();
			return new ResponseEntity<List<Countries>>(countries, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
		@GetMapping(ManagerUserUrlMapping.COUNTRY_GET_PATH_WITH_VARIABLE_MANAGER)
		@ResponseBody
		public ResponseEntity<Countries> getCountryById(@PathVariable String isocode)
		{
			Countries country = countriesRestService.getCountryById(isocode);
			return new ResponseEntity<Countries>(country, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		@GetMapping(ManagerUserUrlMapping.COUNTRY_ACTIVE_GET_MANAGER)
		@ResponseBody
		public ResponseEntity<List<Countries>> getActivecountries()
		{
			List<Countries> countries = countriesRestService.getActiveCountries();
			return new ResponseEntity<List<Countries>>(countries, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
		//GENDER
		@GetMapping(ManagerUserUrlMapping.GENDERS_GET_PATH_MANAGER)
		@ResponseBody
		public ResponseEntity<List<Genders>> getAllGendersDetails()
		{
			List<Genders> genders = gendersRestService.getAllGendersDetails();
			return new ResponseEntity<List<Genders>>(genders, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
		@GetMapping(ManagerUserUrlMapping.GENDERS_MAPPING_PATH_WITH_PATH_VARIABLE_MANAGER)
		@ResponseBody
		public ResponseEntity<Genders> getGenderById(@PathVariable String genderid)
		{
			Genders genders = gendersRestService.getGenderById(genderid);
			return new ResponseEntity<Genders>(genders, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
		//MATERIAL COMPOSITION
		@GetMapping(ManagerUserUrlMapping.MATERIALCOMP_GET_PATH_MANAGER)
		@ResponseBody
		public ResponseEntity<List<Materialcomposition>> getAllMaterialcomposition()
		{
			List<Materialcomposition> materialcomposition = materialcompositionRestService.getAllMaterialcomposition();
			return new ResponseEntity<List<Materialcomposition>>(materialcomposition, headers.getHeader(), HttpStatus.ACCEPTED);
		}

		@GetMapping(ManagerUserUrlMapping.MATERIALCOMPOSITION_GET_PATH_WITH_VARIABLE_MANAGER)
		@ResponseBody
		public ResponseEntity<Materialcomposition> getMaterialcompositionById(@PathVariable String materialid)
		{
			Materialcomposition materialcomposition = materialcompositionRestService.getMaterialcompositionById(materialid);
			return new ResponseEntity<Materialcomposition>(materialcomposition, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
		@PostMapping(ManagerUserUrlMapping.MATERIALCOMP_GET_PATH_MANAGER)
		@ResponseBody
		public ResponseEntity<ResponseBean> insertMaterialcomposition(@RequestBody Materialcomposition matcomp)
						
		{
			ResponseBean responseBean = materialcompositionRestService.insertMaterialcomposition(matcomp.getMaterialid() +"", matcomp.getDescription()+"");
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		 @PutMapping(ManagerUserUrlMapping.MATERIALCOMP_GET_PATH_MANAGER)
			@ResponseBody
			public ResponseEntity<ResponseBean> updateMaterialcomposition(@RequestBody Materialcomposition matcomp)
			{
				ResponseBean responseBean = materialcompositionRestService.updateMaterialcomposition(matcomp.getMaterialid()+"",matcomp.getDescription());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}

		//Material Types
		@GetMapping(ManagerUserUrlMapping.MATERIAL_GET_PATH_MANAGER)
		@ResponseBody
		public ResponseEntity<List<Materialtypes>> getAllMaterialtypes()
		{
			List<Materialtypes> materialtypes = materialtypesRestService.getAllMaterialtypes();
			return new ResponseEntity<List<Materialtypes>>(materialtypes, headers.getHeader(), HttpStatus.ACCEPTED);
		}


		@GetMapping(ManagerUserUrlMapping.MATERIALTYPE_GET_PATH_WITH_VARIABLE_MANAGER)
		@ResponseBody
		public ResponseEntity<Materialtypes> getMaterialtypeById(@PathVariable String materialid)
		{
			Materialtypes materialtypes = materialtypesRestService.getMaterialtypeById(materialid);
			return new ResponseEntity<Materialtypes>(materialtypes, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		@PostMapping(ManagerUserUrlMapping.MATERIAL_GET_PATH_MANAGER)
		@ResponseBody
		public ResponseEntity<ResponseBean> insertMaterialtype(@RequestBody NewMaterialtypes mattypes)
						
		{
			ResponseBean responseBean = materialtypesRestService.insertMaterialtype(mattypes.getMaterialname() +"", mattypes.getDescription()+"",mattypes.getOcid()+"",mattypes.getSeasonid()+"",mattypes.getCatid()+"");
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		@PutMapping(ManagerUserUrlMapping.MATERIAL_GET_PATH_MANAGER)
		@ResponseBody
		public ResponseEntity<ResponseBean> updateMaterialtype(@RequestBody Materialtypes mattypes)
		{
			ResponseBean responseBean = materialtypesRestService.updateMaterialtype(mattypes.getMaterialid()+"",mattypes.getMaterialname()+"" , mattypes.getDescription()+"",mattypes.getOcid()+"",mattypes.getSeasonid()+"",mattypes.getCatid()+"");
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
		//NO. OF PIECES
		@GetMapping(ManagerUserUrlMapping.NO_OF_PIECES_PATH_MANAGER)
		@ResponseBody
		public ResponseEntity<List<NoOfPieces>> getAllNoOfPieces(
				)
		{
			List<NoOfPieces> responseBean = noOfPiecesRestService.getAllNoOfPieces();
			return new ResponseEntity<List<NoOfPieces>>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
		@GetMapping(ManagerUserUrlMapping.NO_OF_PIECES_PATH_WITH_ID_MANAGER)
		@ResponseBody
		public ResponseEntity<NoOfPieces> getNoOfPiecesId(@PathVariable String pieceid)
				
		{
			NoOfPieces responseBean = noOfPiecesRestService.getNoOfPiecesId(pieceid);
			return new ResponseEntity<NoOfPieces>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
		@PutMapping(ManagerUserUrlMapping.NO_OF_PIECES_PATH_MANAGER)
		@ResponseBody
		public ResponseEntity<ResponseBean> update4(@RequestBody NoOfPieces np)
		{
			ResponseBean responseBean = noOfPiecesRestService.update(np.getPieceid()+"",np.getProductid()+"",np.getNoofset()+"");
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
		//OCCASIONAL WEAR
				@GetMapping(ManagerUserUrlMapping.OCCASIONALWEAR_PATH_MANAGER)
				@ResponseBody
				public ResponseEntity<List<OccasionalWear>> getAllOccasionalWearDetails()
				{
					List<OccasionalWear> occasionalwear = occasionalwearRestService.getAllOccasionalWearDetails();
					return new ResponseEntity<List<OccasionalWear>>(occasionalwear, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				
				@GetMapping(ManagerUserUrlMapping.OCCASIONALWEAR_PATH_WITH_ID_MANAGER)
				@ResponseBody
				public ResponseEntity<OccasionalWear> getOccasionalWearById(@PathVariable String occasionid)
				{
					OccasionalWear occasionalwear = occasionalwearRestService.getOccasionalWearById(occasionid);
					return new ResponseEntity<OccasionalWear>(occasionalwear, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				@PostMapping(ManagerUserUrlMapping.OCCASIONALWEAR_PATH_MANAGER)
				@ResponseBody
				public ResponseEntity<ResponseBean> insert4(@RequestBody OccasionalWearBean OWB)
						{
					ResponseBean responseBean = occasionalwearRestService.InsertOccasionalWearDetails(OWB.getOccaname(),OWB.getSubcatid()+"");
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				@PutMapping(ManagerUserUrlMapping.OCCASIONALWEAR_PATH_MANAGER)
				@ResponseBody
				public ResponseEntity<ResponseBean> update	(@RequestBody OccasionalWear OW)
				{
						ResponseBean responseBean = occasionalwearRestService.UpdateOccasionalWearDetails(OW.getOccasionid()+"",OW.getOccaname(),OW.getSubcatid()+"");
						return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
					}

		//PATTERNS
				@GetMapping(ManagerUserUrlMapping.PATTERNS_PATH_MANAGER)
				@ResponseBody
				public ResponseEntity<List<Patterns>> getAllPatternsDetails()
				{
					List<Patterns>  patterns = patternsRestService.getAllPatternsDetails();
					return new ResponseEntity<List<Patterns>>( patterns, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				
				@GetMapping(ManagerUserUrlMapping.PATTERNS_PATH_WITH_ID_MANAGER)
				@ResponseBody
				public ResponseEntity<Patterns> getPatternsById(@PathVariable String patid)
				{
					Patterns  patterns = patternsRestService.getPatternsById(patid);
					return new ResponseEntity<Patterns>( patterns, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				@PutMapping(ManagerUserUrlMapping.PATTERNS_PATH_MANAGER)
				@ResponseBody
				public ResponseEntity<ResponseBean> update6(@RequestBody Patterns PB)
				{
					ResponseBean responseBean = patternsRestService.UpdatePatternsDetails(PB.getPatid()+"",PB.getDescription(),PB.getProductid()+"");
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
		//PRICES TABLE
				@PutMapping(path = ManagerUserUrlMapping.PRICES_TABLE_PATH_MANAGER)
				@ResponseBody	
				public ResponseEntity<ResponseBean> updatePrices(@RequestBody PricesTable PT)
					{
					ResponseBean responseBean = pricesTableRestService.updateprices(PT.getPriceId()+"",PT.getMrp()+"",PT.getProductid()+"",PT.getLcPrice()+"",PT.getTax()+"",PT.getSellingPrice()+"",PT.getFinalPrice()+"");
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
				}
				@GetMapping(ManagerUserUrlMapping.PRICES_TABLE_PATH_WITH_ID_MANAGER)
				@ResponseBody
				public ResponseEntity<PricesTable> getById1(@PathVariable String productid)
				{
					PricesTable prices = pricesTableRestService.getpricebyid(productid);
					return new ResponseEntity<PricesTable>(prices, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				@GetMapping(ManagerUserUrlMapping.PRICES_TABLE_PATH_MANAGER)
				@ResponseBody
				public ResponseEntity<List<PricesTable>> getallprices()
				{
					List<PricesTable> prices = pricesTableRestService.getallprices();
					return new ResponseEntity<List<PricesTable>>(prices, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
		//PRODUCT AGE
				@GetMapping(ManagerUserUrlMapping.PRODUCTAGE_PATH_MANAGER)
				@ResponseBody
				public ResponseEntity<List<ProductAge>> getAll(
						)
				{
					List<ProductAge> responseBean = productAgeRestService.getAll();
					return new ResponseEntity<List<ProductAge>>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				@GetMapping(ManagerUserUrlMapping.PRODUCTAGE_PATH_WITH_ID_MANAGER)
				@ResponseBody
				public ResponseEntity<ProductAge> getProductAgeById(@PathVariable String ageid)
						
				{
					ProductAge responseBean = productAgeRestService.getProductAgeById(ageid);
					return new ResponseEntity<ProductAge>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				
				
				@PutMapping(ManagerUserUrlMapping.PRODUCTAGE_PATH_MANAGER)
				@ResponseBody
				public ResponseEntity<ResponseBean> update7(@RequestBody ProductAge PA)
				{
					ResponseBean responseBean = productAgeRestService.update(PA.getAgeid()+"",PA.getDes());
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
		//PRODUCT DESCRIPTION
				 @PutMapping(path = ManagerUserUrlMapping.PRODUCTDESCRIPTION_MAPPING_PATH_MANAGER)
				 @ResponseBody
				 public ResponseEntity<ResponseBean> update8(@RequestBody ProductDescriptions PD)
				{
					 ResponseBean responseBean = productDescriptionsRestService.update(PD.getDescriptionid()+"",PD.getDescription());
						return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
				 }
				
				 	@GetMapping(ManagerUserUrlMapping.PRODUCTDESCRIPTION_MAPPING_PATH_WITH_ID_MANAGER)
					@ResponseBody
					public ResponseEntity<ProductDescriptions> getById3(@PathVariable String descriptionid)
					{
				 		ProductDescriptions productDescriptions = productDescriptionsRestService.getById(descriptionid);
						return new ResponseEntity<ProductDescriptions>(productDescriptions, headers.getHeader(), HttpStatus.ACCEPTED);
					}
				 	
				 	@GetMapping(ManagerUserUrlMapping.PRODUCTDESCRIPTION_MAPPING_PATH_MANAGER)
					@ResponseBody
					public ResponseEntity<List<ProductDescriptions>> getAllProductDescriptions()
					{
				    	List<ProductDescriptions> productDescriptions = productDescriptionsRestService.getAllProductDescriptions();
						return new ResponseEntity<List<ProductDescriptions>>(productDescriptions, headers.getHeader(), HttpStatus.ACCEPTED);
					}
				 	
		//PRODUCTQUANTITIES
				 	@GetMapping(ManagerUserUrlMapping.PRODUCTQUANTITIES_GET_PATH_MANAGER)
					@ResponseBody
					public ResponseEntity<List<ProductQuantities>> getAllProductquantities()
					{
						List<ProductQuantities> productquantities = productquantitiesRestService.getAllProductQuantities();
						return new ResponseEntity<List<ProductQuantities>>(productquantities, headers.getHeader(), HttpStatus.ACCEPTED);
					}
					
					@GetMapping(ManagerUserUrlMapping.PRODUCTQUANTITIES_GET_PATH_WITH_VARIABLE_MANAGER)
					@ResponseBody
					public ResponseEntity<ProductQuantities> getProductQuantitiesById(@PathVariable String custid)
					{
						ProductQuantities productquantities = productquantitiesRestService.getProductQuantitiesById(custid);
						return new ResponseEntity<ProductQuantities>(productquantities, headers.getHeader(), HttpStatus.ACCEPTED);
					}
					
					@PostMapping(ManagerUserUrlMapping.PRODUCTQUANTITIES_GET_PATH_MANAGER)
					@ResponseBody
					public ResponseEntity<ResponseBean> insert5(@RequestBody ProductQuantitiesPost PQT)
					{
						ResponseBean responseBean = productquantitiesRestService.insertProductQuantities(PQT.getQuantity()+"",PQT.getSizeid()+"");
						return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
					}
					@PutMapping(ManagerUserUrlMapping.PRODUCTQUANTITIES_GET_PATH_MANAGER)
					@ResponseBody
					public ResponseEntity<ResponseBean> update8(@RequestBody ProductQuantities PQ)
					{
						ResponseBean responseBean = productquantitiesRestService.updateProductQuantities(PQ.getCustid()+"",PQ.getQuantity()+"",PQ.getSizeid()+"");
						
						return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
					}
								

		//PRODUCTSERVICE
					@PutMapping(ManagerUserUrlMapping.PRODUCTS_MAPPING_PATH_MANAGER)
					@ResponseBody	
					public ResponseEntity<ResponseBean> updatesize(@RequestBody Products PBP)
					{
						ResponseBean responseBean = productsRestService.update(PBP.getProductid()+"",PBP.getDescriptionid()+"",PBP.getBatchid()+"",PBP.getGenderid()+"",PBP.getCatid()+"",PBP.getSubcatid()+"",PBP.getSeasonid()+"",PBP.getOccasionid()+"",PBP.getAgeid()+"",PBP.getMaterialid()+"",PBP.getColorid()+"",PBP.getCustid()+"",PBP.getStatus());
						return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
					}
					
					@PutMapping( ManagerUserUrlMapping.PRODUCTS_MAPPING_PATH_WITH_PATH_VARIABLE_1_MANAGER)
					@ResponseBody
					public ResponseEntity<ResponseBean> enableBatchStatus(@PathVariable String productid,@PathVariable String status)
					{
						ResponseBean response = productsRestService.enableBatchStatus(productid, status);
						return new ResponseEntity<ResponseBean>(response, headers.getHeader(), HttpStatus.ACCEPTED);
					}
					
					@GetMapping(ManagerUserUrlMapping.PRODUCTS_MAPPING_PATH_ID_MANAGER)
					@ResponseBody
					public ResponseEntity<Products> getById4(@PathVariable String productid)
					{
						Products products = productsRestService.getbyid(productid);
						return new ResponseEntity<Products>(products, headers.getHeader(), HttpStatus.ACCEPTED);
					}
					
					
					@GetMapping(ManagerUserUrlMapping.PRODUCTS_MAPPING_PATH_MANAGER)
					@ResponseBody
					public ResponseEntity<List<Products>> getall()
					{
						List<Products> products = productsRestService.getall();
						return new ResponseEntity<List<Products>>(products, headers.getHeader(), HttpStatus.ACCEPTED);
					}
					
		//PRODUCT TYPE
					@GetMapping(ManagerUserUrlMapping.PRODUCTTYPE_GET_PATH_MANAGER)
					@ResponseBody
					public ResponseEntity<List<ProductType>> getAllProductTypeDetails()
					{
						List<ProductType> producttype = producttypeRestService.getAllProductTypeDetails();
						return new ResponseEntity<List<ProductType>>(producttype, headers.getHeader(), HttpStatus.ACCEPTED);
					}
					
					
					@GetMapping(ManagerUserUrlMapping.PRODUCTTYPE_PATH_WITH_ID_MANAGER)
					@ResponseBody
					public ResponseEntity<ProductType> getProductTypeById(@PathVariable String protypeid)
					{
						ProductType producttype = producttypeRestService.getProductTypeById(protypeid);
						return new ResponseEntity<ProductType>(producttype, headers.getHeader(), HttpStatus.ACCEPTED);
					}
					@PutMapping(ManagerUserUrlMapping.PRODUCTTYPE_GET_PATH_MANAGER)
					@ResponseBody
					public ResponseEntity<ResponseBean> update9(@RequestBody ProductType PT)		
					{
						ResponseBean responseBean = producttypeRestService.UpdateProductType(PT.getProtypeid()+"",PT.getSubcatid()+"",PT.getProducttypename());
						return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
					}

			
			//SalesSellerService
			@GetMapping(ManagerUserUrlMapping.SALLER_SELLER_GET_PATH_MANAGER)
			@ResponseBody
			public ResponseEntity<List<SellerUsers>> getAllSalesUsers(HttpServletRequest request)
			{
				String rolename = (String) request.getSession().getAttribute(ConstantValues.SESSION_ROLENAME);
				System.out.println("Rolename:"+rolename);
				List<SellerUsers> salesUsers = salesSellerRestService.getAllSalesUsers();
				return new ResponseEntity<List<SellerUsers>>(salesUsers, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(ManagerUserUrlMapping.SALES_SELLER_GET_PATH_WITH_VARIABLE_MANAGER)
			@ResponseBody
			public ResponseEntity<SellerUsers> getSalesUser(@PathVariable String username)
			{
				SellerUsers sallerUser = salesSellerRestService.getSalesUserByusername(username);
				return new ResponseEntity<SellerUsers>(sallerUser, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			//Season Wear
			@GetMapping(ManagerUserUrlMapping.SEASON_WEAR_MANAGER)
			@ResponseBody
			public ResponseEntity<List<SeasonWear>> getAllSeasonWearDetails()
			{
				List<SeasonWear> seasonwear = seasonwearRestService.getAllSeasonWearDetails();
				return new ResponseEntity<List<SeasonWear>>(seasonwear, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(ManagerUserUrlMapping.SEASON_WEAR_BY_ID_MANAGER)
			@ResponseBody
			public ResponseEntity<SeasonWear> getSeasonWearById(@PathVariable String seasonid)
			{
				SeasonWear seasonwear = seasonwearRestService.getSeasonWearById(seasonid);
				return new ResponseEntity<SeasonWear>(seasonwear, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@PostMapping(ManagerUserUrlMapping.SEASON_WEAR_MANAGER)
			@ResponseBody
			public ResponseEntity<ResponseBean> insert6(@RequestBody SeasonWearNew SWN)
			{
				ResponseBean responseBean = seasonwearRestService.InsertSeasonWearDetails(SWN.getSubcatId()+"",SWN.getSeason());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@PutMapping(ManagerUserUrlMapping.SEASON_WEAR_MANAGER)
			@ResponseBody
			public ResponseEntity<ResponseBean> update10(@RequestBody SeasonWear Sw)
			{
				ResponseBean responseBean = seasonwearRestService.UpdateSeasonWearDetails(Sw.getSeasonId()+"",Sw.getSubcatId()+"",Sw.getSeason());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			//SELLERSERVICE
			@GetMapping(ManagerUserUrlMapping.SELLER_GET_PATH_MANAGER)
			@ResponseBody
			public ResponseEntity<List<Seller>> getAllSellers()
			{
				List<Seller> sellers = sellerRestService.getAllSellerDetails();
				return new ResponseEntity<List<Seller>>(sellers, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(ManagerUserUrlMapping.SELLER_GET_PATH_WITH_VARIABLE_MANAGER)
			@ResponseBody
			public ResponseEntity<Seller> getAllSellers(@PathVariable Long sellerid)
			{
				Seller sellers = sellerRestService.getSellerById(sellerid);
				return new ResponseEntity<Seller>(sellers, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			//SELLER TO WAREHOUSE
			@GetMapping(ManagerUserUrlMapping.WAREHOUSETOSELLER_GET_MANAGER)
			@ResponseBody
			public ResponseEntity<List<SellerToWarehouse>> getAll2()
			{
		    	List<SellerToWarehouse>  sellerToWarehouse= sellerToWarehouseRestService.getAllData();
				return new ResponseEntity<List<SellerToWarehouse>>(sellerToWarehouse, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			//SIZES
			@PostMapping(path = ManagerUserUrlMapping.SIZES_MAPPING_PATH_MANAGER)
			@ResponseBody	
			public ResponseEntity<ResponseBean> insertSeasonWear(@RequestBody SizesNew SNB)
			{
				ResponseBean responseBean = sizesRestService.insertSeasonWear(SNB.getAgeid()+"",SNB.getSizeno()+"",SNB.getHeight()+"",SNB.getWeight()+"",SNB.getChest()+"",SNB.getWaist()+"",SNB.getHip());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
			}
			
			@PutMapping(path = ManagerUserUrlMapping.SIZES_MAPPING_PATH_MANAGER)
			@ResponseBody	
			public ResponseEntity<ResponseBean> updatesize(@RequestBody Sizes SB)
			{
				ResponseBean responseBean = sizesRestService.updatesize(SB.getSizeid()+"",SB.getAgeid()+"",SB.getSizeno()+"",SB.getHeight()+"",SB.getWeight()+"",SB.getChest()+"",SB.getWaist()+"",SB.getHip());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
			}
			
			@GetMapping(ManagerUserUrlMapping.SIZES_MAPPING_PATH_WITH_ID_MANAGER)
			@ResponseBody
			public ResponseEntity<Sizes> getById5(@PathVariable String sizeid)
			{
				Sizes sizes = sizesRestService.getsizebyid(sizeid);
				return new ResponseEntity<Sizes>(sizes, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(ManagerUserUrlMapping.SIZES_MAPPING_PATH_MANAGER)
			@ResponseBody
			public ResponseEntity<List<Sizes>> getAllSizes()
			{
				List<Sizes> sizes = sizesRestService.getAllSizes();
				return new ResponseEntity<List<Sizes>>(sizes, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			//SUB CATEGORIES
			@GetMapping(ManagerUserUrlMapping.SUBCATEGORIES_GET_PATH_MANAGER)
			@ResponseBody
			public ResponseEntity<List<SubCategories>> getAllSubCategoriesDetails()
			{
				List<SubCategories> subcategories = subcategoriesRestService.getAllSubCategoriesDetails();
				return new ResponseEntity<List<SubCategories>>(subcategories, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(ManagerUserUrlMapping.SUBCATEGORIES_MAPPING_PATH_WITH_VARIABLE_MANAGER )
			@ResponseBody
			public ResponseEntity<SubCategories> getSubCategoriesById(@PathVariable String subcatid)
			{
				SubCategories subcategories = subcategoriesRestService.getSubCategoriesById(subcatid);
				return new ResponseEntity<SubCategories>(subcategories, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@PostMapping(ManagerUserUrlMapping.SUBCATEGORIES_GET_PATH_MANAGER)
			@ResponseBody
			public ResponseEntity<ResponseBean> insertSubcategorytype(@RequestBody NewSubCategory newsubcat)	
					
			{
				ResponseBean responseBean = subcategoriesRestService.insertSubcategorytype(newsubcat.getCatid()+"",newsubcat.getCategoryname()+"");
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@PutMapping(ManagerUserUrlMapping.SUBCATEGORIES_GET_PATH_MANAGER)
			@ResponseBody
			public ResponseEntity<ResponseBean> SubCategoriesServiceupdate(@RequestBody SubCategories subcat)
			{
				ResponseBean responseBean = subcategoriesRestService.updateSubcategorytype(subcat.getSubcatid()+"", subcat.getCatid()+"", subcat.getCategoryname()+"");
				
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			//Warehouse
			@GetMapping(ManagerUserUrlMapping.WAREHOUSES_GET_PATH_MANAGER)
			@ResponseBody
			public ResponseEntity<List<Warehouses>> getAllWarehouseDetails()
			{
				List<Warehouses> warehouses = warehousesRestService.getAllWarehouses();
				return new ResponseEntity<List<Warehouses>>(warehouses, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(ManagerUserUrlMapping.WAREHOUSES_MAPPING_PATH_WITH_PATH_VARIABLE_MANAGER)
			@ResponseBody
			public ResponseEntity<Warehouses> getById6(@PathVariable String warehouseid)
			{
				Warehouses warehouse = warehousesRestService.getById(warehouseid);
				return new ResponseEntity<Warehouses>(warehouse, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			@PutMapping(ManagerUserUrlMapping.WAREHOUSES_GET_PATH_MANAGER)
			@ResponseBody
			public ResponseEntity<ResponseBean> update(@RequestBody Warehouses wh)
			{	
				ResponseBean responseBean = warehousesRestService.update(wh.getWarehouseid()+"", wh.getWarehousename()+"", wh.getContactpersonname(),
							wh.getContactphone()+"", wh.getEmail(), wh.getAddress(), wh.getPincode()+"", wh.getEst()+"", wh.getWarehouse_status()+"", wh.getWhoupdated(), wh.getIsocode());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(ManagerUserUrlMapping.PATHLIST)
			@ResponseBody
			public ResponseEntity<List<UrlsList>> getAllUrlList()
			{
				List<UrlsList> list = new CopyOnWriteArrayList<>();
				list.add(new UrlsList(ManagerUserUrlMapping.MANAGER_USER_ENTRY_POINT_ROOT_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.PATH_1_MANAGER, "GET", "No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.PATH_2_MANAGER, "GET BY ID", "path variable 'rolename'"));
				
				list.add(new UrlsList(ManagerUserUrlMapping.AUTH_USER_GET_PATH_MANAGER, "GET", "No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.AUTH_USER_GET_WITH_PATH_VARIABLE_MANAGER, "GET BY ID","path variable 'username'"));
				
				//BATCH
				list.add(new UrlsList(ManagerUserUrlMapping.BATCHES_GET_PATH_MANAGER, "GET", "No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.BATCHES_MAPPING_PATH_WITH_PATH_VARIABLE_MANAGER, "GET BY ID","path variable 'batchid'"));
                list.add(new UrlsList(ManagerUserUrlMapping.BATCHID_PUT_PATH_WITH_VARIABLE_MANAGER, "PUT", "path variable 'batchid','status'"));
                list.add(new UrlsList(ManagerUserUrlMapping.BATCHES_GET_PATH_MANAGER, "POST", "JsonData ="+new NewBatch().toString()));
                
                //CATEGORIES
                list.add(new UrlsList(ManagerUserUrlMapping.CATEGORIES_MAPPING_PATH_MANAGER, "GET","No parameter"));
                list.add(new UrlsList(ManagerUserUrlMapping.CATEGORIES_MAPPING_PATH_WITH_ID_MANAGER, "GET BY ID","path variable 'catid'"));	
				list.add(new UrlsList(ManagerUserUrlMapping.CATEGORIES_MAPPING_PATH_MANAGER, "PUT","Json:"+new Categories().toString()));
				list.add(new UrlsList(ManagerUserUrlMapping.CATEGORIES_MAPPING_PATH_MANAGER, "POST", "Json:"+new NewCategory().toString()));
				
				//color
			
				list.add(new UrlsList(ManagerUserUrlMapping.COLOR_PATH_MANAGER,"GET", "No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.COLOR_PATH_WITH_COLOR_ID_MANAGER,"GET BY ID","path variable 'colorid'"));
//				list.add(new UrlsList(ManagerUserUrlMapping.COLOR_ACTIVE_PATH_MANAGER,"GET","No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.COLOR_PATH_MANAGER, "POST", "Json:"+new NewColor().toString()));
				list.add(new UrlsList(ManagerUserUrlMapping.COLOR_PATH_MANAGER,"PUT", "Json:"+new Color().toString()));
				
				list.add(new UrlsList(ManagerUserUrlMapping.COUNTRY_GET_PATH_MANAGER,"GET","No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.COUNTRY_GET_PATH_WITH_VARIABLE_MANAGER,"GET BY ID","path variable 'isocode'"));
				list.add(new UrlsList(ManagerUserUrlMapping.COUNTRY_ACTIVE_GET_MANAGER,"GET","No Parameter"));
				
				list.add(new UrlsList(ManagerUserUrlMapping.GENDERS_GET_PATH_MANAGER,"GET","No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.GENDERS_MAPPING_PATH_WITH_PATH_VARIABLE_MANAGER,"GET BY ID","path variable 'genderid'"));
				//materialcomposition
				list.add(new UrlsList(ManagerUserUrlMapping.MATERIALCOMP_GET_PATH_MANAGER,"GET","No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.MATERIALCOMPOSITION_GET_PATH_WITH_VARIABLE_MANAGER,"GET BY ID","path variable 'materialid'"));
				list.add(new UrlsList(ManagerUserUrlMapping.MATERIALCOMP_GET_PATH_MANAGER,"POST","Json:"+new Materialcomposition().toString()));
				list.add(new UrlsList(ManagerUserUrlMapping.MATERIALCOMP_GET_PATH_MANAGER,"PUT","Json:"+new Materialcomposition().toString()));;
				//materialtypes
				list.add(new UrlsList(ManagerUserUrlMapping.MATERIAL_GET_PATH_MANAGER,"GET","No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.MATERIALTYPE_GET_PATH_WITH_VARIABLE_MANAGER,"GET BY ID","path variable 'materialid'"));
				list.add(new UrlsList(ManagerUserUrlMapping.MATERIAL_GET_PATH_MANAGER,"POST","Json:"+new NewMaterialtypes().toString()));
				list.add(new UrlsList(ManagerUserUrlMapping.MATERIAL_GET_PATH_MANAGER,"PUT","Json:"+new Materialtypes().toString()));
				
				list.add(new UrlsList(ManagerUserUrlMapping.NO_OF_PIECES_PATH_MANAGER,"GET","No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.NO_OF_PIECES_PATH_WITH_ID_MANAGER,"GET BY ID","path variable 'pieceid'"));
				list.add(new UrlsList(ManagerUserUrlMapping.NO_OF_PIECES_PATH_MANAGER,"PUT","Json Data:"+new NoOfPieces().toString()));
				
				
				list.add(new UrlsList(ManagerUserUrlMapping.OCCASIONALWEAR_PATH_MANAGER,"GET","No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.OCCASIONALWEAR_PATH_WITH_ID_MANAGER,"GET BY ID","path variable 'occasionid'"));
				list.add(new UrlsList(ManagerUserUrlMapping.OCCASIONALWEAR_PATH_MANAGER,"POST","JsonData ="+new OccasionalWearBean().toString()));
				list.add(new UrlsList(ManagerUserUrlMapping.OCCASIONALWEAR_PATH_MANAGER,"PUT","JsonData ="+new OccasionalWear().toString()));
				
				list.add(new UrlsList(ManagerUserUrlMapping.PATTERNS_PATH_MANAGER,"GET","No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.PATTERNS_PATH_WITH_ID_MANAGER,"GET BY ID","path variable 'patid'"));
				list.add(new UrlsList(ManagerUserUrlMapping.PATTERNS_PATH_MANAGER,"PUT","JsonData ="+new Patterns().toString()));
				
				
				list.add(new UrlsList(ManagerUserUrlMapping.PRICES_TABLE_PATH_MANAGER,"GET","No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.PRICES_TABLE_PATH_WITH_ID_MANAGER,"GET BY ID","path variable 'productid'"));
				list.add(new UrlsList(ManagerUserUrlMapping.PRICES_TABLE_PATH_MANAGER,"PUT","JsonData ="+new PricesTable().toString()));
				
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTAGE_PATH_MANAGER, "GET", "No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTAGE_PATH_WITH_ID_MANAGER, "GET BY ID", "path variable 'ageid'"));					
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTAGE_PATH_MANAGER,"PUT","JsonData ="+new ProductAge().toString()));
				
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTDESCRIPTION_MAPPING_PATH_MANAGER, "GET", "No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTDESCRIPTION_MAPPING_PATH_WITH_ID_MANAGER, "GET BY ID", "path variable 'descriptionid'"));
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTDESCRIPTION_MAPPING_PATH_MANAGER,"PUT","JsonData ="+new ProductDescriptions().toString()));
				
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTQUANTITIES_GET_PATH_MANAGER, "GET", "No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTQUANTITIES_GET_PATH_WITH_VARIABLE_MANAGER, "GET BY ID", "path variable 'custid'"));
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTQUANTITIES_GET_PATH_MANAGER, "POST", "JsonData ="+new ProductQuantitiesPost().toString()));
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTQUANTITIES_GET_PATH_MANAGER, "PUT","JsonData ="+new ProductQuantities().toString()));
				
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTS_MAPPING_PATH_MANAGER, "GET", "No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTS_MAPPING_PATH_ID_MANAGER, "GET BY ID", "path variable 'productid'"));				
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTS_MAPPING_PATH_MANAGER, "PUT","JsonData ="+new Products().toString()));
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTS_MAPPING_PATH_WITH_PATH_VARIABLE_1_MANAGER, "PUT", "path variable 'productid','status'"));				
				
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTTYPE_GET_PATH_MANAGER, "GET", "No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTTYPE_PATH_WITH_ID_MANAGER, "GET BY ID", "path variable 'protypeid'"));
				list.add(new UrlsList(ManagerUserUrlMapping.PRODUCTTYPE_GET_PATH_MANAGER,"PUT","JsonData ="+new ProductType().toString()));
				
				
				list.add(new UrlsList(ManagerUserUrlMapping.SALLER_SELLER_GET_PATH_MANAGER, "GET","No Parameter" ));
				list.add(new UrlsList(ManagerUserUrlMapping.SALES_SELLER_GET_PATH_WITH_VARIABLE_MANAGER, "GET BY ID","path variable 'username'" ));
				
				list.add(new UrlsList(ManagerUserUrlMapping.SEASON_WEAR_MANAGER, "GET", "No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.SEASON_WEAR_BY_ID_MANAGER, "GET BY ID", "path variable 'seasonid'"));
				list.add(new UrlsList(ManagerUserUrlMapping.SEASON_WEAR_MANAGER, "POST","JsonData ="+new SeasonWearNew().toString()));
				list.add(new UrlsList(ManagerUserUrlMapping.SEASON_WEAR_MANAGER, "PUT", "JsonData ="+new SeasonWear().toString()));
				
				list.add(new UrlsList(ManagerUserUrlMapping.SELLER_GET_PATH_MANAGER, "GET", "No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.SELLER_GET_PATH_WITH_VARIABLE_MANAGER, "GET BY ID", "path variable 'sellerid'"));
				
				list.add(new UrlsList(ManagerUserUrlMapping.WAREHOUSETOSELLER_GET_MANAGER, "GET", "No Parameter"));
				
				list.add(new UrlsList(ManagerUserUrlMapping.SIZES_MAPPING_PATH_MANAGER, "GET", "No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.SIZES_MAPPING_PATH_WITH_ID_MANAGER, "GET BY ID", "path variable 'sizeid'"));
				list.add(new UrlsList(ManagerUserUrlMapping.SIZES_MAPPING_PATH_MANAGER, "POST","JsonData ="+new SizesNew().toString()));
				list.add(new UrlsList(ManagerUserUrlMapping.SIZES_MAPPING_PATH_MANAGER, "PUT", "JsonData ="+new Sizes().toString()));
				//subcategories
				list.add(new UrlsList(ManagerUserUrlMapping.SUBCATEGORIES_GET_PATH_MANAGER, "GET", "No Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.SUBCATEGORIES_MAPPING_PATH_WITH_VARIABLE_MANAGER , "GET BY ID", "path variable 'subcatid'"));
				list.add(new UrlsList(ManagerUserUrlMapping.SUBCATEGORIES_GET_PATH_MANAGER , "POST", "Json:"+new NewSubCategory().toString()));
				list.add(new UrlsList(ManagerUserUrlMapping.SUBCATEGORIES_GET_PATH_MANAGER , "PUT", "Json:"+new SubCategories().toString()));
				
				//warehouses
				list.add(new UrlsList(ManagerUserUrlMapping.WAREHOUSES_GET_PATH_MANAGER , "GET", "NO Parameter"));
				list.add(new UrlsList(ManagerUserUrlMapping.WAREHOUSES_MAPPING_PATH_WITH_PATH_VARIABLE_MANAGER , "GET BY ID", "path variable 'warehouseid'"));
				list.add(new UrlsList(ManagerUserUrlMapping.WAREHOUSES_GET_PATH_MANAGER , "PUT","Json:"+new Warehouses().toString())); 
				return new ResponseEntity<List<UrlsList>>(list, headers.getHeader(), HttpStatus.ACCEPTED);
				
				
			}

}
