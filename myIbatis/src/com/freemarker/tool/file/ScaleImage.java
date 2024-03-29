// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 
// Source File Name:   ScaleImage.java

package com.freemarker.tool.file;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.PrintStream;
import javax.imageio.ImageIO;

public class ScaleImage
{

    public ScaleImage()
    {
        support = 3D;
        PI = 3.1415926535897798D;
    }

    public static void main(String args[])
    {
        ScaleImage is = new ScaleImage();
        try
        {
            is.saveImageAsJpg("d:/testjpg.jpg", "d:/mmbre.jpg", 80, 60);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void saveImageAsJpg(String fromFileStr, String saveToFileStr, int formatWideth, int formatHeight)
        throws Exception
    {
        File saveFile = new File(saveToFileStr);
        File fromFile = new File(fromFileStr);
        BufferedImage srcImage = ImageIO.read(fromFile);
        int imageWideth = srcImage.getWidth(null);
        int imageHeight = srcImage.getHeight(null);
        int changeToWideth = 0;
        int changeToHeight = 0;
        if(imageWideth > 0 && imageHeight > 0)
            if(imageWideth / imageHeight >= formatWideth / formatHeight)
            {
                if(imageWideth > formatWideth)
                {
                    changeToWideth = formatWideth;
                    changeToHeight = (imageHeight * formatWideth) / imageWideth;
                } else
                {
                    changeToWideth = imageWideth;
                    changeToHeight = imageHeight;
                }
            } else
            if(imageHeight > formatHeight)
            {
                changeToHeight = formatHeight;
                changeToWideth = (imageWideth * formatHeight) / imageHeight;
            } else
            {
                changeToWideth = imageWideth;
                changeToHeight = imageHeight;
            }
        srcImage = imageZoomOut(srcImage, changeToWideth, changeToHeight);
        ImageIO.write(srcImage, "JPEG", saveFile);
    }

    public BufferedImage imageZoomOut(BufferedImage srcBufferImage, int w, int h)
    {
        width = srcBufferImage.getWidth();
        height = srcBufferImage.getHeight();
        scaleWidth = w;
        if(DetermineResultSize(w, h) == 1)
        {
            return srcBufferImage;
        } else
        {
            CalContrib();
            BufferedImage pbOut = HorizontalFiltering(srcBufferImage, w);
            BufferedImage pbFinalOut = VerticalFiltering(pbOut, h);
            return pbFinalOut;
        }
    }

    private int DetermineResultSize(int w, int h)
    {
        double scaleH = (double)w / (double)width;
        double scaleV = (double)h / (double)height;
        return scaleH < 1.0D || scaleV < 1.0D ? 0 : 1;
    }

    private double Lanczos(int i, int inWidth, int outWidth, double Support)
    {
        double x = ((double)i * (double)outWidth) / (double)inWidth;
        return ((Math.sin(x * PI) / (x * PI)) * Math.sin((x * PI) / Support)) / ((x * PI) / Support);
    }

    private void CalContrib()
    {
        nHalfDots = (int)(((double)width * support) / (double)scaleWidth);
        nDots = nHalfDots * 2 + 1;
        try
        {
            contrib = new double[nDots];
            normContrib = new double[nDots];
            tmpContrib = new double[nDots];
        }
        catch(Exception e)
        {
            System.out.println("init   contrib,normContrib,tmpContrib" + e);
        }
        int center = nHalfDots;
        contrib[center] = 1.0D;
        double weight = 0.0D;
        int i = 0;
        for(i = 1; i <= center; i++)
        {
            contrib[center + i] = Lanczos(i, width, scaleWidth, support);
            weight += contrib[center + i];
        }

        for(i = center - 1; i >= 0; i--)
            contrib[i] = contrib[center * 2 - i];

        weight = weight * 2D + 1.0D;
        for(i = 0; i <= center; i++)
            normContrib[i] = contrib[i] / weight;

        for(i = center + 1; i < nDots; i++)
            normContrib[i] = normContrib[center * 2 - i];

    }

    private void CalTempContrib(int start, int stop)
    {
        double weight = 0.0D;
        int i = 0;
        for(i = start; i <= stop; i++)
            weight += contrib[i];

        for(i = start; i <= stop; i++)
            tmpContrib[i] = contrib[i] / weight;

    }

    private int GetRedValue(int rgbValue)
    {
        int temp = rgbValue & 0xff0000;
        return temp >> 16;
    }

    private int GetGreenValue(int rgbValue)
    {
        int temp = rgbValue & 0xff00;
        return temp >> 8;
    }

    private int GetBlueValue(int rgbValue)
    {
        return rgbValue & 0xff;
    }

    private int ComRGB(int redValue, int greenValue, int blueValue)
    {
        return (redValue << 16) + (greenValue << 8) + blueValue;
    }

    private int HorizontalFilter(BufferedImage bufImg, int startX, int stopX, int start, int stop, int y, double pContrib[])
    {
        double valueRed = 0.0D;
        double valueGreen = 0.0D;
        double valueBlue = 0.0D;
        int valueRGB = 0;
        int i = startX;
        for(int j = start; i <= stopX; j++)
        {
            valueRGB = bufImg.getRGB(i, y);
            valueRed += (double)GetRedValue(valueRGB) * pContrib[j];
            valueGreen += (double)GetGreenValue(valueRGB) * pContrib[j];
            valueBlue += (double)GetBlueValue(valueRGB) * pContrib[j];
            i++;
        }

        valueRGB = ComRGB(Clip((int)valueRed), Clip((int)valueGreen), Clip((int)valueBlue));
        return valueRGB;
    }

    private BufferedImage HorizontalFiltering(BufferedImage bufImage, int iOutW)
    {
        int dwInW = bufImage.getWidth();
        int dwInH = bufImage.getHeight();
        int value = 0;
        BufferedImage pbOut = new BufferedImage(iOutW, dwInH, 1);
        for(int x = 0; x < iOutW; x++)
        {
            int X = (int)(((double)x * (double)dwInW) / (double)iOutW + 0.5D);
            int y = 0;
            int startX = X - nHalfDots;
            int start;
            if(startX < 0)
            {
                startX = 0;
                start = nHalfDots - X;
            } else
            {
                start = 0;
            }
            int stopX = X + nHalfDots;
            int stop;
            if(stopX > dwInW - 1)
            {
                stopX = dwInW - 1;
                stop = nHalfDots + (dwInW - 1 - X);
            } else
            {
                stop = nHalfDots * 2;
            }
            if(start > 0 || stop < nDots - 1)
            {
                CalTempContrib(start, stop);
                for(y = 0; y < dwInH; y++)
                {
                    value = HorizontalFilter(bufImage, startX, stopX, start, stop, y, tmpContrib);
                    pbOut.setRGB(x, y, value);
                }

            } else
            {
                for(y = 0; y < dwInH; y++)
                {
                    value = HorizontalFilter(bufImage, startX, stopX, start, stop, y, normContrib);
                    pbOut.setRGB(x, y, value);
                }

            }
        }

        return pbOut;
    }

    private int VerticalFilter(BufferedImage pbInImage, int startY, int stopY, int start, int stop, int x, double pContrib[])
    {
        double valueRed = 0.0D;
        double valueGreen = 0.0D;
        double valueBlue = 0.0D;
        int valueRGB = 0;
        int i = startY;
        for(int j = start; i <= stopY; j++)
        {
            valueRGB = pbInImage.getRGB(x, i);
            valueRed += (double)GetRedValue(valueRGB) * pContrib[j];
            valueGreen += (double)GetGreenValue(valueRGB) * pContrib[j];
            valueBlue += (double)GetBlueValue(valueRGB) * pContrib[j];
            i++;
        }

        valueRGB = ComRGB(Clip((int)valueRed), Clip((int)valueGreen), Clip((int)valueBlue));
        return valueRGB;
    }

    private BufferedImage VerticalFiltering(BufferedImage pbImage, int iOutH)
    {
        int iW = pbImage.getWidth();
        int iH = pbImage.getHeight();
        int value = 0;
        BufferedImage pbOut = new BufferedImage(iW, iOutH, 1);
        for(int y = 0; y < iOutH; y++)
        {
            int Y = (int)(((double)y * (double)iH) / (double)iOutH + 0.5D);
            int startY = Y - nHalfDots;
            int start;
            if(startY < 0)
            {
                startY = 0;
                start = nHalfDots - Y;
            } else
            {
                start = 0;
            }
            int stopY = Y + nHalfDots;
            int stop;
            if(stopY > iH - 1)
            {
                stopY = iH - 1;
                stop = nHalfDots + (iH - 1 - Y);
            } else
            {
                stop = nHalfDots * 2;
            }
            if(start > 0 || stop < nDots - 1)
            {
                CalTempContrib(start, stop);
                for(int x = 0; x < iW; x++)
                {
                    value = VerticalFilter(pbImage, startY, stopY, start, stop, x, tmpContrib);
                    pbOut.setRGB(x, y, value);
                }

            } else
            {
                for(int x = 0; x < iW; x++)
                {
                    value = VerticalFilter(pbImage, startY, stopY, start, stop, x, normContrib);
                    pbOut.setRGB(x, y, value);
                }

            }
        }

        return pbOut;
    }

    int Clip(int x)
    {
        if(x < 0)
            return 0;
        if(x > 255)
            return 255;
        else
            return x;
    }

    private int width;
    private int height;
    private int scaleWidth;
    double support;
    double PI;
    double contrib[];
    double normContrib[];
    double tmpContrib[];
    int startContrib;
    int stopContrib;
    int nDots;
    int nHalfDots;
}
