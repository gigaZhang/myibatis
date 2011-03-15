// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 
// Source File Name:   MST_MailUtil.java

package com.freemarker.tool;

import java.io.PrintStream;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import jcx.util.datetime;

public class MST_MailUtil
{

    public static boolean sendMail2AdminEx(String strTitle, String strMsg)
    {
        Hashtable HT = new Hashtable();
        String mailServer = "172.16.1.4";
        String sender = "service@gsuo.com";
        String subject = "Admin Mail:" + strTitle;
        String content = strMsg;
        content += "<br>" + datetime.getTime("YYYY/mm/dd h:m:s");
        String receiver[] = new String[1];
        receiver[0] = "itdesk@gsuo.com";
        HT.put("EMAILSERVER", mailServer);
        HT.put("EMAILSENDER", sender);
        HT.put("strCont", subject);
        HT.put("CONT", content);
        HT.put("usr", receiver);
        HT.put("TYPE", "text/html");
        Object retObj = sendmailbcc(HT);
        if(retObj.toString().equalsIgnoreCase("0"))
        {
            return true;
        } else
        {
            System.out.println("MST_MailUtil->sendMail2Admin:" + retObj.toString());
            return false;
        }
    }

    public MST_MailUtil()
    {
    }

    public static Object sendDavMailbcc(Object HT1)
    {
        Hashtable HT = (Hashtable)HT1;
        String host = "172.16.1.4";
        String from = HT.get("EMAILSENDER").toString();
        String subject = HT.get("strCont").toString();
        String content = HT.get("CONT").toString();
        String bcc[] = (String[])HT.get("usr");
        try
        {
            Properties prop = new Properties();
            prop.setProperty("mail.davmail.from", "bishopshen@hotmail.com");
            prop.put("mail.smtp.host", "172.16.1.4");
            Session ses = Session.getInstance(prop);
            Transport transport = ses.getTransport("davmail_xmit");
            transport.connect(null, "bishopshen", "pope981560");
            MimeMessage msg = new MimeMessage(ses);
            msg.setFrom(new InternetAddress(from));
            InternetAddress address[] = new InternetAddress[bcc.length];
            for(int i = 0; i < bcc.length; i++)
                address[i] = new InternetAddress(bcc[i]);

            msg.setRecipients(javax.mail.Message.RecipientType.BCC, address);
            msg.setSubject(subject);
            Multipart mp = new MimeMultipart();
            MimeBodyPart mbp1 = new MimeBodyPart();
            mbp1.setContent(content, "text/html;charset=gb2312");
            mp.addBodyPart(mbp1);
            msg.setContent(mp);
            msg.setSentDate(new Date());
            transport.sendMessage(msg, msg.getAllRecipients());
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return "0";
    }

    public static Object sendmailbcc4(Object HT1)
    {
        Hashtable HT = (Hashtable)HT1;
        String host = HT.get("EMAILSERVER").toString();
        String from = HT.get("EMAILSENDER").toString();
        String subject = HT.get("strCont").toString();
        String content = HT.get("CONT").toString();
        String bcc[] = (String[])HT.get("usr");
        String filename[] = (String[])HT.get("attachs");
        String File_path = "";
        String content_type = HT.get("TYPE").toString();
        Properties props = System.getProperties();
        if(host.indexOf(",") != -1)
        {
            int pos = host.indexOf(",");
            props.put("mail.smtp.port", host.substring(pos + 1));
            host = host.substring(0, pos);
        }
        props.put("mail.smtp.host", host);
        String enc1 = props.getProperty("file.encoding", "");
        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(false);
        try
        {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress address[] = new InternetAddress[bcc.length];
            for(int i = 0; i < bcc.length; i++)
                address[i] = new InternetAddress(bcc[i]);

            msg.setRecipients(javax.mail.Message.RecipientType.BCC, address);
            msg.setSubject(subject);
            Multipart mp = new MimeMultipart();
            MimeBodyPart mbp1 = new MimeBodyPart();
            mbp1.setContent(content, content_type);
            mp.addBodyPart(mbp1);
            if(filename != null)
            {
                for(int i = 0; i < filename.length; i++)
                    if(filename[i] != null && !filename[i].trim().equals(""))
                    {
                        String file = File_path + filename[i];
                        MimeBodyPart mbp2 = new MimeBodyPart();
                        FileDataSource fds = new FileDataSource(file);
                        mbp2.setDataHandler(new DataHandler(fds));
                        String fn = filename[i];
                        int pos = fn.lastIndexOf("/");
                        if(pos != -1)
                            fn = fn.substring(pos + 1);
                        pos = fn.lastIndexOf("\\");
                        if(pos != -1)
                            fn = fn.substring(pos + 1);
                        mbp2.setFileName(fn);
                        mp.addBodyPart(mbp2);
                    }

            }
            msg.setContent(mp);
            msg.setSentDate(new Date());
            Transport.send(msg);
            props.put("file.encoding", enc1);
        }
        catch(SendFailedException e)
        {
            String dd = e.getMessage();
            props.put("file.encoding", enc1);
            if(dd.indexOf("550") != -1)
                return "Error->550:" + e.toString();
            else
                return "Error->1:" + e.toString();
        }
        catch(MessagingException mex)
        {
            Exception ex = null;
            props.put("file.encoding", enc1);
            if((ex = mex.getNextException()) != null)
            {
                System.out.println(ex);
                return "Error->2:" + ex.toString();
            }
        }
        props.put("file.encoding", enc1);
        return "0";
    }

    public static boolean sendMail2Admin(String strMsg)
    {
        Hashtable HT = new Hashtable();
        String mailServer = "172.16.1.4";
        String sender = "service@gsuo.com";
        String subject = "Admin Mail";
        String content = strMsg;
        content += "<br>" + datetime.getTime("YYYY/mm/dd h:m:s");
        String receiver[] = new String[1];
        receiver[0] = "itdesk@gsuo.com";
        HT.put("EMAILSERVER", mailServer);
        HT.put("EMAILSENDER", sender);
        HT.put("strCont", subject);
        HT.put("CONT", content);
        HT.put("usr", receiver);
        HT.put("TYPE", "text/html");
        Object retObj = sendmailbcc(HT);
        if(retObj.toString().equalsIgnoreCase("0"))
        {
            return true;
        } else
        {
            System.out.println("MST_MailUtil->sendMail2Admin:" + retObj.toString());
            return false;
        }
    }

    public static Object sendmailbcc(Object HT1)
    {
        Hashtable HT = (Hashtable)HT1;
        String from = HT.get("EMAILSENDER").toString();
        String subject = HT.get("strCont").toString();
        String content = HT.get("CONT").toString();
        String bcc[] = (String[])HT.get("usr");
        String filename[] = new String[0];
        String File_path = "";
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "172.16.1.4");
        String enc1 = props.getProperty("file.encoding", "");
        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(false);
        try
        {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress address[] = new InternetAddress[bcc.length];
            for(int i = 0; i < bcc.length; i++)
                address[i] = new InternetAddress(bcc[i]);

            msg.setRecipients(javax.mail.Message.RecipientType.BCC, address);
            msg.setSubject(subject);
            Multipart mp = new MimeMultipart();
            MimeBodyPart mbp1 = new MimeBodyPart();
            mbp1.setContent(content, "text/html;charset=gb2312");
            mp.addBodyPart(mbp1);
            if(filename != null)
            {
                for(int i = 0; i < filename.length; i++)
                    if(filename[i] != null && !filename[i].trim().equals(""))
                    {
                        String file = File_path + filename[i];
                        MimeBodyPart mbp2 = new MimeBodyPart();
                        FileDataSource fds = new FileDataSource(file);
                        mbp2.setDataHandler(new DataHandler(fds));
                        String fn = filename[i];
                        int pos = fn.lastIndexOf("/");
                        if(pos != -1)
                            fn = fn.substring(pos + 1);
                        pos = fn.lastIndexOf("\\");
                        if(pos != -1)
                            fn = fn.substring(pos + 1);
                        mbp2.setFileName(fn);
                        mp.addBodyPart(mbp2);
                    }

            }
            msg.setContent(mp);
            msg.setSentDate(new Date());
            Transport.send(msg);
            props.put("file.encoding", enc1);
        }
        catch(SendFailedException e)
        {
            String dd = e.getMessage();
            props.put("file.encoding", enc1);
            if(dd.indexOf("550") != -1)
                return "Error->550:" + e.toString();
            else
                return "Error->1:" + e.toString();
        }
        catch(MessagingException mex)
        {
            Exception ex = null;
            props.put("file.encoding", enc1);
            if((ex = mex.getNextException()) != null)
            {
                System.out.println(ex);
                return "Error->2:" + ex.toString();
            }
        }
        props.put("file.encoding", enc1);
        return "0";
    }
}
