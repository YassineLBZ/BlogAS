package com.yltech.SABlog.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Post {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	private String title;
	@NotEmpty
	@Lob
	private String content;
	private Instant createdOn;
	private Instant updatedOn;
	@NotBlank
	private String username;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Instant getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}
	public Instant getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Instant updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
