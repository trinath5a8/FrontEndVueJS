

/**
 * 
 */
package com.lc.sk.inventory.util;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsInventoryService
 * 2020
 */
public interface ConstantValues {

	final static String NO_COUNTRIES_LIST_FOUND="No Countries List Found...";
	final static String NO_COUNTRIES_LIST_FOUND_GIVEN_ISOCODE = "Not Countries List found for Given isocode.";
	final static String COUNTRY_STATUS_UPDATE_SUCCESS = "Status update success for given ISOCODE:" ;
	final static String COUNTRY_STATUS_UPDATE_FAIL = "Status update fail for given ISOCODE:";
	final static boolean STATUS_ACTIVE=true;
	
	final static String EMPTY_WAREHOUSE_LIST="Warehouse list is empty...";
	final static String WAREHOUSE_NOT_FOUND_WITH_GIVEN_ID = "Warehouse not found with given id...";
	final static String WAREHOUSE_NOT_FOUND_WITH_GIVEN_NAME = "Warehouse not found with given Name...";
	
	

	final static String WAREHOUSE_ID = "warehouseid";
	final static String WAREHOUSE_NAME= "warehousename";
	final static String CONTACT_PERSON_NAME = "contactpersonname";
	final static String CONTACT_PERSON_PHONE = "contactpersonphone";
	final static String WAREHOUSE_EMAIL_ADDRESS = "email";
	final static String WAREHOUSE_ADDRESS = "address";
	final static String WHAREHOUSE_PIN = "pincode";
	final static String WAREHOUSE_EST = "est";
	final static String WAREHOUSE_STATUS ="status";
	final static String WHO_CREATED = "whocreated";
	final static String DATE_OF_CREATION = "dateofcreation";
	final static String WHO_UPDATED = "whoupdated";
	final static String MODIFY_DATE = "modifydate";
	final static String ISOCODE = "isocode";
	
	
	final static String DEFAULT_STRING = "no name";
	final static String DEFAULT_INT = "0";
	final static String DEFAULT_FLOAT = "0";
	final static boolean DEFAULT_BOOLEAN = false;
	
	
	final static String RECEIVED_NULL_VALUES = "Received Null values from Client...";
	final static String WAREHOUSE_INSERTION_HAS_ISSUE = "Warehouse insertion has issue..";
	
	final static String WAREHOUSE_INSERTION_SUCCESS = "Warehouse insertion Sucessful..";
	final static String WAREHOUSE_UPDATE_SUCCESS = "Warehouse Update Sucessful..";
	final static String WAREHOUSE_UPDATE_FAIL = "Warehouse Update Fail..";
	
	final static String SELLER_ID = "sellerid";
	
	final static String DATA_NOT_INSERTED_IN_DB = "Data insert failed..";
	final static String DATA_INSERTED_IN_DB = "Data insert Success..";
	final static String DATA_UPDATED_IN_DB = "Data updated";
	final static String DATA_NOT_UPDATED_IN_DB = "Data not updated";
	
	final static String SELLER_WAREHOUSE_RELATION_NOT_FOUND = "Seller's warehouse list not found";
	
	
	final static String DATE_OF_PURCHASE = "dateofpurchase";
	final static String PURCHASE_BY ="purchasedby";
	final static String INV_AMOUNT ="invamount";
	
	final static String WHO_INSERTED ="whoinserted";
	final static String DATE_OF_INSERTION ="dateinsertion";
	final static String QUANTITY = "qty";
	
	final static String BATCH_DETAILS_NOT_FOUND = "Batch details not found";
	final static String NO_GENDERS_LIST_FOUND="No GendersList Found...";

	final static String NO_PRODUCTAGES_LIST_FOUND="No ProductAges List Found...";
	final static String AGE_ID = "ageid";
	final static String DES = "description";
	
	
	
	
	static final String SIZE_ID = "sizeid";
	static final String SIZE_NO = "sizeno";
	static final String HEIGHT = "height";
	static final String WEIGHT = "weight";
	static final String CHEST = "chest";
	static final String WAIST = "waist";
	static final String HIP = "hip";		
	static final String SIZES_NOT_FOUND_EXCEPTION = "sizes not found";
	
	final static String COLOR_ID ="colorid";
	static final String COLOR_NAME = "colorname";
	static final String HASHCODE = "hashcode";
	static final String COLOR_DETAILS_NOT_FOUND = "color details not found";
	
	
	final static String CATID = "catid";
	final static String CATEGORY = "category";
	final static String GENDER = "gender";
	final static String NO_CATEGORIES_LIST_FOUND = "Categories Details not found";
	final static String NO_CATEGORIES_LIST_FOUND_GIVEN_CATID = "CatID detail not found";
	final static String CATEGORIES_UPDATE_SUCCESS = "Categories Update Successful";
	final static String CATEGORIES_UPDATE_FAIL = "Categories Update Fail..";
	
	static final String SEASON_ID = "seasonid";
	static final String SUB_CAT_ID = "subcatid";
	static final String SEASON = "season";
	static final String NULL_STRING = "";	
	static final String SEASONWEAR_NOT_FOUND_EXCEPTION = "Seasonwear not found";
	
	static final String PROTYPE_ID = "protypeid";
	static final String SUBCAT_ID = "subcatid";
	static final String PRODUCTTYPE_NAME = "producttypename";
	static final String NO_PRODUCT_TYPE_DETAILS_FOUND = "no product type details found";
	static final String NO_PRODUCT_TYPE_FOUND_WITH_GIVEN_ID = "no product type found with given id";
	
	
		
	final static String MATERIAL_ID = "materialid";
	final static String MATERIAL_NAME = "materialname";
	final static String DESCRIPTION = "description";
	final static String OCCASION_ID = "occasionid";
	
	final static String CATEGORY_ID = "catid";
	final static String MATERIALTYPE_INSERTION_SUCCESS = "materialtypes insertion Successful..";
	final static String MATERIALTYPE_INSERTION_HAS_ISSUE = "materialtypes insertion has issue..";
	final static String EMPTY_MATERIALTYPES_LIST="materialtype list is empty...";
	final static String MATERIALTYPES_NOT_FOUND_WITH_GIVEN_ID = "materialtypes not found with given id...";	
	static final String MATERIALTYPE_NOT_FOUND_EXCEPTION = "materialtypes not found exception";
	
	final static String NOT_ACCEPTABLE = "N/A";
	static final String BAD_CREDENTIALS = "The API key was not found \" + \"or not the expected value.";
	
	final static String INVENTORY_KEY_ID_DB = "INVENTORY_API_ACCESS_KEY";
	
	final static String SUBCATID = "subcatid";
	final static String CATEGORYNAME = "categoryname";
	final static String NO_SUBCATEGORIES_LIST_FOUND = "SubCategories Details not found";
	final static String NO_SUBCATEGORIES_LIST_FOUND_GIVEN_SUBCATID = "SubCatID detail not found";
	final static String SUBCATEGORIES_UPDATE_SUCCESS = "SubCategories Update Successful";
	final static String SUBCATEGORIES_UPDATE_FAIL = "SubCategories Update Fail..";
	
	
	final static String OCCANAME="occaname";
	final static String OCCASIONID = "occasionid";
	final static String OCCASIONID_NOT_FOUND ="Occasion id not Found";
	final static String NO_OCCASIONALWEAR_LIST_FOUND="No OccasionWear List Found...";
	
	static final String PRODUCT_ID ="productid";
	static final String NOOFSET = "noofsets";
	static final String PIECE_ID = "pieceid";
	static final String NO_OF_PIECES_NOT_FOUND = "no of pieces not found with given id.. ";

	
	
	static final String DESCRIPTIONID = "descriptionid";
	static final String DESCRIPTIONID_NOT_FOUND = "Description id not found";
	final static String NO_PRODUCTDESCRIPTIONS_LIST_FOUND="No Product Descriptions found....";
	
	final static String PATID="patid";
	final static String PRODUCTID="productid";
	final static String NO_PATTERNS_LIST_FOUND="Patterns Details not found";
	final static String PATTERNS_UPDATE_SUCCESS="Patterns Update Sucessful";
	final static String PATTERNS_UPDATE_FAIL="Patterns Update Fail..";
	
	final static String CUSTID="custid";	
	final static String SIZEID="sizeid";
	final static String NO_PRODUCTQUANTITIES_LIST_FOUND="ProductQuantities Details not found";
	final static String PRODUCTQUANTITIES_UPDATE_SUCCESS="ProductQuantities Update Sucessful";
	final static String PRODUCTQUANTITIES_UPDATE_FAIL="ProductQuantities Update Fail..";
	
		 
	static final String MRP = "mrp";
	static final String lC_PRICE = "lcprice";
	static final String TAX = "tax";
	static final String SELLING_PRICE = "sellingprice";
	static final String FINAL_PRICE = "finalprice";
	static final String PRICE_ID = "priceid";
	static final String PRODUCT_ID_NOT_FOUND = "Product id not found";
	static final String PRICE_ID_NOT_FOUND = "Price id not found";
	
	final static String MATERIALCOMPOSITION_INSERTION_SUCCESS = "materialcomposition insertion sucessful";
	final static String MATERIALCOMPOSITION_INSERTION_HAS_ISSUE = "materialcomposition insertion has issue";
	final static String EMPTY_MATERIALCOMPOSITION_LIST="materialcomposition list is empty...";
	final static String MATERIALCOMPOSITION_NOT_FOUND_WITH_GIVEN_ID = "materialcomposition not found with given id...";	
	
	
	final static String STATUS = "status";
	final static String DESCRIPTION_ID = "descriptionid";
	final static String BATCH_ID = "batchid";
	final static String GENDER_ID = "genderid";
	static final String CUSTOMER_ID = "custid";

	final static String PRODUCTS_INSERTION_SUCCESS = "products insertion sucessful";
	final static String PRODUCTS_INSERTION_HAS_ISSUE = "products insertion has issue";
	static final String NO_PRODUCTS_FOUND = "NO PRODUCTS FOUND";
	static final String NO_OF_SET_NOT_FOUND = "no of sets not found";
	
	static final String COLOR_ID_DETAILS_NOT_FOUND = "Color ID not found";
	static final String COUNTRY_NOT_FOUND = "Country not found with given isocode";
	
     static final String NO_BATCH_SERVICE_FOUND = "no batch id found";
	
	static final String PRODUCT_NOT_FOUND = "product details not found";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	

