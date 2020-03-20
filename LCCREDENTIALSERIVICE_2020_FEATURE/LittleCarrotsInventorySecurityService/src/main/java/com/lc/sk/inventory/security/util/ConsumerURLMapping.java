package com.lc.sk.inventory.security.util;


public interface ConsumerURLMapping {

	final static String CEP="/cep";
	final static String VERSION = "/v1";
	
	static final String USERROLES = "/ur";
	static final String USERROLES_BY_NAME = "/ur/{rolename}";
	static final String USERROLES_BY_STATUS= "/ur/{rolename}/{status}";
	
	static final String AUTH_USERS = "/au";
	static final String AUTH_USERS_PATH_VARIABLE = "/au/{username}";
	static final String AUTH_USER_BLOCK = "/au/{username}/{status}";
	
	static final String SELLER_GET_PATH = "/sell";
	static final String SELLER_GET_PATH_WITH_VARIABLE = "/sell/{username}";
	static final String SELLER_PUT_STATUS = "/sell/{username}/{status}";
	
	static final String SELLERROLE_GET_PATH = "/sr";
	static final String SELLERROLE_GET_PATH_WITH_VARIABLE =  "/sr/{sellerid}";
	
	static final String WAREHOUSES_GET_PATH = "/wh";
	static final String WAREHOUSES_MAPPING_PATH_WITH_PATH_VARIABLE =  "/wh/{warehouseid}";
	
	static final String BATCHES_GET_PATH = "/bat";
	static final String BATCHES_MAPPING_PATH_WITH_PATH_VARIABLE = "/bat/{batchid}";
	static final String BATCHID_PUT_PATH_WITH_VARIABLE = "/bat/{batchid}/{status}";
	
	static final String CATEGORIES_MAPPING_PATH_WITH_ID = "/cat/{catid}";
	static final String CATEGORIES_MAPPING_PATH = "/cat";
	
	static final String COLOR_PATH = "/col";
	static final String COLOR_PATH_WITH_COLOR_ID = "/col/{colorid}";
	
	static final String COUNTRY_GET_PATH = "/cou";
	static final String COUNTRY_GET_PATH_WITH_VARIABLE = "/cou/{isocode}";
	static final String COUNTRY_PUT_PATH_WITH_VARIABLE = "/cou/{isocode}/{status}";
	static final String COUNTRY_ACTIVE_GET = "/actcou";
	
	static final String GENDERS_GET_PATH =  "/gen";
	static final String GENDERS_MAPPING_PATH_WITH_PATH_VARIABLE = "/gen/{genderid}";
	
	static final String MATERIALCOMP_GET_PATH = "/mcomp";
	static final String MATERIALCOMPOSITION_GET_PATH_WITH_VARIABLE = "/mcomp/{materialid}";
	
	static final String MATERIAL_GET_PATH = "/mat";
	static final String MATERIALTYPE_GET_PATH_WITH_VARIABLE = "/mat/{materialid}";
	static final String MATERIAL_GET_PATH1 = "/mat/{sss}/{sss1}";
	static final String METERIAL_GET_PATH3 = "/mat1";
	
	static final String NO_OF_PIECES_PATH = "/nop";
	static final String NO_OF_PIECES_PATH_WITH_ID = "/nop/{pieceid}";

	static final String OCCASIONALWEAR_PATH = "/occ";
	static final String OCCASIONALWEAR_PATH_WITH_ID = "/occ/{occasionid}";
	
	static final String PATTERNS_PATH = "/pat";
	static final String PATTERNS_PATH_WITH_ID = "/pat/{patid}";

	static final String PRICES_TABLE_PATH_WITH_ID = "/ptab/{productid}";
	static final String PRICES_TABLE_PATH =  "/ptab";
	
	static final String PRODUCTAGE_PATH = "/pa";
	static final String PRODUCTAGE_PATH_WITH_ID = "/pa/{ageid}";
	
	static final String PRODUCTDESCRIPTION_MAPPING_PATH_WITH_ID = "/pd/{descriptionid}";
	static final String PRODUCTDESCRIPTION_MAPPING_PATH = "/pd";
	
	static final String PRODUCTQUANTITIES_GET_PATH =  "/pq";
	static final String PRODUCTQUANTITIES_GET_PATH_WITH_VARIABLE = "/pq/{custid}";
	
	static final String PRODUCTS_MAPPING_PATH = "/prod";
	static final String PRODUCTS_MAPPING_PATH_PRODUCT_ID = "/prod/{productid}";
	static final String PRODUCTS_MAPPING_PATH_WITH_PATH_VARIABLE_1 = "/prod/{productid}/{status}";
	
	static final String PRODUCTTYPE_GET_PATH = "/pt";
	static final String PRODUCTTYPE_PATH_WITH_ID = "/pt/{protypeid}";
	
	static final String SALES_SELLER_GET_PATH = "/su";
	static final String SALES_SELLER_GET_PATH_WITH_VARIABLE = "/su/{username}";
	
	static final String SEASON_WEAR =  "/sw";
	static final String SEASON_WEAR_BY_ID = "/sw/{seasonid}";
	
	static final String WAREHOUSETOSELLER_POST = "/stw";
	static final String WAREHOUSETOSELLER_GET = "/stw";
	
	static final String SIZES_MAPPING_PATH_WITH_ID = "/sizes/{sizeid}";
	static final String SIZES_MAPPING_PATH = "/sizes";
	
	static final String SUBCATEGORIES_GET_PATH = "/sc";
	static final String SUBCATEGORIES_MAPPING_PATH_WITH_VARIABLE = "/sc/{subcatid}";


	static final String PRODUCTDESCRIPTION_MAPPING_PATH1 = "/pd/{sss}/{sss1}";
	static final String PRODUCTQUANTITIES_MAPPING_PATH1 = "/pq/{sss}/{sss1}";

	
	final static String PRODUCT_IMG_LIST ="/imgl";
	final static String NO_IMG_PROD = "/noimg";
	
	
	
	
	
	
	
}
