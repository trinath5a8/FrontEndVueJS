/**
 * 
 */
package com.lc.sk.inventory.security.util;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsInventorySecurityService
 * 2020
 */
public interface SuperUserUrlMapping {

	final static String SUPER_USER_ENTRY_POINT_ROOT_PATH = "/superuser";
	
	final static String AUTHORIZED_ADMIN_USER_GET_LINK = "/adminauthusers";
	final static String AUTH_USER_ADMIN_GET_WITH_PATH_VARIABLE = "/adminauthusers/{username}";
	final static String AUTH_ADMIN_USER_BLOCK = "/adminauthusers/{username}/{status}";
	final static String FIRSTPATH_1 = "/userroles";
	final static String SECONDPATH_2 = "/userroles/{rolename}";
	
	
	final static String PATHLIST = "/100";

	static final String ADMIN_PATH_3 = "/userroles/{rolename}/{status}";

	



	/* seller user URL Mapping code start */
	
	static final String FROMADMIN_TOSELLER_GET_PATH = "/adminsalesuser";

	static final String FROMADMIN_TOSELLER_GET_PATH_WITH_VARIABLE = "/adminsalesuser/{username}";

	static final String FROMADMIN_TOSALLER_PUT_STATUS = "/adminsalesuser/{username}/{status}";




	/* seller role URL Mapping code start */
	static final String FROMADMIN_TOSELLERROLE_GET_PATH = "/adminsellerdetails";

	static final String FROMADMIN_TOSELLERROLE_GET_PATH_WITH_VARIABLE = "/adminsellerdetails/{sellerid}";


	
	/* warehouse URL Mapping code start */
	static final String ADMIN_WAREHOUSES_GET_PATH ="/adminwarehouses" ;

	static final String FROMADMIN_WAREHOUSES_MAPPING_PATH_WITH_PATH_VARIABLE =  "/adminwarehouses/{warehouseid}";


	
	/* Batch URL Mapping code start */
	
	static final String FROMADMIN_BATCHES_GET_PATH = "/adminbatches";

	static final String FROMADMIN_BATCHES_MAPPING_PATH_WITH_PATH_VARIABLE = "/adminbatches/{batchid}";

	static final String FROMADMIN_BATCHES_MAPPING_PATH_WITH_STATUS = "/adminbatches";
	
	static final String FROMADMIN_BATCHES_PUT_STATUS_UPDATE="/adminbatches/{batchid}/{status}";
	
	
	/* CategoriesService URL Mapping code start*/ 
	
	static final String FROMADMIN_CATEGORIES_MAPPING_PATH_WITH_ID = "/admincategories/{catid}";

	static final String FROMADMIN_CATEGORIES_MAPPING_PATH = "/admincategories";

	
	
	
	
	/* ColorRestService URL Mapping code start*/ 
	
	
	static final String ADMIN_COLOR_PATH = "/admincolor";

	static final String ADMIN_COLOR_PATH_WITH_COLOR_ID = "/admincolor/{colorid}";

	static final String ADMIN_COLOR_ACTIVE_PATH = "/adminactivecolors";

	
	
	
	/* CountriesService  URL Mapping code start*/ 
	
	static final String ADMIN_COUNTRY_GET_PATH =  "/admincountries";

	static final String ADMIN_COUNTRY_GET_PATH_WITH_VARIABLE = "/admincountries/{isocode}";

	static final String ADMIN_COUNTRY_PUT_PATH_WITH_VARIABLE = "/admincountries/{isocode}/{status}";

	static final String ADMIN_COUNTRY_ACTIVE_GET =  "/adminactivecountries";

	
	
	/* GendersService  URL Mapping code start*/ 
	
	static final String ADMIN_GENDERS_GET_PATH = "/admingenders";

	static final String ADMIN_GENDERS_MAPPING_PATH_WITH_PATH_VARIABLE = "/admingenders/{genderid}";


	
	/* MaterialcompositionService URL Mapping code start*/ 
	static final String ADMIN_MATERIALCOMP_GET_PATH = "/adminmaterialcomp";

	static final String ADMIN_MATERIALCOMPOSITION_GET_PATH_WITH_VARIABLE ="/adminmaterialcomp/{materialid}" ;

	
	
	
	/* MaterialtypesService URL Mapping code start*/
	
	static final String ADMIN_MATERIAL_GET_PATH = "/adminmaterial";

	static final String ADMIN_MATERIALTYPE_GET_PATH_WITH_VARIABLE = "/adminmaterial/{materialid}";

	
	
	/* NoOfPiecesService URL Mapping code end*/
	static final String ADMIN_NO_OF_PIECES_PATH = "/adminnoofpieces";

	static final String ADMIN_NO_OF_PIECES_PATH_WITH_ID = "/adminnoofpieces/{pieceid}";

	
	
	
	/* OccasionalWearService URL Mapping code start*/
	
	static final String ADMIN_OCCASIONALWEAR_PATH = "/adminoccasionalwear";

	static final String ADMIN_OCCASIONALWEAR_PATH_WITH_ID = "/adminoccasionalwear/{occasionid}";

	
	
	/* PatternsService  URL Mapping code start*/
	static final String ADMIN_PATTERNS_PATH = "/adminpatterns";

	static final String ADMIN_PATTERNS_PATH_WITH_ID = "/adminpatterns/{patid}";

	
	
	/* PricesTableService URL Mapping code start*/
	
	static final String ADMIN_PRICES_TABLE_PATH_WITH_ID = "/adminpricestable/{productid}";

	static final String ADMIN_PRICES_TABLE_PATH = "/adminpricestable";

	
	
	
	/* ProductAgeService URL Mapping code start*/
	
	static final String ADMIN_PRODUCTAGE_PATH = "/adminproductage";

	static final String ADMIN_PRODUCTAGE_PATH_WITH_ID = "/adminproductage/{ageid}";

	
	
	
	/* ProductDescriptionsService URL Mapping code start*/
	
	static final String ADMIN_PRODUCTDESCRIPTION_MAPPING_PATH_WITH_ID = "/adminproductdescriptions/{descriptionid}";

	static final String ADMIN_PRODUCTDESCRIPTION_MAPPING_PATH = "/adminproductdescriptions";


	
	
	/* ProductQuantitiesService URL Mapping code start*/
	
	static final String ADMIN_PRODUCTQUANTITIES_GET_PATH = "/adminproductquantities";

	static final String ADMIN_PRODUCTQUANTITIES_GET_PATH_WITH_VARIABLE = "/adminproductquantities/{custid}";
	
	
	/* ProductsService URL Mapping code start*/
	
	

	static final String ADMIN_PRODUCTS_MAPPING_PATH_ID = "/adminproducts/{productid}";

	static final String ADMIN_PRODUCTS_MAPPING_PATH = "/adminproducts";

	static final String ADMIN_PRODUCTS_MAPPING_PATH_WITH_PATH_VARIABLE_1 = "/adminproducts/{productid}/{status}";

	
	
	/* ProductTypeService URL Mapping code start*/ 
	static final String ADMIN_PRODUCTTYPE_GET_PATH = 	"/adminproducttype";

	static final String ADMIN_PRODUCTTYPE_PATH_WITH_ID = "/adminproducttype/{protypeid}";


	
	/* SeasonWearService URL Mapping code start*/
	
	static final String ADMIN_SEASON_WEAR =  "/adminseasonwear";

	static final String ADMIN_SEASON_WEAR_BY_ID ="/adminseasonwear/{seasonid}" ;


	
	/* SellerToWarehouseService  URL Mapping code start*/ 
	
	static final String ADMIN_WAREHOUSETOSELLER_POST = "/adminsellertowarehouse";

	static final String ADMIN_WAREHOUSETOSELLER_GET = "/adminsellertowarehouse";


	
	/* SizesService  URL Mapping code start*/
	static final String ADMIN_SIZES_MAPPING_PATH_WITH_ID = "/adminsizes/{sizeid}";

	static final String ADMIN_SIZES_MAPPING_PATH = "/adminsizes";

	
	
	
	/* SubCategoriesService  URL Mapping code start*/
	
	static final String ADMIN_SUBCATEGORIES_GET_PATH = "/adminsubcategories";

	static final String ADMIN_SUBCATEGORIES_MAPPING_PATH_WITH_VARIABLE = "/adminsubcategories/{subcatid}";

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
