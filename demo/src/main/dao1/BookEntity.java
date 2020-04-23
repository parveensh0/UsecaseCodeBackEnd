package com.library.demo.controller.dao1;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class BookEntity implements Serializable
{
	private static final long serialVersionUID = -1268742613509314712L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="author_name")
	private String author;

	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
//Create a builder of this
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
