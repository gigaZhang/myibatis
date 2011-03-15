package com.freemarker.action;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.freemarker.tool.file.ImageBuilderTool;
import com.freemarker.tool.file.ScaleImage;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport  {
    private static final long serialVersionUID = 572146812454l ;
    private static final int BUFFER_SIZE = 2 * 1024 ;
   
 
    private String contentType;
    private String fileName;
    private String imageFileName;
    private String caption;
    private String imgtype;
    private String editor;
    private String createmark;
    private String shopid;
    private String imageid;
    private String dirid;//ID目录
    private int[] imgsize;
    private File[] myFile;
    private String[] imgdesc;
    private String[] check;
    private String[] imghigh;
    private String[] imgwide;
    private String[] imgcomt;
    private String[] filename;
    private String[] refid;
    private String tp_id;
    private String tg_id;
    private String tp_pid;
    private String tg_pid;
    private String desc;
    private String returntype;
    private Map savemap = null;
    private String di_filename;
    
    
    public static void main(String[] args){
    	
    }
    
    public void setMyFileContentType(String contentType)  {
        this .contentType = contentType;
   } 
   
    public void setMyFileFileName(String fileName)  {
        this .fileName = fileName;
   } 
       
    public String getFileName()  {
        return fileName;
   } 
   
    public String getImageFileName()  {
        return imageFileName;
   } 
   
    public String getCaption()  {
        return caption;
   } 

     public void setCaption(String caption)  {
        this .caption = caption;
   } 
   
    private static void copy(File src, File dst)  {
        try  {
           InputStream in = null ;
           OutputStream out = null ;
            try  {                
               in = new BufferedInputStream( new FileInputStream(src), BUFFER_SIZE);
               out = new BufferedOutputStream( new FileOutputStream(dst), BUFFER_SIZE);
                byte [] buffer = new byte [BUFFER_SIZE];
                while (in.read(buffer) > 0 )  {
                   out.write(buffer);
               } 
            } finally  {
                if ( null != in)  {
                   in.close();
               } 
                 if ( null != out)  {
                   out.close();
               } 
           } 
        } catch (Exception e)  {
          System.out.println("路径错误："+e.toString());
       } 
   } 
   
    private static String getExtention(String fileName)  {
        int pos = fileName.lastIndexOf(".");
        return fileName.substring(pos);
   } 

    @Override
    public String execute() throws IOException{   

	  if (fileName != null){
		  
	   if (getImgtype() == null || getImgtype().equals("")){
		    setImgtype("imgpath");
	   }
	   

	   
	  
	   // setImgtype("imgpath");
	   //System.out.println(imgtype);
	   HttpServletRequest request = ServletActionContext.getRequest();
       String path  =  (String) request.getSession().getServletContext().getAttribute(imgtype);
       String[] fileNames = fileName.split(",");
       fileName = "";
       desc = "";
	   if (check == null)
		   check = new String[fileNames.length];
	   if (filename == null)
		   filename = new String[fileNames.length];
       if (returntype.equals("IMAGE")){
		   if (imgdesc == null)
			   imgdesc = new String[fileNames.length];
		   if (imgcomt == null)
			   imgcomt = new String[fileNames.length];
		   if (imgwide == null)
			   imgwide = new String[fileNames.length];
		   if (imghigh == null)
			   imghigh = new String[fileNames.length];
		   if (refid == null)
			   refid = new String[fileNames.length];
		   if (imgsize == null)
			   imgsize = new int[fileNames.length];
		   if (tg_id == null || tg_id.equals("")){
			   tg_id = tg_pid;
		   }
		   if (tp_id == null || tp_id.equals("")){
			   tp_id = tp_pid;
		   }
       }
       
//       if (!(tp_id == null || tp_id.equals("null") || tp_id.equals(""))){
//		   savemap = new ImageTypeAction().getSaveInfo(String.valueOf(tp_id));
//		   path = (String)savemap.get("savepath");
//		   System.out.println(path);
//       }
       for (int i=0;i<fileNames.length;i++){
    	  // System.out.println(shopid);
    	   if (shopid == null || shopid.equals("null"))
    		   imageFileName = new Date().getTime() + getExtention(fileNames[i]);
    	   else 
    		   imageFileName = "allcity_"+shopid+getExtention(fileNames[i]);
    	   filename[i] = imageFileName;
           if (getImgtype().equals("wlimgpath") || getImgtype().equals("channelimgpath") || "galleryimgpath".equals(getImgtype()) || "gallerysmallimagepath".equals(getImgtype())){
    	       String datePath = new SimpleDateFormat("yyyyMMdd").format(new Date());  
    	       imageFileName = datePath + "/"+imageFileName;
    	       //System.out.println("生成的路径："+path + datePath);
    	       try {
    	    	 File f = new File(path + datePath+"/");
    	   		 forceMkdir(f);
    		   	} catch (IOException e) {
    		   		// TODO Auto-generated catch block
    		   		System.out.println(e.toString());
    		   	}
           }else if (!(dirid == null || dirid.equals("") || dirid.equals("null"))){
        	   imageFileName = dirid + "/"+imageFileName;
    	       try {
        	    	 File f = new File(path + dirid+"/");
        	   		 forceMkdir(f);
        		   	} catch (IOException e) {
        		   		// TODO Auto-generated catch block
      		   		System.out.println(e.toString());
      		   	}	
           }

           
           
    		       File imageFile = new File(path + imageFileName);
				   copy(myFile[i], imageFile);
				   
				   
    		       //new FileUpload().createMark2(path+imageFileName,"/ddmap/topic/logo.png");
    		       if (imageFileName.indexOf(".jpg") != -1){
    		    	   if (returntype.equals("IMAGE")){
	    		    	   BufferedImage srcImage = ImageIO.read(imageFile);
	    		    	   byte[]  data  =  ((DataBufferByte)srcImage.getData().getDataBuffer()).getData(); 
	    		    	   imgsize[i] = data.length;
	    		    	   if (!savemap.get("width").equals("0"))
	    		    		   imgwide[i] = (String) savemap.get("width");
	    		    	   if (!savemap.get("height").equals("0"))
	    		    		   imghigh[i] =  (String) savemap.get("height");
	    		    	   if (imgwide[i] == null || imgwide[i].equals(""))
	   		    	        	imgwide[i] = String.valueOf(srcImage.getWidth(null));
	    		    	   if (Integer.parseInt(imgwide[i]) >550)
	    		    		   imgwide[i] = "550";
	    		    	   if (imghigh[i] == null || imghigh[i].equals(""))
	    		    		   	imghigh[i] = String.valueOf(srcImage.getHeight(null));
	    		    	   if (Integer.parseInt(imghigh[i]) > 600)
	    		    		   imghigh[i] = "600";
	    		    	   ScaleImage is = new ScaleImage();
		    			   try {
		    				   is.saveImageAsJpg(imageFile.getAbsolutePath(),path+imageFileName,Integer.parseInt(imgwide[i]),Integer.parseInt(imghigh[i]));
		    			   } catch (NumberFormatException e) {
		    				   // TODO Auto-generated catch block
		    				   e.printStackTrace();
		    			   } catch (Exception e) {
		    				   // TODO Auto-generated catch block
		    				   e.printStackTrace();
		    			   }
    		    	   }
    		    	   if (check[i] == null || check[i].equals(""))
    		    		   check[i] = "on";
    		    	   else
    		    		   check[i] = "off";
	    		    	  if (!(check[i].equals("on"))){
	    		    		  System.out.println("不打水印--mr.l");
	    		    		 // new ImageBuilderTool().rebuildImage(path+imageFileName,path+imageFileName,1024,768,false,"","");
	    		    	  }else {
	    		    		  new ImageBuilderTool(). createPicMark(imageFile,getRequest().getRealPath("/images/logo.gif"));
	    		    		  System.out.println("打水印--mr.l");
	    		    	  }
	    		   }
//    	   if (returntype.equals("IMAGE")){
//    		   ImageManage im = new ImageManage();
//    		   im.setDi_filename(filename[i]);
//    		   im.setDi_filedesc(imgdesc[i]);
//    		   im.setDi_comment(imgcomt[i]);
//    		   im.setDi_width(String.valueOf(imgwide[i]));
//    		   im.setDi_height(String.valueOf(imghigh[i]));
//    		   im.setDi_refid(String.valueOf(refid[i]));
//    		   im.setDi_tgid(tg_id);
//    		   im.setDi_tpid(tp_id);
//    		   im.setDi_size(String.valueOf(imgsize[i]));
//    		   if (imageid == null || imageid.equals(""))
//    			   new ImageManageAction().saveImageManage(im);
//    		   else {
//    			   im.setDi_id(imageid);
//    			   new ImageManageAction().updateImageManage(im);
//    		   }
//    	   }
    	 
    	   if (!(tp_id == null || tp_id.equals("null") || tp_id.equals(""))){
    		   imageFileName =(String)savemap.get("readpath") + imageFileName;
    		   
    	   }
           if (imgdesc[i] == null)
        	   imgdesc[i] = "";
    	   if (i == fileNames.length-1){
    		   fileName += imageFileName;
    		   desc += imgdesc[i];
    	   }else {	   
    		   fileName += imageFileName + ",";
    		   desc += imgdesc[i] + ",";
    	   }
    	   
       }
	  }
//       else if (di_filename != null){
//		   ImageManage im = new ImageManage();
//		   if (imgdesc == null)
//			   imgdesc = new String[0];
//		   im.setDi_filedesc(imgdesc[0]);
//		   if (imgcomt == null)
//			   imgcomt = new String[0];
//		   im.setDi_comment(imgcomt[0]);
//		   if (imgwide == null)
//			   imgwide = new String[0];
//		   im.setDi_width(String.valueOf(imgwide[0]));
//		   if (imghigh == null)
//			   imghigh = new String[0];
//		   im.setDi_height(String.valueOf(imghigh[0]));
//		   if (refid == null)
//			   refid = new String[0];
//		   im.setDi_refid(String.valueOf(refid[0]));
//		   im.setDi_tgid(tg_id);
//		   im.setDi_tpid(tp_id);
//		   im.setDi_id(imageid);
//		   im.setDi_filename(di_filename);
//		   new ImageManageAction().updateImageManage(im);
//       }
	  
	  String rt = "";
	  if (returntype == null || returntype.equals(""))
		  rt = SUCCESS;
	  else{
		  rt = getReturntype();
	  }
	  System.out.println(rt);
      return rt;
   }
   
   
   public String adv()throws IOException{   
	   
		  if (fileName != null){
		  
		   if (getImgtype() == null || getImgtype().equals("")){
			    setImgtype("imgpath");
		   }
		   
		   
		   System.out.println(imgtype);
		   // setImgtype("imgpath");
		   //System.out.println(imgtype);
		   HttpServletRequest request = ServletActionContext.getRequest();
	       String path  =  (String) request.getSession().getServletContext().getAttribute(imgtype);
	       String[] fileNames = fileName.split(",");
	       fileName = "";
	       desc = "";
		   if (check == null)
			   check = new String[fileNames.length];
	       for (int i=0;i<fileNames.length;i++){
	    	   imageFileName = new Date().getTime() + getExtention(fileNames[i]);
	           if (getImgtype().equals("wlimgpath")){
	    	       String datePath = new SimpleDateFormat("yyyyMMdd").format(new Date());  
	    	       imageFileName = datePath + "/"+imageFileName;
	    	       System.out.println("生成的路径："+path + datePath);
	    	       try {
	    	    	 File f = new File(path + datePath+"/");
	    	   		 forceMkdir(f);
	    		   	} catch (IOException e) {
	    		   		// TODO Auto-generated catch block
	    		   		System.out.println(e.toString());
	    		   	}
	           }
	    		       File imageFile = new File(path + imageFileName);
					   copy(myFile[i], imageFile);
	    		       //new FileUpload().createMark2(path+imageFileName,"/ddmap/topic/logo.png");
	    		       if (imageFileName.indexOf(".jpg") != -1){
	    		    	   if (check[i] == null || check[i].equals(""))
	    		    		   check[i] = "on";
	    		    	   else
	    		    		   check[i] = "off";
		    		    	  if (!(check[i].equals("on"))){
		    		    		  System.out.println("不打水印");
		    		    		 // new ImageBuilderTool().rebuildImage(path+imageFileName,path+imageFileName,1024,768,false,"","");
		    		    	  }else {
		    		    		  new ImageBuilderTool(). createPicMark(imageFile,getRequest().getRealPath("/images/logo.png"));
		    		    		  System.out.println("打水印");
		    		    	  }
	    		       }
	           if (imgdesc[i] == null)
	        	   imgdesc[i] = "";
	    	   if (i == fileNames.length-1){
	    		   fileName += imageFileName;
	    		   desc += imgdesc[i];
	    	   }else {	   
	    		   fileName += imageFileName + ",";
	    		   desc += imgdesc[i] + ",";
	    	   }
	    	   
	       }
	  
		  }
		  
	       return "ADVUPLOAD";
	   }
   
   

   public static void forceMkdir(File directory) throws IOException {
       if (directory.exists()) {
           if (directory.isFile()) {
               String message =
                   "File "
                       + directory
                       + " exists and is "
                       + "not a directory. Unable to create directory.";
               throw new IOException(message);
           }
       } else {
           if (!directory.mkdirs()) {
               String message =
                   "Unable to create directory " + directory;
               throw new IOException(message);
           }
       }
   }  
   
	public HttpServletRequest getRequest(){
		HttpServletRequest request = ServletActionContext.getRequest();	
		return request;
	}
public String getImgtype() {
	return imgtype;
}

public void setImgtype(String imgtype) {
	this.imgtype = imgtype;
}

public String getCreatemark() {
	return createmark;
}

public void setCreatemark(String createmark) {
	this.createmark = createmark;
}

public File[] getMyFile() {
	return myFile;
}

public void setMyFile(File[] myFile) {
	this.myFile = myFile;
}

public String[] getImgdesc() {
	return imgdesc;
}

public void setImgdesc(String[] imgdesc) {
	this.imgdesc = imgdesc;
}

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

public String getEditor() {
	return editor;
}

public void setEditor(String editor) {
	this.editor = editor;
}

public String getReturntype() {
	return returntype;
}

public void setReturntype(String returntype) {
	this.returntype = returntype;
}

public String[] getCheck() {
	return check;
}

public void setCheck(String[] check) {
	this.check = check;
}

public String[] getImgcomt() {
	return imgcomt;
}

public void setImgcomt(String[] imgcomt) {
	this.imgcomt = imgcomt;
}

public int[] getImgsize() {
	return imgsize;
}

public void setImgsize(int[] imgsize) {
	this.imgsize = imgsize;
}

public String[] getImghigh() {
	return imghigh;
}

public void setImghigh(String[] imghigh) {
	this.imghigh = imghigh;
}

public String[] getImgwide() {
	return imgwide;
}

public void setImgwide(String[] imgwide) {
	this.imgwide = imgwide;
}

public String[] getRefid() {
	return refid;
}

public void setRefid(String[] refid) {
	this.refid = refid;
}


public String[] getFilename() {
	return filename;
}

public void setFilename(String[] filename) {
	this.filename = filename;
}

public String getTp_id() {
	return tp_id;
}

public void setTp_id(String tp_id) {
	this.tp_id = tp_id;
}

public String getTg_id() {
	return tg_id;
}

public void setTg_id(String tg_id) {
	this.tg_id = tg_id;
}

public String getTp_pid() {
	return tp_pid;
}

public void setTp_pid(String tp_pid) {
	this.tp_pid = tp_pid;
}

public String getTg_pid() {
	return tg_pid;
}

public void setTg_pid(String tg_pid) {
	this.tg_pid = tg_pid;
}

public String getShopid() {
	return shopid;
}

public void setShopid(String shopid) {
	this.shopid = shopid;
}

public String getImageid() {
	return imageid;
}

public void setImageid(String imageid) {
	this.imageid = imageid;
}

public String getDi_filename() {
	return di_filename;
}

public void setDi_filename(String di_filename) {
	this.di_filename = di_filename;
}

public String getDirid() {
	return dirid;
}

public void setDirid(String dirid) {
	this.dirid = dirid;
}



} 