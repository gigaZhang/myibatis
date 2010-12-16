package com.xml.writer;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class StudyFORXML {

	public static int getXMLFile(){
		int returnValue = 0;
		String filename = "book2010-12-3.xml";
		Document document = DocumentHelper.createDocument();
		Element booksElement = document.addElement("books");
		booksElement.addComment("2010-12-3 lph");
		
		Element bookElement1 = booksElement.addElement("book");
		bookElement1.addAttribute("show", "yes");
		Element titleElement1 = bookElement1.addElement("title");
		titleElement1.setText("java代码之重构");
		Element priceElement1 = bookElement1.addElement("price");
		priceElement1.setText("65.80");
		
		Element bookElement2 = booksElement.addElement("book");
		bookElement2.addAttribute("show", "no");
		Element titleElement2 = bookElement2.addElement("title");
		titleElement2.setText("Java企业级应用");
		Element priceElement2 = bookElement2.addElement("price");
		priceElement2.setText("98.0");
		
		returnValue = StudyFORXML.createXMLFile(document,filename);
		return returnValue;
	}
	
	/**
	 * 创建xml
	 * @param document 传入的Document对象
	 * @param filename 创建xml的路径以及文件名
	 * @return 是否创建成功
	 */
	public static int createXMLFile(Document document,String filename){
		int returnValue = 0;
		try{
			XMLWriter writer = null;
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");
			writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(filename),format.getEncoding()),format);
			writer.write(document);
			writer.close();
			returnValue = 1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnValue;
	}
	
//	public static void main(String [] args){
//		System.out.println(StudyFORXML.getXMLFile());
//	}
}
