package com.mystudy;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class MRL_Util {

	 public static String getUrlData(String strUrl)
	    {
	        String strRet = "Error";
	        try
	        {
	            URL url = new URL(strUrl);
	            URLConnection con = url.openConnection();
	            BufferedInputStream in = new BufferedInputStream(con.getInputStream());
	            ByteArrayOutputStream baOut = new ByteArrayOutputStream();
	            byte bytes[] = new byte[4096];
	            for(int nRead = -1; (nRead = in.read(bytes, 0, 4096)) > 0;)
	                baOut.write(bytes, 0, nRead);

	            strRet = baOut.toString();
	            baOut.close();
	            in.close();
	        }
	        catch(Exception ex)
	        {
	            strRet += ":" + ex.toString();
	        }
	        return strRet;
	    }
}
