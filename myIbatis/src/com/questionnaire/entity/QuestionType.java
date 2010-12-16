package com.questionnaire.entity;

/**
 * 问题类型entity
 * @author lph
 *
 */
public class QuestionType {

	private int quest_id;
	private String quest_type;
	private String quest_description;
	
	public QuestionType(){}
	
	public QuestionType(int quest_id, String quest_type, String quest_description){
		this.quest_id = quest_id;
		this.quest_type = quest_type;
		this.quest_description = quest_description;
	}
	
	
	public int getQuest_id() {
		return quest_id;
	}
	public void setQuest_id(int quest_id) {
		this.quest_id = quest_id;
	}
	public String getQuest_type() {
		return quest_type;
	}
	public void setQuest_type(String quest_type) {
		this.quest_type = quest_type;
	}
	public String getQuest_description() {
		return quest_description;
	}
	public void setQuest_description(String quest_description) {
		this.quest_description = quest_description;
	}
}
