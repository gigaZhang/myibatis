package com.freemarker.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.tool.BeanLocator;
import com.freemarker.dao.ImageTypeDao;
import com.freemarker.entity.ImageType;
import com.questionnaire.action.BaseAction;

public class ImageTypeAction extends BaseAction{
	
	private String msg;
	private String type;
	private String id;
	private String[] tp_name;
	private String[] tp_desc;
	private String[] tp_savepath;
	private String[] tp_readpath;
	private String[] tp_width;
	private String[] tp_height;
	private ImageType imagetype;
	ImageTypeDao imagetypeDao = (ImageTypeDao) BeanLocator.getBean("imagetypeDao");
	

	
	public String saveImageType(){
		ImageType imagetype = new ImageType();
		imagetype.setTp_name(tp_name[0]);
		imagetype.setTp_desc(tp_desc[0]);
		imagetype.setTp_pid("0");
		imagetype.setTp_savepath(tp_savepath[0]);
		imagetype.setTp_readpath(tp_readpath[0]);
		imagetype.setTp_width(tp_width[0]);
		imagetype.setTp_height(tp_height[0]);
		imagetypeDao.insert(imagetype);
		Map map = new HashMap();
		map.put("tp_name",tp_name[0]);
		map.put("tp_pid","0");
		String tppid = imagetypeDao.getImageTypeId(map).getTp_id();
		if (tp_name.length >0){
			for (int i=1;i<tp_name.length;i++){
				ImageType ig = new ImageType();
				ig.setTp_name(tp_name[i]);
				ig.setTp_desc(tp_desc[i]);
				ig.setTp_pid(tppid);
				ig.setTp_savepath(tp_savepath[i]);
				ig.setTp_readpath(tp_readpath[i]);
				ig.setTp_width(tp_width[i]);
				ig.setTp_height(tp_height[i]);
				imagetypeDao.insert(ig);
			}
		}
		msg="<script>alert('添加成功');document.typeform.action=\"imagetype!submitQuery.action\";document.typeform.submit();</script>";
		return submitQuery();
	}
	
	public String ImageTypeList(){
		Map map = new HashMap();
		map.put("search","tp_pid = 0");
		List typelist1 = imagetypeDao.list(map);
		getRequest().setAttribute("typelist1",typelist1);
		if (imagetype != null && !imagetype.getTp_id().equals("")){
			Map map2 = new HashMap();
			map2.put("search","tp_id = "+imagetype.getTp_id()+" or tp_pid = "+imagetype.getTp_id());
			List typelist2 = imagetypeDao.list(map2);
			getRequest().setAttribute("typelist2",typelist2);
		}
		return submitQuery();
	}
	
	public String deleteImageType(){
		if (!id.equals("")){
			Map map = new HashMap();
			map.put("search","tp_id = "+id);
			imagetypeDao.deleteGroup(map);
			msg="<script>alert('删除成功');document.typefrom.action=\"imagetype!ImageTypeList.action\";document.typefrom.submit();</script>";
		}
		
		return submitQuery();
	}

	public String deleteAllImageType(){
		if (!id.equals("")){
			Map map = new HashMap();
			map.put("search","tp_id = "+id +" or tp_pid = "+id);
			imagetypeDao.deleteGroup(map);
			msg="<script>alert('删除成功');document.typefrom.action=\"imagetype!ImageTypeList.action\";document.typefrom.submit();</script>";
		}
		return submitQuery();
	}
	
	public Map getSaveInfo(String tpid){
		Map map = new HashMap();
		map.put("search",tpid);
		ImageType it = (ImageType)imagetypeDao.getImageTypePath(map);
		Map savemap = new HashMap();
		savemap.put("savepath",it.getTp_savepath());
		savemap.put("readpath",it.getTp_readpath());
		savemap.put("width",it.getTp_width());
		savemap.put("height",it.getTp_height());
		return savemap;
	}
	
	public String updateImageType(){
		imagetypeDao.update(imagetype);
		imagetype.setTp_id("");
		type = "2";
		msg="<script>alert('修改成功');</script>";
		return ImageTypeList();
	}
	
	public String saveChildImageType(){
		if (tp_name.length >0){
			for (int i=0;i<tp_name.length;i++){
				ImageType ig = new ImageType();
				ig.setTp_name(tp_name[i]);
				ig.setTp_desc(tp_desc[i]);
				ig.setTp_pid(imagetype.getTp_id());
				ig.setTp_savepath(tp_savepath[i]);
				ig.setTp_readpath(tp_readpath[i]);
				ig.setTp_width(tp_width[i]);
				ig.setTp_height(tp_height[i]);
				imagetypeDao.insert(ig);
			}
		}
		imagetype.setTp_id("");
		type = "2";
		msg="<script>alert('添加成功');</script>";
		return ImageTypeList();
	}
	
	public String getImageTypeInfo(){
		Map map = new HashMap();
		map.put("search","tp_id = "+id );
		imagetype  = (ImageType)imagetypeDao.list(map).get(0);
		//System.out.println(imagetype.getTp_desc());
		setType("4");
		return submitQuery();
	}
	
	public String getImageType(){
		Map map = new HashMap();
		map.put("rows", "tp_id,tp_name");
		map.put("search","tp_pid = 0 and tp_id = "+id );
		imagetype = imagetypeDao.getModel(map);
		setType("3");
		return submitQuery();
	}
	
	public String submitQuery(){
		return "IMAGETYPE";
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
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String[] getTp_name() {
		return tp_name;
	}

	public void setTp_name(String[] tp_name) {
		this.tp_name = tp_name;
	}

	public String[] getTp_desc() {
		return tp_desc;
	}

	public void setTp_desc(String[] tp_desc) {
		this.tp_desc = tp_desc;
	}

	public String[] getTp_savepath() {
		return tp_savepath;
	}

	public void setTp_savepath(String[] tp_savepath) {
		this.tp_savepath = tp_savepath;
	}

	public String[] getTp_width() {
		return tp_width;
	}

	public void setTp_width(String[] tp_width) {
		this.tp_width = tp_width;
	}

	public String[] getTp_height() {
		return tp_height;
	}

	public void setTp_height(String[] tp_height) {
		this.tp_height = tp_height;
	}

	public ImageType getImagetype() {
		return imagetype;
	}

	public void setImagetype(ImageType imagetype) {
		this.imagetype = imagetype;
	}

	public String[] getTp_readpath() {
		return tp_readpath;
	}

	public void setTp_readpath(String[] tp_readpath) {
		this.tp_readpath = tp_readpath;
	}



}
