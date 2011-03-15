// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 
// Source File Name:   MST_Log.java

package com.freemarker.tool;

import java.io.PrintStream;
import java.util.Date;
import javax.servlet.ServletContext;

public class MST_Log
{

    public static void debug2File(Object obj)
    {
        if(m_sc != null)
            m_sc.log(" -debug- " + obj);
    }

    public MST_Log()
    {
    }

    public static void debug(String s)
    {
        System.out.println((new Date()).toString() + " -debug- " + s);
    }

    public static void debug(Object obj)
    {
        System.out.println((new Date()).toString() + " -debug- " + obj);
    }

    public static void debug2File(String s)
    {
        if(m_sc != null)
            m_sc.log(" -debug- " + s);
    }

    public static ServletContext m_sc = null;
    public static final boolean DEBUG = true;

}
