package com.questionnaire.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 问卷调查结果entity
 * @author lph
 *
 */
public class IndagateResult {

	private int indar_id;
	private int inda_id;
	private int ques_id;
	private int ans_id;
	private String indar_no;
	private String indar_person;
	private String indar_start_time;
	private String indar_end_time;
	private int indar_time;
	private Indagate indagate = new Indagate();
	private List<Question> rqueslist = new ArrayList<Question>();
	
	
	
	public IndagateResult(){}
	
	public IndagateResult(int indar_id, int inda_id, int ques_id, int ans_id,
			String indar_no, String indar_person, String indar_start_time,
			String indar_end_time, int indar_time) {
		super();
		this.indar_id = indar_id;
		this.inda_id = inda_id;
		this.ques_id = ques_id;
		this.ans_id = ans_id;
		this.indar_no = indar_no;
		this.indar_person = indar_person;
		this.indar_start_time = indar_start_time;
		this.indar_end_time = indar_end_time;
		this.indar_time = indar_time;
	}
	
	
	public int getIndar_id() {
		return indar_id;
	}
	public void setIndar_id(int indar_id) {
		this.indar_id = indar_id;
	}
	public int getInda_id() {
		return inda_id;
	}
	public void setInda_id(int inda_id) {
		this.inda_id = inda_id;
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
	public String getIndar_no() {
		return indar_no;
	}
	public void setIndar_no(String indar_no) {
		this.indar_no = indar_no;
	}
	public String getIndar_person() {
		return indar_person;
	}
	public void setIndar_person(String indar_person) {
		this.indar_person = indar_person;
	}
	public String getIndar_start_time() {
		return indar_start_time;
	}
	public void setIndar_start_time(String indar_start_time) {
		this.indar_start_time = indar_start_time;
	}
	public String getIndar_end_time() {
		return indar_end_time;
	}
	public void setIndar_end_time(String indar_end_time) {
		this.indar_end_time = indar_end_time;
	}
	public int getIndar_time() {
		return indar_time;
	}
	public void setIndar_time(int indar_time) {
		this.indar_time = indar_time;
	}

	public Indagate getIndagate() {
		return indagate;
	}

	public void setIndagate(Indagate indagate) {
		this.indagate = indagate;
	}

	public List<Question> getRqueslist() {
		return rqueslist;
	}

	public void setRqueslist(List<Question> rqueslist) {
		this.rqueslist = rqueslist;
	}
}
