package com.questionnaire.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 问卷表/调查表entity
 * @author lph
 *
 */
public class Indagate {

	private int inda_id;
	private String inda_no;
	private String inda_title;
	private String inda_theme;
	private String inda_person;
	private String inda_start_time;
	private String inda_end_time;
	private String channelId;
	private List<Question> queslist = new ArrayList<Question>();
	
	
	

	public Indagate(){}
	
	public Indagate(int inda_id, String inda_no, String inda_title,
			String inda_theme, String inda_person, String inda_start_time,
			String inda_end_time, String channelId) {
		super();
		this.inda_id = inda_id;
		this.inda_no = inda_no;
		this.inda_title = inda_title;
		this.inda_theme = inda_theme;
		this.inda_person = inda_person;
		this.inda_start_time = inda_start_time;
		this.inda_end_time = inda_end_time;
		this.channelId = channelId;
	}
	
	public int getInda_id() {
		return inda_id;
	}
	public void setInda_id(int inda_id) {
		this.inda_id = inda_id;
	}
	public String getInda_no() {
		return inda_no;
	}
	public void setInda_no(String inda_no) {
		
		this.inda_no = inda_no;
	}
	public String getInda_title() {
		return inda_title;
	}
	public void setInda_title(String inda_title) {
		this.inda_title = inda_title;
	}
	public String getInda_theme() {
		return inda_theme;
	}
	public void setInda_theme(String inda_theme) {
		this.inda_theme = inda_theme;
	}
	public String getInda_person() {
		return inda_person;
	}
	public void setInda_person(String inda_person) {
		this.inda_person = inda_person;
	}
	public String getInda_start_time() {
		return inda_start_time;
	}
	public void setInda_start_time(String inda_start_time) {
		this.inda_start_time = inda_start_time;
	}
	public String getInda_end_time() {
		return inda_end_time;
	}
	public void setInda_end_time(String inda_end_time) {
		this.inda_end_time = inda_end_time;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public List<Question> getQueslist() {
		return queslist;
	}

	public void setQueslist(List<Question> queslist) {
		this.queslist = queslist;
	}
}
