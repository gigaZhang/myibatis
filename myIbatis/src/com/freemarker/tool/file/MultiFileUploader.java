// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 
// Source File Name:   MultiFileUploader.java

package com.freemarker.tool.file;

import com.oreilly.servlet.MultipartRequest;
import java.io.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;;

// Referenced classes of package com.mst.file:
//            FileRenamePy, ImageBuilderTool

public class MultiFileUploader
{

    public MultiFileUploader()
    {
        multi = null;
    }

    public File[] doUploadFile(HttpServletRequest request, String savePath, int limit)
    {
        return doUploadFile(request, savePath, limit, false, "");
    }

    public String getTheValue(String valueName)
    {
        return multi.getParameter(valueName);
    }

    public File[] doUploadFile(HttpServletRequest request, String savePath, int limit, boolean generateSmall, String smallPath)
    {
        return doUploadFile(request, savePath, limit, generateSmall, smallPath, 80, 60);
    }

    public File[] doUploadFile(HttpServletRequest request, String savePath, int limit, boolean generateSmall, String smallPath, int smallWidth, int smallHeight)
    {
        File saveDir = new File(savePath);
        if(!saveDir.exists())
            saveDir.mkdirs();
        try
        {
            multi = new MultipartRequest(request, savePath, limit, "GBK", new FileRenamePy());
        }
        catch(IOException e)
        {
            System.err.println((new Date()).toLocaleString() + " : \u4E0A\u4F20\u6587\u4EF6\u5931\u8D25:" + e.getMessage());
            e.printStackTrace();
            return null;
        }
        Enumeration filesname = multi.getFileNames();
        List uploadFiles = new ArrayList();
        File f;
        for(; filesname.hasMoreElements(); uploadFiles.add(f))
        {
            String name = (String)filesname.nextElement();
            f = multi.getFile(name);
        }

        File fileArray[] = new File[uploadFiles.size()];
        for(int i = 0; i < uploadFiles.size(); i++)
            fileArray[i] = (File)uploadFiles.get(i);

        if(generateSmall)
        {
            for(int i = 0; i < uploadFiles.size(); i++)
            {
                fileArray[i] = (File)uploadFiles.get(i);
                ImageBuilderTool.createMarkStr(fileArray[i].getAbsolutePath(), "\u4E0A\u4F20\u4E8E\u4E01\u4E01\u7F51 DDMAP.COM");
                ImageBuilderTool.buildSmallImage(fileArray[i], smallPath, smallWidth, smallHeight, true);
            }

        }
        return fileArray;
    }

    private MultipartRequest multi;
}
