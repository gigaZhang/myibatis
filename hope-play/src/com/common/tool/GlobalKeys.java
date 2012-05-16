package com.common.tool;



/**
 * 资源文件
 * @author lph
 *
 */
public class GlobalKeys {

	/**
	 * 测试全局键值对-数据源：properties
	 * @return
	 */
	public static int getSearchMaxDoc() {
		String val = ApplicationConfig.getApplicationConfig().getPropertie("test",  "test");
		if (StringUtils.isNumber(val)) {
			return new Integer(val).intValue();
		} else {
			return new Integer(100000).intValue();
		}
	}
	

}
