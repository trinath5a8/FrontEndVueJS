package com.lc.sk.inventory.security.util;

public interface SellerUserURLMapping {

	final static String SELLER_USER_ENTRY_POINT_ROOT_PATH="/seller"; //salesuser
	
	final static String SELLER_BATCHES_GET_PATH = "/sellerbatches";
	final static String SELLER_BATCHES_MAPPING_PATH_WITH_PATH_VARIABLE ="/sellerbatches/{batchid}" ;
	static final String SELLER_BATCHID_PUT_PATH_WITH_VARIABLE ="/sellerbatches/{batchid}/{status}" ;
	
	static final String SELLER_CATEGORIES_MAPPING_PATH = "/sellercategories";
	static final String SELLER_CATEGORIES_MAPPING_PATH_WITH_ID = "/sellercategories/{catid}";
	
	static final String SELLER_COLOR_PATH_WITH_COLOR_ID = "/sellercolors/{colorid}";
	static final String SELLER_COLOR_PATH = "/sellercolors";
	
	static final String SELLER_COUNTRY_GET_PATH = "/sellercountries";
	static final String SELLER_COUNTRY_GET_PATH_WITH_VARIABLE = "/sellercountries/{isocode}";
	
	static final String SELLER_GENDERS_GET_PATH = "/sellergenders";
	static final String SELLER_GENDERS_MAPPING_PATH_WITH_PATH_VARIABLE = "/sellergenders/{genderid}";
	
	static final String SELLER_MATERIALCOMP_GET_PATH = "/sellermaterialcomp";
	static final String SELLER_MATERIALCOMPOSITION_GET_PATH_WITH_VARIABLE = "/sellermaterialcomp/{materialid}";
	
	static final String SELLER_MATERIAL_GET_PATH = "/sellermaterial";
	static final String SELLER_MATERIALTYPE_GET_PATH_WITH_VARIABLE = "/sellermaterial/{materialid}";
	
	static final String SELLER_NO_OF_PIECES_PATH = "/sellernoofpieces";
	static final String SELLER_NO_OF_PIECES_PATH_WITH_ID = "/sellernoofpieces/{pieceid}";
	
	static final String SELLER_OCCASIONALWEAR_PATH = "/selleroccasionalwear";
	static final String SELLER_OCCASIONALWEAR_PATH_WITH_ID = "/selleroccasionalwear/{occasionid}";
	
	static final String SELLER_PATTERNS_PATH = "/sellerpatterns";
	static final String SELLER_PATTERNS_PATH_WITH_ID = "/sellerpatterns/{patid}";
	
	static final String SELLER_PRICES_TABLE_PATH = "/sellerpricestable";
	static final String SELLER_PRICES_TABLE_PATH_WITH_ID = "/sellerpricestable/{productid}";
	
	static final String SELLER_PRODUCTAGE_PATH = "/sellerproductage";
	static final String SELLER_PRODUCTAGE_PATH_WITH_ID = "/sellerproductage/{ageid}";
	
	static final String SELLER_PRODUCTDESCRIPTION_MAPPING_PATH = "/sellerproductdescriptions";
	static final String SELLER_PRODUCTDESCRIPTION_MAPPING_PATH_WITH_ID = "/sellerproductdescriptions/{descriptionid}";
	
	static final String SELLER_PRODUCTQUANTITIES_GET_PATH = "/sellerproductquantities";
	static final String SELLER_PRODUCTQUANTITIES_GET_PATH_WITH_VARIABLE = "/sellerproductquantities/{custid}";
	
	static final String SELLER_PRODUCTS_MAPPING_PATH = "/sellerproducts";
	static final String SELLER_PRODUCTS_MAPPING_PATH_ID = "/sellerproducts/{productid}";
	
	static final String SELLER_PRODUCTTYPE_GET_PATH = "/sellerproducttype";
	static final String SELLER_PRODUCTTYPE_PATH_WITH_ID = "/sellerproducttype/{protypeid}";
	
	static final String SELLER_SALLER_SELLER_GET_PATH = "/sellersalesuser";
	static final String SELLER_SELLER_GET_PATH_WITH_VARIABLE = "/sellersalesuser/{username}";
	
	static final String SELLER_SEASON_WEAR = "/sellerseasonwear";
	static final String SELLER_SEASON_WEAR_BY_ID = "/sellerseasonwear/{seasonid}";
	
	static final String SELLER_WAREHOUSETOSELLER_POST = "/sellersellertowarehouse";
	
	static final String SELLER_SIZES_MAPPING_PATH = "/sellersizes";
	static final String SELLER_SIZES_MAPPING_PATH_WITH_ID = "/sellersizes/{sizeid}";
	
	static final String SELLER_SUBCATEGORIES_GET_PATH = "/sellersubcategories";
	static final String SELLER_SUBCATEGORIES_MAPPING_PATH_WITH_VARIABLE = "/sellersubcategories/{subcatid}";
	
	static final String SELLER_PATH_1 = "/sellerroles";
	static final String SELLER_PATH_2 = "/sellerroles/{rolename}";
	
	static final String SELLER_SELLER_GET_PATH = "/sellersellerdetails";

	static final String PATHLIST = "/100";

	static final String SELLER_COUNTRY_ACTIVE_GET = "/selleractivecountries";
	
	
	
	
	
	

}
