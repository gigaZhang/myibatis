package com.common.tool;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String工具类
 * @author lph
 *
 */
public class StringUtils {

	
	public static boolean compareStrSplitByComma(String firstStr, String secondStr) {
		if ((firstStr == null) || (secondStr == null)) {
			return false;
		}
		String[] firstArray = firstStr.split(",");
		String[] secondArray = secondStr.split(",");
		Map<String,String> secondStrMap = new HashMap<String,String>();
		if (firstArray.length != secondArray.length) {
			return false;
		}
		for (int i = 0; i < secondArray.length; ++i) {
			secondStrMap.put(secondArray[i], secondArray[i]);
		}
		for (int i = 0; i < firstArray.length; ++i) {
			if (!(secondStrMap.containsKey(firstArray[i]))) {
				return false;
			}
		}
		return true;
	}

	public static String doubleToCurrency(double doubleValue) {
		Object[] args = { new Double(doubleValue) };
		return MessageFormat.format("{0,number,￥,#,###,###,###,###,###,##0.00}", args);
	}

	public static String encodeString(String stringValue, String srcEncoding, String destEncoding) {
		if ((stringValue == null) || (srcEncoding == null) || (destEncoding == null)) {
			return null;
		}
		String value = null;
		try {
			value = new String(stringValue.getBytes(srcEncoding), destEncoding);
		} catch (UnsupportedEncodingException ex) {
			value = stringValue;
		}
		return value;
	}

	public static boolean isEmptyString(String stringValue) {
		return ((stringValue == null) || (stringValue.trim().length() < 1) || (stringValue.trim()
				.equalsIgnoreCase("null")));
	}

	public static boolean isEmpty(String stringValue) {
		return ((stringValue == null) || (stringValue.trim().length() < 1) || (stringValue.trim()
				.equalsIgnoreCase("null")));
	}

	public static boolean isNotEmpty(String stringValue) {
		return ((stringValue != null) && (stringValue.trim().length() >= 1) && (!(stringValue.trim()
				.equalsIgnoreCase("null"))));
	}

	public static boolean isNumber(String str) {
		if (isEmptyString(str)) {
			return false;
		}

		for (int i = 0; i < str.length(); ++i) {
			char ch = str.charAt(i);

			if ((ch < '0') || (ch > '9')) {
				return false;
			}
		}

		return true;
	}

	public static boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
		}
		return false;
	}

	public static String[] getNumStringArray(String stringValue) {
		if (stringValue == null) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile("([0-9])+");
		Matcher m = p.matcher(stringValue);
		while (m.find()) {
			list.add(m.group());
		}
		return ((String[]) list.toArray(new String[0]));
	}

	/**
	 * 转成int类型数据，如果不能转返回-1
	 * @param stringValue
	 * @return
	 */
	public static int stringToInt(String stringValue) {
		return stringToInt(stringValue, -1);
	}

	/**
	 * 转成int类型，如果不能转换，返回defaultValue
	 * @param stringValue
	 * @param defaultValue
	 * @return
	 */
	public static int stringToInt(String stringValue, int defaultValue) {
		int intValue = defaultValue;
		if (stringValue != null) {
			try {
				intValue = Integer.parseInt(stringValue);
			} catch (NumberFormatException ex) {
				intValue = defaultValue;
			}
		}
		return intValue;
	}

	/**
	 * 将字符串转化成gbk格式
	 * @param stringValue
	 * @return
	 */
	public static String toGBKString(String stringValue) {
		return encodeString(stringValue, "ISO8859_1", "GBK");
	}

	/**
	 * 比较对象是否相等
	 * @param string
	 * @param value
	 * @return
	 */
	public static boolean isEquals(Object string, Object value) {
		return ((string != null) && (value != null) && (string.toString().equals(value.toString())));
	}

	/**
	 * 针对String类型，是否不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		return ((str != null) && (!(str.equals(""))));
	}

	/**
	 * 是否为null
	 * @param o
	 * @return
	 */
	public static boolean isNULL(Object o) {
		if (o == null)
			return true;
		if (o instanceof String)
			return isEmpty((String) o);
		return false;
	}

	/**
	 * 是否不为null
	 * @param o
	 * @return
	 */
	public static boolean isNotNULL(Object o) {
		return (!(isNULL(o)));
	}
}
