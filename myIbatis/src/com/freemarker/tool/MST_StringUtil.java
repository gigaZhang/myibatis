
package com.freemarker.tool;

import java.io.*;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MST_StringUtil
{

	/**
	 * HTML 过滤正则
	 */
	static String htmlFilterReg = "<([^>]+>)"; 
	static Pattern htmlFilterPattern = Pattern.compile(htmlFilterReg);

	/**
	 * 非法符号正则
	 */
	static String illegalrReg = "([\\n|\\r])"; 
	static Pattern illegalPattern = Pattern.compile(illegalrReg);	
	
	
	
	/**
	 * 
	 * 方法说明: 过滤非法符号 
	 * TODO
	 * Administrator
	 * @param srcContent
	 * @return
	 * String
	 * 2008-7-18
	 */
	public static String filterIllegalTag(String srcContent){
		return filterIllegalTag(srcContent,0);
		
	}
	
	/*
	 * 加入字符限制
	 */
    public static String filterIllegalTag(String srcContent, int len) {
    	String afterReplace = filterByPattern(srcContent,illegalPattern);
    	if(len == 0){
    		return afterReplace;
    	}else{
    		return showContent(afterReplace,len);
    	}
	}

    
    
    /*
     * 过滤HTML标签的内容 , 如  "你好<a href=''>alan</a>" ,过滤后变成 "你好alan"
     */
	public static final String filterHtml(String srcContent){
    	return filterHtml(srcContent,0);
    }
    
	/**
	 * 
	 * 方法说明: 加入字符数限制
	 * TODO
	 * Administrator
	 * @param srcContent
	 * @param len
	 * @return
	 * String
	 * 2008-7-18
	 */
    public static final String filterHtml(String srcContent,int len){
    	
    	String afterReplace = filterByPattern(srcContent,htmlFilterPattern);
    	if(len == 0){
    		return afterReplace;
    	}else{
    		return showContent(afterReplace,len);
    	}
    }
    
    public static final String showContent(String src,int length){
    	if(MST_StringUtil.isStringNull(src)){
    		return "";
    	}else{
    		int maxLen = src.length()>length?length:src.length();
    		return src.substring(0,maxLen);
    		
    		
    	}
    }
    
    public static String filterByPattern(String srcContent , Pattern pattern){
    	Matcher matcher = pattern.matcher(srcContent);
    	return matcher.replaceAll("");
    }
	

    public static final String gb2iso(String s)
    {
        try
        {
            if(s != null)
                if(ifSqlInj(s))
                {
                    return "";
                } else
                {
                    byte abyte0[] = s.getBytes("gb2312");
                    return new String(abyte0, "iso-8859-1");
                }
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) { }
        return s;
    }


    public static final String iso2gb(String s)
    {
        try
        {
            if(s != null)
            {
                if(ifSqlInj(s))
                {
                    return "";
                } else
                {
                    byte abyte0[] = s.getBytes("iso-8859-1");
                    return new String(abyte0, "GBK");
                }
            } else
            {
                return "";
            }
        }
        catch(UnsupportedEncodingException unsupportedencodingexception)
        {
            return s;
        }
    }

    public static String FindStrInStringEx(String strOgi, String strArrStrs[])
    {
        for(int i = 0; i < strArrStrs.length; i++)
            if(strOgi.indexOf(strArrStrs[i]) != -1)
                return strArrStrs[i];

        return null;
    }

    public static int FindIdxPosInArr(String strOgi, String strArrStrs[])
    {
        int nRet = -1;
        for(int i = 0; i < strArrStrs.length; i++)
            if(strOgi.indexOf(strArrStrs[i]) != -1)
                return i;

        return nRet;
    }

    public static String UnUnicode(String inStr)
    {
        if(inStr == null || inStr.length() == 0)
            return "";
        String strOld = toUnicode(inStr);
        String s = "";
        for(StringTokenizer st = new StringTokenizer(strOld, "\\u"); st.hasMoreTokens();)
        {
            String t = st.nextToken();
            try
            {
                s += (char)Integer.valueOf(t, 16).intValue();
            }
            catch(NumberFormatException _ex) { }
        }

        return s;
    }

    public static String parsePartner_logo2(String strPNId)
    {
        if(strPNId.equalsIgnoreCase("smmail"))
            return "<img src='images/smmail_1.gif' alt='\u5E02\u6C11\u4FE1\u7BB1' border='0'>";
        if(strPNId.equalsIgnoreCase("coupon"))
            return "<img src='images/coupon_1.gif' alt='\u98DF\u5E93\u95E8' border='0'>";
        if(strPNId.equalsIgnoreCase("why"))
            return "<img src='images/whyy_1.gif' alt='\u4E0A\u6D77\u9752\u5E74\u7535\u5B50\u793E\u533A -- \u4E01\u4E01\u5730\u56FE' border='0'>";
        if(strPNId.equalsIgnoreCase("jfdaily"))
            return "<img src='images/jfdaily_1.gif' alt='\u89E3\u653E\u7F51' border='0'>";
        else
            return "<img src='images/mstlogo_1.gif' alt='\u4E01\u4E01\u5730\u56FE' border='0'>";
    }

    public static final String utf82gb(String s)
    {
        try
        {
            if(s != null)
                if(ifSqlInj(s))
                {
                    return "";
                } else
                {
                    byte abyte0[] = s.getBytes("UTF8");
                    return new String(abyte0, "gb2312");
                }
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) { }
        return s;
    }

    public static String trans2dbEx(String strValue)
    {
        if(strValue == null || strValue.trim().length() == 0)
            return "";
        String strRet = strValue.replaceAll("'", "\u2018").replaceAll("%", "").replaceAll("\"", "\u201C");
        if(ifSqlInj(strRet))
            return "";
        else
            return strRet;
    }

 

    public static String transReq2Db(String str)
    {
        if(str == null || str.length() == 0 || str.equalsIgnoreCase("null"))
            return "";
        else
            return trans2db(str);
    }

    public static String transReqcn2Db(String str)
    {
        return iso2gb(transReq2Db(str));
    }

    public static String trans2showEx2(String strValue)
    {
        if(strValue == null || strValue.trim().length() == 0)
            return "";
        String strRet = strValue.replaceAll(" ", "&nbsp;");
        strRet = strRet.replaceAll("<", "&lt;");
        strRet = strRet.replaceAll(">", "&gt;");
        if(strRet.indexOf("\n") != -1)
        {
            strRet = strRet.replaceAll("\n", "<br>");
            strRet = strRet.replaceAll("\r", "");
        }
        strRet = strRet.replaceAll("'", "\u2018");
        strRet = strRet.replaceAll("\"", "\u201C");
        return strRet;
    }

    public static String trans2sp(String strValue)
    {
        if(strValue == null || strValue.trim().length() == 0)
        {
            return "";
        } else
        {
            String strRet = strValue.replaceAll("'", "''");
            return strRet;
        }
    }

    public static String trans2wap(String strOld)
    {
        return strOld.replaceAll("&", "&amp;");
    }

    public static int FindStrInString(String strOgi, String strArrStrs[])
    {
        int nRet = -1;
        for(int i = 0; i < strArrStrs.length; i++)
            if((nRet = strOgi.indexOf(strArrStrs[i])) != -1)
                return nRet;

        return nRet;
    }

    public static String toUnicode(String inStr)
    {
        if(inStr == null || inStr.length() == 0)
            return "";
        char myBuffer[] = inStr.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < inStr.length(); i++)
        {
            short s = (short)myBuffer[i];
            String hexS = Integer.toHexString(s).toUpperCase();
            if(hexS.length() > 4)
                hexS = hexS.substring(4);
            sb.append("\\u");
            sb.append(hexS);
        }

        return sb.toString();
    }

    public static String trans2JS(String strValue)
    {
        if(strValue == null || strValue.trim().length() == 0)
            return "";
        String strRet = strValue;
        if(strRet.indexOf("'") != -1)
            strRet = strRet.replaceAll("'", "");
        if(strRet.indexOf("\"") != -1)
            strRet = strRet.replaceAll("\"", "");
        if(strRet.indexOf("\n") != -1)
        {
            strRet = strRet.replaceAll("\n", "");
            strRet = strRet.replaceAll("\r", "");
        }
        return strRet;
    }

    public static String gbEncoding(String gbString)
    {
        char utfBytes[] = gbString.toCharArray();
        String unicodeBytes = "";
        String strTmp = "";
        for(int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++)
        {
            strTmp = Integer.toHexString(utfBytes[byteIndex]);
            if(strTmp.length() <= 2)
                strTmp = "00" + strTmp;
            unicodeBytes = unicodeBytes + "\\u" + strTmp;
        }

        return unicodeBytes;
    }

    public static String decodeUnicode(String dataStr)
    {
        StringBuffer buffer = new StringBuffer();
        try
        {
            int start = 0;
            int end = 0;
            for(; start > -1; start = end)
            {
                end = dataStr.indexOf("\\u", start + 2);
                String charStr = "";
                if(end == -1)
                    charStr = dataStr.substring(start + 2, dataStr.length());
                else
                    charStr = dataStr.substring(start + 2, end);
                try
                {
                    char letter = (char)Integer.parseInt(charStr, 16);
                    buffer.append((new Character(letter)).toString());
                }
                catch(Exception exx)
                {
                    System.out.println("Here err:" + exx.toString());
                }
            }

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return buffer.toString();
    }

    public static String parsePartner_title(String strPNId)
    {
        if(strPNId.equalsIgnoreCase("smmail"))
            return "\u5E02\u6C11\u4FE1\u7BB1";
        if(strPNId.equalsIgnoreCase("coupon"))
            return "\u98DF\u5E93\u95E8";
        if(strPNId.equalsIgnoreCase("why"))
            return "\u4E0A\u6D77\u9752\u5E74\u7535\u5B50\u793E\u533A -- \u4E01\u4E01\u5730\u56FE";
        if(strPNId.equalsIgnoreCase("jfdaily"))
            return "\u89E3\u653E\u7F51 -- \u4E01\u4E01\u5730\u56FE";
        else
            return "\u4E01\u4E01\u5730\u56FE";
    }

    public static String transScript(String strValue)
    {
        if(strValue == null || strValue.trim().length() == 0)
            return "";
        if(strValue.toLowerCase().indexOf("script") != -1)
            return strValue.toLowerCase().replaceAll("script", "\uFF53\uFF43\uFF52\uFF49\uFF50\uFF54");
        else
            return strValue;
    }

    public static String utf8url_unescape(String s)
    {
        if(s == null || s.length() == 0)
            return "";
        StringBuffer sbuf = new StringBuffer();
        int l = s.length();
        int ch = -1;
        int sumb = 0;
        int i = 0;
        int more = -1;
        for(; i < l; i++)
        {
            int b;
            switch(ch = s.charAt(i))
            {
            case 37: // '%'
                ch = s.charAt(++i);
                int hb = (Character.isDigit((char)ch) ? ch - 48 : (10 + Character.toLowerCase((char)ch)) - 97) & 0xf;
                ch = s.charAt(++i);
                int lb = (Character.isDigit((char)ch) ? ch - 48 : (10 + Character.toLowerCase((char)ch)) - 97) & 0xf;
                b = hb << 4 | lb;
                break;

            case 43: // '+'
                b = 32;
                break;

            default:
                b = ch;
                break;
            }
            if((b & 0xc0) == 128)
            {
                sumb = sumb << 6 | b & 0x3f;
                if(--more == 0)
                    sbuf.append((char)sumb);
            } else
            if((b & 0x80) == 0)
                sbuf.append((char)b);
            else
            if((b & 0xe0) == 192)
            {
                sumb = b & 0x1f;
                more = 1;
            } else
            if((b & 0xf0) == 224)
            {
                sumb = b & 0xf;
                more = 2;
            } else
            if((b & 0xf8) == 240)
            {
                sumb = b & 7;
                more = 3;
            } else
            if((b & 0xfc) == 248)
            {
                sumb = b & 3;
                more = 4;
            } else
            {
                sumb = b & 1;
                more = 5;
            }
        }

        return sbuf.toString();
    }

    public static final String transNullObj(Object obj)
    {
        if(obj != null)
            return transNullString(obj.toString());
        else
            return "";
    }

    public static boolean isRoadNum(String strFind)
    {
        int nRoadPos = FindStrInString(strFind, G_ARR_ROAD_FLAG);
        int nLen = strFind.length();
        if(nRoadPos == nLen - 1)
            return false;
        int nNumEnd = FindStrInString(strFind.substring(nRoadPos + 1), G_ARR_ROADNUM_FLAG);
        if(nNumEnd != -1)
            return true;
        try
        {
            Integer.parseInt(strFind.substring(nRoadPos + 1));
        }
        catch(Exception ex)
        {
            return false;
        }
        return true;
    }

    public static int FindFirstStrInString(String strOgi, String strArrStrs[])
    {
        int nRet = -1;
        int nTmpRet = -1;
        for(int i = 0; i < strArrStrs.length; i++)
            if((nTmpRet = strOgi.indexOf(strArrStrs[i])) != -1 && (nRet == -1 || nTmpRet < nRet))
                nRet = nTmpRet;

        return nRet;
    }

    public static boolean FindStrEqualsInString(String strOgi, String strArrStrs[])
    {
        boolean bRet = false;
        for(int i = 0; i < strArrStrs.length; i++)
            if(strOgi.equalsIgnoreCase(strArrStrs[i]))
                return true;

        return bRet;
    }

    public MST_StringUtil()
    {
    }

    public static String trans2db(String strValue)
    {
        if(strValue == null || strValue.trim().length() == 0)
            return "";
        String strRet = strValue.replaceAll("\"", "'").replaceAll("%", "");        
        strRet = strValue.replaceAll("'", "''").replaceAll("%", "");
        if(ifSqlInj(strRet))
            return "";
        else
            return strRet;
    }

    public static String cityName(int nCity)
    {
        switch(nCity)
        {
        case 21: // '\025'
            return "\u4E0A\u6D77";

        case 571: 
            return "\u676D\u5DDE";

        case 20: // '\024'
            return "\u5E7F\u5DDE";

        case 25: // '\031'
            return "\u5357\u4EAC";

        case 755: 
            return "\u6DF1\u5733";

        case 27: // '\033'
            return "\u6B66\u6C49";

        case 551: 
            return "\u5408\u80A5";

        case 510: 
            return "\u65E0\u9521";

        case 519: 
            return "\u5E38\u5DDE";

        case 577: 
            return "\u6E29\u5DDE";

        case 592: 
            return "\u53A6\u95E8";

        case 574: 
            return "\u5B81\u6CE2";

        case 512: 
            return "\u82CF\u5DDE";

        case 23: // '\027'
            return "\u91CD\u5E86";

        case 575: 
            return "\u7ECD\u5174";

        case 898: 
            return "\u6D77\u53E3";

        case 899: 
            return "\u4E09\u4E9A";

        case 531: 
            return "\u6D4E\u5357";

        case 532: 
            return "\u9752\u5C9B";

        case 511: 
            return "\u9547\u6C5F";

        case 516: 
            return "\u5F90\u5DDE";

        case 514: 
            return "\u626C\u5DDE";

        case 771: 
            return "\u5357\u5B81";

        case 773: 
            return "\u6842\u6797";

        case 411: 
            return "\u5927\u8FDE";

        case 28: // '\034'
            return "\u6210\u90FD";

        case 591: 
            return "\u798F\u5DDE";

        case 871: 
            return "\u6606\u660E";

        case 29: // '\035'
            return "\u897F\u5B89";

        case 791: 
            return "\u5357\u660C";

        case 851: 
            return "\u8D35\u9633";

        case 731: 
            return "\u957F\u6C99";

        case 10: // '\n'
            return "\u5317\u4EAC";
        }
        return "";
    }

    public static String trans2showEx(String strValue)
    {
        if(strValue == null || strValue.trim().length() == 0)
            return "";
        int nStart = -1;
        int nEnd = 0;
        String strRet;
        for(strRet = strValue.replaceAll(" ", "&nbsp;"); (nStart = strRet.indexOf("<")) != -1; strRet = strRet.substring(0, nStart) + " " + strRet.substring(nEnd + 1))
        {
            nEnd = strRet.indexOf(">", nStart);
            if(nEnd == -1)
            {
                strRet = strRet.substring(0, nStart);
                break;
            }
            if(nEnd == strRet.length())
                nEnd--;
        }

        return strRet;
    }

    public static final String iso2utf8(String s)
    {
        try
        {
            if(s != null)
                if(ifSqlInj(s))
                {
                    return "";
                } else
                {
                    byte abyte0[] = s.getBytes("iso-8859-1");
                    return new String(abyte0, "UTF8");
                }
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) { }
        return s;
    }

    public static final String transNullString(String str)
    {
        if(str == null || str.length() == 0 || str.equalsIgnoreCase("null"))
            return "";
        if(ifSqlInj(str)){
            System.out.println(str+": is inj");
           return "";
        
        }
        else
            return str;
    }

    public static final String transNullString(String str, String repStr)
    {
        if(str == null || str.length() == 0 || str.equalsIgnoreCase("null"))
            return repStr;
        else
            return str;
    }

    public static String parsePartner_logo1(String strPNId)
    {
        if(strPNId.equalsIgnoreCase("smmail"))
            return "<img src='images/smmail.gif' alt='\u5E02\u6C11\u4FE1\u7BB1' border='0'>";
        if(strPNId.equalsIgnoreCase("coupon"))
            return "<img src='images/coupon.gif' alt='\u98DF\u5E93\u95E8' border='0'>";
        if(strPNId.equalsIgnoreCase("why"))
            return "<img src='images/whyy.gif' alt='\u4E0A\u6D77\u9752\u5E74\u7535\u5B50\u793E\u533A -- \u4E01\u4E01\u5730\u56FE' border='0'>";
        else
            return "<img src='images/mstlogo.gif' alt='\u4E01\u4E01\u5730\u56FE' border='0'>";
    }

    public static final boolean isStringNull(String str)
    {
        return str == null || str.length() == 0 || str.equalsIgnoreCase("null");
    }

    public static String trans2show(String strValue)
    {
        if(strValue == null || strValue.trim().length() == 0)
            return "";
        String strRet = strValue.replaceAll(" ", "&nbsp;");
        strRet = strRet.replaceAll("<", "&lt;");
        strRet = strRet.replaceAll(">", "&gt;");
        if(strRet.indexOf("\n") != -1)
        {
            strRet = strRet.replaceAll("\n", "<br>");
            strRet = strRet.replaceAll("\r", "");
        }
        return strRet;
    }

    public static String readUTF(byte btStr[])
    {
        if(btStr == null || btStr.length == 0)
            return "";
        int utflen = btStr.length;
        StringBuffer str = new StringBuffer(utflen);
        byte bytearr[] = btStr;
        for(int count = 0; count < utflen;)
        {
            int c = bytearr[count] & 0xff;
            switch(c >> 4)
            {
            case 0: // '\0'
            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
            {
                count++;
                str.append((char)c);
                break;
            }

            case 12: // '\f'
            case 13: // '\r'
            {
                if((count += 2) > utflen)
                {
                    System.out.println("MST_StringUtil->readUTF->Err(1).");
                    return "";
                }
                int char2 = bytearr[count - 1];
                if((char2 & 0xc0) != 128)
                {
                    System.out.println("MST_StringUtil->readUTF->Err(2).");
                    return "";
                }
                str.append((char)((c & 0x1f) << 6 | char2 & 0x3f));
                break;
            }

            case 14: // '\016'
            {
                if((count += 3) > utflen)
                {
                    System.out.println("MST_StringUtil->readUTF->Err(3).");
                    return "";
                }
                int char2 = bytearr[count - 2];
                int char3 = bytearr[count - 1];
                if((char2 & 0xc0) != 128 || (char3 & 0xc0) != 128)
                {
                    System.out.println("MST_StringUtil->readUTF->Err(4).");
                    return "";
                }
                str.append((char)((c & 0xf) << 12 | (char2 & 0x3f) << 6 | char3 & 0x3f));
                break;
            }

            case 8: // '\b'
            case 9: // '\t'
            case 10: // '\n'
            case 11: // '\013'
            default:
            {
                System.out.println("MST_StringUtil->readUTF->Err(5).");
                return "";
            }
            }
        }

        return str.toString();
    }

    public static void writeUTF(String str, ByteArrayOutputStream out)
    {
        if(str == null || str.length() == 0)
        {
            System.out.println("writeUTF return empty(1)");
            return;
        }
        int strlen = str.length();
        int utflen = 0;
        char charr[] = new char[strlen];
        int count = 0;
        str.getChars(0, strlen, charr, 0);
        for(int i = 0; i < strlen; i++)
        {
            int c = charr[i];
            if(c >= 1 && c <= 127)
                utflen++;
            else
            if(c > 2047)
                utflen += 3;
            else
                utflen += 2;
        }

        if(utflen > 65535)
        {
            System.out.println("writeUTF return empty(1)");
            return;
        }
        byte bytearr[] = new byte[utflen];
        for(int i = 0; i < strlen; i++)
        {
            int c = charr[i];
            if(c >= 1 && c <= 127)
                bytearr[count++] = (byte)c;
            else
            if(c > 2047)
            {
                bytearr[count++] = (byte)(0xe0 | c >> 12 & 0xf);
                bytearr[count++] = (byte)(0x80 | c >> 6 & 0x3f);
                bytearr[count++] = (byte)(0x80 | c & 0x3f);
            } else
            {
                bytearr[count++] = (byte)(0xc0 | c >> 6 & 0x1f);
                bytearr[count++] = (byte)(0x80 | c & 0x3f);
            }
        }

        out.write(bytearr, 0, bytearr.length);
    }

    public static String parseQueryKey(String strKey)
    {
        String strRet = strKey;
        if(!isStringNull(strRet))
        {
            if(strKey.indexOf(" ") != -1 || strKey.indexOf("\u3000") != -1 || strKey.indexOf(",") != -1 || strKey.indexOf("\uFF0C") != -1)
                return strRet;
            String strArrAD1[] = {
                "\u4E0A\u6D77", "\u6D66\u4E1C", "\u5F90\u6C47", "\u9759\u5B89", "\u9EC4\u57D4", "\u95F5\u884C", "\u957F\u5B81", "\u5362\u6E7E", "\u6D66\u4E1C", "\u6D66\u4E1C\u65B0", 
                "\u9752\u6D66", "\u677E\u6C5F", "\u91D1\u5C71", "\u5949\u8D24", "\u666E\u9640", "\u95F8\u5317", "\u5B9D\u5C71", "\u5DDD\u6C99", "\u676D\u5DDE", "\u5E7F\u5DDE", 
                "\u82CF\u5DDE", ""
            };
            String strArrAD2[] = {
                "\u5E02", "\u533A", "\u53BF"
            };
            int nFindADPos = FindIdxPosInArr(strRet, strArrAD1);
            if(nFindADPos != -1)
                strRet = strRet.replaceAll(strArrAD1[nFindADPos], "");
            nFindADPos = FindIdxPosInArr(strRet, strArrAD2);
            if(nFindADPos != -1)
                strRet = strRet.replaceAll(strArrAD2[nFindADPos], "");
            int nLen = strRet.length();
            if(nLen <= 4)
            {
                if(nLen > 2)
                    strRet = strRet.substring(0, 2) + " " + strRet.substring(2);
            } else
            {
                strRet = strRet.substring(0, 3) + " " + (nLen - 6 <= 0 ? "" : strRet.substring(3, nLen - 3) + " ") + strRet.substring(nLen - 3);
            }
        }
        return strRet;
    }

    public static String parseQueryKey(String strMapid, String strKey, String strArrSpecQuery[])
    {
        String strRet = strKey;
        if(!isStringNull(strRet))
        {
            if(FindIdxPosInArr(strRet, strArrSpecQuery) != -1)
                return "#" + strRet;
            if(FindIdxPosInArr(strRet, G_ARR_SPLITCHAR) != -1)
                return strRet;
            int nPosTmp = strRet.indexOf("\u8DEF");
            int nLenTmp = strRet.length();
            int nLenOgi = nLenTmp;
            nPosTmp = FindIdxPosInArr(strRet, G_ARR_SPLIT_SHENSHI);
            if(nPosTmp != -1)
                strRet = strRet.replaceAll(G_ARR_SPLIT_SHENSHI[nPosTmp], "");
            nPosTmp = FindIdxPosInArr(strRet, G_ARR_SPLIT_CITY);
            if(nPosTmp != -1)
                strRet = strRet.replaceAll(G_ARR_SPLIT_CITY[nPosTmp], "");
            nLenTmp = strRet.length();
            if(strMapid != null && strMapid.equals("21"))
            {
                String strArrAD1[] = {
                    "\u6D66\u4E1C", "\u5F90\u6C47", "\u9759\u5B89", "\u9EC4\u57D4", "\u95F5\u884C", "\u957F\u5B81", "\u5362\u6E7E", "\u6D66\u4E1C", "\u6D66\u4E1C\u65B0", "\u9752\u6D66", 
                    "\u677E\u6C5F", "\u91D1\u5C71", "\u5949\u8D24", "\u666E\u9640", "\u95F8\u5317", "\u5B9D\u5C71", "\u5DDD\u6C99"
                };
                int nPosInArrTmp = FindIdxPosInArr(strRet, strArrAD1);
                if(nPosInArrTmp != -1)
                {
                    nPosTmp = strRet.indexOf(strArrAD1[nPosInArrTmp]);
                    if(nPosTmp != -1 && nPosTmp != nLenTmp - 1)
                    {
                        strRet = strRet.substring(0, nPosTmp) + " " + strArrAD1[nPosInArrTmp] + " " + strRet.substring(nPosTmp + strArrAD1[nPosInArrTmp].length());
                        return strRet;
                    }
                }
            }
            if(nLenTmp == 0)
                return "#0\u957F\u5EA6";
            if(nLenTmp <= 6)
            {
                nPosTmp = nLenTmp / 2;
                strRet = strRet.substring(0, nPosTmp) + " " + strRet.substring(nPosTmp);
            } else
            {
                strRet = strRet.substring(0, 2) + " " + strRet.substring(nLenTmp - 3);
            }
        }
        return strRet;
    }

    public static boolean ifSqlInj(String str)
    {
        if(str == null || str.length() == 0)
            return false;
        str = str.toLowerCase();
        for(int i = 0; i < INJSTRA.length; i++){
            if(str.indexOf(INJSTRA[i]) >= 0){
              return true;
            }
        }

        return false;
    }

    public static final String G_ARR_SPLITCHAR[] = {
        " ", "\u3000", ",", "\uFF0C"
    };
    public static final String G_ARR_SPLIT_SHENSHI[] = {
        "\u533A", "\u53BF"
    };
    public static final String G_ARR_SPLIT_CITY[] = {
        "\u4E0A\u6D77", "\u676D\u5DDE", "\u5E7F\u5DDE", "\u6DF1\u5733", "\u5357\u4EAC", "\u82CF\u5DDE", "\u53A6\u95E8", "\u5B81\u6CE2"
    };
    public static final String G_ARR_ROAD_FLAG[] = {
        "\u8DEF", "\u9053", "\u8857"
    };
    public static final String G_ARR_ROADNUM_FLAG[] = {
        "\u53F7", "\u5F04"
    };
    private static String INJSTR;
    private static String INJSTRA[];

    static 
    {
        INJSTR = "exec|insert|select|delete|update|count|master|declare|drop|create";
        INJSTRA = INJSTR.split("\\|");
    }
    
    
    public static void main(String[] args) {
//		String content = "圣诞帽 　现在艾泽拉斯和外域的boss已经提前开始狂欢了！官方的放假时间是12月25日，但是他们现在已经向广大玩家发放[红色冬帽]和[绿色冬帽]了！以下是这些不好好工作，提前开始PARTY的boss名单，大家可以去替BLZ行道，好好教训这些懒虫，并收缴他们的红帽子或者绿帽子：　　注意：70级的玩家无法在旧大陆的副本里拿到帽子！所以不要为了帽子去单刷啦。　　指挥官沃恩（黑石塔）——红色冬帽　　达格兰·索瑞森大帝（黑石深渊）——红色冬帽　　炮手威利（斯坦索姆）——红色冬帽　　古拉鲁克（黑石塔）——绿色冬帽　　托塞德林王子（厄运之锤）——绿色冬帽　　黑暗院长加丁（通灵学院）——绿色冬帽　　* War Master Voone (Blackrock Spire) - Red Winter Hat　　* Emperor Dagran Thaurissan (B";
//		System.out.println("after filter:"+MST_StringUtil.transReqcn2Db(content));
//		
		System.out.println("过滤回车等字符-----------------");
    	String illegalTest = "第一段\n\r第二段";
    	System.out.println("---正常输出:");
    	System.out.println(illegalTest);
    	System.out.println("---过滤非法字符");
    	System.out.println(MST_StringUtil.filterIllegalTag(illegalTest));
    	System.out.println("---过滤非法字符,并限制字数");
    	System.out.println(MST_StringUtil.filterIllegalTag(illegalTest,5));   
    	
		System.out.println("过滤HTML标签-----------------");    	
    	String htmlTest = "我是<a href=''> <script>alan</script> </a>";
    	System.out.println("---正常输出:");
    	System.out.println(htmlTest);
    	System.out.println("---过滤HTML标签");
    	System.out.println(MST_StringUtil.filterHtml(htmlTest));
    	System.out.println("---过滤HTML标签,并限制字数");
    	System.out.println(MST_StringUtil.filterHtml(htmlTest,5));     
    	
    	
    	

    	
	}
}