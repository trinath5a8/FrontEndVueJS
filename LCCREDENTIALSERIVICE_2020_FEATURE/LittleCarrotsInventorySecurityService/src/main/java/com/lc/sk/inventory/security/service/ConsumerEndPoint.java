package com.lc.sk.inventory.security.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lc.sk.inventory.security.beans.AppUserBean;
import com.lc.sk.inventory.security.beans.Authorization;
import com.lc.sk.inventory.security.beans.AuthorizedUsers;
import com.lc.sk.inventory.security.beans.Batch;
import com.lc.sk.inventory.security.beans.Categories;
import com.lc.sk.inventory.security.beans.Color;
import com.lc.sk.inventory.security.beans.Countries;
//import com.lc.sk.inventory.security.beans.DistinctProductDesId;
import com.lc.sk.inventory.security.beans.Genders;
import com.lc.sk.inventory.security.beans.Materialcomposition;
import com.lc.sk.inventory.security.beans.Materialtypes;
import com.lc.sk.inventory.security.beans.Materialtypessubcat;
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
import com.lc.sk.inventory.security.beans.PasswordUpdateBean;
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
import com.lc.sk.inventory.security.beans.SalesUser;
import com.lc.sk.inventory.security.beans.SeasonWear;
import com.lc.sk.inventory.security.beans.SeasonWearNew;
import com.lc.sk.inventory.security.beans.Seller;
import com.lc.sk.inventory.security.beans.SellerToWarehouse;
import com.lc.sk.inventory.security.beans.SellerToWarehouseBean;
import com.lc.sk.inventory.security.beans.SellerUsers;
import com.lc.sk.inventory.security.beans.Sizes;
import com.lc.sk.inventory.security.beans.SizesNew;
import com.lc.sk.inventory.security.beans.SubCategories;
import com.lc.sk.inventory.security.beans.UserRoles;
import com.lc.sk.inventory.security.beans.WarehouseBean;
import com.lc.sk.inventory.security.beans.Warehouses;
import com.lc.sk.inventory.security.rest.AuthorizationRestService;
import com.lc.sk.inventory.security.rest.AuthorizedUsersRestService;
import com.lc.sk.inventory.security.rest.BatchRestService;
import com.lc.sk.inventory.security.rest.CategoriesRestService;
import com.lc.sk.inventory.security.rest.ColorRestService;
import com.lc.sk.inventory.security.rest.CountriesRestService;
import com.lc.sk.inventory.security.rest.GendersRestService;
import com.lc.sk.inventory.security.rest.ImagesResetService;
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
import com.lc.sk.inventory.security.util.ConsumerURLMapping;
import com.lc.sk.inventory.security.util.HeaderComponent;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = ConsumerURLMapping.CEP+ConsumerURLMapping.VERSION)
public class ConsumerEndPoint {

	@Autowired
	private HeaderComponent headers;
	@Autowired
	BatchRestService batchRestService;
	@Autowired
	WarehousesRestService warehousesRestService;
	@Autowired
	private AuthorizedUsersRestService authorizedUsersRestService;
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
	
	@Autowired
	private ImagesResetService imageResetService;
	
	
	/* authorization role code start */

	@GetMapping(ConsumerURLMapping.USERROLES)
	@ResponseBody
	public ResponseEntity<List<Authorization>> getAllAuthorizationsList() {
		List<Authorization> authroizations = authorizationRestService.getAllRoleList();
		return new ResponseEntity<List<Authorization>>(authroizations, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@GetMapping(ConsumerURLMapping. USERROLES_BY_NAME)
	@ResponseBody
	public ResponseEntity<Authorization> getAuthorizationByRolename(@PathVariable String rolename) {
		Authorization authorization = authorizationRestService.getRoleByName(rolename);
		return new ResponseEntity<Authorization>(authorization, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@PostMapping(ConsumerURLMapping.USERROLES) // CODE FOR POST METHOD
	@ResponseBody
	public ResponseEntity<ResponseBean> insertData(@RequestBody UserRoles userroles)
	{
		return new ResponseEntity<ResponseBean>(
				authorizationRestService.insertAuthorization(userroles.getRolename(), userroles.getDescription(), userroles.getStatus()),
				headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@PutMapping(ConsumerURLMapping.USERROLES_BY_STATUS) // CODE FOR PUT
	@ResponseBody
	public ResponseEntity<ResponseBean> updateStatus(@PathVariable String rolename, @PathVariable boolean status) {
		return new ResponseEntity<ResponseBean>(authorizationRestService.updateAuthorizationStatus(rolename, status),
				headers.getHeader(), HttpStatus.ACCEPTED);
	}

	/* authorization role code end */
	
	
	// AUTHORIZED USERS SERVICE ACCESS
		@GetMapping(ConsumerURLMapping.AUTH_USERS)
		@ResponseBody
		public ResponseEntity<List<AuthorizedUsers>> getAllAuthorizedUsersList() {
			List<AuthorizedUsers> authorizedUsers = authorizedUsersRestService.getAllAuthorizedUsers();
			return new ResponseEntity<List<AuthorizedUsers>>(authorizedUsers, headers.getHeader(), HttpStatus.ACCEPTED);
		}

		@GetMapping(ConsumerURLMapping.AUTH_USERS_PATH_VARIABLE)
		@ResponseBody
		public ResponseEntity<AuthorizedUsers> getAuthorizedUserByusername(@PathVariable String username) {
			AuthorizedUsers authorizedUser = authorizedUsersRestService.getAuthorizedUserByUsername(username);
			return new ResponseEntity<AuthorizedUsers>(authorizedUser, headers.getHeader(), HttpStatus.ACCEPTED);
		}

		@PostMapping(ConsumerURLMapping.AUTH_USERS)
		@ResponseBody
		public ResponseEntity<ResponseBean> insertAuthorizedUser(@RequestBody AppUserBean user)
				{
			ResponseBean responseBean = authorizedUsersRestService.insertNewUser(
					user.getUsername(),user.getPassword(),user.getEmail(),user.getStatus(),	user.getRolename());
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}

		@PutMapping(ConsumerURLMapping.AUTH_USER_BLOCK)
		@ResponseBody
		public ResponseEntity<ResponseBean> blockAuthorizedUser(@PathVariable String username, @PathVariable boolean status) {
			ResponseBean responseBean = authorizedUsersRestService.blockUser(username, status);
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}

		
		@PutMapping(ConsumerURLMapping.AUTH_USERS)
		@ResponseBody
		public ResponseEntity<ResponseBean> passwordChange(@RequestBody PasswordUpdateBean pub)
		{
			ResponseBean responseBean = authorizedUsersRestService.passwordUpdate(pub.getUsername(), pub.getPassword(), pub.getNewPassword());
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
		/* auth user code end */
		
		
		/* seller user code start */
		@GetMapping(ConsumerURLMapping.SELLER_GET_PATH)
		@ResponseBody
		public ResponseEntity<List<SellerUsers>> getAllSalesUsers() {
			List<SellerUsers> salesUsers = salesSellerRestService.getAllSalesUsers();
			return new ResponseEntity<List<SellerUsers>>(salesUsers, headers.getHeader(), HttpStatus.ACCEPTED);
		}

		@GetMapping(ConsumerURLMapping.SELLER_GET_PATH_WITH_VARIABLE)
		@ResponseBody
		public ResponseEntity<SellerUsers> getSalesUser(@PathVariable String username) {
			SellerUsers sallerUser = salesSellerRestService.getSalesUserByusername(username);
			return new ResponseEntity<SellerUsers>(sallerUser, headers.getHeader(), HttpStatus.ACCEPTED);
		}

		@PostMapping(ConsumerURLMapping.SELLER_GET_PATH)
		@ResponseBody
		public ResponseEntity<ResponseBean> insertNewSalesUser(@RequestBody SalesUser salesUser)
		{
			ResponseBean responseBean = salesSellerRestService.insertNewSalesUser(salesUser.getUsername(), salesUser.getPassword(), salesUser.getEmail(),
					salesUser.getFullname(),salesUser.getRolename(), salesUser.getSellerid(), salesUser.getStatus());
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);

		}

		@PutMapping(ConsumerURLMapping.SELLER_PUT_STATUS)
		@ResponseBody
		public ResponseEntity<ResponseBean> updateStatus(@PathVariable String username, @PathVariable String status) {
			ResponseBean responseBean = salesSellerRestService.updateSalesUserStatus(username, status);
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);

		}

		@PutMapping(ConsumerURLMapping.SELLER_GET_PATH)
		@ResponseBody
		public ResponseEntity<ResponseBean> updateSalesUserPassword(@RequestBody PasswordUpdateBean pub)
		{
		ResponseBean responseBean = salesSellerRestService.updateSalesUserPasswrod(pub.getUsername(), pub.getPassword(), pub.getNewPassword());
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);

		}
		
		/* seller user code end */
		
		/* seller role code start */
		@GetMapping(ConsumerURLMapping.SELLERROLE_GET_PATH)
		@ResponseBody
		public ResponseEntity<List<Seller>> getAllSellers() {
			List<Seller> sellers = sellerRestService.getAllSellerDetails();
			return new ResponseEntity<List<Seller>>(sellers, headers.getHeader(), HttpStatus.ACCEPTED);
		}

		@GetMapping(ConsumerURLMapping.SELLERROLE_GET_PATH_WITH_VARIABLE)
		@ResponseBody
		public ResponseEntity<Seller> getAllSellers(@PathVariable Long sellerid) {
			Seller sellers = sellerRestService.getSellerById(sellerid);
			return new ResponseEntity<Seller>(sellers, headers.getHeader(), HttpStatus.ACCEPTED);
		}

		@PostMapping(ConsumerURLMapping.SELLERROLE_GET_PATH)
		@ResponseBody
		public ResponseEntity<ResponseBean> insertNewSeller(@RequestBody NewSellerBean nsb)
		{
			System.out.println(nsb);
		ResponseBean responseBean = sellerRestService.insertSeller(nsb.getSellercompanyname(), nsb.getSellername(), nsb.getPhone()+"", nsb.getEmail(),
					nsb.getAddress(), nsb.getIsocode(), nsb.getStatus());
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}

		@PutMapping(ConsumerURLMapping.SELLERROLE_GET_PATH)
		@ResponseBody
		public ResponseEntity<ResponseBean> updateSellerDetails(@RequestBody Seller seller)
		{
			ResponseBean responseBean = sellerRestService.updateSeller(seller.getSellerid()+"",seller.getSellercompanyname(), seller.getSellername(), seller.getPhone()+"", seller.getEmail(),
					seller.getAddress(), seller.getIsocode(), seller.getStatus()+"");
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}

		/* seller role code end */
		
		
		/* warehouse code start */
		@GetMapping(ConsumerURLMapping.WAREHOUSES_GET_PATH)
		@ResponseBody
		public ResponseEntity<List<Warehouses>> getAllWarehouseDetails() {
			List<Warehouses> warehouses = warehousesRestService.getAllWarehouses();
			return new ResponseEntity<List<Warehouses>>(warehouses, headers.getHeader(), HttpStatus.ACCEPTED);
		}

		@GetMapping(ConsumerURLMapping.WAREHOUSES_MAPPING_PATH_WITH_PATH_VARIABLE)
		@ResponseBody
		public ResponseEntity<Warehouses> getByIdwarehouse(@PathVariable String warehouseid) {
			Warehouses warehouse = warehousesRestService.getById(warehouseid);
			return new ResponseEntity<Warehouses>(warehouse, headers.getHeader(), HttpStatus.ACCEPTED);
		}

		@PostMapping(ConsumerURLMapping.WAREHOUSES_GET_PATH)
		@ResponseBody
		public ResponseEntity<ResponseBean> insertNewWarehouse(@RequestBody WarehouseBean wb)
		{
			ResponseBean responseBean = warehousesRestService.insertNewWarehouse(wb.getWarehousename(), wb.getContactpersonname(),
					wb.getContactphone(), wb.getEmail(), wb.getAddress(), wb.getPincode(), wb.getEst(), wb.getStatus(), wb.getUsername()
					, wb.getUsername(), wb.getIsocode());
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}

		@PutMapping(ConsumerURLMapping.WAREHOUSES_GET_PATH)
		@ResponseBody
		public ResponseEntity<ResponseBean> update(@RequestBody Warehouses wh)
		{	
			ResponseBean responseBean = warehousesRestService.update(wh.getWarehouseid()+"", wh.getWarehousename()+"", wh.getContactpersonname(),
						wh.getContactphone()+"", wh.getEmail(), wh.getAddress(), wh.getPincode()+"", wh.getEst()+"", wh.getWarehouse_status()+"", wh.getWhoupdated(), wh.getIsocode());
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}

		/* warehouse code end */
		
		
		/* Batch code start */
		
		@PostMapping(ConsumerURLMapping.BATCHES_GET_PATH)
		@ResponseBody
		public ResponseEntity<ResponseBean> insertNewBatch(@RequestBody NewBatch nb)
		{
			ResponseBean responseBean = batchRestService.insertBatch(nb.getWarehouseid(),  nb.getDateofpurchase(),  nb.getPurchasedby(),  nb.getInvamount(),
					 nb.getWhoinserted(),  nb.getStatus(),  nb.getIsocode(),  nb.getQty(), nb.getSellerid());
			return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
		@GetMapping(ConsumerURLMapping.BATCHES_GET_PATH)
		@ResponseBody
		public ResponseEntity<List<Batch>> getAllBatchList()
		{
			List<Batch> batches = batchRestService.getAllBatchList();
			return new ResponseEntity<List<Batch>>(batches, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
		
		@GetMapping(ConsumerURLMapping.BATCHES_MAPPING_PATH_WITH_PATH_VARIABLE)
		@ResponseBody
		public ResponseEntity<Batch> getBatchById(@PathVariable String batchid)
		{
			Batch batch = batchRestService.getBatchById(batchid);
			return new ResponseEntity<Batch>(batch, headers.getHeader(), HttpStatus.ACCEPTED);
		}
		
		@PutMapping(ConsumerURLMapping.BATCHID_PUT_PATH_WITH_VARIABLE)
	    @ResponseBody
	    public ResponseEntity<ResponseBean> updateBatch(@PathVariable String batchid, @PathVariable String status)
	    {
	           ResponseBean responseBean = batchRestService.updateBatch(batchid, status);
	           return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
	    }
		
		/* Batch code end */ 
		
		/* CategoriesService start end*/
		 @GetMapping(ConsumerURLMapping.CATEGORIES_MAPPING_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<Categories> getById(@PathVariable String catid)
			{
			 Categories categories = categoriesRestService.getById(catid);
				return new ResponseEntity<Categories>(categories, headers.getHeader(), HttpStatus.ACCEPTED);
			}
		 
		    @GetMapping(ConsumerURLMapping.CATEGORIES_MAPPING_PATH)
			@ResponseBody
			public ResponseEntity<List<Categories>> getAllCategories()
			{
		    	System.err.println("Hit at 490..");
		    	List<Categories> categories = categoriesRestService.getAllCategories();
				return new ResponseEntity<List<Categories>>(categories, headers.getHeader(), HttpStatus.ACCEPTED);
			}
	
		    @PutMapping(ConsumerURLMapping.CATEGORIES_MAPPING_PATH)
			 @ResponseBody
			 public ResponseEntity<ResponseBean> update(@RequestBody Categories cats)
			 {
				 ResponseBean responseBean = categoriesRestService.update(cats.getCatid()+"",cats.getCategory(),cats.getGender());
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
			 }
		    
		    @PostMapping(ConsumerURLMapping.CATEGORIES_MAPPING_PATH)
		    @ResponseBody
		    public ResponseEntity<ResponseBean> insertNewCategory(@RequestBody NewCategory nc)
		    {
		    	 ResponseBean responseBean = categoriesRestService.addCategory(nc.getCategory(), nc.getGender());
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
			 }
		    
		    /* CategoriesService code end*/ 
		    
		    
		    /* ColorRestService code start*/ 
		  
		    @PostMapping(ConsumerURLMapping.COLOR_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> insertNewColor(@RequestBody NewColor nc)
			{
				ResponseBean responseBean = colorRestService.insertNewColor(nc.getColorname(), nc.getHashcode());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
		    @PutMapping(ConsumerURLMapping.COLOR_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> updateColor(@RequestBody Color color)
			{
				ResponseBean responseBean = colorRestService.updateColor(color.getColorid()+"",color.getColorname(),color.getHashcode());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
		    
		    @GetMapping(ConsumerURLMapping.COLOR_PATH)
			@ResponseBody
			public ResponseEntity<List<Color>> getAllColors()
			{
				List<Color> responseBean = colorRestService.getAllColors();
				return new ResponseEntity<List<Color>>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(ConsumerURLMapping.COLOR_PATH_WITH_COLOR_ID)
			@ResponseBody
			public ResponseEntity<Color> getColorById(@PathVariable String colorid)
			{
				Color responseBean = colorRestService.getColorById(colorid);
				return new ResponseEntity<Color>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			 /* ColorRestService code end*/ 
			
			
			/* CountriesService code start*/ 
			
			@GetMapping(ConsumerURLMapping.COUNTRY_GET_PATH)
			@ResponseBody
			public ResponseEntity<List<Countries>> getAllCountries()
			{
				List<Countries> countries = countriesRestService.getAllCountries();
				return new ResponseEntity<List<Countries>>(countries, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(ConsumerURLMapping.COUNTRY_GET_PATH_WITH_VARIABLE)
			@ResponseBody
			public ResponseEntity<Countries> getCountryById(@PathVariable String isocode)
			{
				Countries country = countriesRestService.getCountryById(isocode);
				return new ResponseEntity<Countries>(country, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@PutMapping(ConsumerURLMapping.COUNTRY_PUT_PATH_WITH_VARIABLE)
			@ResponseBody
			public ResponseEntity<ResponseBean> enableCountry(@PathVariable String isocode,@PathVariable boolean status)
			{
				ResponseBean responseBean = countriesRestService.enableCountry(isocode, status);
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}

			@GetMapping(ConsumerURLMapping.COUNTRY_ACTIVE_GET)
			@ResponseBody
			public ResponseEntity<List<Countries>> getActivecountries()
			{
				List<Countries> countries = countriesRestService.getActiveCountries();
				return new ResponseEntity<List<Countries>>(countries, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			/* CountriesService code start*/ 
			
			
			/* GendersService code start*/ 
			@GetMapping(ConsumerURLMapping.GENDERS_GET_PATH)
			@ResponseBody
			public ResponseEntity<List<Genders>> getAllGendersServiceDetails()
			{
				List<Genders> genders = gendersRestService.getAllGendersDetails();
				return new ResponseEntity<List<Genders>>(genders, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(ConsumerURLMapping.GENDERS_MAPPING_PATH_WITH_PATH_VARIABLE)
			@ResponseBody
			public ResponseEntity<Genders> getGenderById(@PathVariable String genderid)
			{
				Genders genders = gendersRestService.getGenderById(genderid);
				
				return new ResponseEntity<Genders>(genders, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			/* GendersService code end*/ 
			
			
			/* MaterialcompositionService code start*/ 
			@PostMapping(ConsumerURLMapping.MATERIALCOMP_GET_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> insertMaterialcomposition(@RequestBody Materialcomposition matcomp)
							
			{
				ResponseBean responseBean = materialcompositionRestService.insertMaterialcomposition(matcomp.getMaterialid() +"", matcomp.getDescription()+"");
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			 @PutMapping(ConsumerURLMapping.MATERIALCOMP_GET_PATH)
				@ResponseBody
				public ResponseEntity<ResponseBean> updateMaterialcomposition(@RequestBody Materialcomposition matcomp)
				{
					ResponseBean responseBean = materialcompositionRestService.updateMaterialcomposition(matcomp.getMaterialid()+"",matcomp.getDescription());
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
				}

			@GetMapping(ConsumerURLMapping.MATERIALCOMP_GET_PATH)
			@ResponseBody
			public ResponseEntity<List<Materialcomposition>> getAllMaterialcomposition()
			{
				List<Materialcomposition> materialcomposition = materialcompositionRestService.getAllMaterialcomposition();
				return new ResponseEntity<List<Materialcomposition>>(materialcomposition, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(ConsumerURLMapping.MATERIALCOMPOSITION_GET_PATH_WITH_VARIABLE)
			@ResponseBody
			public ResponseEntity<Materialcomposition> getMaterialcompositionById(@PathVariable String materialid)
			{
				Materialcomposition materialcomposition = materialcompositionRestService.getMaterialcompositionById(materialid);
				return new ResponseEntity<Materialcomposition>(materialcomposition, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			/* MaterialcompositionService code end*/
			
			
			/* MaterialtypesService code start*/
			@PostMapping(ConsumerURLMapping.MATERIAL_GET_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> insertMaterialtype(@RequestBody NewMaterialtypes mattypes)
							
			{
				ResponseBean responseBean = materialtypesRestService.insertMaterialtype(mattypes.getMaterialname() +"", mattypes.getDescription()+"",mattypes.getOcid()+"",mattypes.getSeasonid()+"",mattypes.getCatid()+"");
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			@PutMapping(ConsumerURLMapping.MATERIAL_GET_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> updateMaterialtype(@RequestBody Materialtypes mattypes)
			{
				ResponseBean responseBean = materialtypesRestService.updateMaterialtype(mattypes.getMaterialid()+"",mattypes.getMaterialname()+"" , mattypes.getDescription()+"",mattypes.getOcid()+"",mattypes.getSeasonid()+"",mattypes.getCatid()+"");
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			@GetMapping(ConsumerURLMapping.MATERIAL_GET_PATH)
			@ResponseBody
			public ResponseEntity<List<Materialtypes>> getAllMaterialtypes()
			{
				List<Materialtypes> materialtypes = materialtypesRestService.getAllMaterialtypes();
				return new ResponseEntity<List<Materialtypes>>(materialtypes, headers.getHeader(), HttpStatus.ACCEPTED);
			}

			@GetMapping(ConsumerURLMapping.MATERIAL_GET_PATH1)
			@ResponseBody
			public ResponseEntity<List<Materialtypessubcat>> getAllMaterialtypessubcat(@PathVariable String sss,@PathVariable String sss1)
			{
				
				long temp_ocid , season_id , cat_id , season_sub_cat = 0 , occassion_sub_cat=0;
				List<Materialtypes> materialtypes = materialtypesRestService.getAllMaterialtypes();
				List<OccasionalWear> occasionalwear = occasionalwearRestService.getAllOccasionalWearDetails();
				List<SeasonWear> seasonwears = seasonwearRestService.getAllSeasonWearDetails();
				List<SubCategories> subcategories = subcategoriesRestService.getAllSubCategoriesDetails();
				List<Categories> categories = categoriesRestService.getAllCategories();
				
				List<Materialtypessubcat> obj = new CopyOnWriteArrayList<>();
				
				if(!materialtypes.isEmpty()) {
					for (Materialtypes me : materialtypes) 
					{	
						Materialtypessubcat ob = new Materialtypessubcat();
						ob.setMETERIAL_NAME(me.getMaterialname());
						ob.setMETERIALID(me.getMaterialid());
						ob.setDESCRIPTION(me.getDescription());
						season_id = me.getSeasonid();
						temp_ocid = me.getOcid();
						cat_id = me.getCatid();
						for(SeasonWear sw: seasonwears)
						{
							if(sw.getSeasonId() == season_id)
							{
								season_sub_cat = sw.getSubcatId();
								ob.setSEASON(sw.getSeason());
							}
						}
						for(OccasionalWear ow: occasionalwear) {
							if(ow.getOccasionid() ==temp_ocid) {
								occassion_sub_cat = ow.getSubcatid();
								ob.setOCCASSION(ow.getOccaname());
							}
						}
						for(Categories cats: categories) {
							if(cats.getCatid() == cat_id) {
								ob.setCATEGORY(cats.getCategory());
							}
						}
						for(SubCategories sc: subcategories) {
							if(sc.getSubcatid() == season_sub_cat ) {
								ob.setSEASON_SUBCATEGORY(sc.getCategoryname());
							}
							if(sc.getSubcatid() == occassion_sub_cat) {
								ob.setOCCASSION_SUBCATEGORY(sc.getCategoryname());
							}
						}
						obj.add(ob);
					}
				}
				
				
				return new ResponseEntity<List<Materialtypessubcat>>(obj, headers.getHeader(), HttpStatus.ACCEPTED);
				
			}

			@GetMapping(ConsumerURLMapping.MATERIALTYPE_GET_PATH_WITH_VARIABLE)
			@ResponseBody
			public ResponseEntity<Materialtypes> getMaterialtypeById(@PathVariable String materialid)
			{
				Materialtypes materialtypes = materialtypesRestService.getMaterialtypeById(materialid);
				return new ResponseEntity<Materialtypes>(materialtypes, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@PostMapping(ConsumerURLMapping.METERIAL_GET_PATH3)
			@ResponseBody
			public ResponseEntity<List<Materialtypes>> getDetailedMaterialType(@RequestBody ProductsPost pp){
				List<Materialtypes> materials = new CopyOnWriteArrayList<>();
				
				List<Materialtypes> materialtypes = materialtypesRestService.getAllMaterialtypes();
//				List<OccasionalWear> occasionalwear = occasionalwearRestService.getAllOccasionalWearDetails();
//				List<SeasonWear> seasonwears = seasonwearRestService.getAllSeasonWearDetails();
//				List<SubCategories> subcategories = subcategoriesRestService.getAllSubCategoriesDetails();
//				List<Categories> categories = categoriesRestService.getAllCategories();
				if(!materialtypes.isEmpty()&& pp.getCatid()!=0&&pp.getOccasionid()!=0&&pp.getSeasonid()!=0) {
				for(Materialtypes mt: materialtypes) {
					if(mt.getCatid()== pp.getCatid() && mt.getOcid() == pp.getOccasionid() && mt.getSeasonid()==pp.getSeasonid()) {
						materials.add(mt);
					}
				}
				}
				
				return new ResponseEntity<List<Materialtypes>>(materials, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			/* MaterialtypesService code end*/
			
			
			/* NoOfPiecesService code start*/
			@PostMapping(ConsumerURLMapping.NO_OF_PIECES_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> insertNoOfPiecesList(@RequestBody NoOfPiecesPost npp)
			{
				ResponseBean responseBean = noOfPiecesRestService.insertNoOfPiecesList(npp.getProductid()+"",npp.getNoofset()+"");
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			@GetMapping(ConsumerURLMapping.NO_OF_PIECES_PATH)
			@ResponseBody
			public ResponseEntity<List<NoOfPieces>> getAllNoOfPieces(
					)
			{
				List<NoOfPieces> responseBean = noOfPiecesRestService.getAllNoOfPieces();
			
				return new ResponseEntity<List<NoOfPieces>>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(ConsumerURLMapping.NO_OF_PIECES_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<NoOfPieces> getNoOfPiecesId(@PathVariable String pieceid)
					
			{
				NoOfPieces responseBean = noOfPiecesRestService.getNoOfPiecesId(pieceid);
				
				return new ResponseEntity<NoOfPieces>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@PutMapping(ConsumerURLMapping.NO_OF_PIECES_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> NoOfPiecesServiceupdate(@RequestBody NoOfPieces np)
			{
				ResponseBean responseBean = noOfPiecesRestService.update(np.getPieceid()+"",np.getProductid()+"",np.getNoofset()+"");
			
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			/* NoOfPiecesService code end*/
			
			
			/* OccasionalWearService code start*/
			@PostMapping(ConsumerURLMapping.OCCASIONALWEAR_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> insert4(@RequestBody OccasionalWearBean OWB)
					{
				ResponseBean responseBean = occasionalwearRestService.InsertOccasionalWearDetails(OWB.getOccaname(),OWB.getSubcatid()+"");
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			@GetMapping(ConsumerURLMapping.OCCASIONALWEAR_PATH)
			@ResponseBody
			public ResponseEntity<List<OccasionalWear>> getAllOccasionalWearDetails()
			{
				List<OccasionalWear> occasionalwear = occasionalwearRestService.getAllOccasionalWearDetails();
				
				return new ResponseEntity<List<OccasionalWear>>(occasionalwear, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(ConsumerURLMapping.OCCASIONALWEAR_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<OccasionalWear> getOccasionalWearById(@PathVariable String occasionid)
			{
				OccasionalWear occasionalwear = occasionalwearRestService.getOccasionalWearById(occasionid);
				
				return new ResponseEntity<OccasionalWear>(occasionalwear, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			@PutMapping(ConsumerURLMapping.OCCASIONALWEAR_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> update	(@RequestBody OccasionalWear OW)
			{
					ResponseBean responseBean = occasionalwearRestService.UpdateOccasionalWearDetails(OW.getOccasionid()+"",OW.getOccaname(),OW.getSubcatid()+"");
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
				}
			/* OccasionalWearService code end*/
			
			
			/* PatternsService code start*/
			@PostMapping(ConsumerURLMapping.PATTERNS_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> insertPatternsService(@RequestBody PatternsPOSTBean PPB)
					
			{
				ResponseBean responseBean = patternsRestService.InsertPatternsDetails(PPB.getDescription(),PPB.getProductid()+"");
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			@GetMapping(ConsumerURLMapping.PATTERNS_PATH)
			@ResponseBody
			public ResponseEntity<List<Patterns>> getAllPatternsDetails()
			{
				List<Patterns>  patterns = patternsRestService.getAllPatternsDetails();
			
				return new ResponseEntity<List<Patterns>>( patterns, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(ConsumerURLMapping.PATTERNS_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<Patterns> getPatternsById(@PathVariable String patid)
			{
				Patterns  patterns = patternsRestService.getPatternsById(patid);
				
				return new ResponseEntity<Patterns>( patterns, headers.getHeader(), HttpStatus.ACCEPTED);
			}

			@PutMapping(ConsumerURLMapping.PATTERNS_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> PatternsServiceupdate(@RequestBody Patterns PB)
			{
				ResponseBean responseBean = patternsRestService.UpdatePatternsDetails(PB.getPatid()+"",PB.getDescription(),PB.getProductid()+"");
				
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
						
			/* PatternsService code end*/
			
			/* PricesTableService code start*/
			@PostMapping(path = ConsumerURLMapping.PRICES_TABLE_PATH)
			@ResponseBody	
			public ResponseEntity<ResponseBean> insertPrices(@RequestBody PricesTablePost PTP)
					{
				ResponseBean responseBean = pricesTableRestService.insertprices(PTP.getMrp()+"",PTP.getProductid()+"",PTP.getLcPrice()+"",PTP.getTax()+"",PTP.getSellingPrice()+"",PTP.getFinalPrice()+"");
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
			}
			@GetMapping(ConsumerURLMapping.PRICES_TABLE_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<PricesTable> PricesTableServicegetById(@PathVariable String productid)
			{
				PricesTable prices = pricesTableRestService.getpricebyid(productid);
				
				return new ResponseEntity<PricesTable>(prices, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(ConsumerURLMapping.PRICES_TABLE_PATH)
			@ResponseBody
			public ResponseEntity<List<PricesTable>> getallprices()
			{
				List<PricesTable> prices = pricesTableRestService.getallprices();
			
				return new ResponseEntity<List<PricesTable>>(prices, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@PutMapping(path = ConsumerURLMapping.PRICES_TABLE_PATH)
			@ResponseBody	
			public ResponseEntity<ResponseBean> updatePrices(@RequestBody PricesTable PT)
			{
				ResponseBean responseBean = pricesTableRestService.updateprices(PT.getPriceId()+"",PT.getMrp()+"",PT.getProductid()+"",PT.getLcPrice()+"",PT.getTax()+"",PT.getSellingPrice()+"",PT.getFinalPrice()+"");
			
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
			}
			/* PricesTableService code end*/
			
			/* ProductAgeService code start*/

			@PostMapping(ConsumerURLMapping.PRODUCTAGE_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> addProductAge(@RequestBody ProductAge PA)
			{
				ResponseBean responseBean = productAgeRestService.addProductAge(PA.getAgeid()+"",PA.getDes());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			@GetMapping(ConsumerURLMapping.PRODUCTAGE_PATH)
			@ResponseBody
			public ResponseEntity<List<ProductAge>> getAll(
					)
			{
				List<ProductAge> responseBean = productAgeRestService.getAll();
				
				return new ResponseEntity<List<ProductAge>>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(ConsumerURLMapping.PRODUCTAGE_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<ProductAge> getProductAgeById(@PathVariable String ageid)
					
			{
				ProductAge responseBean = productAgeRestService.getProductAgeById(ageid);
				
				return new ResponseEntity<ProductAge>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
						
			@PutMapping(ConsumerURLMapping.PRODUCTAGE_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> ProductAgeServiceupdate(@RequestBody ProductAge PA)
			{
				ResponseBean responseBean = productAgeRestService.update(PA.getAgeid()+"",PA.getDes());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			/* ProductAgeService code end*/
			
			
			/* ProductDescriptionsService code start*/
			@PostMapping(path = ConsumerURLMapping.PRODUCTDESCRIPTION_MAPPING_PATH)
			@ResponseBody	
			public ResponseEntity<ResponseBean> insertion(@RequestBody ProductDescriptionsPost PDP)
			{
				ResponseBean responseBean = productDescriptionsRestService.insert(PDP.getDescription());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
			}
			@GetMapping(ConsumerURLMapping.PRODUCTDESCRIPTION_MAPPING_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<ProductDescriptions> ProductDescriptionsServicegetById(@PathVariable String descriptionid)
			{
		 		ProductDescriptions productDescriptions = productDescriptionsRestService.getById(descriptionid);
				
				return new ResponseEntity<ProductDescriptions>(productDescriptions, headers.getHeader(), HttpStatus.ACCEPTED);
			}
		 	
		 	@GetMapping(ConsumerURLMapping.PRODUCTDESCRIPTION_MAPPING_PATH)
			@ResponseBody
			public ResponseEntity<List<ProductDescriptions>> getAllProductDescriptions()
			{
		    	List<ProductDescriptions> productDescriptions = productDescriptionsRestService.getAllProductDescriptions();
			
				return new ResponseEntity<List<ProductDescriptions>>(productDescriptions, headers.getHeader(), HttpStatus.ACCEPTED);
			}
		 	
		 	@GetMapping(ConsumerURLMapping.PRODUCTDESCRIPTION_MAPPING_PATH1)
		 	@ResponseBody
			public ResponseEntity<List<ProductDescriptions>> getDistinctProductDescription(@PathVariable String sss,@PathVariable String sss1)
			{
				
			
				List<ProductDescriptions> pd = productDescriptionsRestService.getAllProductDescriptions();
				List<Products> products = productsRestService.getall();
				
			
				
				if(!pd.isEmpty()) {
					for(Products p: products) {
					for (int i=0;i<pd.size();i++) 
					{	
						
						
							if(p.getDescriptionid() == pd.get(i).getDescriptionid() ) {
								pd.remove(i);
							}
						}
						
					}
				}
				
				
				return new ResponseEntity<List<ProductDescriptions>>(pd, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
		 	 @PutMapping(path = ConsumerURLMapping.PRODUCTDESCRIPTION_MAPPING_PATH)
			 @ResponseBody
			 public ResponseEntity<ResponseBean> ProductDescriptionsServiceupdate(@RequestBody ProductDescriptions PD)
				{
				 ResponseBean responseBean = productDescriptionsRestService.update(PD.getDescriptionid()+"",PD.getDescription());
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
			 }
							
			/* ProductDescriptionsService code end*/
		 	 
		 	/* ProductQuantitiesService code start*/
		 	@PostMapping(ConsumerURLMapping.PRODUCTQUANTITIES_GET_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> insert5(@RequestBody ProductQuantitiesPost PQT)
			{
				ResponseBean responseBean = productquantitiesRestService.insertProductQuantities(PQT.getQuantity()+"",PQT.getSizeid()+"");
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			 	@GetMapping(ConsumerURLMapping.PRODUCTQUANTITIES_GET_PATH)
				@ResponseBody
				public ResponseEntity<List<ProductQuantities>> getAllProductquantities()
				{
					List<ProductQuantities> productquantities = productquantitiesRestService.getAllProductQuantities();
					
					return new ResponseEntity<List<ProductQuantities>>(productquantities, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				@GetMapping(ConsumerURLMapping.PRODUCTQUANTITIES_GET_PATH_WITH_VARIABLE)
				@ResponseBody
				public ResponseEntity<ProductQuantities> getProductQuantitiesById(@PathVariable String custid)
				{
					ProductQuantities productquantities = productquantitiesRestService.getProductQuantitiesById(custid);
					
					return new ResponseEntity<ProductQuantities>(productquantities, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				@GetMapping(ConsumerURLMapping.PRODUCTQUANTITIES_MAPPING_PATH1)
			 	@ResponseBody
				public ResponseEntity<List<ProductQuantities>> getAllProductquantities(@PathVariable String sss,@PathVariable String sss1)
				{
					
				
					List<ProductQuantities> pq = productquantitiesRestService.getAllProductQuantities();
					List<Products> products = productsRestService.getall();
					
				
					
					if(!pq.isEmpty()) {
						for(Products p: products) {
						for (int i=0;i<pq.size();i++) 
						{	
							
							
								if(p.getCustid() == pq.get(i).getCustid() ) {
									pq.remove(i);
								}
							}
							
						}
					}
					
					
					return new ResponseEntity<List<ProductQuantities>>(pq, headers.getHeader(), HttpStatus.ACCEPTED);
				}
			 	 
				@PutMapping(ConsumerURLMapping.PRODUCTQUANTITIES_GET_PATH)
				@ResponseBody
				public ResponseEntity<ResponseBean> ProductDescriptionsServiceupdate(@RequestBody ProductQuantities PQ)
				{
					ResponseBean responseBean = productquantitiesRestService.updateProductQuantities(PQ.getCustid()+"",PQ.getQuantity()+"",PQ.getSizeid()+"");
					
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				/* ProductQuantitiesService code end*/
				
				/* ProductsService code start*/ 
				@PostMapping( ConsumerURLMapping.PRODUCTS_MAPPING_PATH)
				@ResponseBody	
				public ResponseEntity<ResponseBean> insert(@RequestBody ProductsPost PBP)
				{
				
						ResponseBean responseBean = productsRestService.insert(PBP.getDescriptionid()+"",PBP.getBatchid()+"",PBP.getGenderid()+"",PBP.getCatid()+"",PBP.getSubcatid()+"",PBP.getSeasonid()+"",PBP.getOccasionid()+"",PBP.getAgeid()+"",PBP.getMaterialid()+"",PBP.getColorid()+"",PBP.getCustid()+"",PBP.getStatus());
						return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
					
				}
				@GetMapping(ConsumerURLMapping.PRODUCTS_MAPPING_PATH_PRODUCT_ID)
				@ResponseBody
				public ResponseEntity<Products> ProductsServicegetById(@PathVariable String productid)
				{
					Products products = productsRestService.getbyid(productid);
				
					return new ResponseEntity<Products>(products, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				
				@GetMapping(ConsumerURLMapping.PRODUCTS_MAPPING_PATH)
				@ResponseBody
				public ResponseEntity<List<Products>> getall()
				{
					List<Products> products = productsRestService.getall();
				
					return new ResponseEntity<List<Products>>(products, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				@PutMapping(ConsumerURLMapping.PRODUCTS_MAPPING_PATH)
				@ResponseBody	
				public ResponseEntity<ResponseBean> updatesize(@RequestBody Products PBP)
				{
					ResponseBean responseBean = productsRestService.update(PBP.getProductid()+"",PBP.getDescriptionid()+"",PBP.getBatchid()+"",PBP.getGenderid()+"",PBP.getCatid()+"",PBP.getSubcatid()+"",PBP.getSeasonid()+"",PBP.getOccasionid()+"",PBP.getAgeid()+"",PBP.getMaterialid()+"",PBP.getColorid()+"",PBP.getCustid()+"",PBP.getStatus());
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
				}
			 	 
				@PutMapping( ConsumerURLMapping.PRODUCTS_MAPPING_PATH_WITH_PATH_VARIABLE_1)
				@ResponseBody
				public ResponseEntity<ResponseBean> enableBatchStatus(@PathVariable String productid,@PathVariable boolean status)
				{
					ResponseBean response = productsRestService.enableBatchStatus(productid, status);
					
					return new ResponseEntity<ResponseBean>(response, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
			 	/* ProductsService code end*/ 
				
				
				/* ProductTypeService code start*/ 
				@PostMapping(ConsumerURLMapping.PRODUCTTYPE_GET_PATH)
				@ResponseBody
				public ResponseEntity<ResponseBean> insertProductTypeService(@RequestBody ProductTypePost PTP)
				{
					ResponseBean responseBean = producttypeRestService.InsertProductType(PTP.getSubcatid()+"",PTP.getProducttypename());
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
				}
			 @GetMapping(ConsumerURLMapping.PRODUCTTYPE_GET_PATH)
				@ResponseBody
				public ResponseEntity<List<ProductType>> getAllProductTypeDetails()
				{
					List<ProductType> producttype = producttypeRestService.getAllProductTypeDetails();
				
					return new ResponseEntity<List<ProductType>>(producttype, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				
				@GetMapping(ConsumerURLMapping.PRODUCTTYPE_PATH_WITH_ID)
				@ResponseBody
				public ResponseEntity<ProductType> ProductTypeServicegetProductTypeById(@PathVariable String protypeid)
				{
					ProductType producttype = producttypeRestService.getProductTypeById(protypeid);
					
					return new ResponseEntity<ProductType>(producttype, headers.getHeader(), HttpStatus.ACCEPTED);
				}
			 	 

				@PutMapping(ConsumerURLMapping.PRODUCTTYPE_GET_PATH)
				@ResponseBody
				public ResponseEntity<ResponseBean> ProductTypeServiceupdate(@RequestBody ProductType PT)		
				{
					ResponseBean responseBean = producttypeRestService.UpdateProductType(PT.getProtypeid()+"",PT.getSubcatid()+"",PT.getProducttypename());
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
				}				 	 
				/* ProductTypeService code end*/ 
				
				
				/* SalesSellerService start here*/
				
				@GetMapping(ConsumerURLMapping.SALES_SELLER_GET_PATH)
				@ResponseBody
				public ResponseEntity<List<SellerUsers>> getAllSalesUsers(HttpServletRequest request)
				{
					String rolename = (String) request.getSession().getAttribute(ConstantValues.SESSION_ROLENAME);
					System.out.println("Rolename:"+rolename);
					List<SellerUsers> salesUsers = salesSellerRestService.getAllSalesUsers();
					return new ResponseEntity<List<SellerUsers>>(salesUsers, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				
				@GetMapping(ConsumerURLMapping.SALES_SELLER_GET_PATH_WITH_VARIABLE)
				@ResponseBody
				public ResponseEntity<SellerUsers> getSalesUsers(@PathVariable String username)
				{
					SellerUsers sallerUser = salesSellerRestService.getSalesUserByusername(username);
					return new ResponseEntity<SellerUsers>(sallerUser, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				/* SalesSellerService end here*/
				
				/* SeasonWearService code start*/ 
				@PostMapping(ConsumerURLMapping.SEASON_WEAR)
				@ResponseBody
				public ResponseEntity<ResponseBean> insert6(@RequestBody SeasonWearNew SWN)
				{
					ResponseBean responseBean = seasonwearRestService.InsertSeasonWearDetails(SWN.getSubcatId()+"",SWN.getSeason());
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				@GetMapping(ConsumerURLMapping.SEASON_WEAR)
				@ResponseBody
				public ResponseEntity<List<SeasonWear>> getAllSeasonWearDetails()
				{
					List<SeasonWear> seasonwear = seasonwearRestService.getAllSeasonWearDetails();
					
					return new ResponseEntity<List<SeasonWear>>(seasonwear, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				
				@GetMapping(ConsumerURLMapping.SEASON_WEAR_BY_ID)
				@ResponseBody
				public ResponseEntity<SeasonWear> getSeasonWearById(@PathVariable String seasonid)
				{
					SeasonWear seasonwear = seasonwearRestService.getSeasonWearById(seasonid);
					
					return new ResponseEntity<SeasonWear>(seasonwear, headers.getHeader(), HttpStatus.ACCEPTED);
				}
			 	 
				@PutMapping(ConsumerURLMapping.SEASON_WEAR)
				@ResponseBody
				public ResponseEntity<ResponseBean> SeasonWearServiceupdate(@RequestBody SeasonWear Sw)
				{
					ResponseBean responseBean = seasonwearRestService.UpdateSeasonWearDetails(Sw.getSeasonId()+"",Sw.getSubcatId()+"",Sw.getSeason());
					
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
				}
			 	 
				/* SeasonWearService code end*/ 
				
				
				/* SellerToWarehouseService code start*/ 
				@PostMapping(ConsumerURLMapping.WAREHOUSETOSELLER_POST)
				@ResponseBody	
				public ResponseEntity<ResponseBean> addList(@RequestBody SellerToWarehouseBean stwb)
			
						{
						ResponseBean responseBean = sellerToWarehouseRestService.addList(stwb.getWarehouseid()+"", stwb.getSellerid()+"");
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
				}
				@GetMapping(ConsumerURLMapping.WAREHOUSETOSELLER_GET)
				@ResponseBody
				public ResponseEntity<List<SellerToWarehouse>> SellerToWarehouseServicegetAll()
				{
			    	List<SellerToWarehouse>  sellerToWarehouse= sellerToWarehouseRestService.getAllData();
				
					return new ResponseEntity<List<SellerToWarehouse>>(sellerToWarehouse, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				
				/* SellerToWarehouseService code end*/ 
				
				
				/* SizesService code start*/
				@PostMapping(path = ConsumerURLMapping.SIZES_MAPPING_PATH)
				@ResponseBody	
				public ResponseEntity<ResponseBean> insertSeasonWear(@RequestBody SizesNew SNB)
				{
					ResponseBean responseBean = sizesRestService.insertSeasonWear(SNB.getAgeid()+"",SNB.getGender()+"",SNB.getSizeno()+"",SNB.getHeight()+"",SNB.getWeight()+"",SNB.getChest()+"",SNB.getWaist()+"",SNB.getHip());
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
				}
				@GetMapping(ConsumerURLMapping.SIZES_MAPPING_PATH_WITH_ID)
				@ResponseBody
				public ResponseEntity<Sizes> SizesServicegetById(@PathVariable String sizeid)
				{
					//System.out.println("At 1096..................................|||||||||||||||||||||||||||||||");
					Sizes sizes = sizesRestService.getsizebyid(sizeid);
				
					return new ResponseEntity<Sizes>(sizes, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				@GetMapping(ConsumerURLMapping.SIZES_MAPPING_PATH)
				@ResponseBody
				public ResponseEntity<List<Sizes>> getAllSizes()
				{
					List<Sizes> sizes = sizesRestService.getAllSizes();
					
					return new ResponseEntity<List<Sizes>>(sizes, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				@PutMapping(path = ConsumerURLMapping.SIZES_MAPPING_PATH)
				@ResponseBody	
				public ResponseEntity<ResponseBean> updatesize(@RequestBody Sizes SB)
				{
					ResponseBean responseBean = sizesRestService.updatesize(SB.getSizeid()+"",SB.getAgeid()+"",SB.getGender()+"",SB.getSizeno()+"",SB.getHeight()+"",SB.getWeight()+"",SB.getChest()+"",SB.getWaist()+"",SB.getHip());
					
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
				}
				
				/* SizesService code end*/
				
				/* SubCategoriesService code start*/
				
				@PostMapping(ConsumerURLMapping.SUBCATEGORIES_GET_PATH)
				@ResponseBody
				public ResponseEntity<ResponseBean> insertSubcategorytype(@RequestBody NewSubCategory newsubcat)	
						
				{
					ResponseBean responseBean = subcategoriesRestService.insertSubcategorytype(newsubcat.getCatid()+"",newsubcat.getCategoryname()+"");
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				@GetMapping(ConsumerURLMapping.SUBCATEGORIES_GET_PATH)
				@ResponseBody
				public ResponseEntity<List<SubCategories>> getAllSubCategoriesDetails()
				{
					List<SubCategories> subcategories = subcategoriesRestService.getAllSubCategoriesDetails();
				
					return new ResponseEntity<List<SubCategories>>(subcategories, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				@GetMapping(ConsumerURLMapping.SUBCATEGORIES_MAPPING_PATH_WITH_VARIABLE )
				@ResponseBody
				public ResponseEntity<SubCategories> getSubCategoriesById(@PathVariable String subcatid)
				{
					SubCategories subcategories = subcategoriesRestService.getSubCategoriesById(subcatid);
				
					return new ResponseEntity<SubCategories>(subcategories, headers.getHeader(), HttpStatus.ACCEPTED);
				}

				@PutMapping(ConsumerURLMapping.SUBCATEGORIES_GET_PATH)
				@ResponseBody
				public ResponseEntity<ResponseBean> SubCategoriesServiceupdate(@RequestBody SubCategories subcat)
				{
					ResponseBean responseBean = subcategoriesRestService.updateSubcategorytype(subcat.getSubcatid()+"", subcat.getCatid()+"", subcat.getCategoryname()+"");
					
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
				}
				/* SubCategoriesService code end*/
				
				
				//PRODUCT MANAGEMENT CODE START
				@GetMapping(ConsumerURLMapping.PRODUCT_IMG_LIST)
				@ResponseBody
				public ResponseEntity<List<Long>> getAllImageProductIds(){
					return new ResponseEntity<List<Long>>(imageResetService.getAllProductIdsFromImgService(), headers.getHeader(), HttpStatus.ACCEPTED);
				}
				
				@GetMapping(ConsumerURLMapping.NO_IMG_PROD)
				@ResponseBody //returning product ids
				public ResponseEntity<List<Long>> getNoImgProducts(){
					List<Long> data = new CopyOnWriteArrayList<>() ;
					List<Long> imgprdid = imageResetService.getAllProductIdsFromImgService();
					List<Products> products = productsRestService.getall();
					for(int i=0;i<products.size();i++) {
						if(imgprdid.contains(products.get(i).getProductid())) {
							products.remove(i);
						}
					}
					for(Products pp: products) {
						data.add(pp.getProductid());
					}
					return new ResponseEntity<List<Long>>(data, headers.getHeader(), HttpStatus.ACCEPTED); 
				}
				//PRODUCT MANAGEMENT CODE END
}
