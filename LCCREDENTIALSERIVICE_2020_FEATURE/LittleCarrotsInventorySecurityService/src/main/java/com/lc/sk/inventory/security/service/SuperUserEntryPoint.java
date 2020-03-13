/**
 * 
 */
package com.lc.sk.inventory.security.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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

import com.lc.sk.inventory.security.beans.AppUserBean;
import com.lc.sk.inventory.security.beans.Authorization;
import com.lc.sk.inventory.security.beans.AuthorizedUsers;
import com.lc.sk.inventory.security.beans.Batch;
import com.lc.sk.inventory.security.beans.Categories;
import com.lc.sk.inventory.security.beans.Color;
import com.lc.sk.inventory.security.beans.Countries;
import com.lc.sk.inventory.security.beans.Genders;
import com.lc.sk.inventory.security.beans.Materialcomposition;
import com.lc.sk.inventory.security.beans.Materialtypes;
import com.lc.sk.inventory.security.beans.NewCategory;
import com.lc.sk.inventory.security.beans.NewSellerBean;
import com.lc.sk.inventory.security.beans.NoOfPieces;
import com.lc.sk.inventory.security.beans.OccasionalWear;
import com.lc.sk.inventory.security.beans.PasswordUpdateBean;
import com.lc.sk.inventory.security.beans.Patterns;
import com.lc.sk.inventory.security.beans.PricesTable;
import com.lc.sk.inventory.security.beans.ProductAge;
import com.lc.sk.inventory.security.beans.ProductDescriptions;
import com.lc.sk.inventory.security.beans.ProductQuantities;
import com.lc.sk.inventory.security.beans.ProductType;
import com.lc.sk.inventory.security.beans.Products;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.beans.SalesUser;
import com.lc.sk.inventory.security.beans.SeasonWear;
import com.lc.sk.inventory.security.beans.Seller;
import com.lc.sk.inventory.security.beans.SellerToWarehouse;
import com.lc.sk.inventory.security.beans.SellerToWarehouseBean;
import com.lc.sk.inventory.security.beans.SellerUsers;
import com.lc.sk.inventory.security.beans.Sizes;
import com.lc.sk.inventory.security.beans.SubCategories;
import com.lc.sk.inventory.security.beans.UrlsList;
import com.lc.sk.inventory.security.beans.UserRoles;
import com.lc.sk.inventory.security.beans.WarehouseBean;
import com.lc.sk.inventory.security.beans.Warehouses;
import com.lc.sk.inventory.security.rest.AuthorizationRestService;
import com.lc.sk.inventory.security.rest.AuthorizedUsersRestService;
import com.lc.sk.inventory.security.rest.BatchRestService;
import com.lc.sk.inventory.security.rest.CategoriesRestService;
import com.lc.sk.inventory.security.rest.ColorRestService;
import com.lc.sk.inventory.security.rest.CountriesRestService;
import com.lc.sk.inventory.security.rest.ProductquantitiesRestService;
import com.lc.sk.inventory.security.rest.SalesSellerRestService;
import com.lc.sk.inventory.security.rest.SellerRestService;
import com.lc.sk.inventory.security.rest.WarehousesRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
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
import com.lc.sk.inventory.security.rest.ProductsRestService;
import com.lc.sk.inventory.security.rest.SeasonWearRestService;
import com.lc.sk.inventory.security.rest.SellerToWarehouseRestService;
import com.lc.sk.inventory.security.rest.SizesRestService;
import com.lc.sk.inventory.security.rest.SubCategoriesRestService;
import com.lc.sk.inventory.security.util.HeaderComponent;
import com.lc.sk.inventory.security.util.SuperUserUrlMapping;
import com.lc.sk.inventory.security.util.URLMapping;;

/**
 * @author Mastanvali Shaik LittleCarrotsInventorySecurityService 2020
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = SuperUserUrlMapping.SUPER_USER_ENTRY_POINT_ROOT_PATH+URLMapping.VERSION)
public class SuperUserEntryPoint {

	// SERVICE COMPONENTS

	@Autowired
	private HeaderComponent headers;
	@Autowired
	private AuthorizedUsersRestService authorizedUsersRestService;
	@Autowired
	private AuthorizationRestService authorizationRestService;
	@Autowired
	private SalesSellerRestService salesSellerRestService;
	@Autowired
	private SellerRestService sellerRestService;
	@Autowired
	WarehousesRestService warehousesRestService;
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
	SeasonWearRestService seasonwearRestService;
	@Autowired
	SellerToWarehouseRestService sellerToWarehouseRestService;	
	@Autowired
	SizesRestService sizesRestService;
	@Autowired
	SubCategoriesRestService subcategoriesRestService;

	// AUTHORIZED USERS SERVICE ACCESS
	@GetMapping(SuperUserUrlMapping.AUTHORIZED_ADMIN_USER_GET_LINK)
	@ResponseBody
	public ResponseEntity<List<AuthorizedUsers>> getAllAuthorizedUsersList() {
		List<AuthorizedUsers> authorizedUsers = authorizedUsersRestService.getAllAuthorizedUsers();
		return new ResponseEntity<List<AuthorizedUsers>>(authorizedUsers, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@GetMapping(SuperUserUrlMapping.AUTH_USER_ADMIN_GET_WITH_PATH_VARIABLE)
	@ResponseBody
	public ResponseEntity<AuthorizedUsers> getAuthorizedUserByusername(@PathVariable String username) {
		AuthorizedUsers authorizedUser = authorizedUsersRestService.getAuthorizedUserByUsername(username);
		return new ResponseEntity<AuthorizedUsers>(authorizedUser, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@PostMapping(SuperUserUrlMapping.AUTHORIZED_ADMIN_USER_GET_LINK)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertAuthorizedUser(@RequestBody AppUserBean user)
			{
		ResponseBean responseBean = authorizedUsersRestService.insertNewUser(
				user.getUsername(),user.getPassword(),user.getEmail(),user.getStatus(),	user.getRolename());
		return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@PutMapping(SuperUserUrlMapping.AUTH_ADMIN_USER_BLOCK)
	@ResponseBody
	public ResponseEntity<ResponseBean> blockAuthorizedUser(@PathVariable String username, @PathVariable boolean status) {
		ResponseBean responseBean = authorizedUsersRestService.blockUser(username, status);
		return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	
	@PutMapping(SuperUserUrlMapping.AUTHORIZED_ADMIN_USER_GET_LINK)
	@ResponseBody
	public ResponseEntity<ResponseBean> passwordChange(@RequestBody PasswordUpdateBean pub)
	{
		ResponseBean responseBean = authorizedUsersRestService.passwordUpdate(pub.getUsername(), pub.getPassword(), pub.getNewPassword());
		return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	
	/* auth user code end */

	/* authorization role code start */

	@GetMapping(SuperUserUrlMapping.FIRSTPATH_1)
	@ResponseBody
	public ResponseEntity<List<Authorization>> getAllAuthorizationsList() {
		List<Authorization> authroizations = authorizationRestService.getAllRoleList();
		return new ResponseEntity<List<Authorization>>(authroizations, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@GetMapping(SuperUserUrlMapping.SECONDPATH_2)
	@ResponseBody
	public ResponseEntity<Authorization> getAuthorizationByRolename(@PathVariable String rolename) {
		Authorization authorization = authorizationRestService.getRoleByName(rolename);
		return new ResponseEntity<Authorization>(authorization, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@PostMapping(SuperUserUrlMapping.FIRSTPATH_1) // CODE FOR POST METHOD
	@ResponseBody
	public ResponseEntity<ResponseBean> insertData(@RequestBody UserRoles userroles)
	{
		return new ResponseEntity<ResponseBean>(
				authorizationRestService.insertAuthorization(userroles.getRolename(), userroles.getDescription(), userroles.getStatus()),
				headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@PutMapping(SuperUserUrlMapping.ADMIN_PATH_3) // CODE FOR PUT
	@ResponseBody
	public ResponseEntity<ResponseBean> updateStatus(@PathVariable String rolename, @PathVariable boolean status) {
		return new ResponseEntity<ResponseBean>(authorizationRestService.updateAuthorizationStatus(rolename, status),
				headers.getHeader(), HttpStatus.ACCEPTED);
	}

	/* authorization role code end */

	/* seller user code start */
	@GetMapping(SuperUserUrlMapping.FROMADMIN_TOSELLER_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<SellerUsers>> getAllSalesUsers() {
		List<SellerUsers> salesUsers = salesSellerRestService.getAllSalesUsers();
		return new ResponseEntity<List<SellerUsers>>(salesUsers, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@GetMapping(SuperUserUrlMapping.FROMADMIN_TOSELLER_GET_PATH_WITH_VARIABLE)
	@ResponseBody
	public ResponseEntity<SellerUsers> getSalesUser(@PathVariable String username) {
		SellerUsers sallerUser = salesSellerRestService.getSalesUserByusername(username);
		return new ResponseEntity<SellerUsers>(sallerUser, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@PostMapping(SuperUserUrlMapping.FROMADMIN_TOSELLER_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertNewSalesUser(@RequestBody SalesUser salesUser)
	{
		ResponseBean responseBean = salesSellerRestService.insertNewSalesUser(salesUser.getUsername(), salesUser.getPassword(), salesUser.getEmail(),
				salesUser.getFullname(),salesUser.getRolename(), salesUser.getSellerid(), salesUser.getStatus());
		return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);

	}

		@PutMapping(SuperUserUrlMapping.FROMADMIN_TOSALLER_PUT_STATUS)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateStatus(@PathVariable String username, @PathVariable String status) {
		ResponseBean responseBean = salesSellerRestService.updateSalesUserStatus(username, status);
		return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);

	}

	@PutMapping(SuperUserUrlMapping.FROMADMIN_TOSELLER_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateSalesUserPassword(@RequestBody PasswordUpdateBean pub)
	{
	ResponseBean responseBean = salesSellerRestService.updateSalesUserPasswrod(pub.getUsername(), pub.getPassword(), pub.getNewPassword());
		return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);

	}

	
	
	
	/* seller user code end */

	/* seller role code start */
	@GetMapping(SuperUserUrlMapping.FROMADMIN_TOSELLERROLE_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<Seller>> getAllSellers() {
		List<Seller> sellers = sellerRestService.getAllSellerDetails();
		return new ResponseEntity<List<Seller>>(sellers, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@GetMapping(SuperUserUrlMapping.FROMADMIN_TOSELLERROLE_GET_PATH_WITH_VARIABLE)
	@ResponseBody
	public ResponseEntity<Seller> getAllSellers(@PathVariable Long sellerid) {
		Seller sellers = sellerRestService.getSellerById(sellerid);
		return new ResponseEntity<Seller>(sellers, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@PostMapping(SuperUserUrlMapping.FROMADMIN_TOSELLERROLE_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertNewSeller(@RequestBody NewSellerBean nsb)
	{
		System.out.println(nsb);
	ResponseBean responseBean = sellerRestService.insertSeller(nsb.getSellercompanyname(), nsb.getSellername(), nsb.getPhone()+"", nsb.getEmail(),
				nsb.getAddress(), nsb.getIsocode(), nsb.getStatus());
		return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@PutMapping(SuperUserUrlMapping.FROMADMIN_TOSELLERROLE_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateSellerDetails(@RequestBody Seller seller)
	{
		ResponseBean responseBean = sellerRestService.updateSeller(seller.getSellerid()+"",seller.getSellercompanyname(), seller.getSellername(), seller.getPhone()+"", seller.getEmail(),
				seller.getAddress(), seller.getIsocode(), seller.getStatus()+"");
		return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	/* seller role code end */

	/* warehouse code start */
	@GetMapping(SuperUserUrlMapping.ADMIN_WAREHOUSES_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<Warehouses>> getAllWarehouseDetails() {
		List<Warehouses> warehouses = warehousesRestService.getAllWarehouses();
		return new ResponseEntity<List<Warehouses>>(warehouses, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@GetMapping(SuperUserUrlMapping.FROMADMIN_WAREHOUSES_MAPPING_PATH_WITH_PATH_VARIABLE)
	@ResponseBody
	public ResponseEntity<Warehouses> getByIdwarehouse(@PathVariable String warehouseid) {
		Warehouses warehouse = warehousesRestService.getById(warehouseid);
		return new ResponseEntity<Warehouses>(warehouse, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@PostMapping(SuperUserUrlMapping.ADMIN_WAREHOUSES_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertNewWarehouse(@RequestBody WarehouseBean wb)
	{
		ResponseBean responseBean = warehousesRestService.insertNewWarehouse(wb.getWarehousename(), wb.getContactpersonname(),
				wb.getContactphone(), wb.getEmail(), wb.getAddress(), wb.getPincode(), wb.getEst(), wb.getStatus(), wb.getUsername()
				, wb.getUsername(), wb.getIsocode());
		return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@PutMapping(SuperUserUrlMapping.ADMIN_WAREHOUSES_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> update(@RequestBody Warehouses wh)
	{	
		ResponseBean responseBean = warehousesRestService.update(wh.getWarehouseid()+"", wh.getWarehousename()+"", wh.getContactpersonname(),
					wh.getContactphone()+"", wh.getEmail(), wh.getAddress(), wh.getPincode()+"", wh.getEst()+"", wh.getWarehouse_status()+"", wh.getWhoupdated(), wh.getIsocode());
		return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	/* warehouse code end */
	
	/* Batch code start */
	@GetMapping(SuperUserUrlMapping.FROMADMIN_BATCHES_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<Batch>> getAllBatchList()
	{
		List<Batch> batches = batchRestService.getAllBatchList();
		return new ResponseEntity<List<Batch>>(batches, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	
	/*
	@PostMapping(SuperUserUrlMapping.FROMADMIN_BATCHES_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertNewBatch(@RequestBody NewBatch nb)
	{
		ResponseBean responseBean = batchRestService.insertBatch(nb.getWarehouseid(),  nb.getDateofpurchase(),  nb.getPurchasedby(),  nb.getInvamount(),
				 nb.getWhoinserted(),  nb.getStatus(),  nb.getIsocode(),  nb.getQty(), nb.getSellerid());
		return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	*/
	@GetMapping(SuperUserUrlMapping.FROMADMIN_BATCHES_MAPPING_PATH_WITH_PATH_VARIABLE)
	@ResponseBody
	public ResponseEntity<Batch> getBatchById(@PathVariable String batchid)
	{
		Batch batch = batchRestService.getBatchById(batchid);
		return new ResponseEntity<Batch>(batch, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	/*
	@PutMapping(SuperUserUrlMapping.FROMADMIN_BATCHES_PUT_STATUS_UPDATE)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateBatchStatus(@PathVariable String batchid, @PathVariable String status)
	{
		ResponseBean responseBean = batchRestService.updateBatch(batchid, status);
		return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	*/
	/* Batch code end */ 
	
	/* CategoriesService code start*/ 
	
	  @GetMapping(SuperUserUrlMapping.FROMADMIN_CATEGORIES_MAPPING_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<Categories> getById(@PathVariable String catid)
			{
			 Categories categories = categoriesRestService.getById(catid);
				return new ResponseEntity<Categories>(categories, headers.getHeader(), HttpStatus.ACCEPTED);
			}
		 
		    @GetMapping(SuperUserUrlMapping.FROMADMIN_CATEGORIES_MAPPING_PATH)
			@ResponseBody
			public ResponseEntity<List<Categories>> getAllCategories()
			{
		    	System.err.println("Hit at 490..");
		    	List<Categories> categories = categoriesRestService.getAllCategories();
				return new ResponseEntity<List<Categories>>(categories, headers.getHeader(), HttpStatus.ACCEPTED);
			}
	
		    @PutMapping(SuperUserUrlMapping.FROMADMIN_CATEGORIES_MAPPING_PATH)
			 @ResponseBody
			 public ResponseEntity<ResponseBean> update(@RequestBody Categories cats)
			 {
				 ResponseBean responseBean = categoriesRestService.update(cats.getCatid()+"",cats.getCategory(),cats.getGender());
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
			 }
		    
		    @PostMapping(SuperUserUrlMapping.FROMADMIN_CATEGORIES_MAPPING_PATH)
		    @ResponseBody
		    public ResponseEntity<ResponseBean> insertNewCategory(@RequestBody NewCategory nc)
		    {
		    	 ResponseBean responseBean = categoriesRestService.addCategory(nc.getCategory(), nc.getGender());
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
			 }
		    
		    /* CategoriesService code end*/ 
		    
		    
		    /* ColorRestService code start*/ 
		    
		    @GetMapping(SuperUserUrlMapping.ADMIN_COLOR_PATH)
			@ResponseBody
			public ResponseEntity<List<Color>> getAllColors()
			{
				List<Color> responseBean = colorRestService.getAllColors();
				return new ResponseEntity<List<Color>>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(SuperUserUrlMapping.ADMIN_COLOR_PATH_WITH_COLOR_ID)
			@ResponseBody
			public ResponseEntity<Color> getColorById(@PathVariable String colorid)
			{
				Color responseBean = colorRestService.getColorById(colorid);
				return new ResponseEntity<Color>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
/*
			@PutMapping(SuperUserUrlMapping.ADMIN_COLOR_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> updateColor(@RequestBody Color color)
			{
				ResponseBean responseBean = colorRestService.updateColor(color.getColorid()+"",color.getColorname(),color.getHashcode());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@PostMapping(SuperUserUrlMapping.ADMIN_COLOR_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> insertNewColor(@RequestBody NewColor nc)
			{
				ResponseBean responseBean = colorRestService.insertNewColor(nc.getColorname(), nc.getHashcode());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			*/
			 /* ColorRestService code end*/ 
			
			
			/* CountriesService code start*/ 
			
			@GetMapping(SuperUserUrlMapping.ADMIN_COUNTRY_GET_PATH)
			@ResponseBody
			public ResponseEntity<List<Countries>> getAllCountries()
			{
				List<Countries> countries = countriesRestService.getAllCountries();
				return new ResponseEntity<List<Countries>>(countries, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(SuperUserUrlMapping.ADMIN_COUNTRY_GET_PATH_WITH_VARIABLE)
			@ResponseBody
			public ResponseEntity<Countries> getCountryById(@PathVariable String isocode)
			{
				Countries country = countriesRestService.getCountryById(isocode);
				return new ResponseEntity<Countries>(country, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@PutMapping(SuperUserUrlMapping.ADMIN_COUNTRY_PUT_PATH_WITH_VARIABLE)
			@ResponseBody
			public ResponseEntity<ResponseBean> enableCountry(@PathVariable String isocode,@PathVariable boolean status)
			{
				System.err.println("At Superuserentry: 482::::"+status);
				ResponseBean responseBean = countriesRestService.enableCountry(isocode,status);
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}

			@GetMapping(SuperUserUrlMapping.ADMIN_COUNTRY_ACTIVE_GET)
			@ResponseBody
			public ResponseEntity<List<Countries>> getActivecountries()
			{
				List<Countries> countries = countriesRestService.getActiveCountries();
				return new ResponseEntity<List<Countries>>(countries, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			/* CountriesService code start*/ 
			
			
	/* GendersService code start*/ 
			@GetMapping(SuperUserUrlMapping.ADMIN_GENDERS_GET_PATH)
			@ResponseBody
			public ResponseEntity<List<Genders>> getAllGendersServiceDetails()
			{
				List<Genders> genders = gendersRestService.getAllGendersDetails();
				return new ResponseEntity<List<Genders>>(genders, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(SuperUserUrlMapping.ADMIN_GENDERS_MAPPING_PATH_WITH_PATH_VARIABLE)
			@ResponseBody
			public ResponseEntity<Genders> getGenderById(@PathVariable String genderid)
			{
				Genders genders = gendersRestService.getGenderById(genderid);
				
				return new ResponseEntity<Genders>(genders, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			/* GendersService code end*/ 
			
			
			/* MaterialcompositionService code start*/ 
			@GetMapping(SuperUserUrlMapping.ADMIN_MATERIALCOMP_GET_PATH)
			@ResponseBody
			public ResponseEntity<List<Materialcomposition>> getAllMaterialcomposition()
			{
				List<Materialcomposition> materialcomposition = materialcompositionRestService.getAllMaterialcomposition();
				return new ResponseEntity<List<Materialcomposition>>(materialcomposition, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(SuperUserUrlMapping.ADMIN_MATERIALCOMPOSITION_GET_PATH_WITH_VARIABLE)
			@ResponseBody
			public ResponseEntity<Materialcomposition> getMaterialcompositionById(@PathVariable String materialid)
			{
				Materialcomposition materialcomposition = materialcompositionRestService.getMaterialcompositionById(materialid);
				return new ResponseEntity<Materialcomposition>(materialcomposition, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
		
		/*	
			@PutMapping(SuperUserUrlMapping.ADMIN_MATERIALCOMP_GET_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> update(
					@RequestParam(name = ConstantValues.MATERIAL_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String materialid,
					@RequestParam(name = ConstantValues.DESCRIPTION, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String description
					
					)
			{
				ResponseBean responseBean = materialcompositionRestService.updateMaterialcomposition( materialid, description);
				
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			*/
			
			/* MaterialcompositionService code end*/ 
			
/* MaterialtypesService code start*/
			
			@GetMapping(SuperUserUrlMapping.ADMIN_MATERIAL_GET_PATH)
			@ResponseBody
			public ResponseEntity<List<Materialtypes>> getAllMaterialtypes()
			{
				List<Materialtypes> materialtypes = materialtypesRestService.getAllMaterialtypes();
				return new ResponseEntity<List<Materialtypes>>(materialtypes, headers.getHeader(), HttpStatus.ACCEPTED);
			}


			@GetMapping(SuperUserUrlMapping.ADMIN_MATERIALTYPE_GET_PATH_WITH_VARIABLE)
			@ResponseBody
			public ResponseEntity<Materialtypes> getMaterialtypeById(@PathVariable String materialid)
			{
				Materialtypes materialtypes = materialtypesRestService.getMaterialtypeById(materialid);
				return new ResponseEntity<Materialtypes>(materialtypes, headers.getHeader(), HttpStatus.ACCEPTED);
			}

		/*	
			@PutMapping(SuperUserUrlMapping.ADMIN_MATERIAL_GET_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> update(
					@RequestParam(name = ConstantValues.MATERIAL_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String materialname,
					@RequestParam(name = ConstantValues.DESCRIPTION, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String description,
					@RequestParam(name = ConstantValues.OCCASION_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String occasionid,
					@RequestParam(name = ConstantValues.SEASON_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE)  String seasonid,
					@RequestParam(name = ConstantValues.CATEGORY_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE)  String catid,
					@RequestParam(name = ConstantValues.MATERIAL_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE)  String materialid
					)
			{
				ResponseBean responseBean = materialtypesRestService.updateMaterialtype( materialid,materialname, description, occasionid, seasonid, catid);
			
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			*/
			
					
			/* MaterialtypesService code end*/
			
/* NoOfPiecesService code end*/
			@GetMapping(SuperUserUrlMapping.ADMIN_NO_OF_PIECES_PATH)
			@ResponseBody
			public ResponseEntity<List<NoOfPieces>> getAllNoOfPieces(
					)
			{
				List<NoOfPieces> responseBean = noOfPiecesRestService.getAllNoOfPieces();
			
				return new ResponseEntity<List<NoOfPieces>>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(SuperUserUrlMapping.ADMIN_NO_OF_PIECES_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<NoOfPieces> getNoOfPiecesId(@PathVariable String pieceid)
					
			{
				NoOfPieces responseBean = noOfPiecesRestService.getNoOfPiecesId(pieceid);
				
				return new ResponseEntity<NoOfPieces>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@PutMapping(SuperUserUrlMapping.ADMIN_NO_OF_PIECES_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> NoOfPiecesServiceupdate(@RequestBody NoOfPieces np)
			{
				ResponseBean responseBean = noOfPiecesRestService.update(np.getPieceid()+"",np.getProductid()+"",np.getNoofset()+"");
			
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			/* NoOfPiecesService code end*/
			
/* OccasionalWearService code start*/
			
			@GetMapping(SuperUserUrlMapping.ADMIN_OCCASIONALWEAR_PATH)
			@ResponseBody
			public ResponseEntity<List<OccasionalWear>> getAllOccasionalWearDetails()
			{
				List<OccasionalWear> occasionalwear = occasionalwearRestService.getAllOccasionalWearDetails();
				
				return new ResponseEntity<List<OccasionalWear>>(occasionalwear, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(SuperUserUrlMapping.ADMIN_OCCASIONALWEAR_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<OccasionalWear> getOccasionalWearById(@PathVariable String occasionid)
			{
				OccasionalWear occasionalwear = occasionalwearRestService.getOccasionalWearById(occasionid);
				
				return new ResponseEntity<OccasionalWear>(occasionalwear, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			@PutMapping(SuperUserUrlMapping.ADMIN_OCCASIONALWEAR_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> update	(@RequestBody OccasionalWear OW)
			{
					ResponseBean responseBean = occasionalwearRestService.UpdateOccasionalWearDetails(OW.getOccasionid()+"",OW.getOccaname(),OW.getSubcatid()+"");
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
				}
			
			/* OccasionalWearService code end*/
/* PatternsService code start*/

			@GetMapping(SuperUserUrlMapping.ADMIN_PATTERNS_PATH)
			@ResponseBody
			public ResponseEntity<List<Patterns>> getAllPatternsDetails()
			{
				List<Patterns>  patterns = patternsRestService.getAllPatternsDetails();
			
				return new ResponseEntity<List<Patterns>>( patterns, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(SuperUserUrlMapping.ADMIN_PATTERNS_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<Patterns> getPatternsById(@PathVariable String patid)
			{
				Patterns  patterns = patternsRestService.getPatternsById(patid);
				
				return new ResponseEntity<Patterns>( patterns, headers.getHeader(), HttpStatus.ACCEPTED);
			}

			@PutMapping(SuperUserUrlMapping.ADMIN_PATTERNS_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> PatternsServiceupdate(@RequestBody Patterns PB)
			{
				ResponseBean responseBean = patternsRestService.UpdatePatternsDetails(PB.getPatid()+"",PB.getDescription(),PB.getProductid()+"");
				
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
						
			/* PatternsService code end*/
			
/* PricesTableService code start*/
			
			@GetMapping(SuperUserUrlMapping.ADMIN_PRICES_TABLE_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<PricesTable> PricesTableServicegetById(@PathVariable String productid)
			{
				PricesTable prices = pricesTableRestService.getpricebyid(productid);
				
				return new ResponseEntity<PricesTable>(prices, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(SuperUserUrlMapping.ADMIN_PRICES_TABLE_PATH)
			@ResponseBody
			public ResponseEntity<List<PricesTable>> getallprices()
			{
				List<PricesTable> prices = pricesTableRestService.getallprices();
			
				return new ResponseEntity<List<PricesTable>>(prices, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@PutMapping(path = SuperUserUrlMapping.ADMIN_PRICES_TABLE_PATH)
			@ResponseBody	
			public ResponseEntity<ResponseBean> updatePrices(@RequestBody PricesTable PT)
			{
				ResponseBean responseBean = pricesTableRestService.updateprices(PT.getPriceId()+"",PT.getMrp()+"",PT.getProductid()+"",PT.getLcPrice()+"",PT.getTax()+"",PT.getSellingPrice()+"",PT.getFinalPrice()+"");
			
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
			}
			/* PricesTableService code end*/
			
/* ProductAgeService code start*/

			@GetMapping(SuperUserUrlMapping.ADMIN_PRODUCTAGE_PATH)
			@ResponseBody
			public ResponseEntity<List<ProductAge>> getAll(
					)
			{
				List<ProductAge> responseBean = productAgeRestService.getAll();
				
				return new ResponseEntity<List<ProductAge>>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(SuperUserUrlMapping.ADMIN_PRODUCTAGE_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<ProductAge> getProductAgeById(@PathVariable String ageid)
					
			{
				ProductAge responseBean = productAgeRestService.getProductAgeById(ageid);
				
				return new ResponseEntity<ProductAge>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
						
			@PutMapping(SuperUserUrlMapping.ADMIN_PRODUCTAGE_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> ProductAgeServiceupdate(@RequestBody ProductAge PA)
			{
				ResponseBean responseBean = productAgeRestService.update(PA.getAgeid()+"",PA.getDes());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			/* ProductAgeService code end*/
			
/* ProductDescriptionsService code start*/
			
			@GetMapping(SuperUserUrlMapping.ADMIN_PRODUCTDESCRIPTION_MAPPING_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<ProductDescriptions> ProductDescriptionsServicegetById(@PathVariable String descriptionid)
			{
		 		ProductDescriptions productDescriptions = productDescriptionsRestService.getById(descriptionid);
				
				return new ResponseEntity<ProductDescriptions>(productDescriptions, headers.getHeader(), HttpStatus.ACCEPTED);
			}
		 	
		 	@GetMapping(SuperUserUrlMapping.ADMIN_PRODUCTDESCRIPTION_MAPPING_PATH)
			@ResponseBody
			public ResponseEntity<List<ProductDescriptions>> getAllProductDescriptions()
			{
		    	List<ProductDescriptions> productDescriptions = productDescriptionsRestService.getAllProductDescriptions();
			
				return new ResponseEntity<List<ProductDescriptions>>(productDescriptions, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
		 	 @PutMapping(path = SuperUserUrlMapping.ADMIN_PRODUCTDESCRIPTION_MAPPING_PATH)
			 @ResponseBody
			 public ResponseEntity<ResponseBean> ProductDescriptionsServiceupdate(@RequestBody ProductDescriptions PD)
				{
				 ResponseBean responseBean = productDescriptionsRestService.update(PD.getDescriptionid()+"",PD.getDescription());
					return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
			 }
							
			/* ProductDescriptionsService code end*/
		 	 
/* ProductQuantitiesService code start*/
		 	@GetMapping(SuperUserUrlMapping.ADMIN_PRODUCTQUANTITIES_GET_PATH)
			@ResponseBody
			public ResponseEntity<List<ProductQuantities>> getAllProductquantities()
			{
				List<ProductQuantities> productquantities = productquantitiesRestService.getAllProductQuantities();
				
				return new ResponseEntity<List<ProductQuantities>>(productquantities, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(SuperUserUrlMapping.ADMIN_PRODUCTQUANTITIES_GET_PATH_WITH_VARIABLE)
			@ResponseBody
			public ResponseEntity<ProductQuantities> getProductQuantitiesById(@PathVariable String custid)
			{
				ProductQuantities productquantities = productquantitiesRestService.getProductQuantitiesById(custid);
				
				return new ResponseEntity<ProductQuantities>(productquantities, headers.getHeader(), HttpStatus.ACCEPTED);
			}
		 	 
			@PutMapping(SuperUserUrlMapping.ADMIN_PRODUCTQUANTITIES_GET_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> ProductDescriptionsServiceupdate(@RequestBody ProductQuantities PQ)
			{
				ResponseBean responseBean = productquantitiesRestService.updateProductQuantities(PQ.getCustid()+"",PQ.getQuantity()+"",PQ.getSizeid()+"");
				
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			/* ProductQuantitiesService code end*/
			
/* ProductsService code start*/ 
			@GetMapping(SuperUserUrlMapping.ADMIN_PRODUCTS_MAPPING_PATH_ID)
			@ResponseBody
			public ResponseEntity<Products> ProductsServicegetById(@PathVariable String productid)
			{
				Products products = productsRestService.getbyid(productid);
			
				return new ResponseEntity<Products>(products, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(SuperUserUrlMapping.ADMIN_PRODUCTS_MAPPING_PATH)
			@ResponseBody
			public ResponseEntity<List<Products>> getall()
			{
				List<Products> products = productsRestService.getall();
			
				return new ResponseEntity<List<Products>>(products, headers.getHeader(), HttpStatus.ACCEPTED);
			}
		 	 
			@PutMapping( SuperUserUrlMapping.ADMIN_PRODUCTS_MAPPING_PATH_WITH_PATH_VARIABLE_1)
			@ResponseBody
			public ResponseEntity<ResponseBean> enableBatchStatus(@PathVariable String productid,@PathVariable String status)
			{
				ResponseBean response = productsRestService.enableBatchStatus(productid, status);
				
				return new ResponseEntity<ResponseBean>(response, headers.getHeader(), HttpStatus.ACCEPTED);
			}
				 
		 	 
		 	 
		 	/* ProductsService code end*/ 
		 	 
/* ProductTypeService code start*/ 
		 	 

			@GetMapping(SuperUserUrlMapping.ADMIN_PRODUCTTYPE_GET_PATH)
			@ResponseBody
			public ResponseEntity<List<ProductType>> getAllProductTypeDetails()
			{
				List<ProductType> producttype = producttypeRestService.getAllProductTypeDetails();
			
				return new ResponseEntity<List<ProductType>>(producttype, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(SuperUserUrlMapping.ADMIN_PRODUCTTYPE_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<ProductType> ProductTypeServicegetProductTypeById(@PathVariable String protypeid)
			{
				ProductType producttype = producttypeRestService.getProductTypeById(protypeid);
				
				return new ResponseEntity<ProductType>(producttype, headers.getHeader(), HttpStatus.ACCEPTED);
			}
		 	 

			@PutMapping(SuperUserUrlMapping.ADMIN_PRODUCTTYPE_GET_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> ProductTypeServiceupdate(@RequestBody ProductType PT)		
			{
				ResponseBean responseBean = producttypeRestService.UpdateProductType(PT.getProtypeid()+"",PT.getSubcatid()+"",PT.getProducttypename());
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
									 	 
			/* ProductTypeService code end*/ 
			
/* SeasonWearService code start*/ 
		 	 
			@GetMapping(SuperUserUrlMapping.ADMIN_SEASON_WEAR)
			@ResponseBody
			public ResponseEntity<List<SeasonWear>> getAllSeasonWearDetails()
			{
				List<SeasonWear> seasonwear = seasonwearRestService.getAllSeasonWearDetails();
				
				return new ResponseEntity<List<SeasonWear>>(seasonwear, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(SuperUserUrlMapping.ADMIN_SEASON_WEAR_BY_ID)
			@ResponseBody
			public ResponseEntity<SeasonWear> getSeasonWearById(@PathVariable String seasonid)
			{
				SeasonWear seasonwear = seasonwearRestService.getSeasonWearById(seasonid);
				
				return new ResponseEntity<SeasonWear>(seasonwear, headers.getHeader(), HttpStatus.ACCEPTED);
			}
		 	 
			@PutMapping(SuperUserUrlMapping.ADMIN_SEASON_WEAR)
			@ResponseBody
			public ResponseEntity<ResponseBean> SeasonWearServiceupdate(@RequestBody SeasonWear Sw)
			{
				ResponseBean responseBean = seasonwearRestService.UpdateSeasonWearDetails(Sw.getSeasonId()+"",Sw.getSubcatId()+"",Sw.getSeason());
				
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
		 	 
			/* SeasonWearService code end*/ 
		 	 
/* SellerToWarehouseService code start*/ 
		 	 
			@PostMapping(SuperUserUrlMapping.ADMIN_WAREHOUSETOSELLER_POST)
			@ResponseBody	
			public ResponseEntity<ResponseBean> addList(@RequestBody SellerToWarehouseBean stwb)
		
					{
					ResponseBean responseBean = sellerToWarehouseRestService.addList(stwb.getWarehouseid()+"", stwb.getSellerid()+"");
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
			}
			@GetMapping(SuperUserUrlMapping.ADMIN_WAREHOUSETOSELLER_GET)
			@ResponseBody
			public ResponseEntity<List<SellerToWarehouse>> SellerToWarehouseServicegetAll()
			{
		    	List<SellerToWarehouse>  sellerToWarehouse= sellerToWarehouseRestService.getAllData();
			
				return new ResponseEntity<List<SellerToWarehouse>>(sellerToWarehouse, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			/* SellerToWarehouseService code end*/ 
			
/* SizesService code start*/
			
			@GetMapping(SuperUserUrlMapping.ADMIN_SIZES_MAPPING_PATH_WITH_ID)
			@ResponseBody
			public ResponseEntity<Sizes> SizesServicegetById(@PathVariable String sizeid)
			{
				System.out.println("At 1096..................................|||||||||||||||||||||||||||||||");
				Sizes sizes = sizesRestService.getsizebyid(sizeid);
			
				return new ResponseEntity<Sizes>(sizes, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(SuperUserUrlMapping.ADMIN_SIZES_MAPPING_PATH)
			@ResponseBody
			public ResponseEntity<List<Sizes>> getAllSizes()
			{
				List<Sizes> sizes = sizesRestService.getAllSizes();
				
				return new ResponseEntity<List<Sizes>>(sizes, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@PutMapping(path = SuperUserUrlMapping.ADMIN_SIZES_MAPPING_PATH)
			@ResponseBody	
			public ResponseEntity<ResponseBean> updatesize(@RequestBody Sizes SB)
			{
				ResponseBean responseBean = sizesRestService.updatesize(SB.getSizeid()+"",SB.getAgeid()+"",SB.getSizeno()+"",SB.getHeight()+"",SB.getWeight()+"",SB.getChest()+"",SB.getWaist()+"",SB.getHip());
				
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);	
			}
			
			/* SizesService code end*/
/* SubCategoriesService code start*/
			
			@GetMapping(SuperUserUrlMapping.ADMIN_SUBCATEGORIES_GET_PATH)
			@ResponseBody
			public ResponseEntity<List<SubCategories>> getAllSubCategoriesDetails()
			{
				List<SubCategories> subcategories = subcategoriesRestService.getAllSubCategoriesDetails();
			
				return new ResponseEntity<List<SubCategories>>(subcategories, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(SuperUserUrlMapping.ADMIN_SUBCATEGORIES_MAPPING_PATH_WITH_VARIABLE )
			@ResponseBody
			public ResponseEntity<SubCategories> getSubCategoriesById(@PathVariable String subcatid)
			{
				SubCategories subcategories = subcategoriesRestService.getSubCategoriesById(subcatid);
			
				return new ResponseEntity<SubCategories>(subcategories, headers.getHeader(), HttpStatus.ACCEPTED);
			}

			

			@PutMapping(SuperUserUrlMapping.ADMIN_SUBCATEGORIES_GET_PATH)
			@ResponseBody
			public ResponseEntity<ResponseBean> SubCategoriesServiceupdate(@RequestBody SubCategories subcat)
			{
				ResponseBean responseBean = subcategoriesRestService.updateSubcategorytype(subcat.getSubcatid()+"", subcat.getCatid()+"", subcat.getCategoryname()+"");
				
				return new ResponseEntity<ResponseBean>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			
			
			
			/* SubCategoriesService code end*/
			
						
			@GetMapping(SuperUserUrlMapping.PATHLIST)
			@ResponseBody
			public ResponseEntity<List<UrlsList>> getAllUrlList()
			{
				List<UrlsList> list = new CopyOnWriteArrayList<>();
				list.add(new UrlsList(SuperUserUrlMapping.SUPER_USER_ENTRY_POINT_ROOT_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.AUTH_USER_ADMIN_GET_WITH_PATH_VARIABLE, "GET BY ID", "path variable 'username'"));
				list.add(new UrlsList(SuperUserUrlMapping.AUTHORIZED_ADMIN_USER_GET_LINK, "POST", "Json Data ("+ConstantValues.AUTHORIZED_USERNAME+","+ConstantValues.AUTHORIZED_PASSWORD+","+	ConstantValues.AUTHORIZED_USER_EMAIL+","+	ConstantValues.AUTHORIZED_STATUS+","+ConstantValues.AUTHORIZATION_ROLE_NAME_VARIABLE_NAME));
				list.add(new UrlsList(SuperUserUrlMapping.AUTH_ADMIN_USER_BLOCK  , "   PUT ", "path variable ' username, status'"));
				list.add(new UrlsList(SuperUserUrlMapping.AUTHORIZED_ADMIN_USER_GET_LINK  , "   PUT ", "JSON Data (username, password, newpassword)'"));
				
				list.add(new UrlsList(SuperUserUrlMapping.FIRSTPATH_1, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.SECONDPATH_2, "GET BY ID", "path variable ' rolename'"));			
				list.add(new UrlsList(SuperUserUrlMapping.FIRSTPATH_1, "POST", "RequestParame ("+ConstantValues.AUTHORIZATION_ROLE_NAME_VARIABLE_NAME+","+ConstantValues.AUTHORIZATION_ROLE_DESCRIPTIONS_VARIABLE_NAME+","+ConstantValues.AUTHORIZATION_ROLE_STATUS_VARIABLE_NAME));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PATH_3  , "PUT ", "path variable ' rolename, status'"));
				
				list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_TOSELLER_GET_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_TOSELLER_GET_PATH_WITH_VARIABLE, "GET BY ID", "path variable 'username'"));				
				list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_TOSELLER_GET_PATH, "POST", "RequestParame ("+ConstantValues.AUTHORIZED_USERNAME+","+ConstantValues.AUTHORIZED_PASSWORD+","+ConstantValues.EMAIL+","+ConstantValues.FULLNAME+","+	ConstantValues.AUTHORIZATION_ROLE_NAME_VARIABLE_NAME+","+ConstantValues.SELLER_ID+","+ConstantValues.STATUS));
				list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_TOSALLER_PUT_STATUS, "PUT ", "path variable '  status'"));				
				list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_TOSELLER_GET_PATH, "PUT", "RequestParame ("+ConstantValues.AUTHORIZED_USERNAME+","+	ConstantValues.AUTHORIZED_PASSWORD+","+ConstantValues.AUTHORIZED_NEW_PASSWORD));
				
				list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_TOSELLERROLE_GET_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_TOSELLERROLE_GET_PATH_WITH_VARIABLE, "GET by id", "path variable 'sellerid'"));
				list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_TOSELLERROLE_GET_PATH, "POST", "RequestParame ("+ConstantValues.
						SELLER_COMPANY_NAME+","+ConstantValues.SELLER_NAME+","+	ConstantValues.PHONE_NUMBER+","+	ConstantValues.EMAIL+","+ConstantValues.ADDRESS+","+ConstantValues.ISOCODE+","+ConstantValues.STATUS));
			
				list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_TOSELLERROLE_GET_PATH, "PUT", "RequestParame ("+ConstantValues.SELLER_COMPANY_NAME+","+ConstantValues.SELLER_NAME+","+	ConstantValues.PHONE_NUMBER+","+	ConstantValues.EMAIL+","+ConstantValues.ADDRESS+","+ConstantValues.ISOCODE+","+ConstantValues.STATUS));
				
				
				
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_WAREHOUSES_GET_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_WAREHOUSES_MAPPING_PATH_WITH_PATH_VARIABLE, "GET", "path variable 'warehouseid'"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_WAREHOUSES_GET_PATH, "POST", "RequestParame ("+ConstantValues.WAREHOUSE_NAME+","+ConstantValues.WAREHOUSE_NAME+","+ConstantValues.CONTACT_PERSON_NAME+","+	ConstantValues.	CONTACT_PERSON_PHONE+","+	ConstantValues.WAREHOUSE_EMAIL_ADDRESS+","+ConstantValues.WAREHOUSE_ADDRESS+","+ConstantValues.WHAREHOUSE_PIN+","+ConstantValues.WAREHOUSE_EST+","+ConstantValues.WAREHOUSE_STATUS+","+ConstantValues.WHO_CREATED+","+ConstantValues.ISOCODE));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_WAREHOUSES_GET_PATH, "PUT", "RequestParame ("+ConstantValues.WAREHOUSE_ID+","+ConstantValues.CONTACT_PERSON_NAME+","+	ConstantValues.	CONTACT_PERSON_PHONE+","+	ConstantValues.WAREHOUSE_EMAIL_ADDRESS+","+ConstantValues.WAREHOUSE_ADDRESS+","+ConstantValues.WHAREHOUSE_PIN+","+ConstantValues.WAREHOUSE_EST+","+ConstantValues.WAREHOUSE_STATUS+","+ConstantValues.WHO_CREATED+","+ConstantValues.ISOCODE));
				
				
				//BATCHES//
				list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_BATCHES_GET_PATH, "GET", "No Parameter"));	
				list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_BATCHES_MAPPING_PATH_WITH_PATH_VARIABLE, "GET", "path variable 'batchid'"));			
	//			list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_BATCHES_PUT_STATUS_UPDATE, "PUT", "path variable 'batchid, status'"));
   //			list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_BATCHES_GET_PATH, "POST", "JsonData ="+new NewBatch().toString()));			
				
				//Categories//				
				list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_CATEGORIES_MAPPING_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_CATEGORIES_MAPPING_PATH_WITH_ID, "GET BY ID", "path variable 'catid'"));
				list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_CATEGORIES_MAPPING_PATH, "PUT", "Json:"+new Categories().toString()));
				list.add(new UrlsList(SuperUserUrlMapping.FROMADMIN_CATEGORIES_MAPPING_PATH, "POST", "Json:"+new NewCategory().toString()));
				
				//COLOR//
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_COLOR_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_COLOR_PATH_WITH_COLOR_ID, "GET BY ID", "path variable 'colorid'"));
	//			list.add(new UrlsList(SuperUserUrlMapping.ADMIN_COLOR_PATH, "POST","Json:"+new NewColor().toString()));
	//			list.add(new UrlsList(SuperUserUrlMapping.ADMIN_COLOR_PATH, "PUT", "Json:"+new Color().toString()));
				
				//Countries//
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_COUNTRY_GET_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_COUNTRY_GET_PATH_WITH_VARIABLE, "GET BY ID", "path variable 'isocode'"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_COUNTRY_PUT_PATH_WITH_VARIABLE , "PUT",  "path variable 'isocode','status'"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_COUNTRY_ACTIVE_GET, "GET", "No Parameter"));
									
				//GENDERS//
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_GENDERS_GET_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_GENDERS_MAPPING_PATH_WITH_PATH_VARIABLE, "GET BY ID", "path variable 'genderid'"));

				//MATERIALCOMPOSITION//
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_MATERIALCOMP_GET_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_MATERIALCOMPOSITION_GET_PATH_WITH_VARIABLE, "GET BY ID", "path variable 'materialid'"));
//				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_MATERIALCOMP_GET_PATH, "PUT", "RequestParam ("+ConstantValues.MATERIAL_ID+","+ConstantValues.DESCRIPTION));
				
				//MaterialTypes//
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_MATERIAL_GET_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_MATERIALTYPE_GET_PATH_WITH_VARIABLE, "GET BY ID", "path variable 'materialid'"));
//				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_MATERIAL_GET_PATH, "PUT", "RequestParame ("+ConstantValues.	MATERIAL_NAME+","+ConstantValues.DESCRIPTION+","+ConstantValues.OCCASION_ID+","+ConstantValues.SEASON_ID+","+	ConstantValues.CATEGORY_ID+","+ConstantValues.MATERIAL_ID));
										
				//NOOFPIECES//
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_NO_OF_PIECES_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_NO_OF_PIECES_PATH_WITH_ID, "GET BY ID", "path variable 'pieceid'"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_NO_OF_PIECES_PATH, "PUT", "Json Data:"+new NoOfPieces().toString()));
				
				//Occasional Wear//
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_OCCASIONALWEAR_PATH, "GET", "No Parameter"));				
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_OCCASIONALWEAR_PATH_WITH_ID, "GET BY ID", "path variable 'occasionid'"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_OCCASIONALWEAR_PATH, "PUT", "JsonData ="+new OccasionalWear().toString()));				
				
				//PATTERNS//
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PATTERNS_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PATTERNS_PATH_WITH_ID, "GET BY ID", "path variable 'patid'"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PATTERNS_PATH, "PUT", "JsonData ="+new Patterns().toString()));

				//Price Table//				
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRICES_TABLE_PATH, "GET", "No Parameter"));				
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRICES_TABLE_PATH_WITH_ID, "GET BY ID", "path variable 'productid'"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRICES_TABLE_PATH, "PUT", "JsonData ="+new PricesTable().toString()));
				
				//Product Age//
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRODUCTAGE_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRODUCTAGE_PATH_WITH_ID, "GET BY ID", "path variable 'ageid'"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRODUCTAGE_PATH, "PUT", "JsonData ="+new  ProductAge().toString()));				
				
				//Product Description//
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRODUCTDESCRIPTION_MAPPING_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRODUCTDESCRIPTION_MAPPING_PATH_WITH_ID, "GET BY ID", "path variable 'descriptionid'"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRODUCTDESCRIPTION_MAPPING_PATH, "PUT", "JsonData ="+new ProductDescriptions().toString()));
				
				//Product Quantities//
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRODUCTQUANTITIES_GET_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRODUCTQUANTITIES_GET_PATH_WITH_VARIABLE, "GET BY ID", "path variable 'custid'"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRODUCTQUANTITIES_GET_PATH, "PUT", "JsonData ="+new ProductQuantities().toString()));
				
				//Products				
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRODUCTS_MAPPING_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRODUCTS_MAPPING_PATH_ID, "GET BY ID", "path variable 'productid'"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRODUCTS_MAPPING_PATH_WITH_PATH_VARIABLE_1, "PUT", "RequestParame ("+ConstantValues.PRODUCT_ID+","+ConstantValues.STATUS));
				
				//productType
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRODUCTTYPE_GET_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRODUCTTYPE_PATH_WITH_ID, "GET BY ID", "path variable 'protypeid'"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_PRODUCTTYPE_GET_PATH, "PUT", "JsonData ="+new ProductType().toString()));
				
				//SeasonWear//
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_SEASON_WEAR, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_SEASON_WEAR_BY_ID, "GET BY ID", "path variable 'seasonid'"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_SEASON_WEAR, "PUT","JsonData ="+new SeasonWear().toString()));								
				
				//Sizes//				
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_SIZES_MAPPING_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_SIZES_MAPPING_PATH_WITH_ID, "GET BY ID", "path variable 'sizeid'"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_SIZES_MAPPING_PATH, "PUT", "JsonData ="+new Sizes().toString()));
				
				//SubCategories//				
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_SUBCATEGORIES_GET_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_SUBCATEGORIES_MAPPING_PATH_WITH_VARIABLE , "GET BY ID", "path variable 'subcatid'"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_SUBCATEGORIES_GET_PATH, "PUT", "RequestParame ("+ConstantValues.SUBCATID+","+ConstantValues.CATID+","+ConstantValues.CATEGORYNAME));
				
				//SELLER TO WAREHOUSE
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_WAREHOUSETOSELLER_GET,"GET", "No Parameter"));
				list.add(new UrlsList(SuperUserUrlMapping.ADMIN_WAREHOUSETOSELLER_POST,"POST", "Json:"+new SellerToWarehouseBean().toString()));
				
				
				return new ResponseEntity<List<UrlsList>>(list, headers.getHeader(), HttpStatus.ACCEPTED);
				
				
				
				
				
				
				
				
			
			
				
				
				
			}
			
		    }
	

