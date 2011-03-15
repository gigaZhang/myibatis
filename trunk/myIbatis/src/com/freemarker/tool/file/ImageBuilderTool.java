package com.freemarker.tool.file;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageBuilderTool {

	public static void main(String[] args) {
		rebuildImage("d:/btest/IMG_1993.JPG", "D:/btest/df2.jpg", 700, 700,true,"","d:/btest/logo.png");
		
	}
	
	
	public static boolean rebuildImage(String srcFile, String destFile,
			int allMaxWidth, int allMaxHeight,boolean isCreateMark,String contentMark,String imageMarkFilePath) {
		
		ScaleImage is = new ScaleImage();
		
		try {
			File sourceFile = new File(srcFile);
			//System.out.println("sourcefile:"+sourceFile.getAbsolutePath());
	        is.saveImageAsJpg(sourceFile.getAbsolutePath(), destFile, allMaxWidth,
	        		allMaxHeight);
	        //System.out.println("生成完成");
	       
	        if(isCreateMark){
	        	File destObj = new File(destFile);
	        	if(contentMark!=null && contentMark.length()>0){
	        		createMarkStr(destFile, contentMark);
	        	}else if(imageMarkFilePath!=null && imageMarkFilePath.length()>0){
	        		createPicMark(destObj,imageMarkFilePath);
	        	}
	        	
	        }
	        
	        
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("生成缩略图失败!"+e.getMessage());
			return false;
		}
		

	}
	
	
	public static void buildSmallImage(File sourceFile, String smallPath,
			int width, int height, boolean adjustSize) {
		
		
		ScaleImage is = new ScaleImage();
		try {
			
			//System.out.println("开始生成缩图:"+sourceFile.getAbsolutePath()+" to "+smallPath);
	        is.saveImageAsJpg(sourceFile.getAbsolutePath(), smallPath, width,
	                height);
	        //System.out.println("生成完成");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("生成缩略图失败!"+e.getMessage());
		}

	}

	private static void writeFile(Image image, int width, int height,
			String thumbnailFile) throws Exception {

		if (image == null)
			return;

		BufferedImage tag = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		tag.getGraphics().drawImage(image, 0, 0, width, height, null);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(thumbnailFile);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(tag);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}

	private static int[] adjustImageSize(int theImgWidth, int theImgHeight,
			int defWidth, int defHeight) {
		int[] size = { 0, 0 };

		float theImgHeightFloat = Float
				.parseFloat(String.valueOf(theImgHeight));
		float theImgWidthFloat = Float.parseFloat(String.valueOf(theImgWidth));
		if (theImgWidth < theImgHeight) {
			float scale = theImgHeightFloat / theImgWidthFloat;
			size[0] = Math.round(defHeight / scale);
			size[1] = defHeight;
		} else {
			float scale = theImgWidthFloat / theImgHeightFloat;
			size[0] = defWidth;
			size[1] = Math.round(defWidth / scale);
		}
		return size;
	}
	
	public static void createPicMark(File destFile, String markPicPath) throws IOException {
		
		
		BufferedImage  originImg   =   ImageIO.read(destFile); 
		int width1=originImg.getWidth();
		int height1=originImg.getHeight();
		Graphics2D   g2d   =   originImg.createGraphics();   
		g2d.drawImage(originImg,0,0,width1,height1,null);
		BufferedImage  waterMarkImg   =  ImageIO.read(new   File(markPicPath));
		int width2 = waterMarkImg.getWidth(); // 得到水印图宽
		int height2 = waterMarkImg.getHeight(); // 得到水印图长  
		g2d.drawImage(waterMarkImg,width1-width2,height1-height2-5,width2,height2,null);
		g2d.dispose();
		
		FileOutputStream out=new FileOutputStream(destFile);
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
		encoder.encode(originImg);
		out.close();
	}

	
	
	public static boolean createMark(String filePath, String watermark,
			String strmark) {
		ImageIcon imgIcon = new ImageIcon(filePath);
		Image theImg = imgIcon.getImage();
		ImageIcon waterIcon = new ImageIcon(watermark);
		Image waterImg = waterIcon.getImage();
		int width = theImg.getWidth(null);
		int height = theImg.getHeight(null);
		BufferedImage bimage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bimage.createGraphics();
		//设置水印字体
		//System.out.println(width/20);
		Font font1 = null;
		if (width > 200)
			//font1 = new Font("华文彩云", Font.BOLD, width/20);
			font1 = new Font("Arial", Font.PLAIN, width / 30);
		else
			//font1 = new Font("华文彩云", Font.BOLD, 22);
			font1 = new Font("Arial", Font.PLAIN, 10);
		g.setFont(font1);

		//g.setColor(Color.getColor("",14408667));
		//g.setBackground(Color.getColor("",14408667));
		g.setColor(Color.GRAY);

		g.drawImage(theImg, 0, 0, null);
		g.drawImage(waterImg, width, height, null);
		//g.drawImage(waterImg, 0, 0, null);
		//g.drawImage(theImg, 100, 100, null);
		if (width > 200)
			g.drawString(strmark, width / 2 - 40, height / 2); //添加文字
		else
			g.drawString(strmark, 20, 90); //添加文字
		g.dispose();
		try {
			FileOutputStream out = new FileOutputStream(watermark);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bimage);
			param.setQuality(50f, true);
			encoder.encode(bimage, param);
			out.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
    public static boolean createMarkStr(String filePath,String strmark) {
        ImageIcon imgIcon = new ImageIcon(filePath);
        Image theImg = imgIcon.getImage();

        int width = theImg.getWidth(null);
        int height = theImg.getHeight(null);
        BufferedImage bimage = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimage.createGraphics();
        //设置水印字体
        Font font1 = null;
        font1 = new Font("宋体", Font.PLAIN, 12);
        g.setFont(font1);
        g.setColor(Color.WHITE);
        g.drawImage(theImg, 0, 0, null);
        g.drawImage(theImg, width, height, null);

        if(width>140)
          g.drawString(strmark,width-150, height-8); //添加文字
        else if(width>20)
          g.drawString("WWW.DDMAP.COM",5, height-15); //添加文字
        g.dispose();
        try {
          FileOutputStream out = new FileOutputStream(filePath);
          JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
          JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bimage);
          param.setQuality(50f, true);
          encoder.encode(bimage, param);
          out.close();
        }
        catch (Exception e) {
          return false;
        }
        return true;
      }
}
