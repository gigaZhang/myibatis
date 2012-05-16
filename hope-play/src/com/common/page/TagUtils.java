package com.common.page;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Provides helper methods for JSP tags.
 * 
 * @version $Rev: 191170 $
 * @since Struts 1.2
 */
public class TagUtils {

	/**
	 * The Singleton instance.
	 */
	private static final TagUtils instance = new TagUtils();

	/**
	 * Commons logging instance.
	 */
	private static final Log log = LogFactory.getLog(TagUtils.class);


	/**
	 * Maps lowercase JSP scope names to their PageContext integer constant
	 * values.
	 */
	private static final Map scopes = new HashMap();

	/**
	 * Initialize the scope names map.
	 */
	static {
		scopes.put("page", new Integer(PageContext.PAGE_SCOPE));
		scopes.put("request", new Integer(PageContext.REQUEST_SCOPE));
		scopes.put("session", new Integer(PageContext.SESSION_SCOPE));
		scopes.put("application", new Integer(PageContext.APPLICATION_SCOPE));
	}

	/**
	 * Constructor for TagUtils.
	 */
	protected TagUtils() {
		super();
	}

	/**
	 * Returns the Singleton instance of TagUtils.
	 */
	public static TagUtils getInstance() {
		return instance;
	}

	public int getScope(String scopeName) throws JspException {
		Integer scope = (Integer) scopes.get(scopeName.toLowerCase());

		if (scope == null) {
			throw new JspException("lookup.scope"+scope);
		}

		return scope.intValue();
	}

	/**
	 * Locate and return the specified bean, from an optionally specified scope,
	 * in the specified page context. If no such bean is found, return
	 * <code>null</code> instead. If an exception is thrown, it will have
	 * already been saved via a call to <code>saveException()</code>.
	 * 
	 * @param pageContext
	 *            Page context to be searched
	 * @param name
	 *            Name of the bean to be retrieved
	 * @param scopeName
	 *            Scope to be searched (page, request, session, application) or
	 *            <code>null</code> to use <code>findAttribute()</code>
	 *            instead
	 * @return JavaBean in the specified page context
	 * @exception JspException
	 *                if an invalid scope name is requested
	 */
	public Object lookup(PageContext pageContext, String name, String scopeName)
			throws JspException {

		if (scopeName == null) {
			return pageContext.findAttribute(name);
		}
		try {
			return pageContext.getAttribute(name, instance.getScope(scopeName));
		} catch (JspException e) {
			throw e;
		}

	}

	/**
	 * Locate and return the specified property of the specified bean, from an
	 * optionally specified scope, in the specified page context. If an
	 * exception is thrown, it will have already been saved via a call to
	 * <code>saveException()</code>.
	 * 
	 * @param pageContext
	 *            Page context to be searched
	 * @param name
	 *            Name of the bean to be retrieved
	 * @param property
	 *            Name of the property to be retrieved, or <code>null</code>
	 *            to retrieve the bean itself
	 * @param scope
	 *            Scope to be searched (page, request, session, application) or
	 *            <code>null</code> to use <code>findAttribute()</code>
	 *            instead
	 * @return property of specified JavaBean
	 * 
	 * @exception JspException
	 *                if an invalid scope name is requested
	 * @exception JspException
	 *                if the specified bean is not found
	 * @exception JspException
	 *                if accessing this property causes an
	 *                IllegalAccessException, IllegalArgumentException,
	 *                InvocationTargetException, or NoSuchMethodException
	 */
	public Object lookup(PageContext pageContext, String name, String property,
			String scope) throws JspException {

		// Look up the requested bean, and return if requested
		Object bean = lookup(pageContext, name, scope);
		if (bean == null) {
			JspException e = null;
			if (scope == null) {
				e = new JspException("lookup.bean.any"+name);
			} else {
				e = new JspException("lookup.bean"+name+scope);
			}
			throw e;
		}

		if (property == null) {
			return bean;
		}

		// Locate and return the specified property
		try {
			return PropertyUtils.getProperty(bean, property);

		} catch (Exception e) {
			
			throw new JspException(e.toString());

		} 

	}

	
	/**
	 * Write the specified text as the response to the writer associated with
	 * this page. <strong>WARNING</strong> - If you are writing body content
	 * from the <code>doAfterBody()</code> method of a custom tag class that
	 * implements <code>BodyTag</code>, you should be calling
	 * <code>writePrevious()</code> instead.
	 * 
	 * @param pageContext
	 *            The PageContext object for this page
	 * @param text
	 *            The text to be written
	 * 
	 * @exception JspException
	 *                if an input/output error occurs (already saved)
	 */
	public void write(PageContext pageContext, String text) throws JspException {

		JspWriter writer = pageContext.getOut();

		try {
			writer.print(text);

		} catch (IOException e) {
			
			throw new JspException(e.toString());
		}

	}

	/**
	 * Write the specified text as the response to the writer associated with
	 * the body content for the tag within which we are currently nested.
	 * 
	 * @param pageContext
	 *            The PageContext object for this page
	 * @param text
	 *            The text to be written
	 * 
	 * @exception JspException
	 *                if an input/output error occurs (already saved)
	 */
	public void writePrevious(PageContext pageContext, String text)
			throws JspException {

		JspWriter writer = pageContext.getOut();
		if (writer instanceof BodyContent) {
			writer = ((BodyContent) writer).getEnclosingWriter();
		}

		try {
			writer.print(text);

		} catch (IOException e) {
			
			throw new JspException(e.toString());
		}

	}

}
