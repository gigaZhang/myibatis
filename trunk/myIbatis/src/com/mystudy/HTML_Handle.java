package com.mystudy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import uk.ltd.getahead.dwr.DWRServlet;

public class HTML_Handle {

	  /**  
	     * @param args  
	     */  
	    public static void main(String[] args) {   
	        // TODO Auto-generated method stub   
	        String content="<p>�ɾ�15��º컨�ɾ�53��500ML��¥���������ڸɺ죨���У�750ML����ϼ�699Ԫ��</p>";   
	        Pattern patt=Pattern.compile("<[^>]+>([^<]*)</[^>]+>");   
	        Matcher m=patt.matcher(content);   
	        while(m.find()){   
	            content=content.replaceFirst("<[^>]+>([^<]*)</[^>]+>", m.group(1).toString());   
	        }  
	        
	        System.out.println(content);   
	         //�ɾ�15��º컨�ɾ�53��500ML��¥���������ڸɺ죨���У�750ML����ϼ�699Ԫ��   
	    }   
}
