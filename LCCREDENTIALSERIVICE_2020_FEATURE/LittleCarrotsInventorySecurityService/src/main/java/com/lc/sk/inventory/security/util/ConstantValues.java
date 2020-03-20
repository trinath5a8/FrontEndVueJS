/**
 * 
 */
package com.lc.sk.inventory.security.util;

import java.io.Serializable;

/**
 * @author Mastanvali Shaik LittleCarrotsInventorySecurityService 2020
 */
public interface ConstantValues extends Serializable {

	final static String HEADER_KEY_DB_ID = "SECU_API_ACCESS_KEY";
	final static String AUTH_HEADER_KEY_DB_ID ="AUTH_API_ACCESS_KEY";
	final static String INVENTORY_API_ACCESS_KEY = "INVENTORY_API_ACCESS_KEY";
	final static String EMAIL_API_ACCESS_KEY = "EMAIL_API_ACCESS_KEY";

	final static String FORBIDDEN_403_INFO = "The API key was not found or not the expected value.";

	static final String MATERIAL_NAME = "materialname";
	static final String DESCRIPTION = "description";
	static final String OCCASION_ID = "occasionid";
	static final String SEASON_ID = "seasonid";
	static final String CATEGORY_ID = "catid";

	static final String MATERIAL_ID = "materialid";

	final static String ERROR_BEAN_RETURNED = "Returned Error Bean";

	final static String SLASH_TAG = "/";

	final static String AUTHORIZATION_ROLE_NAME_VARIABLE_NAME = "rolename";
	final static String AUTHORIZATION_ROLE_DESCRIPTIONS_VARIABLE_NAME = "descriptions";
	final static String AUTHORIZATION_ROLE_STATUS_VARIABLE_NAME = "rolestatus";

	final static String DEFAULT_INT_VALUE = "0";
	final static String DEFAULT_STRING_VALUE = "noname";

	final static String AUTHORIZED_USERNAME = "username";
	final static String AUTHORIZED_PASSWORD = "password";
	final static String AUTHORIZED_NEW_PASSWORD = "newpassword";
	final static String AUTHORIZED_STATUS = "status";
	final static String AUTHORIZED_USER_EMAIL = "email";

	final static String SELLER_ID = "sellerid";
	final static String SELLER_NAME = "sellername";
	final static String SELLER_COMPANY_NAME = "sellercompanyname";
	final static String PHONE_NUMBER = "phonenumber";
	final static String ADDRESS = "address";
	final static String EMAIL = "email";
	final static String ISOCODE = "isocode";
	final static String STATUS = "status";
	final static String FULLNAME = "fullname";

	final static String REGEX = "[]";

	final static String SESSION_USERNAME = "username";
	final static String SESSION_TOKENID = "tokenid";
	final static String SESSION_ROLENAME = "rolename";
	final static String SESSION_EMAIL = "email";

	static final String COLOR_NAME = "colorname";
	static final String HASHCODE = "hashcode";
	static final String COLOR_ID = "colorid";

	final static String SUBCATID = "subcatid";
	final static String CATID = "catid";
	final static String CATEGORYNAME = "categoryname";

	final static String SEASON = "season";

	final static String PROTYPE_ID = "protypeid";
	final static String SUBCAT_ID = "subcatid";
	final static String PRODUCTTYPE_NAME = "producttypename";

	final static String OCCANAME = "occaname";
	final static String OCCASIONID = "occasionid";

	static final String AGE_ID = "ageid";
	static final String DES = "description";

	static final String WAREHOUSE_ID = "warehouseid";
	static final String DATE_OF_PURCHASE = "dateofpurchase";
	static final String PURCHASE_BY = "purchasedby";
	static final String INV_AMOUNT = "invamount";
	static final String WHO_INSERTED = "whoinserted";
	static final String WAREHOUSE_STATUS = "status";
	static final String QUANTITY = "qty";

	final static String PATID = "patid";
	final static String PRODUCTID = "productid";

	static final String WAREHOUSE_NAME = "warehousename";
	static final String CONTACT_PERSON_NAME = "contactpersonname";
	static final String CONTACT_PERSON_PHONE = "contactpersonphone";
	static final String WAREHOUSE_EMAIL_ADDRESS = "email";
	static final String WAREHOUSE_ADDRESS = "address";
	static final String WHAREHOUSE_PIN = "pincode";
	static final String WAREHOUSE_EST = "est";
	static final String WHO_CREATED = "whocreated";
	static final String WHO_UPDATED = "whoupdated";

	static final String CUST_ID = "custid";

	static final String SIZE_ID = "sizeid";

	final static String CATEGORY = "category";
	final static String GENDER = "gender";
	static final String CAT_ID = "catid";

	static final String SIZE_NO = "sizeno";
	static final String HEIGHT = "height";
	static final String WEIGHT = "weight";
	static final String CHEST = "chest";
	static final String WAIST = "waist";
	static final String HIP = "hip";

	static final String MRP = "mrp";
	static final String PRODUCT_ID = "productid";
	static final String lC_PRICE = "lcprice";
	static final String TAX = "tax";
	static final String SELLING_PRICE = "sellingprice";
	static final String FINAL_PRICE = "finalprice";
	static final String PRICE_ID = "priceid";

	static final String DESCRIPTION_ID = "descriptionid";

	static final String BATCH_ID = "batchid";
	static final String GENDER_ID = "genderid";
	static final String CUSTOMER_ID = "custid";

	static final String NOOFSETS = "noofsets";

	static final String PIECE_ID = "pieceid";

	final static String BACK_END_SERVER_NO_RESPONSE = "Back End Server not Responding...";

	final static int ACTIVE_USER = 1;
	final static String NOT_ACCEPTABLE = "N/A";
	final static String USER_ID_INVALID = "Invalid username/password...";
	
	
	//AADARSH
	final static String NO_PRODUCT_TYPE_DETAILS_NOT_FOUND="no product type details found";
	final static String NO_PRODUCT_TYPE_NOT_FOUND="no product type found with given id";
	final static String PRICE_ID_NOT_FOUND="Price id not found";
	static final String NO_PRODUCT_AGES_FOUND = "No ProductAges List Found...";
	static final String NO_PRODUCT_DESCRIPTIONS_FOUND = "No Product Descriptions found....";
	static final String PRODUCT_QUANTITIES_NOT_FOUND = "ProductQuantities Details not found";
	static final String NO_PRODUCTS_FOUND = "NO PRODUCTS FOUND";
	
	static final String DATA_NOT_UPDATED = "Data not updated";
	static final String NO_GENDERS_LIST_FOUND = "No GendersList Found...";
	static final String NO_CATEGORIES_LIST_FOUND = "Categories Details not found";
	static final String NO_CATEGORIES_LIST_FOUND_GIVEN_CATID = "CatID detail not found";
	static final String DATA_NOT_INSERTED_IN_DB = "Data insert failed..";
	static final String CATEGORIES_UPDATE_FAIL = "Categories Update Fail..";
	static final String EMPTY_MATERIALCOMPOSITION_LIST = "materialcomposition list is empty...";
	static final String MATERIALCOMPOSITION_NOT_FOUND_WITH_GIVEN_ID = "materialcomposition not found with given id...";
	static final String EMPTY_MATERIALTYPES_LIST = "materialtype list is empty...";
	static final String MATERIALTYPES_NOT_FOUND_WITH_GIVEN_ID = "materialtypes not found with given id...";
	static final String NO_OF_SET_NOT_FOUND = "no of sets not found";
	static final String NO_OF_PIECES_NOT_FOUND = "no of pieces not found with given id.. ";
	static final String NO_OCCASIONALWEAR_LIST_FOUND = "No OccasionWear List Found...";
	static final String OCCASIONID_NOT_FOUND = "Occasion id not Found";
	
	//rekha
	static final String NO_COUNTRIES_LIST_FOUND_GIVEN_ISOCODE = "Not Countries List found for Given isocode.";
	static final String NO_COUNTRIES_LIST_FOUND ="No Countries List Found...";
	static final String COUNTRY_STATUS_UPDATE_FAIL = "Status update fail for given ISOCODE:";
	static final String COLOR_DETAILS_NOT_FOUND = "color details not found";
	static final String RECEIVED_NULL_VALUES = "Received Null values from Client...";
	static final String AUTHORIZATION_ROLES_NOT_FOUND = "Authorized Roles not Found...";
	static final String NULL_VALUES_RECEIVED_FROM_CLIENT = "Received Null Values from Client...";
	static final String NO_AUTHORIZED_USER_FOUND = "No Authorized User Found....";
	static final String BATCH_DETAILS_NOT_FOUND = "Batch details not found";
	static final String NO_PATTERNS_LIST_FOUND = "Patterns Details not found";

	static final String SEASONWEAR_NOT_FOUND = "Seasonwear not found";
	static final String SIZES_NOT_FOUND_EXCEPTION = "sizes not found";
	static final String SUBCAT_ID_NOT_FOUND = "SubCatID detail not found";
	static final String WAREHOUSE_NOT_FOUND = "Warehouse not found with given id...";
	static final String  NO_SALES_USER_FOUND="No Sales User Found....";
	static final String VALUE_NOT_FOUND = " No role name present";
	static final String USER_NAME_NOT_FOUND = "User name not found";
	static final String WAREHOUSE_DATA_NOT_FOUND = "Warehouse list is empty...";
	static final String DESCRIPTION_ID_NOT_FOUND = "Description id not found";
	
	final  static String MAIL_NOT_SENT = "Mail Server has issue and mail not sent to destination";
	static final String COUNTRY_NOT_FOUND = "Country not found with given isocode";

	static final String NO_BATCH_SERVICE_FOUND = "no batch id found";
	static final Object PRODUCT_NOT_FOUND = "product details not found";
	
	
	final static String IMAGE_PARAM="img";
	final static String IMAGE_PRODUCTID = "productid";
}
