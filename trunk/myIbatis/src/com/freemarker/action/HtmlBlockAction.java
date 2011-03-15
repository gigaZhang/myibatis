package com.freemarker.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.tool.BeanLocator;
import com.freemarker.entity.MstHtmlCreator;
import com.freemarker.entity.MstHtmlElement;
import com.freemarker.service.MstHtmlCreatorService;
import com.freemarker.service.MstHtmlElementService;
import com.questionnaire.action.BaseAction;


public class HtmlBlockAction extends BaseAction{

		private String msg;//返回提示
		private String type;
		private String mapno;
		private String mhcid;
		private String mhcmodule;
		private String tips;
		private String mheids;
		private MstHtmlCreator creator;
		private MstHtmlElement element;
		
		MstHtmlCreatorService creatorService = (MstHtmlCreatorService)BeanLocator.getBean("msthtmlcreatorService");
		MstHtmlElementService elementService = (MstHtmlElementService)BeanLocator.getBean("msthtmlelementService");
		
		
		public String submitQuery(){
			getRequest().setAttribute("moduleList",creatorService.moduleList());
			if (!(getMhcmodule() == null || getMhcmodule().equals("")))
				getRequest().setAttribute("nameList",creatorService.nameList(getMhcmodule()));
			if(!(getMhcid() == null || getMhcid().equals(""))){
				creator = creatorService.mhcValue(getMhcid());
			}else 
				creator = null;
			getRequest().setAttribute("mheList",elementService.listModel(getMhcid(),getMapno()));
			return "HTMLBLOCK";
		}
		
		public String updateMstHtmlCreator(){
			creatorService.update(creator);
			msg = "<script>alert('修改成功！！');</script>";
			return submitQuery();
		}
		
		public String insertMstHtmlCreator(){
			creatorService.insert(creator);
			msg = "<script>alert('添加成功！！');</script>";
			return submitQuery();
		}
		
		public String closeMstHtmlCreator(){
			elementService.deleteGroup(getMhcid(),getMapno());
			msg = "<script>alert('关闭成功！！');</script>";
			return submitQuery();
		}
		
		public String initialMstHtmlCreator(){
			if (!(getMhcid() == null || getMhcid().equals(""))){
				elementService.initial(getMhcid(),getMapno(),creator.getPic_counts(),creator.getTxt_counts());
				//System.out.println("个别");
			}else {
				List mhcList = creatorService.nameList(getMhcmodule());
				if (mhcList != null){
					for (int i=0;i<mhcList.size();i++){
						MstHtmlCreator mhc = (MstHtmlCreator)mhcList.get(i);
						//System.out.println(mhc.getPic_counts());
						elementService.initial(mhc.getMhc_id(),getMapno(),mhc.getPic_counts(),mhc.getTxt_counts());
					}
					//System.out.println("全部");
				}
			}
				
			msg = "<script>alert('初始成功！！');</script>";
			return submitQuery();
		}
		
		public String deleteMstHtmlCreator(){
			
			Map map = new HashMap();
			map.put("search","mhc_module = '"+getMhcmodule()+"'");
			creatorService.deleteGroup(map);
				
			msg = "<script>alert('删除成功！！');</script>";
			return submitQuery();
		}
		
		public String updateTips(){
			elementService.updateTips(getTips(), getMheids());
			return submitQuery();
		}
		
		
		
		public String getSpaceChar(int size){
			String space="";
		    for(int i=0;i<size;i++){
			   space =space+ "-";
			}
			return space;
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


		public MstHtmlCreator getCreator() {
			return creator;
		}


		public void setCreator(MstHtmlCreator creator) {
			this.creator = creator;
		}


		public MstHtmlElement getElement() {
			return element;
		}


		public void setElement(MstHtmlElement element) {
			this.element = element;
		}


		public String getMapno() {
			return mapno;
		}


		public void setMapno(String mapno) {
			this.mapno = mapno;
		}


		public String getMhcid() {
			return mhcid;
		}


		public void setMhcid(String mhcid) {
			this.mhcid = mhcid;
		}


		public String getMhcmodule() {
			return mhcmodule;
		}


		public void setMhcmodule(String mhcmodule) {
			this.mhcmodule = mhcmodule;
		}

		public String getTips() {
			return tips;
		}

		public void setTips(String tips) {
			this.tips = tips;
		}

		public String getMheids() {
			return mheids;
		}

		public void setMheids(String mheids) {
			this.mheids = mheids;
		}

}