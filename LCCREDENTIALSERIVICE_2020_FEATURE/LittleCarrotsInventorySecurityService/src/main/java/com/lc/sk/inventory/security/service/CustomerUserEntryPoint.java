package com.lc.sk.inventory.security.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lc.sk.inventory.security.beans.Categories;
import com.lc.sk.inventory.security.beans.Color;
import com.lc.sk.inventory.security.beans.Genders;
import com.lc.sk.inventory.security.beans.Materialcomposition;
import com.lc.sk.inventory.security.beans.Materialtypes;
import com.lc.sk.inventory.security.beans.NoOfPieces;
import com.lc.sk.inventory.security.beans.OccasionalWear;
import com.lc.sk.inventory.security.beans.Patterns;
import com.lc.sk.inventory.security.beans.PricesTable;
import com.lc.sk.inventory.security.beans.ProductAge;
import com.lc.sk.inventory.security.beans.ProductDescriptions;
import com.lc.sk.inventory.security.beans.ProductQuantities;
import com.lc.sk.inventory.security.beans.ProductType;
import com.lc.sk.inventory.security.beans.Products;
import com.lc.sk.inventory.security.beans.SeasonWear;
import com.lc.sk.inventory.security.beans.Sizes;
import com.lc.sk.inventory.security.beans.SubCategories;
import com.lc.sk.inventory.security.beans.UrlsList;
import com.lc.sk.inventory.security.rest.CategoriesRestService;
import com.lc.sk.inventory.security.rest.ColorRestService;
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
import com.lc.sk.inventory.security.rest.SeasonWearRestService;
import com.lc.sk.inventory.security.rest.SizesRestService;
import com.lc.sk.inventory.security.rest.SubCategoriesRestService;
import com.lc.sk.inventory.security.util.HeaderComponent;
import com.lc.sk.inventory.security.util.URLMapping;
import com.lc.sk.inventory.security.util.CustomerUserUrlMapping;


@RestController
@Validated
@RequestMapping(value = CustomerUserUrlMapping.CUSTOMER_USER_ENTRY_POINT_ROOT_PATH+URLMapping.VERSION)
public class CustomerUserEntryPoint {

	
	@Autowired
	private HeaderComponent headers;
	@Autowired
	CategoriesRestService categoriesRestService;  
    @Autowired
	ColorRestService   colorRestService;
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
	SizesRestService sizesRestService;    
    @Autowired
    SubCategoriesRestService subcategoriesRestService;
    
  //CATEGORIES
    @GetMapping(CustomerUserUrlMapping.CATEGORIES_MAPPING_PATH_WITH_ID_CUSTOMER)
	@ResponseBody
	public ResponseEntity<Categories> getById(@PathVariable String catid)
	{
	 Categories categories = categoriesRestService.getById(catid);
		return new ResponseEntity<Categories>(categories, headers.getHeader(), HttpStatus.ACCEPTED);
	}
 
    @GetMapping(CustomerUserUrlMapping.CATEGORIES_MAPPING_PATH_CUSTOMER)
	@ResponseBody
	public ResponseEntity<List<Categories>> getAllCategories()
	{
    	List<Categories> categories = categoriesRestService.getAllCategories();
		return new ResponseEntity<List<Categories>>(categories, headers.getHeader(), HttpStatus.ACCEPTED);
	}
    
  //COLOR
    @GetMapping(CustomerUserUrlMapping.COLOR_PATH_CUSTOMER)
	@ResponseBody
	public ResponseEntity<List<Color>> getAllColors(
			)
	{
		List<Color> responseBean = colorRestService.getAllColors();
		return new ResponseEntity<List<Color>>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping(CustomerUserUrlMapping.COLOR_PATH_WITH_COLOR_ID_CUSTOMER)
	@ResponseBody
	public ResponseEntity<Color> getColorById(@PathVariable String colorid)
			
	{
		Color responseBean = colorRestService.getColorById(colorid);
		return new ResponseEntity<Color>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	
/*
	@GetMapping(CustomerUserUrlMapping.COLOR_ACTIVE_PATH_CUSTOMER)
	@ResponseBody
	public ResponseEntity<List<Color>> getActiveColors()
	{
		List<Color> responseBean = colorRestService.getActiveColors();
		return new ResponseEntity<List<Color>>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	*/
	//GENDER
	@GetMapping(CustomerUserUrlMapping.GENDERS_GET_PATH_CUSTOMER)
	@ResponseBody
	public ResponseEntity<List<Genders>> getAllGendersDetails()
	{
		List<Genders> genders = gendersRestService.getAllGendersDetails();
		return new ResponseEntity<List<Genders>>(genders, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(CustomerUserUrlMapping.GENDERS_MAPPING_PATH_WITH_PATH_VARIABLE)
	@ResponseBody
	public ResponseEntity<Genders> getGenderById(@PathVariable String genderid)
	{
		Genders genders = gendersRestService.getGenderById(genderid);
		return new ResponseEntity<Genders>(genders, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	
	//MATERIAL COMPOSITION
	@GetMapping(CustomerUserUrlMapping.MATERIALCOMP_GET_PATH_CUSTOMER)
	@ResponseBody
	public ResponseEntity<List<Materialcomposition>> getAllMaterialcomposition()
	{
		List<Materialcomposition> materialcomposition = materialcompositionRestService.getAllMaterialcomposition();
		return new ResponseEntity<List<Materialcomposition>>(materialcomposition, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(CustomerUserUrlMapping.MATERIALCOMPOSITION_GET_PATH_WITH_VARIABLE_CUSTOMER)
	@ResponseBody
	public ResponseEntity<Materialcomposition> getMaterialcompositionById(@PathVariable String materialid)
	{
		Materialcomposition materialcomposition = materialcompositionRestService.getMaterialcompositionById(materialid);
		return new ResponseEntity<Materialcomposition>(materialcomposition, headers.getHeader(), HttpStatus.ACCEPTED);
	}
	
	//Material Types
	@GetMapping(CustomerUserUrlMapping.MATERIAL_GET_PATH_CUSTOMER)
	@ResponseBody
	public ResponseEntity<List<Materialtypes>> getAllMaterialtypes()
	{
		List<Materialtypes> materialtypes = materialtypesRestService.getAllMaterialtypes();
		return new ResponseEntity<List<Materialtypes>>(materialtypes, headers.getHeader(), HttpStatus.ACCEPTED);
	}

	@GetMapping(CustomerUserUrlMapping.MATERIALTYPE_GET_PATH_WITH_VARIABLE_CUSTOMER)
	@ResponseBody
	public ResponseEntity<Materialtypes> getMaterialtypeById(@PathVariable String materialid)
	{
		Materialtypes materialtypes = materialtypesRestService.getMaterialtypeById(materialid);
		return new ResponseEntity<Materialtypes>(materialtypes, headers.getHeader(), HttpStatus.ACCEPTED);
	}
			
	//NO. OF PIECES
	@GetMapping(CustomerUserUrlMapping.NO_OF_PIECES_PATH_CUSTOMER)
	@ResponseBody
    public ResponseEntity<List<NoOfPieces>> getAllNoOfPieces(
					)
			{
				List<NoOfPieces> responseBean = noOfPiecesRestService.getAllNoOfPieces();
				return new ResponseEntity<List<NoOfPieces>>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(CustomerUserUrlMapping.NO_OF_PIECES_PATH_WITH_ID_CUSTOMER)
			@ResponseBody
			public ResponseEntity<NoOfPieces> getNoOfPiecesId(@PathVariable String pieceid)
					
			{
				NoOfPieces responseBean = noOfPiecesRestService.getNoOfPiecesId(pieceid);
				return new ResponseEntity<NoOfPieces>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			//OCCASIONAL WEAR
			@GetMapping(CustomerUserUrlMapping.OCCASIONALWEAR_PATH_CUSTOMER)
			@ResponseBody
			public ResponseEntity<List<OccasionalWear>> getAllOccasionalWearDetails()
			{
				List<OccasionalWear> occasionalwear = occasionalwearRestService.getAllOccasionalWearDetails();
				return new ResponseEntity<List<OccasionalWear>>(occasionalwear, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(CustomerUserUrlMapping.OCCASIONALWEAR_PATH_WITH_ID_CUSTOMER)
			@ResponseBody
			public ResponseEntity<OccasionalWear> getOccasionalWearById(@PathVariable String occasionid)
			{
				OccasionalWear occasionalwear = occasionalwearRestService.getOccasionalWearById(occasionid);
				return new ResponseEntity<OccasionalWear>(occasionalwear, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			//PATTERNS
			@GetMapping(CustomerUserUrlMapping.PATTERNS_PATH_CUSTOMER)
			@ResponseBody
			public ResponseEntity<List<Patterns>> getAllPatternsDetails()
			{
				List<Patterns>  patterns = patternsRestService.getAllPatternsDetails();
				return new ResponseEntity<List<Patterns>>( patterns, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(CustomerUserUrlMapping.PATTERNS_PATH_WITH_ID_CUSTOMER)
			@ResponseBody
			public ResponseEntity<Patterns> getPatternsById(@PathVariable String patid)
			{
				Patterns  patterns = patternsRestService.getPatternsById(patid);
				return new ResponseEntity<Patterns>( patterns, headers.getHeader(), HttpStatus.ACCEPTED);
			}
    
			//prices//
			@GetMapping(CustomerUserUrlMapping.PRICES_TABLE_PATH_WITH_ID_CUSTOMER)
			@ResponseBody
			public ResponseEntity<PricesTable> getById1(@PathVariable String productid)
			{
				PricesTable prices = pricesTableRestService.getpricebyid(productid);
				return new ResponseEntity<PricesTable>(prices, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(CustomerUserUrlMapping.PRICES_TABLE_PATH_CUSTOMER)
			@ResponseBody
			public ResponseEntity<List<PricesTable>> getallprices()
			{
				List<PricesTable> prices = pricesTableRestService.getallprices();
				return new ResponseEntity<List<PricesTable>>(prices, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			//PRODUCT AGE
			@GetMapping(CustomerUserUrlMapping.PRODUCTAGE_PATH_CUSTOMER)
			@ResponseBody
			public ResponseEntity<List<ProductAge>> getAll(
					)
			{
				List<ProductAge> responseBean = productAgeRestService.getAll();
				return new ResponseEntity<List<ProductAge>>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(CustomerUserUrlMapping.PRODUCTAGE_PATH_WITH_ID_CUSTOMER)
			@ResponseBody
			public ResponseEntity<ProductAge> getProductAgeById(@PathVariable String ageid)
					
			{
				ProductAge responseBean = productAgeRestService.getProductAgeById(ageid);
				return new ResponseEntity<ProductAge>(responseBean, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			//PRODUCT DESCRIPTION
			@GetMapping(CustomerUserUrlMapping.PRODUCTDESCRIPTION_MAPPING_PATH_WITH_ID_CUSTOMER)
			@ResponseBody
			public ResponseEntity<ProductDescriptions> getById3(@PathVariable String descriptionid)
			{
		 		ProductDescriptions productDescriptions = productDescriptionsRestService.getById(descriptionid);
				return new ResponseEntity<ProductDescriptions>(productDescriptions, headers.getHeader(), HttpStatus.ACCEPTED);
			}
		 	
		 	@GetMapping(CustomerUserUrlMapping.PRODUCTDESCRIPTION_MAPPING_PATH_CUSTOMER)
			@ResponseBody
			public ResponseEntity<List<ProductDescriptions>> getAllProductDescriptions()
			{
		    	List<ProductDescriptions> productDescriptions = productDescriptionsRestService.getAllProductDescriptions();
				return new ResponseEntity<List<ProductDescriptions>>(productDescriptions, headers.getHeader(), HttpStatus.ACCEPTED);
			}
		 	
		 	//PRODUCTQUANTITIES
		 	@GetMapping(CustomerUserUrlMapping.PRODUCTQUANTITIES_GET_PATH_CUSTOMER)
			@ResponseBody
			public ResponseEntity<List<ProductQuantities>> getAllProductquantities()
			{
				List<ProductQuantities> productquantities = productquantitiesRestService.getAllProductQuantities();
				return new ResponseEntity<List<ProductQuantities>>(productquantities, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(CustomerUserUrlMapping.PRODUCTQUANTITIES_GET_PATH_WITH_VARIABLE_CUSTOMER)
			@ResponseBody
			public ResponseEntity<ProductQuantities> getProductQuantitiesById(@PathVariable String custid)
			{
				ProductQuantities productquantities = productquantitiesRestService.getProductQuantitiesById(custid);
				return new ResponseEntity<ProductQuantities>(productquantities, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			//PRODUCTSERVICE
			@GetMapping(CustomerUserUrlMapping.PRODUCTS_MAPPING_PATH_ID_CUSTOMER)
			@ResponseBody
			public ResponseEntity<Products> getById4(@PathVariable String productid)
			{
				Products products = productsRestService.getbyid(productid);
				return new ResponseEntity<Products>(products, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(CustomerUserUrlMapping.PRODUCTS_MAPPING_PATH_CUSTOMER)
			@ResponseBody
			public ResponseEntity<List<Products>> getall()
			{
				List<Products> products = productsRestService.getall();
				return new ResponseEntity<List<Products>>(products, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			//PRODUCT TYPE
			@GetMapping(CustomerUserUrlMapping.PRODUCTTYPE_GET_PATH_CUSTOMER)
			@ResponseBody
			public ResponseEntity<List<ProductType>> getAllProductTypeDetails()
			{
				List<ProductType> producttype = producttypeRestService.getAllProductTypeDetails();
				return new ResponseEntity<List<ProductType>>(producttype, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(CustomerUserUrlMapping.PRODUCTTYPE_PATH_WITH_ID_CUSTOMER)
			@ResponseBody
			public ResponseEntity<ProductType> getProductTypeById(@PathVariable String protypeid)
			{
				ProductType producttype = producttypeRestService.getProductTypeById(protypeid);
				return new ResponseEntity<ProductType>(producttype, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
           //Season Wear
			@GetMapping(CustomerUserUrlMapping.SEASON_WEAR_CUSTOMER)
			@ResponseBody
			public ResponseEntity<List<SeasonWear>> getAllSeasonWearDetails()
			{
				List<SeasonWear> seasonwear = seasonwearRestService.getAllSeasonWearDetails();
				return new ResponseEntity<List<SeasonWear>>(seasonwear, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(CustomerUserUrlMapping.SEASON_WEAR_BY_ID_CUSTOMER)
			@ResponseBody
			public ResponseEntity<SeasonWear> getSeasonWearById(@PathVariable String seasonid)
			{
				SeasonWear seasonwear = seasonwearRestService.getSeasonWearById(seasonid);
				return new ResponseEntity<SeasonWear>(seasonwear, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			//SIZES
			@GetMapping(CustomerUserUrlMapping.SIZES_MAPPING_PATH_WITH_ID_CUSTOMER)
			@ResponseBody
			public ResponseEntity<Sizes> getById5(@PathVariable String sizeid)
			{
				Sizes sizes = sizesRestService.getsizebyid(sizeid);
				return new ResponseEntity<Sizes>(sizes, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(CustomerUserUrlMapping.SIZES_MAPPING_PATH_CUSTOMER)
			@ResponseBody
			public ResponseEntity<List<Sizes>> getAllSizes()
			{
				List<Sizes> sizes = sizesRestService.getAllSizes();
				return new ResponseEntity<List<Sizes>>(sizes, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			//SUB CATEGORIES
			@GetMapping(CustomerUserUrlMapping.SUBCATEGORIES_GET_PATH_CUSTOMER)
			@ResponseBody
			public ResponseEntity<List<SubCategories>> getAllSubCategoriesDetails()
			{
				List<SubCategories> subcategories = subcategoriesRestService.getAllSubCategoriesDetails();
				return new ResponseEntity<List<SubCategories>>(subcategories, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			
			@GetMapping(CustomerUserUrlMapping.SUBCATEGORIES_MAPPING_PATH_WITH_VARIABLE_CUSTOMER )
			@ResponseBody
			public ResponseEntity<SubCategories> getSubCategoriesById(@PathVariable String subcatid)
			{
				SubCategories subcategories = subcategoriesRestService.getSubCategoriesById(subcatid);
				return new ResponseEntity<SubCategories>(subcategories, headers.getHeader(), HttpStatus.ACCEPTED);
			}
			
			@GetMapping(CustomerUserUrlMapping.CUSTOMER_PATHLIST)
			@ResponseBody
			public ResponseEntity<List<UrlsList>> getAllUrlList()
			{
				List<UrlsList> list = new CopyOnWriteArrayList<>();
				list.add(new UrlsList(CustomerUserUrlMapping.CUSTOMER_USER_ENTRY_POINT_ROOT_PATH, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.CATEGORIES_MAPPING_PATH_WITH_ID_CUSTOMER, "GET", "path variable 'catid'"));
				list.add(new UrlsList(CustomerUserUrlMapping.CATEGORIES_MAPPING_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.COLOR_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.COLOR_PATH_WITH_COLOR_ID_CUSTOMER, "GET", "path variable 'colorid'"));
		//		list.add(new UrlsList(CustomerUserUrlMapping.COLOR_ACTIVE_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.GENDERS_GET_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.GENDERS_MAPPING_PATH_WITH_PATH_VARIABLE, "GET", "path variable 'genderid'"));
				list.add(new UrlsList(CustomerUserUrlMapping.MATERIALCOMP_GET_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.MATERIALCOMPOSITION_GET_PATH_WITH_VARIABLE_CUSTOMER, "GET", "path variable 'materialid'"));
				list.add(new UrlsList(CustomerUserUrlMapping.MATERIAL_GET_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.MATERIALTYPE_GET_PATH_WITH_VARIABLE_CUSTOMER, "GET", "path variable 'materialid'"));
				list.add(new UrlsList(CustomerUserUrlMapping.NO_OF_PIECES_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.NO_OF_PIECES_PATH_WITH_ID_CUSTOMER, "GET", "path variable 'pieceid'"));
				list.add(new UrlsList(CustomerUserUrlMapping.OCCASIONALWEAR_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.OCCASIONALWEAR_PATH_WITH_ID_CUSTOMER, "GET", "path variable 'occasionid'"));
				list.add(new UrlsList(CustomerUserUrlMapping.PATTERNS_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.PATTERNS_PATH_WITH_ID_CUSTOMER, "GET", "path variable 'patid'"));
				list.add(new UrlsList(CustomerUserUrlMapping.PRICES_TABLE_PATH_WITH_ID_CUSTOMER, "GET", "path variable 'productid'"));
				list.add(new UrlsList(CustomerUserUrlMapping.PRICES_TABLE_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.PRODUCTAGE_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.PRODUCTAGE_PATH_WITH_ID_CUSTOMER, "GET", "path variable 'ageid'"));
				list.add(new UrlsList(CustomerUserUrlMapping.PRODUCTDESCRIPTION_MAPPING_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.PRODUCTDESCRIPTION_MAPPING_PATH_WITH_ID_CUSTOMER, "GET", "path variable 'descriptionid'"));
				list.add(new UrlsList(CustomerUserUrlMapping.PRODUCTQUANTITIES_GET_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.PRODUCTQUANTITIES_GET_PATH_WITH_VARIABLE_CUSTOMER, "GET", "path variable 'custid'"));
				list.add(new UrlsList(CustomerUserUrlMapping.PRODUCTS_MAPPING_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.PRODUCTS_MAPPING_PATH_ID_CUSTOMER, "GET", "path variable 'productid'"));
				list.add(new UrlsList(CustomerUserUrlMapping.PRODUCTTYPE_GET_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.PRODUCTTYPE_PATH_WITH_ID_CUSTOMER, "GET", "path variable 'protypeid'"));
				list.add(new UrlsList(CustomerUserUrlMapping.SEASON_WEAR_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.SEASON_WEAR_BY_ID_CUSTOMER, "GET", "path variable 'seasonid'"));
				list.add(new UrlsList(CustomerUserUrlMapping.SIZES_MAPPING_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.SIZES_MAPPING_PATH_WITH_ID_CUSTOMER, "GET", "path variable 'sizeid'"));
				list.add(new UrlsList(CustomerUserUrlMapping.SUBCATEGORIES_GET_PATH_CUSTOMER, "GET", "No Parameter"));
				list.add(new UrlsList(CustomerUserUrlMapping.SUBCATEGORIES_MAPPING_PATH_WITH_VARIABLE_CUSTOMER, "GET", "path variable 'subcatid'"));
				
				
				return new ResponseEntity<List<UrlsList>>(list, headers.getHeader(), HttpStatus.ACCEPTED);
				
				
			}
}
