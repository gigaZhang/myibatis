package com.freemarker.tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import javax.xml.transform.sax.TemplatesHandler;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class Freemarker {

	
	public static boolean create(Template tpl, Map ftldataMap, String htmlfile)
	{
	File htmlFile = new File(htmlfile);
	Writer out;
	try
	{
	out = new BufferedWriter(new OutputStreamWriter(
	new FileOutputStream(htmlFile)));
	tpl.process(ftldataMap, out);
	out.flush();
	return true;
	} catch (Exception e)
	{
	e.printStackTrace();
	return false;
	}
	}

	public static boolean create(String ftlpath, String ftlname, Map ftldataMap,
			String htmlfile)
			{
			Configuration con = new Configuration();
			Template t = null;
			try
			{
			con.setDirectoryForTemplateLoading(new File(ftlpath));
			t = con.getTemplate(ftlname);
			} catch (IOException e1)
			{
			e1.printStackTrace();
			return false;
			}

			return create(t, ftldataMap, htmlfile);
			}
	
}
