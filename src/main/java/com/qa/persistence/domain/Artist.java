package com.qa.persistence.domain;

import javax.persistence.Entity;

@Entity
public class Artist 
{
	public Long getParentID() {
		return parentID;
	}

	public void setParentID(Long parentID) {
		this.parentID = parentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Artist () {}
	
	private String name;
	private Long parentID;
}
