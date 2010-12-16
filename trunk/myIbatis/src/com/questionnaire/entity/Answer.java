package com.questionnaire.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Ñ¡Ïî/´ð°¸entity
 * @author lph
 *
 */
public class Answer {

	private int ans_id;
	private int ques_id;
	private String ans_content;
	private String ans_value;
	private String ans_description;
	public Answer(){}

	public Answer(int ans_id, int ques_id, String ans_content,
			String ans_value, String ans_description) {
		super();
		this.ans_id = ans_id;
		this.ques_id = ques_id;
		this.ans_content = ans_content;
		this.ans_value = ans_value;
		this.ans_description = ans_description;
	}
	
	public int getAns_id() {
		return ans_id;
	}
	public void setAns_id(int ans_id) {
		this.ans_id = ans_id;
	}
	public int getQues_id() {
		return ques_id;
	}
	public void setQues_id(int ques_id) {
		this.ques_id = ques_id;
	}
	public String getAns_content() {
		return ans_content;
	}
	public void setAns_content(String ans_content) {
		this.ans_content = ans_content;
	}
	public String getAns_value() {
		return ans_value;
	}
	public void setAns_value(String ans_value) {
		this.ans_value = ans_value;
	}
	public String getAns_description() {
		return ans_description;
	}
	public void setAns_description(String ans_description) {
		this.ans_description = ans_description;
	}
}
