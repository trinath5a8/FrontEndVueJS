package com.lc.sk.inventory.security.util;

public interface CustomerUserUrlMapping {
	final static String CUSTOMER_USER_ENTRY_POINT_ROOT_PATH = "/customer";
	
	//CATEGORIES//

	static final String CATEGORIES_MAPPING_PATH_WITH_ID_CUSTOMER = "/customercategory/{catid}";;
	final static String CATEGORIES_MAPPING_PATH_CUSTOMER = "/customercategory";

	  //COLOR//
    static final String COLOR_PATH_CUSTOMER = "/customercolors";
    static final String COLOR_PATH_WITH_COLOR_ID_CUSTOMER = "/customercolors/{colorid}";
    static final String COLOR_ACTIVE_PATH_CUSTOMER = "/customeractivecolor";

	//GENDER//
    static final String GENDERS_GET_PATH_CUSTOMER = "/customergender";

	static final String GENDERS_MAPPING_PATH_WITH_PATH_VARIABLE = "/customergender/{genderid}";

	//MATERIAL COMPOSITION//
	static final String MATERIALCOMP_GET_PATH_CUSTOMER = "/customermaterialcomp" ;
    static final String MATERIALCOMPOSITION_GET_PATH_WITH_VARIABLE_CUSTOMER = "/customermaterialcomp/{materialid}";
   

	//Material Types//
	static final String MATERIAL_GET_PATH_CUSTOMER = "/customermaterials";

	static final String MATERIALTYPE_GET_PATH_WITH_VARIABLE_CUSTOMER ="/customermaterials/{materialid}";

	//No of pieces//
	static final String NO_OF_PIECES_PATH_CUSTOMER = "/customerpieces";

	static final String NO_OF_PIECES_PATH_WITH_ID_CUSTOMER = "/customerpieces/{pieceid}";

	//Occasionalwear
	static final String OCCASIONALWEAR_PATH_CUSTOMER = "/customeroccwear";

	static final String OCCASIONALWEAR_PATH_WITH_ID_CUSTOMER = "/customeroccwear/{occasionid}";
    
	//patterns//
	static final String PATTERNS_PATH_CUSTOMER = "/customerpattern";

	static final String PATTERNS_PATH_WITH_ID_CUSTOMER = "/customerpattern/{patid}";
    
	//prices//
	static final String PRICES_TABLE_PATH_WITH_ID_CUSTOMER = "/customerprices/{productid}";

	static final String PRICES_TABLE_PATH_CUSTOMER = "/customerprices";

	//PRODUCTAGE//
	static final String PRODUCTAGE_PATH_CUSTOMER = "/customerprodage";

	static final String PRODUCTAGE_PATH_WITH_ID_CUSTOMER = "/customerprodage/{ageid}";

	//productdescription//
	static final String PRODUCTDESCRIPTION_MAPPING_PATH_WITH_ID_CUSTOMER = "/customerproddesc/{descriptionid}";

	static final String PRODUCTDESCRIPTION_MAPPING_PATH_CUSTOMER = "/customerproddesc";
     
	//PRODUCTQUANTITIES//
	static final String PRODUCTQUANTITIES_GET_PATH_CUSTOMER = "/customerproductquant";

	static final String PRODUCTQUANTITIES_GET_PATH_WITH_VARIABLE_CUSTOMER = "/customerproductquant/{custid}";
    
	//PRODUCTS//
	static final String PRODUCTS_MAPPING_PATH_ID_CUSTOMER = "/customerproduct/{productid}";

	static final String PRODUCTS_MAPPING_PATH_CUSTOMER = "/customerproduct";
    
	//producttype//
	static final String PRODUCTTYPE_GET_PATH_CUSTOMER = "/customerprodtype";

	static final String PRODUCTTYPE_PATH_WITH_ID_CUSTOMER = "/customerprodtype/{protypeid}";

	//seasonwear//
	static final String SEASON_WEAR_CUSTOMER = "/customerseaswear";

	static final String SEASON_WEAR_BY_ID_CUSTOMER = "/customerseaswear/{seasonid}";

	//sizes//
	static final String SIZES_MAPPING_PATH_WITH_ID_CUSTOMER = "/customersize/{sizeid}";

	static final String SIZES_MAPPING_PATH_CUSTOMER = "/customersize";

	//subcategories//
	static final String SUBCATEGORIES_GET_PATH_CUSTOMER = "/customersubcategory";

	static final String SUBCATEGORIES_MAPPING_PATH_WITH_VARIABLE_CUSTOMER = "/customersubcategory/{subcatid}";

	

	static final String CUSTOMER_PATHLIST = "/100";
	
	
	
	


	




}
