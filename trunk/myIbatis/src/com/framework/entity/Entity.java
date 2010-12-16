package com.framework.entity;

/**
 * NamedEntity
 * 
 * @author kim
 * 
 */
public class Entity {
	public String getEntityName() {
		return this.getClass().getName();
	}

}