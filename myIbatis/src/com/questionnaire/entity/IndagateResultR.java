package com.questionnaire.entity;

public class IndagateResultR {
	private int indarr_id;
	private int indar_id;
	private int ques_id;
	private int ans_id;
	
	private Answer answer = new Answer();
	public int getIndarr_id() {
		return indarr_id;
	}
	public void setIndarr_id(int indarr_id) {
		this.indarr_id = indarr_id;
	}
	public int getIndar_id() {
		return indar_id;
	}
	public void setIndar_id(int indar_id) {
		this.indar_id = indar_id;
	}
	public int getQues_id() {
		return ques_id;
	}
	public void setQues_id(int ques_id) {
		this.ques_id = ques_id;
	}
	public int getAns_id() {
		return ans_id;
	}
	public void setAns_id(int ans_id) {
		this.ans_id = ans_id;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
}
