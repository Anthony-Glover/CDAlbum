package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artist 
{
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Artist () {}
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;	
	private String name;

}
