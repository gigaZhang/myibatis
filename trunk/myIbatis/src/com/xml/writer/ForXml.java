package com.xml.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class ForXml {

	/**
	 * 建立一个xml文档，文档名由输入属性决定
	 * @param finename 需要建立的文件名
	 * @return 返回操作结果，0表示失败，1表示成功
	 */
	public static int createXMLFile(String filename){
		
		int returnValue = 0;
		//建立document对象
		Document document = DocumentHelper.createDocument();
		
		//建立XML文档的根 books
		Element booksElement = document.addElement("books");
		
		//加入一行注释
		booksElement.addComment("time:2010-12-01");
		
		//加入第一个book节点
		Element bookElement = booksElement.addElement("book");
		
		//加入show属性内容
		bookElement.addAttribute("show", "yes");
		
		//加入title节点
		Element titleElement = bookElement.addElement("title");
		
		//为title设置内容
		titleElement.setText("book1");
		
		Element bookElement2 = booksElement.addElement("book");
		bookElement2.addAttribute("show", "no");
		Element titleElement2 = bookElement2.addElement("title");
		titleElement2.setText("book2");
		
		Element bookElement3 = booksElement.addElement("owner");
		bookElement3.setText("lph");
		
		//将document写入文件中
		try{
			XMLWriter writer = new XMLWriter(new FileWriter	(new File(filename)));
			writer.write(document);
			writer.close();
			returnValue = 1;
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		return returnValue;
		
	}
	
	
	
	public static void modiXMLFile(String filename, String newfilename){
		int returnValue = 0;
		try{
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(new File(filename));
			
			//把book书籍中的show属性如果是yes改为no
			List list = document.selectNodes("books/book/@show");
			Iterator iter = list.iterator();
			while(iter.hasNext()){
				Attribute attribute = (Attribute)iter.next();
				if(attribute.getValue().equals("yes")){
					attribute.setValue("no");
				}
			}
			
			//修改内容二：把owner向内容改为smiles，并在owner节点中加入date节点，
			//date节点的内容为2010-12-02,还为date节点添加一个属性type
			list = document.selectNodes("books/owner");
			iter = list.iterator();
			if(iter.hasNext()){
				Element ownerElement = (Element)iter.next();
				Element dateElement = ownerElement.addElement("date");
				dateElement.setText("2010-12-02");
				dateElement.addAttribute("type", "1");
			}
			//修改内容三：如果title是book1，则删除该节点
			list = document.selectNodes("books/book");
			iter = list.iterator();
			while(iter.hasNext()){
				Element bookElement = (Element)iter.next();
				Iterator iterator = bookElement.elementIterator("title");
					while(iterator.hasNext()){
						Element titleElement = (Element)iterator.next();
						if(titleElement.getText().equals("book1")){
							bookElement.remove(titleElement);
						}
					}
				}
			try{
				XMLWriter writer = null;
				OutputFormat format = OutputFormat.createPrettyPrint();
				format.setEncoding("utf-8");
				writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(newfilename),format.getEncoding()),format);
				writer.write(document);
				writer.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void main(String [] args){
		ForXml.createXMLFile("test.xml");
		ForXml.modiXMLFile("test.xml", "newTest.xml");
	}
	
}
