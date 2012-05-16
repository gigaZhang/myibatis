package com.common.tool;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.filefilter.FileFilterUtils;

/**
 * 资源文件读取工具类
 * @author lph
 *
 */
public class ApplicationConfig {
	private static Properties prop;
	private static ApplicationConfig app = new ApplicationConfig();

	public static ApplicationConfig getApplicationConfig() {
		if (prop == null) {
			app = new ApplicationConfig();
		}
		return app;
	}


	/**
	 * 前缀是mzcrm,后缀是.properties的资源文件
	 */
	private ApplicationConfig() {
		if (prop == null) {
			prop = new Properties();
			try {
				File dir = new File(ApplicationConfig.class.getResource("/").getPath());
				String[] files = dir.list(FileFilterUtils.andFileFilter(FileFilterUtils.prefixFileFilter("mzcrm"),
						FileFilterUtils.suffixFileFilter(".properties")));
				for (String file : files)
					prop.load(ApplicationConfig.class.getResourceAsStream("/" + file));
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	public String getPropertie(String key) {
		return prop.getProperty(key);
	}

	public String getPropertie(String key, String defaultStr) {
		String value = prop.getProperty(key);
		return ((value == null) ? defaultStr : value);
	}

	public Map<String, String> getStartsWithProper(String startsWith) {
		Set<Object> keySet = prop.keySet();
		Map<String, String> map = new HashMap<String, String>();
		for (Iterator<Object> localIterator = keySet.iterator(); localIterator.hasNext();) {
			Object object = localIterator.next();
			String key = object.toString();
			if (key.startsWith(startsWith)) {
				map.put(key, prop.getProperty(key));
			}
		}
		return map;
	}
}