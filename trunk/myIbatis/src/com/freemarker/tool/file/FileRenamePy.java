// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 
// Source File Name:   FileRenamePy.java

package com.freemarker.tool.file;

import com.oreilly.servlet.multipart.FileRenamePolicy;
import java.io.File;
import java.util.Random;

public class FileRenamePy
    implements FileRenamePolicy
{

    public FileRenamePy()
    {
        startBase = 0;
    }

    public File rename(File arg0)
    {
        Random random = new Random();
        String strRndNum = String.valueOf(random.nextInt(100));
        String path = arg0.getAbsolutePath().substring(0, arg0.getAbsolutePath().lastIndexOf("\\"));
        String fileExt = arg0.getName().substring(arg0.getName().lastIndexOf(".") + 1);
        String newFileName = System.currentTimeMillis() + "_" + strRndNum + "." + fileExt;
        File f = new File(path + "\\" + newFileName);
        return f;
    }

    public static void main(String args[])
    {
    }

    int startBase;
}
