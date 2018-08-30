package com.qa.persistence.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CD 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String title;
	
	@OneToMany(
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
    private Collection<Artist> artists;
	
	public CD() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Collection<Artist> getArtists() {
		return artists;
	}

	public void setArtists(Collection<Artist> artists) {
		this.artists = artists;
	}
}
