package com.freemarker.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.common.PageProperty;
import com.framework.dao.impl.EntityDaoImpl;
import com.framework.tool.BeanLocator;
import com.freemarker.dao.ImageGroupDao;
import com.freemarker.dao.ImageManageDao;
import com.freemarker.dao.ImageTypeDao;
import com.freemarker.dao.impl.ImageManageDaoImpl;
import com.freemarker.entity.ImageGroup;
import com.freemarker.entity.ImageManage;
import com.freemarker.entity.ImageType;
import com.freemarker.tool.file.PageData;
import com.freemarker.tool.file.PageDataCollector;
import com.questionnaire.action.BaseAction;



public class ImageManageAction extends BaseAction{

	private String msg;
	private String type;
	private String tg_id;
	private String tg_pid;
	private String tp_id;
	private String tp_pid;
	private String[] refid;
	private ImageManage imagemanage;


	ImageManageDao imagemanageDao = (ImageManageDao) BeanLocator.getBean("imagemanageDao");
	ImageTypeDao imagetypeDao = (ImageTypeDao) BeanLocator.getBean("imagetypeDao");
	ImageGroupDao imagegroupDao = (ImageGroupDao) BeanLocator.getBean("imagegroupDao");
	
	public void ImageType(){

		Map map = new HashMap();
		map.put("rows", "tp_id,tp_name");
		map.put("search","tp_pid = 0");
		List typelist = imagetypeDao.list(map);
		getRequest().setAttribute("typelist1",typelist);
		List typelist2 = null;
		if (!(tp_pid == null || tp_pid.equals(""))){
			Map map2 = new HashMap();
			map2.put("rows", "tp_id,tp_name,tp_readpath");
			map2.put("search","tp_pid = "+tp_pid);
			typelist2 = imagetypeDao.list(map2);
		}
		getRequest().setAttribute("typelist2",typelist2);
		
		Map map3 = new HashMap();
		map3.put("rows", "tg_id,tg_name");
		map3.put("search","tg_pid = 0");
		List grouplist1 = imagegroupDao.list(map3);
		getRequest().setAttribute("grouplist1",grouplist1);
		
		List grouplist2 = null;
		if (!(tg_pid == null || tg_pid.equals(""))){
			Map map4 = new HashMap();
			map4.put("rows", "tg_id,tg_name");
			map4.put("search","tg_pid = "+tg_pid);
			grouplist2 = imagegroupDao.list(map4);
		}
		getRequest().setAttribute("grouplist2",grouplist2);
	}

	public String saveImageManage(ImageManage imagemanage){
		imagemanageDao.insert(imagemanage);
		return submitQuery();
	}
	
	public String ImageManageList(){
		ImageType();
		Map typemap = new HashMap();
		typemap.put("rows", "tp_id,tp_name,tp_readpath");
		typemap.put("search","tp_id > 0");
		List typelist = imagetypeDao.list(typemap);
		if (typelist != null){
			for (int i=0;i<typelist.size();i++){
				ImageType it = (ImageType)typelist.get(i);
				typemap.put(it.getTp_id(),it.getTp_name()+","+it.getTp_readpath());
				//typemap.put(it.getTp_id()+"readpath",it.getTp_readpath());
			}
		}
		Map groupmap = new HashMap();
		groupmap.put("rows", "tg_id,tg_name");
		groupmap.put("search","tg_id > 0");
		List grouplist = imagegroupDao.list(groupmap);
		if (grouplist != null){
			for (int i=0;i<grouplist.size();i++){
				ImageGroup ig = (ImageGroup)grouplist.get(i);
				groupmap.put(ig.getTg_id(),ig.getTg_name());
			}
		}
		
		String page = "";
		String search = "di_valid=1";

		if (tp_id == null || tp_id.equals(""))
			tp_id = tp_pid;
		if (tg_id == null || tg_id.equals(""))
			tg_id = tg_pid;
		if (!(tg_id == null || tg_id.equals(""))){
			search += " and di_tgid = "+tg_id;
		}
		if (!(tp_id == null || tp_id.equals(""))){
			search += " and di_tpid = "+tp_id;
		}
		PageData showPage = PageDataCollector.collectAndSavePage(getRequest());
		showPage.setPerPageRecords(30);
		if (showPage.getCurrentPage() == 1)
			page = "0";
		else 
			page = String.valueOf(showPage.getCurrentPage()-1);
		PageProperty p = new PageProperty();
		p.putParamMap("search",search);
		p.putParamMap("search2",search.replaceAll("''","'"));
		p.putParamMap("page",page);
		List imageList = ((EntityDaoImpl<ImageManage>) imagemanageDao).findPageList(p);
		if (imageList != null){
			for (int i=0;i<imageList.size();i++){
				ImageManage im = (ImageManage)imageList.get(i);
				String[] type = String.valueOf(typemap.get(im.getDi_tpid())).split(",");
				System.out.println(type.length);
				if (type.length > 1){
					im.setDi_tpid(type[0]);
					im.setDi_filename(type[1]+im.getDi_filename());
				}
				im.setDi_tgid((String)groupmap.get(im.getDi_tgid()));
			}
		}
		if (showPage.getTotalItems() == 0){
			showPage.setTotalItems(((EntityDaoImpl<ImageManage>) imagemanageDao).findCount(p));	
		}
		getRequest().setAttribute("imageList",imageList);
		return "IMAGE";
	}
	
	public String deleteImageManage(){
		Map map = new HashMap();
		map.put("di_id",imagemanage.getDi_id());
		imagemanageDao.deleteGroup(map);
		msg="<script>alert('删除成功');document.imageform.action=\"imagemanage!ImageManageList.action\";document.imageform.submit();</script>";
		return submitQuery();
	}
	
	public String updateImageManage(ImageManage imagemanage){
		imagemanageDao.update(imagemanage);
		System.out.println("修改成功");
		imagemanage.setDi_id("");
		//type = "2";
		return ImageManageList();
	}
	
	public String getImageManage(){
		//System.out.println(imagemanage.getDi_id());
		if (!imagemanage.getDi_id().equals("")){
			Map map = new HashMap();
			map.put("rows", "di_id,di_tpid,di_tgid,di_refid,di_filename,di_filedesc,di_comment,di_size,di_time,di_width,di_height");
			map.put("search","di_id = "+imagemanage.getDi_id());
			imagemanage = imagemanageDao.getModel(map);
			
			Map typemap = new HashMap();
			map.put("rows", "tp_id,tp_pid,tp_name");
			map.put("search","tp_id = "+imagemanage.getDi_tpid() );
			ImageType imagetype = imagetypeDao.getModel(map);
			if (imagetype.getTp_pid().equals("0")){
				tp_pid = imagetype.getTp_id();
				tp_id = "";
			}else{
				tp_pid = imagetype.getTp_pid();
				tp_id = imagetype.getTp_id();
			}
			Map groupmap = new HashMap();
			map.put("rows", "tg_id,tg_pid,tg_name");
			map.put("search","tg_id = "+imagemanage.getDi_tgid() );
			ImageGroup imagegroup = imagegroupDao.getModel(map);	
			if (imagegroup.getTg_pid().equals("0")){
				tg_pid = imagegroup.getTg_id();
				tg_id = "";
			}else{
				tg_pid = imagegroup.getTg_pid();
				tg_id = imagegroup.getTg_id();
			}
				
			type = "3";
		}
		
		return submitQuery();
	}
	
	public String submitQuery(){
		ImageType();
		System.out.println(refid);
		return "IMAGE";
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ImageManage getImagemanage() {
		return imagemanage;
	}

	public void setImagemanage(ImageManage imagemanage) {
		this.imagemanage = imagemanage;
	}

	public String getTg_id() {
		return tg_id;
	}

	public void setTg_id(String tg_id) {
		this.tg_id = tg_id;
	}

	public String getTg_pid() {
		return tg_pid;
	}

	public void setTg_pid(String tg_pid) {
		this.tg_pid = tg_pid;
	}

	public String getTp_id() {
		return tp_id;
	}

	public void setTp_id(String tp_id) {
		this.tp_id = tp_id;
	}

	public String getTp_pid() {
		return tp_pid;
	}

	public void setTp_pid(String tp_pid) {
		this.tp_pid = tp_pid;
	}

	public String[] getRefid() {
		return refid;
	}

	public void setRefid(String[] refid) {
		this.refid = refid;
	}



}
