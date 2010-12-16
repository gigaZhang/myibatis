package com.questionnaire.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Œ Ã‚entity
 * @author lph
 *
 */
public class Question {
 
	private int ques_id;
	private int inda_id;
	private int quest_id;
	private String ques_no;
	private String ques_content;
	private String ques_description;
	private List<Answer> ansList = new ArrayList<Answer>();
	private int ansArray[] ;
	

	public Question(){}
	
	public Question(int ques_id, int inda_id, int quest_id, String ques_no,
			String ques_content, String ques_description) {
		super();
		this.ques_id = ques_id;
		this.inda_id = inda_id;
		this.quest_id = quest_id;
		this.ques_no = ques_no;
		this.ques_content = ques_content;
		this.ques_description = ques_description;
	}
	public int getQues_id() {
		return ques_id;
	}
	public void setQues_id(int ques_id) {
		this.ques_id = ques_id;
	}
	public int getInda_id() {
		return inda_id;
	}
	public void setInda_id(int inda_id) {
		this.inda_id = inda_id;
	}
	public int getQuest_id() {
		return quest_id;
	}
	public void setQuest_id(int quest_id) {
		this.quest_id = quest_id;
	}
	public String getQues_no() {
		return ques_no;
	}
	public void setQues_no(String ques_no) {
		this.ques_no = ques_no;
	}
	public String getQues_content() {
		return ques_content;
	}
	public void setQues_content(String ques_content) {
		this.ques_content = ques_content;
	}
	public String getQues_description() {
		return ques_description;
	}
	public void setQues_description(String ques_description) {
		this.ques_description = ques_description;
	}

	public List<Answer> getAnsList() {
		return ansList;
	}

	public void setAnsList(List<Answer> ansList) {
		this.ansList = ansList;
	}

	public int[] getAnsArray() {
		return ansArray;
	}

	public void setAnsArray(int[] ansArray) {
		this.ansArray = ansArray;
	}



	
	
}
