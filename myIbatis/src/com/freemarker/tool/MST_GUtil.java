// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 
// Source File Name:   MST_GUtil.java

package com.freemarker.tool;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletContext;

import jcx.util.convert;

// Referenced classes of package com.mst.util:
//            MST_MailUtil

public class MST_GUtil
{

    public MST_GUtil()
    {
    }

    private static boolean ifServerNameByIP(Object objServerName)
    {
        return objServerName != null && objServerName.toString().indexOf(".") != -1;
    }

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

    private static Socket genSocket(Object objName, Object objPort, ServletContext sc)
        throws Exception
    {
        if(ifServerNameByIP(objName))
        {
            String strByte[] = convert.separStr(objName.toString(), ".");
            if(strByte.length == 4)
            {
                byte b[] = new byte[4];
                b[0] = (new Integer(strByte[0])).byteValue();
                b[1] = (new Integer(strByte[1])).byteValue();
                b[2] = (new Integer(strByte[2])).byteValue();
                b[3] = (new Integer(strByte[3])).byteValue();
                try
                {
                    return new Socket(InetAddress.getByAddress(b), Integer.parseInt(objPort.toString()));
                }
                catch(Exception ex)
                {
                    try
                    {
                        Object objMailedFlag = sc.getAttribute("g_service_mailed");
                        if(objMailedFlag == null || objMailedFlag.toString().equals("0"))
                        {
                            if(MST_MailUtil.sendMail2Admin("Service\u7AEF\u53E3\u65AD\u5F00\uFF1A" + ex.toString()))
                                sc.setAttribute("g_service_mailed", "1");
                            try
                            {
                                MST_Log.debug("MST_GUtil->Invoke MSTRestart->before");
                                Runtime.getRuntime().exec("java MSTRestart");
                                MST_Log.debug("MST_GUtil->Invoke MSTRestart->after");
                            }
                            catch(Exception err)
                            {
                                MST_Log.debug("MST_GUtil->Invoke MSTRestart->Err:" + err.toString());
                                MST_Log.debug2File("MST_GUtil->Invoke MSTRestart->Err:" + err.toString());
                            }
                        }
                    }
                    catch(Exception errMail)
                    {
                        MST_Log.debug("MST_GUtil->Invoke Send Admin Mail->Err:" + errMail.toString());
                    }
                    throw new Exception("genSocket->Exception->" + ex.toString());
                }
            } else
            {
                return null;
            }
        }
        try
        {
            return new Socket(objName.toString(), Integer.parseInt(objPort.toString()));
        }
        catch(Exception ex)
        {
            try
            {
                Object objMailedFlag = sc.getAttribute("g_service_mailed");
                if(objMailedFlag == null || objMailedFlag.toString().equals("0"))
                {
                    if(MST_MailUtil.sendMail2Admin("Service\u7AEF\u53E3\u65AD\u5F00\uFF1A" + ex.toString()))
                        sc.setAttribute("g_service_mailed", "1");
                    try
                    {
                        MST_Log.debug("MST_GUtil->Invoke MSTRestart->before");
                        Runtime.getRuntime().exec("java MSTRestart");
                        MST_Log.debug("MST_GUtil->Invoke MSTRestart->after");
                    }
                    catch(Exception err)
                    {
                        MST_Log.debug("MST_GUtil->Invoke MSTRestart->Err:" + err.toString());
                        MST_Log.debug2File("MST_GUtil->Invoke MSTRestart->Err:" + err.toString());
                    }
                }
            }
            catch(Exception errMail)
            {
                MST_Log.debug("MST_GUtil->Invoke Send Admin Mail->Err:" + errMail.toString());
            }
            throw new Exception("genSocket->Exception->" + ex.toString());
        }
    }

    private static Socket genSocket(Object objName, Object objPort)
        throws Exception
    {
        if(ifServerNameByIP(objName))
        {
            String strByte[] = convert.separStr(objName.toString(), ".");
            if(strByte.length == 4)
            {
                byte b[] = new byte[4];
                b[0] = (new Integer(strByte[0])).byteValue();
                b[1] = (new Integer(strByte[1])).byteValue();
                b[2] = (new Integer(strByte[2])).byteValue();
                b[3] = (new Integer(strByte[3])).byteValue();
                try
                {
                    return new Socket(InetAddress.getByAddress(b), Integer.parseInt(objPort.toString()));
                }
                catch(Exception ex)
                {
                    throw new Exception("genSocket->Exception->" + ex.toString());
                }
            } else
            {
                return null;
            }
        }
        try
        {
            return new Socket(objName.toString(), Integer.parseInt(objPort.toString()));
        }
        catch(Exception ex)
        {
            throw new Exception("genSocket->Exception->" + ex.toString());
        }
    }

    private static boolean ifSocketAvail(Object objFlag, Object objName, Object objPort)
    {
        return objFlag != null && objName != null && objPort != null && objFlag.toString().trim().equalsIgnoreCase("1");
    }

    public static String send2SocketMsg(String strServer, int nPort, String strCmd)
        throws Exception
    {
        try
        {
            Socket server = genSocket(strServer, new String(nPort + ""));
            if(server != null)
            {
                PrintWriter out = new PrintWriter(server.getOutputStream());
                String params = strCmd;
                out.write(params);
                out.flush();
                server.close();
            } else
            {
                throw new Exception("MapAddrServlet->throw exception->can't get the MSTAddrService Socket!");
            }
        }
        catch(Exception ex)
        {
            return "False";
        }
        return "Success";
    }

    public static Socket getAvailSocket(ServletContext sc, int nKind)
        throws Exception
    {
        Object objFlag = null;
        Object objName = null;
        Object objPort = null;
        if(nKind == 10)
        {
            objFlag = sc.getAttribute("g_addrservice_serverflag_main");
            objName = sc.getAttribute("g_addrservice_servername_main");
            objPort = sc.getAttribute("g_addrservice_serverport_main");
            if(ifSocketAvail(objFlag, objName, objPort))
                return genSocket(objName, objPort, sc);
            nKind = 11;
        }
        if(nKind == 11)
        {
            objFlag = sc.getAttribute("g_addrservice_serverflag_remote_main");
            objName = sc.getAttribute("g_addrservice_servername_remote_main");
            objPort = sc.getAttribute("g_addrservice_serverport_remote_main");
            if(ifSocketAvail(objFlag, objName, objPort))
                return genSocket(objName, objPort, sc);
            MST_Log.debug("MST_GUtil->Can't get the MSTAddrService(remote_main) Socket!-->" + objFlag.toString() + "#" + objName.toString() + "#" + objPort.toString());
            MST_Log.debug2File("MST_GUtil->Can't get the MSTAddrService(remote_main) Socket!");
        }
        if(nKind == 20)
        {
            objFlag = sc.getAttribute("g_addrservice_serverflag_second");
            objName = sc.getAttribute("g_addrservice_servername_second");
            objPort = sc.getAttribute("g_addrservice_serverport_second");
            if(ifSocketAvail(objFlag, objName, objPort))
                return genSocket(objName, objPort, sc);
            nKind = 21;
        }
        if(nKind == 21)
        {
            objFlag = sc.getAttribute("g_addrservice_serverflag_remote_second");
            objName = sc.getAttribute("g_addrservice_servername_remote_second");
            objPort = sc.getAttribute("g_addrservice_serverport_remote_second");
            if(ifSocketAvail(objFlag, objName, objPort))
                return genSocket(objName, objPort, sc);
            MST_Log.debug("MST_GUtil->Can't get the MSTAddrService(second) Socket!");
            MST_Log.debug2File("MST_GUtil->Can't get the MSTAddrService(second) Socket!");
        }
        if(nKind == 30)
        {
            objFlag = sc.getAttribute("g_mapserver_serverflag_main");
            objName = sc.getAttribute("g_mapserver_servername_main");
            objPort = sc.getAttribute("g_mapserver_serverport_main");
            if(ifSocketAvail(objFlag, objName, objPort))
                return genSocket(objName, objPort, sc);
            nKind = 31;
        }
        if(nKind == 31)
        {
            objFlag = sc.getAttribute("g_mapserver_serverflag_remote");
            objName = sc.getAttribute("g_mapserver_servername_remote");
            objPort = sc.getAttribute("g_mapserver_serverport_remote");
            if(ifSocketAvail(objFlag, objName, objPort))
                return genSocket(objName, objPort, sc);
            MST_Log.debug("MST_GUtil->Can't get the MSTMapServer(main) Socket!");
            MST_Log.debug2File("MST_GUtil->Can't get the MSTMapServer(main) Socket!");
        }
        return null;
    }
}
