package com.framework.tool;

import java.util.Locale;
 
public class Constants {  
//	
//	/**
//	 * 管理员操作记录,INSERT是增加操作，UPDATE是修改操作,DELETE是删除操作
//	 * */
//	
//	public final static String ADMIN_LOG_INSERT = "INSERT";
//	
//	public final static String ADMIN_LOG_UPDATE = "UPDATE";
//	
//	public final static String ADMIN_LOG_DELETE = "DELETE";
//	
//	
//	/**
//	 * 系统用户登录的Session名称
//	 */
//	public final static String SESSION_USER = "SESSION_USER_NAME";
//
//	public final static String SESSION_LOGIN = "SESSION_LOGIN";
//	
//	public final static String SESSION_USERID = "SESSION_USERID";
//
//	public final static String SESSION_PASSWORD = "SESSION_PASSWORD";
//
//	/**
//	 * 系统用户登录的Session后的权限名称
//	 */ 
//	public final static String SESSION_USER_POPEDOM = "SESSION_USER_POPEDOM_NAME";
//	
//	/**
//	 * 系统管理员登录的Session后的权限名称
//	 */
//	public final static String SESSION_ADMIN_POPEDOM = "SESSION_ADMIN_POPEDOM_NAME";
//
//	/**
//	 * 系统管理员登录的Session名称
//	 */
//	public final static String SESSION_ADMIN = "SESSION_ADMIN_NAME";
//
//	/**
//	 * 前台WEB系统分页中每页最大记录数
//	 */
//	public final static int WEB_PAGE_SIZE = 10;
//
//	/**
//	 * 后台管理系统分页中每页最大记录数
//	 */
//	public final static int ADMIN_PAGE_SIZE = 13;
//
//	/**
//	 * 字符分割符号
//	 */
//	public final static String SPLIT_SIGN = "^";
//
//	/**
//	 * 参数前缀
//	 */
//	public final static String PARAM_PREFIX = "pf_";
// 
//	public final static String PATTERN_TIMESTAMP = "yyyy-MM-dd HH:mm:ss";
//
//	public final static String DEFAULT_TIMEZONE = "GMT+8";
//
//	public final static Locale DEFAULT_LOCALE = Locale.CHINA;
//
//	public final static String DEFAULT_ENCODINIG = "UTF-8";
//
//	public final static String DATABASE_CHARSET = "UTF-8";
//
//	public final static int DEFAULT_SESSION_TIMEOUT = 600; // second
//
//	public final static int TASK_STATUS_ERROR = 0;
//
//	public final static int TASK_STATUS_ACCEPTED = 1;
//
//	public final static int TASK_STATUS_EXECUTING = 2;
//
//	public final static int TASK_STATUS_FILE_CREATED = 3;
//
//	public final static int TASK_STATUS_PARTIAL_COMPLETED = 4;
//
//	public final static int TASK_STATUS_ALL_COMPLETED = 5;
//
//	public final static int TASK_STATUS_CACELED = 6;
//	
//	/** 已过期 **/
//	public final static int STATUS_OVERDUE = 7; 
//	
//	/** 禁用,冻结 **/
//	public final static int STATUS_FORBIDDEN = 8; 
//
	/** 删除 **/
	public final static int STATUS_DELETED = 9; 
//
//	// 操作动作
//	public final static String ACTION_INSERT = "i";
//
//	public final static String ACTION_DELETE = "d";
//
//	public final static String ACTION_QUERY = "q";
//
//	public final static String ACTION_FORBIDDEN = "f";
//
//	public final static String ACTION_ACTIVE = "a";
//
//	public final static String ACTION_PASS = "p";

	// result dao code
	public final static int CODE_DEFAULT_RESULT = -1;

	public final static int CODE_DAO_SUCCESS = 1;

	public final static int CODE_DAO_FAILURE = -1;
//    //client manager
//	public final static String CODE_CLINET_APPLY="500";
//
//	public final static String ACTION_CLIENT_PASS = "Z";
//	
//	public final static String ACTION_HOLD_BACK = "h";
//	
//	public final static String ACTION_DOWN = "x";
//	
//	// result code
//	public final static String CODE_SUCCESS = "0";
//
//	public final static String CODE_PARAMETER_ERROR = "1";
//
//	public final static String CODE_DATABASE_ACCESS_ERROR = "2";
//
//	public final static String CODE_UNSUPPORTED_COMMAND_ERROR = "3";
//
//	public final static String CODE_NO_PERMISSION_ERROR = "4";
//
//	public final static String CODE_INVALID = "5";
//
//	public final static String CODE_MAXLENGTH = "6";
//
//	public final static String CODE_MINLENGTH = "7";
//
//	public final static String CODE_RANGE = "8";
//
//	public final static String CODE_REQUIRED = "9";
//
//	public final static String CODE_BYTE = "10";
//
//	public final static String CODE_DATE = "11";
//
//	public final static String CODE_DOUBLE = "12";
//
//	public final static String CODE_FLOAT = "13";
//
//	public final static String CODE_INTEGER = "14";
//
//	public final static String CODE_LONG = "15";
//
//	public final static String CODE_SHORT = "16";
//
//	public final static String CODE_CREDITCARD = "17";
//
//	public final static String CODE_EMAIL = "18";
//
//	public final static String CODE_NOT_EXISTS = "19";
//
//	public final static String CODE_UNIQUE = "20";
//
//	public final static String CODE_USERNAME_PASSWORD_NOT_MATCH = "21";
//
//	public final static String CODE_NEED_LOGIN = "22";
//
//	public final static String CODE_NO_MATCHED_RECORD = "23";
//
//	public final static String CODE_INVALID_LICENSE = "24";
//
//	public final static String CODE_CAMERA_AMOUNT_EXCEED = "25";
//
//	public final static String CODE_USER_AMOUNT_EXCEED = "26";
//
//	public final static String CODE_IN_USING = "27";
//
//	public final static String CODE_CANNOT_BE_DELETE = "28";
//
//	public final static String CODE_XML_INVALID = "29";
//
//	public final static String CODE_CANNOT_GET_JDBC_CONNECTION = "30";
//
//	public final static String CODE_PARAMETER_REQUIRE = "31";
//
//	public final static String CODE_UNKNOWN_ERROR = "99";
//
//	// Exception code from gpio
//	public final static String CODE_GPIO_INVALID = "100";
//
//	public final static String CODE_DELETE_AREA_WITH_SUBITEM_ERROR = "101";
//
//	public final static String CODE_CANNOT_DELETE_ROOT_AREA = "102";
//
//	public final static String CODE_NEED_STOP_ALL_TASK_BEFORE_DELETE_SA = "105";
//
//	public final static String CODE_NOT_APPOINT_AREA = "106";
//
//	public final static String CODE_PAIR_PARAMS_NOT_EQUALS = "200";
//
//	public final static String CODE_SA_EERORS = "201";
//
//	public final static String CODE_NOT_THE_SAME = "202";
//
//	public final static String CODE_CAMEREA_IN_OTHER_GROUPS = "203";
//
//	public final static String CODE_NEED_BACKUP_BEFORE_CLEAN = "204";
//
//	public final static String CODE_TASK_HAS_BEEN_CANCELED = "205";
//
//	public final static String CODE_TIME_OUT_RANGE = "206";
//
//	public final static String CODE_START_TIME_LARGER = "207";
//
//	// Exception Code from CSG
//	public final static String CODE_CONTROLPTZ_FAILED = "300";
//
//	public final static String CODE_DELETEVSUSER_FAILED = "301";
//
//	public final static String CODE_SETVSIMAGEADJUSTING_FAILED = "302";
//
//	public final static String CODE_SETVSIMAGEFORMAT_FAILED = "303";
//
//	public final static String CODE_SETVSSERIALPORT_FAILED = "304";
//
//	public final static String CODE_SETVSUSER_FAILED = "305";
//
//	public final static String CODE_SETVSVIDEO_FAILED = "306";
//
//	public final static String CODE_SUBSCRIBEALARM_FAILED = "307";
//
//	public final static String CODE_VISIT_NVS_ERROR = "308";
//
//	public final static String CODE_UNSUPPORTED_PTZ_PROTOCOL = "309";
//
//	public final static String CODE_UNSUPPORTED_PTZ_PROTOCOL_COMMAND = "310";
//
//	public final static String CODE_UNSUPPORTED_ACTION = "311";
//
//	public final static String CODE_SETVSIMGPARAM_FAILED = "312";
//
//	public final static String CODE_VS_AUTHENTICATE_FAILED = "313";
//
//	public final static String CODE_SETVSIPINFO_FAILED = "314";
//
//	public final static String CODE_SETGPIODEVICE_FAILED = "315";
//
//	public final static String CODE_SETVSTIME_FAILED = "316";
//
//	public final static String CODE_UNSUPPORT_VS_VENDOR = "317";
//
//	public final static String CODE_SETDECODER_FAILED = "318";
//
//	public final static String CODE_CONTROLVS_FAILED = "319";
//
//	public final static String CODE_SET_VS_LOCAL_STORAGE_TASK_FAILED = "320";
//
//	public final static String CODE_STOP_VS_LOCAL_STORAGE_TASK_FAILED = "321";
//	
//	public final static String CODE_ISEMPTY = "00";
}
