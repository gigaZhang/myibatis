package com.framework.tool;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 定位器
 * @author user
 *
 */
public class BeanLocator {

	private static final String CONTEXT_LOCATION = "/applicationContext.xml";

	private static final String DAO_LOCATION = "/conf/spring/beans-dao.xml";

	private static final String SERVICE_LOCATION = "/conf/spring/beans-service.xml";

	private static final String[] locations = { CONTEXT_LOCATION, DAO_LOCATION,
			SERVICE_LOCATION };

	private static ApplicationContext app;

	/**
	 * 从配置文件中根据名称获得Bean
	 * @param name  bean的名称
	 * @return Object 返回获得的Bean
	 */
	public static Object getBean(String name) {
		if (app == null) {
			app = new ClassPathXmlApplicationContext(locations);
		}
		return app.getBean(name);
	}
}
