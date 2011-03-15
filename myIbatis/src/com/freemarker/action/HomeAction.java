package com.freemarker.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.framework.tool.Constants;
import jcx.util.datetime;

import com.framework.tool.BeanLocator;
import com.freemarker.dao.DirectoryDao;
import com.freemarker.dao.DiscouponDao;
import com.freemarker.dao.HomeDao;
import com.freemarker.dao.HtmlRightDao;
import com.freemarker.dao.MainDao;
import com.freemarker.entity.BDirectory;
import com.freemarker.entity.BHome;
import com.freemarker.entity.BMain;
import com.freemarker.entity.BUser;
import com.freemarker.entity.HtmlRight;
import com.freemarker.tool.Freemarker;
import com.freemarker.tool.MST_GUtil;
import com.freemarker.tool.MST_StringUtil;
import com.questionnaire.action.BaseAction;
import com.sun.corba.se.impl.orbutil.closure.Constant;



public class HomeAction extends BaseAction{

	private String msg;
	private BHome home;
	private String plogid;
	private String tlogid;
	private List<BHome> modulelist;
	private List<BHome> items;
	private List<BHome> places;
	HomeDao homedao = (HomeDao) BeanLocator.getBean("homeDao");
	DirectoryDao directorydao = (DirectoryDao)BeanLocator.getBean("directoryDao");
//	DiscouponDao discoupoDao = (DiscouponDao)BeanLocator.getBean("discouponDao");
//	HtmlRightDao htmlrightDao = (HtmlRightDao) BeanLocator.getBean("htmlrightDao");
//	MainDao maindao = (MainDao) BeanLocator.getBean("mainDao");
	
	/*
	 * 模板数据读取
	 */
	public String moduleMenu(){
		
		if (home.getMapno() == null || home.getMapno().equals(""))
			home.setMapno("21");
		if (home.getPlace() == 0)
			home.setPlace(1);
		int item = home.getItem();
		String module = home.getModule();
		String place = String.valueOf(home.getPlace());
		String mapno = home.getMapno();
		String title = home.getTitle();
		String url = home.getUrl();
		String key = home.getKey();
		String keyurl = home.getKeyurl();
		String img = home.getFilename();
		String desc = home.getDesc();
		String returntype = home.getReturntype();
		if (home.getItem() != 0){
			BHome b = homedao.initialValue(String.valueOf(home.getItem()));
			if (b != null){
				home = b;
				home.setCure(String.valueOf(Integer.parseInt(b.getPiccounts())*2));
				home.setTotal(String.valueOf(Integer.parseInt(b.getTxtcounts()) - Integer.parseInt(b.getPiccounts())));
				home.setItem(item);
				home.setPlace(Integer.parseInt(place));
				home.setModule(module);
				home.setMapno(mapno);
				home.setTitle(title);
				home.setKey(key);
				home.setKeyurl(keyurl);
				home.setUrl(url);
				home.setFilename(img);
				home.setDesc(desc);
				home.setReturntype(returntype);
				home.setType("0");
				places = new ArrayList<BHome>();
				for (int i=0;i<Integer.parseInt(home.getTxtcounts());i++){
					BHome bp = new BHome();
					bp.setPlace(Integer.parseInt(String.valueOf(i+1)));
					places.add(bp);
				}	
			}

			List piclist = (List)homedao.picInfo(String.valueOf(home.getItem()),home.getMapno(),home.getPiccounts());
			List txtlist = (List)homedao.txtInfo(String.valueOf(home.getItem()),home.getMapno());
			if (piclist != null && txtlist != null){
				for (int i=0;i<piclist.size();i++){
					BHome tb = (BHome)txtlist.get(i+Integer.parseInt(home.getPiccounts()));
					BHome pb = (BHome)piclist.get(i);
					if (tb.getKey() == null)
						tb.setKey("");
					if (pb.getKey() == null)
						pb.setKey("");
					if (tb.getTips() == null)
						tb.setTips("");
					if (pb.getTips() == null)
						pb.setTips("");
					if (tb.getFilename() == null)
						tb.setFilename("");
					if (pb.getFilename() == null)
						pb.setFilename("");
					if (tb.getTitle() != null){
						if (tb.getTitle().indexOf(",") != -1)
							tb.setStitle(tb.getTitle().substring(0, tb.getTitle().indexOf(",")));
						else
							tb.setStitle(tb.getTitle());
					}
					pb.setTitle(tb.getTitle());
					pb.setUrl(tb.getUrl());
					
				}
			}
			if (txtlist != null){
				for (int i=0;i<txtlist.size();i++){
					BHome tb = (BHome)txtlist.get(i);
					if (tb.getTitle() != null){
						if (tb.getTitle().indexOf(",") != -1)
							tb.setStitle(tb.getTitle().substring(0, tb.getTitle().indexOf(",")));
						else
							tb.setStitle(tb.getTitle());
					}
				}
			}
	
			getRequest().setAttribute("piclist",piclist);
			getRequest().setAttribute("txtlist",txtlist);
		}
		if (home.getReturntype().equals("HOME"))
			modulelist = (List)homedao.getModule();
		BUser bu = (BUser)getSession().getAttribute("SESSION_USER");
		System.out.println(home.getModule()+"============="+home.getMapno());
		items = (List)homedao.allItem("mhc_module = '"+home.getModule()+"' and b.mhe_name = 't1'",home.getMapno());
		System.out.println(items.size()+"=======================");
		return submitQuery();
	}

	/*
	 * 模板数据添加
	 */
	public String addRecommand(){

		if (!(home.getHot() == null || home.getHot().equals("")))
			homedao.setHot(home);
		if (!(home.getEffect() == null || home.getEffect().equals(""))){
			if (home.getEffect().equals("1"))
				home.setKey("<font style=color:#FF0000>"+ home.getKey() + "</font>");
			else if (home.getEffect().equals("2"))
				home.setKey("<b>" + home.getKey() + "</b>");
			
		}else {
			if (home.getKey() != null)
				home.setKey(home.getKey().replace("<span class=newDis>","").replace("</span>","").replace("<b>","").replace("</b>",""));
		}

		
		if ((home.getItem() > 1231 && home.getItem() < 1237) || home.getItem() == 1262 ){
			if (home.getUrl().indexOf("bbs.ddmap.com") != -1 && home.getUrl().indexOf("-1.htm") != -1){
				String bbsid = home.getUrl().replace("http://bbs.ddmap.com/"+home.getMapno()+"-","").replace("-1.htm","");
				System.out.println(bbsid);
			}
		}
		if (home.getUrl().indexOf("%") == -1)
			home.setUrl(URLEncoder.encode(home.getUrl()).replaceAll("%3A",":").replaceAll("%3F","?").replaceAll("%3D","=").replaceAll("%26","&").replaceAll("%7E","~").replaceAll("%2F","/"));
	
		homedao.setPic(home);
		homedao.settxt(home);
		homedao.setLog(home);
		
		home.setTitle("");
		home.setUrl("");
		home.setFilename("");
		home.setKey("");
		home.setKeyurl("");
		home.setDesc("");
		
		//System.out.println("update MST_HTML_ELEMENT set mhe_desc = "+home.getDesc()+",mhe_url = "+home.getFilename()+"where mhc_id = "+home.getItem()+" and mhe_mapno = "+home.getMapno()+" and and mhe_name = 'p"+home.getPlace()+"'");
		msg = "<script>alert('修改成功');</script>";
		return moduleMenu();
	}
	
	public String bringFileAll(){
		List itemlist = (List)homedao.allItem("mhc_module = '"+home.getModule()+"' and b.mhe_name = 't1'",home.getMapno());
		if (itemlist != null){
			for (int i=0;i<itemlist.size();i++){
				BHome bh = (BHome)itemlist.get(i);
				System.out.println(bh.getMhcid());
				contentSplice(String.valueOf(bh.getMhcid()),String.valueOf(bh.getMhcid()),home.getMapno());
			}
			//msg ="<script>alert('生成成功');</spript>";
		}
		return moduleMenu();
	}
	
	public String bringFile(){
		
		if (!(home.getSite() == null || home.getSite().equals(""))){
			String[] site = home.getSite().split(",");
			//同步生成
			if (site.length > 0){
				BHome b = homedao.initialValue(String.valueOf(home.getItem()));
				for (int i=0;i<site.length;i++){
					if (b.getMhcname().indexOf("(") != -1)
						b.setMhcname(b.getMhcname().substring(0,b.getMhcname().indexOf("("))+site[i]);
					else
						b.setMhcname(b.getMhcname()+site[i]);
					//System.out.println(b.getMhcname());
					BHome b2 = homedao.getMhcId(b.getMhcname());
					if(b2 != null)
						System.err.println(contentSplice(String.valueOf(home.getItem()),b2.getMhcid(),home.getMapno()));
				}
			}
		}
		msg = "<script>alert('" +contentSplice(String.valueOf(home.getItem()),String.valueOf(home.getItem()),home.getMapno())+ "');</script>";
		
		return moduleMenu();
	}
	/*
	 * 生成模板
	 */
	public String contentSplice(String contitem,String pathitem,String mapno){
		//System.out.println(home.getSite());
		String msg1 = "";
		String msg2 = "";
		List txtlist = homedao.txtList(mapno,contitem);
		List piclist = homedao.picList(mapno,contitem);
		BHome path = homedao.recommandPath(pathitem);
		int stencil = 1;
		//判断模板类型
		if (path.getUrl().indexOf(".ftl") != -1)
			stencil = 2;
		
		if (stencil == 1){
			String infilepath = "";
			if (path.getModule().equals("POIList专题")){
				infilepath = getRequest().getRealPath(path.getInpath()+"in_list_topic_v2.txt");
			}else if (path.getModule().equals("促销List专题")){
				infilepath = getRequest().getRealPath(path.getInpath()+"in_city_topic_v2.txt");
			}else{
				infilepath = getRequest().getRealPath(path.getInpath()+path.getUrl()+".txt");
			}
				//"D:/stencil/"+path.getUrl().trim()+".txt";
				//path.getInpath()+"/"+path.getUrl()+".txt";
			String outfilepath = "";
			if (path.getModule().indexOf("WAP") != -1)
				outfilepath = path.getOutpath()+mapno+"/"+path.getUrl().trim()+".jsp";
			else if (path.getMhcname().indexOf("Flash") != -1)
				outfilepath = path.getOutpath()+mapno+"/"+path.getUrl().trim()+".xml";
			else{
				if (path.getOuturl() == null || path.getOuturl().equals(""))
					outfilepath = path.getOutpath()+mapno+"/"+path.getUrl().trim()+".htm";
				else
					outfilepath = path.getOutpath()+mapno+"/"+path.getOuturl();
			}
				//"D:/life/"+path.getUrl().trim()+".htm";
				//path.getOutpath()+"/"+path.getMapno()+"/"+path.getUrl()+".htm";
			File infile = new File(infilepath.trim());
			BufferedReader br;
			try {
				if (path.getModule().indexOf("WAP") != -1)
					br = new BufferedReader(new InputStreamReader(new FileInputStream(infile),"UTF-8"));
				else 
					br = new BufferedReader(new InputStreamReader(new FileInputStream(infile),"GBK"));
				while((msg1= br.readLine()) != null){
					msg2 += msg1;
					msg2 = msg2 + "\n";
				}
				//System.out.println(msg2);
	
				//System.out.println("模版读入："+msg2);
				//处理图片
				if (piclist != null){
					for (int i=0;i<piclist.size();i++){
						BHome bp = (BHome)piclist.get(i);
						BHome bt = (BHome)txtlist.get(i);
						if (bt.getTitle() != null && bt.getTitle().indexOf(",") != -1){
							//System.out.println("2");
							String[] titles = bt.getTitle().split(",");
							msg2 = msg2.replaceAll("&t"+(i+1)+"&",titles[0]);
							msg2 = msg2.replaceAll("&alt"+(i+1)+"&",titles[0].replaceAll("<img src=http://img3.ddmapimg.com/pageimg/channel/camera.gif/>",""));
							for (int tsize=1;tsize<titles.length;tsize++){
								msg2 = msg2.replaceAll("&ts\\["+(tsize)+"\\]"+(i+1)+"&",titles[tsize]);
								//System.out.println("&ts["+(tsize)+"]"+(i+1)+"&");
							}
						}
						
						msg2 = msg2.replaceAll("&p"+(i+1)+"&",MST_StringUtil.transNullString(bp.getDesc()));
						msg2 = msg2.replaceAll("&pu"+(i+1)+"&",MST_StringUtil.transNullString(bp.getFilename()));
					}
				}
				//处理文本
				if (txtlist != null){
					if (home.getNum() == null || home.getNum().equals(""))
						msg2 = msg2.replaceAll("&num&",String.valueOf(txtlist.size()));
					else
						msg2 = msg2.replaceAll("&num&",home.getNum());
					for (int i=0;i<txtlist.size();i++){
						BHome bt = (BHome)txtlist.get(i);
						if (!MST_StringUtil.transNullString(bt.getTitle()).equals(""))
							bt.setTitle(bt.getTitle().replaceAll("\"", "”"));
						//附加统计代码
						if (!(path.getStat() == null || path.getStat().equals(""))){
							if (!(bt.getUrl() == null || bt.getUrl().equals(""))){
								if (bt.getUrl().indexOf("ddmap.com") != -1 || bt.getUrl().indexOf("mstmap50007") != -1 || bt.getUrl().indexOf("map/") != -1){
									if (bt.getUrl().indexOf("g_f=") == -1){
										bt.setUrl(bt.getUrl().trim());
										if (bt.getUrl().substring(bt.getUrl().length()-1).equals("/")){
											bt.setUrl(bt.getUrl()+"?"+path.getStat()+"_"+(i+1));
										}else if(bt.getUrl().indexOf("?") != -1){
											bt.setUrl(bt.getUrl()+"&"+path.getStat()+"_"+(i+1));
										}else if (bt.getUrl().indexOf("bbs.ddmap.com") != -1){
											bt.setUrl(bt.getUrl()+"&"+path.getStat()+"_"+(i+1));
										}else if (bt.getUrl().indexOf("&") != -1){
											bt.setUrl(bt.getUrl()+"&"+path.getStat()+"_"+(i+1));
										}else if (bt.getUrl().indexOf("#") != -1){
											bt.setUrl(bt.getUrl().substring(0, bt.getUrl().indexOf("#"))+"?"+path.getStat()+"_"+(i+1)+bt.getUrl().substring(bt.getUrl().indexOf("#"), bt.getUrl().length()));
										}else {
											bt.setUrl(bt.getUrl()+"?"+path.getStat()+"_"+(i+1));
										}
									}
								}
							}
						} 

	
						//bt.setKeyurl(""+bt.getKeyurl()+"\" target=\"_blank");
					//System.out.println("1");
						msg2 = msg2.replaceAll("&city&",mapno);
						msg2 = msg2.replaceAll("&alt"+(i+1)+"&",MST_StringUtil.transNullString(bt.getTitle()).trim());
						msg2 = msg2.replaceAll("&k"+(i+1)+"&",MST_StringUtil.transNullString(bt.getKey()).trim());
						msg2 = msg2.replaceAll("&ku"+(i+1)+"&",MST_StringUtil.transNullString(bt.getKeyurl()).trim());
						//判断内容是否为组装
						if (bt.getTitle() != null && bt.getTitle().indexOf(",") != -1){
							//System.out.println("2");
							String[] titles = bt.getTitle().split(",");
							msg2 = msg2.replaceAll("&t"+(i+1)+"&",titles[0]);
							msg2 = msg2.replaceAll("&alt"+(i+1)+"&",titles[0]);
							for (int tsize=1;tsize<titles.length;tsize++){
								msg2 = msg2.replaceAll("&ts\\["+(tsize)+"\\]"+(i+1)+"&",titles[tsize]);
								//System.out.println("&ts["+(tsize)+"]"+(i+1)+"&");
							}
						}else{
							//System.out.println(bt.getTitle());
							msg2 = msg2.replaceAll("&t"+(i+1)+"&",MST_StringUtil.transNullString(bt.getTitle())).trim();
						}
						if (path.getModule().indexOf("WAP") != -1){
							int of = 0;
							bt.setUrl(bt.getUrl().replaceAll("&","&amp;"));
							if (bt.getUrl().indexOf("?") != -1){
								 of = bt.getUrl().indexOf("?");
								 msg2 = msg2.replaceAll("&value"+(i+1)+"&",bt.getUrl().substring(of+1,bt.getUrl().length()));
								 bt.setUrl(bt.getUrl().substring(0,of));
							}else
								 msg2 = msg2.replaceAll("&value"+(i+1)+"&","");
									
						}
						if (bt.getUrl() != null)
							msg2 = msg2.replaceAll("&tu"+(i+1)+"&",bt.getUrl().trim());
	
						
						if (bt.getTitle() == null || bt.getTitle().equals(""))
							msg2 = msg2.replaceAll("&t"+(i+1)+"&","");
						if (bt.getUrl() == null || bt.getUrl().equals(""))
							msg2 = msg2.replaceAll("&tu"+(i+1)+"&","");
						if (!(MST_StringUtil.transNullString(bt.getHot()).equals("") || MST_StringUtil.transNullString(bt.getHot()).equals("0"))){
							msg2 = msg2.replaceAll("&h"+(i+1)+"&","<font style=color:#"+MST_StringUtil.transNullString(bt.getHot())+">");
							msg2 = msg2.replaceAll("&ot"+(i+1)+"&","</font>");
							msg2 = msg2.replaceAll("&hot"+(i+1)+"&","class='hotfont'");
							msg2 = msg2.replaceAll("&new"+(i+1)+"&","<img src=\"http://img1.ddmapimg.com/pageimg/dm/new.gif\"/>");
							if (bt.getHot().equals("bold"))
								msg2 = msg2.replaceAll("&bold"+(i+1)+"&","style=\"font-weight:bold;\"");
							else
								msg2 = msg2.replaceAll("&color"+(i+1)+"&","style=color:#"+MST_StringUtil.transNullString(bt.getHot())+"");
	
						}else{
							msg2 = msg2.replaceAll("&h"+(i+1)+"&","");
							msg2 = msg2.replaceAll("&ot"+(i+1)+"&","");
							msg2 = msg2.replaceAll("&hot"+(i+1)+"&","");
							msg2 = msg2.replaceAll("&new"+(i+1)+"&","");
							msg2 = msg2.replaceAll("&color"+(i+1)+"&","");
							msg2 = msg2.replaceAll("&bold"+(i+1)+"&","");
	
						}
					}
				}
	
					
					File outfile = new File(outfilepath);
					FileOutputStream fos = new FileOutputStream(outfile);
				//	System.out.println("模版输出："+msg2);
					if (path.getModule().indexOf("WAP") != -1)
						fos.write(msg2.getBytes("UTF-8"));
					else
						fos.write(msg2.getBytes("GBK"));
					
					fos.close();
					br.close();
	
	
				
			} catch (FileNotFoundException e) {
				
				return e.toString();
			} catch (IOException e) {
	
				return e.toString();
			}
			if (!(home.getPlogid() == null || home.getPlogid().equals(""))){
				String[] p = home.getPlogid().trim().split(",");
				directory(p,"2","0");
			}
			if (!(home.getTlogid() == null || home.getTlogid().equals(""))){
				String[] t = home.getTlogid().trim().split(",");
				directory(t,"1","0");
				//System.out.println("长度："+element.size());
			}
		}else if (stencil == 2){
			if (txtlist != null){
				for (int i=0;i<txtlist.size();i++){
					BHome bt = (BHome)txtlist.get(i);
				//	BHome bp = (BHome)piclist.get(i);
				//	bt.setDesc(bp.getDesc());
				//	bt.setFilename(bp.getFilename());
					if (!(path.getStat() == null || path.getStat().equals(""))){
						if (!(bt.getUrl() == null || bt.getUrl().equals(""))){
							if (bt.getUrl().indexOf("ddmap.com") != -1 || bt.getUrl().indexOf("mstmap50007") != -1 || bt.getUrl().indexOf("map/") != -1){
								if (bt.getUrl().indexOf("g_f=") == -1){
									bt.setUrl(bt.getUrl().trim());
									if (bt.getUrl().substring(bt.getUrl().length()-1).equals("/")){
										bt.setUrl(bt.getUrl()+"?"+path.getStat()+"_"+(i+1));
									}else if(bt.getUrl().indexOf("?") != -1){
										bt.setUrl(bt.getUrl()+"&"+path.getStat()+"_"+(i+1));
									}else if (bt.getUrl().indexOf("bbs.ddmap.com") != -1){
										bt.setUrl(bt.getUrl()+"&"+path.getStat()+"_"+(i+1));
									}else if (bt.getUrl().indexOf("&") != -1){
										bt.setUrl(bt.getUrl()+"&"+path.getStat()+"_"+(i+1));
									}else if (bt.getUrl().indexOf("#") != -1){
										bt.setUrl(bt.getUrl().substring(0, bt.getUrl().indexOf("#"))+"?"+path.getStat()+"_"+(i+1)+bt.getUrl().substring(bt.getUrl().indexOf("#"), bt.getUrl().length()));
									}else {
										bt.setUrl(bt.getUrl()+"?"+path.getStat()+"_"+(i+1));
									}
								}
							}
						}
					} 
					if (bt.getTitle() == null)
						bt.setTitle("");
					if (bt.getTitle().indexOf(",") != -1){
						String[] ts = bt.getTitle().split(",");
						bt.setTitle(ts[0]);
						if (ts.length > 1)
							bt.setCol1(ts[1]);
						if (ts.length > 2)
							bt.setCol2(ts[2]);
						if (ts.length > 3)
							bt.setCol3(ts[3]);
						if (ts.length > 4)
							bt.setCol4(ts[4]);
						if (ts.length > 5)
							bt.setCol5(ts[5]); 
					}
					
				}
			}
			if (piclist != null){
				for (int i=0;i<piclist.size();i++){
					BHome bp = (BHome)piclist.get(i);
					BHome bt = (BHome)txtlist.get(i);
					bp.setTitle(bt.getTitle());
					bp.setUrl(bt.getUrl());
					bp.setKey(bt.getKey());
					bp.setKeyurl(bt.getKeyurl());
				}
			}
			Map map = new HashMap();
			map.put("piclist",piclist);
			map.put("txtlist",txtlist);
			map.put("stat",path.getStat());
			String outurl = "";
			if (path.getOuturl() == null || path.getOuturl().equals(""))
				outurl = path.getUrl().replaceAll("ftl","htm").trim();
			else
				outurl = path.getOuturl();
			Freemarker.create(getRequest().getRealPath(path.getInpath()),path.getUrl(), map,path.getOutpath()+mapno+"/"+outurl);	
		}
		return "生成成功";
	}
	
	
	
	
	public String published(){
		if (!(getPlogid() == null || getPlogid().equals(""))){
			String[] p = getPlogid().trim().split(",");
			directory(p,"2","1");
		}
		if (!(getTlogid() == null || getTlogid().equals(""))){
			String[] t = getTlogid().trim().split(",");
			directory(t,"1","1");
		}

		
		BHome b = homedao.initialValue(String.valueOf(home.getItem()));
		if (home.getReturntype().equals("DDSH")){
			msg = "<script>window.open('http://app.ddmap.com/htmlgenerator.jsp?mapId=21&type=ddsh');</script>";
		}else if (home.getReturntype().equals("DDSHHOME")){
			MST_GUtil.getUrlData("http://172.16.1.17/publish_index.jsp");
			msg = "<script>alert('发布成功');</script>";
		}else if (home.getReturntype().indexOf("CHANNEL") != -1 || home.getReturntype().equals("MARRY")){
			String filename = "index.htm";
			File outfile = new File((String)getSession().getServletContext().getAttribute(home.getReturntype().replaceAll("CHANNEL","").toLowerCase()+"createpath")+"21/"+filename);
			String testlink = (String)getSession().getServletContext().getAttribute(home.getReturntype().replaceAll("CHANNEL","").toLowerCase()+"testlink");
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(outfile);
				fos.write(download(testlink,"GBK").getBytes("GBK"));
				fos.close();
				msg = "<script>alert('发布成功');</script>";
			} catch (FileNotFoundException e) {
				msg = "<script>alert('"+e.toString()+"');</script>";
				return msg;
			} catch (UnsupportedEncodingException e) {
				msg = "<script>alert('"+e.toString()+"');</script>";
				return msg;
			} catch (IOException e) {
				msg = "<script>alert('"+e.toString()+"');</script>";
				return msg;
			}

		}else{
			if (home.getItem() == 64)
				MST_GUtil.getUrlData(b.getPublished()+"g_topic_sysc.jsp?option=sync&topic_url=in_hot_path&item=2&g_mapid="+home.getMapno()+"&type=1");
			else if (home.getItem() > 1324 && home.getItem() < 1330)
				MST_GUtil.getUrlData(b.getPublished()+"g_topic_sysc.jsp?option=sync&topic_url=in_list_coupon_&item=2&g_mapid="+home.getMapno()+"&type=1");
			if (b != null)
				MST_GUtil.getUrlData(b.getPublished()+"g_topic_sysc.jsp?option=sync&topic_url="+b.getMhcurl().replaceAll(".ftl","")+"&item=2&g_mapid="+home.getMapno()+"&type=1");
			else 
				System.out.println("为空！！！！");

			msg = "<script>alert('发布成功');</script>";
		}
		
		return moduleMenu();
	}
	
	public void autoPublished(){
		String filename = "in_idx_channel_ganji.htm";
		File outfile =  new File("/ddmap/26_ddmapindex_rec/21/"+filename);
		String testlink = "http://test.ddmap.com:81/mstmap50007/ganji_index.jsp";
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outfile);
			fos.write(download(testlink,"GBK").getBytes("GBK"));
			fos.close();
			BHome b = homedao.initialValue("711");
			MST_GUtil.getUrlData(b.getPublished()+"g_topic_sysc.jsp?option=sync&topic_url="+b.getMhcurl()+"&item=2&g_mapid=21&type=1");
			System.out.println("自动发布成功！！");
		} catch (FileNotFoundException e) {
			System.out.println("自动发布失败");
			e.printStackTrace();
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("自动发布失败");
			e.printStackTrace();
			
		} catch (IOException e) {
			System.out.println("自动发布失败");
			e.printStackTrace();
			
		}
		
	}

	
	public void directory(String[] l,String dtype,String status){
	
		//String[] c = home.getChannel().split(",");
		
		String[] p = home.getProf().split(",");
		String[] n = home.getNotes().split(",");
		String tlogid = "";
		String plogid = "";
		for (int i=0;i<l.length;i++){
			tlogid += "'t"+l[i].trim()+"'";
			if (dtype.equals("2"))
				plogid += "'p"+l[i].trim()+"'";
			if (i < l.length-1){
				tlogid+=",";
				if (dtype.equals("2"))
					plogid+=",";
			}
		}
		
		List element = homedao.getElement(home.getMapno(),String.valueOf(home.getItem()),tlogid.trim());
		List element2 = null;
		if (dtype.equals("2")){
			element2 = homedao.getElement(home.getMapno(),String.valueOf(home.getItem()),plogid.trim());
		}

	
		for (int i=0;i<element.size();i++){
			String log = l[i].trim();
			BHome tb = (BHome)element.get(i);
			if (tb.getUrl().indexOf("app.ddmap.com") != -1){
				tb.setChannel("S");
			}else if (tb.getUrl().indexOf("wenba.ddmap.com") != -1){
				tb.setChannel("W");
			}else if (tb.getUrl().indexOf("bbs.ddmap.com") != -1){
				tb.setChannel("B");
			}else if (tb.getUrl().indexOf("city.ddmap.com") != -1){
				tb.setChannel("C");
			}else {
				tb.setChannel("O");
			}
			
			tb.setProf(p[Integer.parseInt(log)-1].trim());
			tb.setNotes(n[Integer.parseInt(log)-1].trim());
		
			tb.setStatus(status);
			tb.setTime(datetime.getTime("YYYY/mm/dd h:m:s"));
			if (dtype.equals("2")){
				BHome pb = (BHome)element2.get(i);
				tb.setMheid(pb.getMheid());
				tb.setMhename(pb.getMhename());
				tb.setDesc(pb.getTitle());
				tb.setFilename(pb.getUrl());
			}
			BHome logb = homedao.getDirectory(tb.getMheid());
			if (logb == null)
				homedao.setDirectory(tb);
			else 
				homedao.setDirectoryStatus(logb.getTlogid());
				
		}
	}
	
	public void initElementByFName(int mhcid,int psize,int tsize,String mapno){
		   String[] imgs = {"http://img4.ddmapimg.com/topic/1239875426562_14.jpg",
					 "http://img4.ddmapimg.com/topic/1240284272125_29.jpg",
					 "http://img4.ddmapimg.com/topic/1240887745437_31.jpg",
					 "http://img4.ddmapimg.com/topic/1239875459281_93.jpg",
					 "http://img4.ddmapimg.com/topic/1239875467484_27.jpg",
					 "http://img4.ddmapimg.com/topic/1239875476406_48.jpg",
					 "http://img4.ddmapimg.com/topic/1239875484890_44.jpg",
					 "http://img4.ddmapimg.com/topic/1239875494968_33.jpg",};
			   int j = 0;
		for (int i=1;i<psize+1;i++){
			BHome b = new BHome();
			b.setMhcid(String.valueOf(mhcid));
			b.setMhename("p"+i);
			b.setDesc("测试"+i);
			
			b.setKey("关键"+i);
			b.setUrl("http://www.ddmap.com");
			b.setUrl(imgs[j]);
			b.setMapno(mapno);
			homedao.initElementByFName(b);
			if (j < 7)
				j++;
			else 
				j = 0;
		}
		for (int i=1;i<tsize+1;i++){
			BHome b = new BHome();
			b.setMhcid(String.valueOf(mhcid));
			b.setMhename("t"+i);
			b.setDesc("标题"+i);
			System.out.println(b.getDesc());
			//b.setDesc("标题"+i);
			b.setKey("关键"+i);
			b.setUrl("http://www.ddmap.com");
			b.setMapno(mapno);
			homedao.initElementByFName(b);
			
		}
	}
	
	public void upElementByFName(String mhcid,int psize,int tsize){
	   String[] imgs = {"http://img4.ddmapimg.com/topic/1239875426562_14.jpg",
			 "http://img4.ddmapimg.com/topic/1240284272125_29.jpg",
			 "http://img4.ddmapimg.com/topic/1240887745437_31.jpg",
			 "http://img4.ddmapimg.com/topic/1239875459281_93.jpg",
			 "http://img4.ddmapimg.com/topic/1239875467484_27.jpg",
			 "http://img4.ddmapimg.com/topic/1239875476406_48.jpg",
			 "http://img4.ddmapimg.com/topic/1239875484890_44.jpg",
			 "http://img4.ddmapimg.com/topic/1239875494968_33.jpg",};
	   int j = 0;
		for (int i=1;i<tsize+1;i++){
			//homedao.upElementByFName("标题"+i,"http://www.ddmap.com"+i,mhcid,"t"+i);
			//System.out.println();
		}
		for (int i=1;i<psize+1;i++){
			//homedao.upElementByFName("",imgs[j],mhcid,"p"+i);
			if (j < 7)
				j++;
			else 
				j = 0;
		}
	}
	
	public String BBSFunction(){
		List txtlist = homedao.txtList(home.getMapno(),String.valueOf(home.getItem()));
		List piclist = homedao.picList(home.getMapno(),String.valueOf(home.getItem()));
		if (txtlist != null){
			for (int i=0;i<txtlist.size();i++){
				BHome h= (BHome)txtlist.get(i);
				h.setMapno(home.getMapno());
				h.setPlace(Integer.parseInt(h.getMhename().substring(1)));
				h.setItem(1232);
				homedao.settxt(h);
				
			}
		}
		if (piclist != null){
			for (int i=0;i<piclist.size();i++){
				BHome h= (BHome)piclist.get(i);
				h.setMapno(home.getMapno());
				h.setPlace(Integer.parseInt(h.getMhename().substring(1)));
				h.setItem(1232);
				homedao.setPic(h);
			}
		}
		msg = "<script>alert('操作成功');</script>";
		
		return moduleMenu();
	}
	
	public String Initial(){
		Map map = new HashMap();
		map.put("rows","mhc_id");
		map.put("search","mhc_module = '"+home.getModule()+"'");
		List itemlist = homedao.list(map);
		HomeAction home = new HomeAction();
		//home.initElementByFName("466",16,16,"21");
		if (itemlist != null){
			for (int i=0;i<itemlist.size();i++){
				BHome items = (BHome)itemlist.get(i);
				BHome b = homedao.initialValue(items.getMhcid());
				if ( b != null){
					List txtlist = homedao.txtList("21",items.getMhcid());
					if (txtlist.size()==0){
						home.initElementByFName(Integer.parseInt(items.getMhcid()),Integer.parseInt(b.getPiccounts()),Integer.parseInt(b.getTxtcounts()),"21");
						System.out.println(items.getMhcid());
					}
				}
			}

		}
		return moduleMenu();
	}
	

	
	public String homeEditor(){
		List adirectorylist = directorydao.getDirectoryeList("logid = "+home.getLogid()+"","med_ctime","0");
		if (adirectorylist != null){
			BDirectory b = (BDirectory)adirectorylist.get(0);
			home.setTitle(b.getTitle());
			home.setUrl(b.getUrl());
			home.setFilename(b.getImgurl());
			home.setDesc(b.getDesc());
			home.setKey(b.getKey());
			home.setKeyurl(b.getKeyurl());
			home.setItem(Integer.parseInt(b.getMhcid()));
			home.setPlace(Integer.parseInt(b.getMhename().replaceAll("p","").replaceAll("t","")));
			//System.out.println("fdkflsdjk"+b.getMhcid());
			if (home.getReturntype().equals("HOME"))
				home.setModule("新版首页");
			else if (home.getReturntype().equals("DDSH"))
				home.setModule("新版盯盯");
			
		}
		return moduleMenu();
	}
	
	public static String download(String link,String code){
		
		try {
			StringBuffer html = new StringBuffer();
			URL url = new URL(link);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStreamReader in = new InputStreamReader(conn.getInputStream(),code);
			BufferedReader r = new BufferedReader(in);
			String c;
			while ((c = r.readLine()) != null) {
				html.append(c).append("\n");
			}
			r.close();
			in.close();
			return html.toString();
			
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public String submitQuery(){
		
		return home.getReturntype();
	}
	
	public BHome getHome() {
		return home;
	}
	public void setHome(BHome home) {
		this.home = home;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<BHome> getModulelist() {
		return modulelist;
	}

	public void setModulelist(List<BHome> modulelist) {
		this.modulelist = modulelist;
	}


	public List<BHome> getItems() {
		return items;
	}


	public void setItems(List<BHome> items) {
		this.items = items;
	}


	public List<BHome> getPlaces() {
		return places;
	}


	public void setPlaces(List<BHome> places) {
		this.places = places;
	}


	public String getPlogid() {
		return plogid;
	}

	public void setPlogid(String plogid) {
		this.plogid = plogid;
	}

	public String getTlogid() {
		return tlogid;
	}

	public void setTlogid(String tlogid) {
		this.tlogid = tlogid;
	}




}
