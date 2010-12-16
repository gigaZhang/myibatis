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
	 * ����һ��xml�ĵ����ĵ������������Ծ���
	 * @param finename ��Ҫ�������ļ���
	 * @return ���ز��������0��ʾʧ�ܣ�1��ʾ�ɹ�
	 */
	public static int createXMLFile(String filename){
		
		int returnValue = 0;
		//����document����
		Document document = DocumentHelper.createDocument();
		
		//����XML�ĵ��ĸ� books
		Element booksElement = document.addElement("books");
		
		//����һ��ע��
		booksElement.addComment("time:2010-12-01");
		
		//�����һ��book�ڵ�
		Element bookElement = booksElement.addElement("book");
		
		//����show��������
		bookElement.addAttribute("show", "yes");
		
		//����title�ڵ�
		Element titleElement = bookElement.addElement("title");
		
		//Ϊtitle��������
		titleElement.setText("book1");
		
		Element bookElement2 = booksElement.addElement("book");
		bookElement2.addAttribute("show", "no");
		Element titleElement2 = bookElement2.addElement("title");
		titleElement2.setText("book2");
		
		Element bookElement3 = booksElement.addElement("owner");
		bookElement3.setText("lph");
		
		//��documentд���ļ���
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
			
			//��book�鼮�е�show���������yes��Ϊno
			List list = document.selectNodes("books/book/@show");
			Iterator iter = list.iterator();
			while(iter.hasNext()){
				Attribute attribute = (Attribute)iter.next();
				if(attribute.getValue().equals("yes")){
					attribute.setValue("no");
				}
			}
			
			//�޸����ݶ�����owner�����ݸ�Ϊsmiles������owner�ڵ��м���date�ڵ㣬
			//date�ڵ������Ϊ2010-12-02,��Ϊdate�ڵ����һ������type
			list = document.selectNodes("books/owner");
			iter = list.iterator();
			if(iter.hasNext()){
				Element ownerElement = (Element)iter.next();
				Element dateElement = ownerElement.addElement("date");
				dateElement.setText("2010-12-02");
				dateElement.addAttribute("type", "1");
			}
			//�޸������������title��book1����ɾ���ýڵ�
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
