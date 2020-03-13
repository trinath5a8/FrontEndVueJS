/**
 * 
 */
package com.lc.sk.inventory.util;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsInventoryService
 * 2020
 */
public interface URLMapping {

	
	final static String INVENTORY_ROOT_PATH = "/";
	final static String COUNTRY_PATH="/countries";
	final static String COUNTRY_PATH_WITH_COUNTRY_ID = "/countries/{isocode}";
	final static String UPDATE_COUNTRY_STATUS = "/countries/{isocode}/{status}";
	final static String GET_COUNTRIES_ENABLED_LIST = "/activecountries";
	
	final static String GET_ALL_WAREHOUSE_LIST = "/warehouses";
	final static String GET_ALL_WAREHOUSE_LIST_BY_ID = "/warehouses/{warehouseid}";
	final static String GET_ALL_WAREHOUSE_LIST_BY_NAME = "/warehouses/{warehousename}";
	
	final static String POST_SUBMIT_WAREHOUSE_TO_SELLER = "/sellertowarehouse";
	
	final static String BATCH_MAPPING_PATH = "/batches";
	final static String BATCH_MAPPING_PATH_WITH_PATH_VARIABLE = "/batches/{batchid}";
	final static String BATCH_MAPPING_PATH_WITH_PATH_VARIABLE_1 = "/batches/{batchid}/{status}";
	
	final static String GENDERS_MAPPING_PATH = "/genders";
	final static String GENDERS_MAPPING_PATH_WITH_PATH_VARIABLE = "/genders/{genderid}";
	
	final static String PRODUCTAGE_PATH="/productage";
	final static String PRODUCTAGE_PATH_WITH_ID="/productage/{ageid}";
	
	
	final static String SIZES="/sizes";
	final static String SIZE_BY_ID="/sizes/{sizeid}";
	
	final static String COLOR_PATH="/color";
	final static String COLOR_PATH_WITH_COLOR_ID="/color/{colorid}";
	
	
	final static String CATEGORIES_MAPPING_PATH = "/categories";	
	final static String CATEGORIES_MAPPING_PATH_BY_CID = "/categories/{catid}";
	
	
	final static String SEASON_WEAR="/seasonwear";
	final static String SEASON_WEAR_BY_ID="/seasonwear/{seasonId}";
	
	final static String PRODUCTTYPE_PATH="/producttype";
	final static String PRODUCTTYPE_PATH_WITH_ID="/producttype/{protypeid}";
	

	final static String MATERIALTYPES_MAPPING_PATH = "/material";
	final static String GET_ALL_MATERIALTYPES_LIST = "/material";
	final static String GET_ALL_MATERIALTYPES_LIST_BY_ID = "/material/{materialid}";
	
	final static String SUBCATEGORIES_MAPPING_PATH = "/subcategories";
	final static String SUBCATEGORIES_MAPPING_PATH_WITH_ID = "/subcategories/{subcatid}";
	
	final static String OCCASIONALWEAR_PATH="/occasionalwear";
	final static String OCCASIONALWEAR_PATH_WITH_ID="/occasionalwear/{occasionid}";
	
	
	
	final static String NO_OF_PIECES_PATH_WITH_ID="/noofpieces/{pieceid}";
	static final String NO_OF_PIECES_PATH = "/noofpieces";
	
	final static String ROOT_PATH_FOR_VALIDATION = "/**";
	
	final static String PRODUCTDESCRIPTIONS_PATH="/productdescriptions";
	static final String PRODUCTDESCRIPTIONS_PATH_WITH_ID = "/productdescriptions/{descriptionid}";



	final static String PATTERNS_PATH="/patterns";
	final static String PATTERNS_PATH_WITH_ID="/patterns/{patid}";
	
	final static String PRODUCTQUANTITIES_PATH="/productquantities";
	final static String PRODUCTQUANTITIES_PATH_WITH_ID="/productquantities/{custid}";
	

	final static String PRICES_TABLE="/pricestable";
	static final String PRICES_TABLE_BY_ID = "/pricestable/{priceId}" ;
	
	final static String MATERIALCOMPOSITION_MAPPING_PATH = "/materialcomp";
	final static String GET_ALL_MATERIALCOMPOSITION_LIST_BY_ID = "/materialcomp/{materialid}";
	
	final static String PRODUCTS_MAPPING_PATH = "/products";
	static final String PRODUCTS_MAPPING_PATH_ID = "/products/{productid}";
	static final String PRODUCTS_MAPPING_PATH_WITH_PATH_VARIABLE_1 ="/products/{productid}/{status}" ;
}
