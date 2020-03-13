package com.lc.sk.inventory.security.util;

public interface ManagerUserUrlMapping {
	
	final static String MANAGER_USER_ENTRY_POINT_ROOT_PATH = "/manager";  //manager
	final static String PATH_1_MANAGER="/roles_manager";
	final static String PATH_2_MANAGER="/roles_manager/{rolename}";
	
	final static String AUTH_USER_GET_PATH_MANAGER="/authusers_manager";
	final static String AUTH_USER_GET_WITH_PATH_VARIABLE_MANAGER="/authusers_manager/{username}";
	
	final static String BATCHES_GET_PATH_MANAGER="/batches_manager";
	final static String BATCHES_MAPPING_PATH_WITH_PATH_VARIABLE_MANAGER="/batches_manager/{batchid}";
	final static String	BATCHID_PUT_PATH_WITH_VARIABLE_MANAGER="/batches_manager/{batchid}/{status}";
	
	final static String CATEGORIES_MAPPING_PATH_MANAGER = "/categories_manager";
	final static String CATEGORIES_MAPPING_PATH_WITH_ID_MANAGER = "/categories_manager/{catid}";
	
	final static String	COLOR_PATH_MANAGER = "/color_manager";
	final static String COLOR_PATH_WITH_COLOR_ID_MANAGER=	"/color_manager/{colorid}";
	final static String COLOR_ACTIVE_PATH_MANAGER ="/activecolors_manager";
	
	final static String COUNTRY_GET_PATH_MANAGER= "/countries_manager";
	final static String COUNTRY_GET_PATH_WITH_VARIABLE_MANAGER = "/countries_manager/{isocode}";
	final static String	COUNTRY_ACTIVE_GET_MANAGER = "/activecountries_manager";
	
	
	final static String GENDERS_GET_PATH_MANAGER = "/genders_manager";
	final static String	GENDERS_MAPPING_PATH_WITH_PATH_VARIABLE_MANAGER="/genders_manager/{genderid}";
	
	final static String MATERIALCOMP_GET_PATH_MANAGER="/materialcomp_manager";
	final static String MATERIALCOMPOSITION_GET_PATH_WITH_VARIABLE_MANAGER = "/materialcomp_manager/{materialid}";
	
	
	final static String MATERIAL_GET_PATH_MANAGER =	"/material_manager";
	final static String MATERIALTYPE_GET_PATH_WITH_VARIABLE_MANAGER = "/material_manager/{materialid}";
	
	final static String NO_OF_PIECES_PATH_MANAGER="/noofpieces_manager";
	final static String NO_OF_PIECES_PATH_WITH_ID_MANAGER ="/noofpieces_manager/{pieceid}";
	
	final static String OCCASIONALWEAR_PATH_MANAGER = "/occasionalwear_manager";
	final static String OCCASIONALWEAR_PATH_WITH_ID_MANAGER =  "/occasionalwear_manager/{occasionid}";
	
	final static String PATTERNS_PATH_MANAGER ="/patterns_manager";
	final static String PATTERNS_PATH_WITH_ID_MANAGER = "/patterns_manager/{patid}";
	
	final static String PRICES_TABLE_PATH_MANAGER = "/pricestable_manager";
	final static String PRICES_TABLE_PATH_WITH_ID_MANAGER = "/pricestable_manager/{productid}";
	
	final static String PRODUCTAGE_PATH_MANAGER ="/productage_manager";
	final static String PRODUCTAGE_PATH_WITH_ID_MANAGER ="/productage_manager/{ageid}";
	
	final static String PRODUCTDESCRIPTION_MAPPING_PATH_MANAGER = "/productdescriptions_manager";
	final static String PRODUCTDESCRIPTION_MAPPING_PATH_WITH_ID_MANAGER = "/productdescriptions_manager/{descriptionid}";
	
	final static String PRODUCTQUANTITIES_GET_PATH_MANAGER ="/productquantities_manager";
	final static String PRODUCTQUANTITIES_GET_PATH_WITH_VARIABLE_MANAGER	= "/productquantities_manager/{custid}";
	
	final static String PRODUCTS_MAPPING_PATH_MANAGER ="/products_manager";
	final static String PRODUCTS_MAPPING_PATH_WITH_PATH_VARIABLE_1_MANAGER="/products_manager/{productid}/{status}";
	final static String PRODUCTS_MAPPING_PATH_ID_MANAGER ="/products_manager/{productid}";
	
	final static String PRODUCTTYPE_GET_PATH_MANAGER =	"/producttype_manager";
	final static String PRODUCTTYPE_PATH_WITH_ID_MANAGER = "/producttype_manager/{protypeid}";
	
	final static String SALLER_SELLER_GET_PATH_MANAGER ="/salesuser_manager";
	final static String  SALES_SELLER_GET_PATH_WITH_VARIABLE_MANAGER ="/salesuser_manager/{username}";
	
	final static String SEASON_WEAR_MANAGER = "/seasonwear_manager";
	final static String SEASON_WEAR_BY_ID_MANAGER =	"/seasonwear_manager/{seasonid}";
	
	final static String SELLER_GET_PATH_MANAGER ="/sellerdetails_manager";
	final static String SELLER_GET_PATH_WITH_VARIABLE_MANAGER = "/sellerdetails_manager/{sellerid}";
	
	final static String WAREHOUSETOSELLER_GET_MANAGER = "/sellertowarehouse_manager";
	
	final static String SIZES_MAPPING_PATH_MANAGER="/sizes_manager";
	final static String SIZES_MAPPING_PATH_WITH_ID_MANAGER = "/sizes_manager/{sizeid}";
	
	final static String SUBCATEGORIES_GET_PATH_MANAGER = "/subcategories_manager";
	final static String SUBCATEGORIES_MAPPING_PATH_WITH_VARIABLE_MANAGER ="/subcategories_manager/{subcatid}";
	
	final static String WAREHOUSES_GET_PATH_MANAGER = "/warehouses_manager";
	final static String  WAREHOUSES_MAPPING_PATH_WITH_PATH_VARIABLE_MANAGER = "/warehouses_manager/{warehouseid}";
	static final String PATHLIST ="/100";
	}
