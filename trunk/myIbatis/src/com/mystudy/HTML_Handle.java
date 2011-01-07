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
	        String content="<p>ÀÉ¾Æ15Äê³Âºì»¨ÀÉ¾Æ53¡ã500ML£¬Â¥À¼ÉßÁúÖé¸ê±Ú¸Éºì£¨ÌúºĞ£©750ML£¬×éºÏ¼Û699Ôª¡£</p>";   
	        Pattern patt=Pattern.compile("<[^>]+>([^<]*)</[^>]+>");   
	        Matcher m=patt.matcher(content);   
	        while(m.find()){   
	            content=content.replaceFirst("<[^>]+>([^<]*)</[^>]+>", m.group(1).toString());   
	        }  
	        
	        System.out.println(content);   
	         //ÀÉ¾Æ15Äê³Âºì»¨ÀÉ¾Æ53¡ã500ML£¬Â¥À¼ÉßÁúÖé¸ê±Ú¸Éºì£¨ÌúºĞ£©750ML£¬×éºÏ¼Û699Ôª¡£   
	    }   
}
