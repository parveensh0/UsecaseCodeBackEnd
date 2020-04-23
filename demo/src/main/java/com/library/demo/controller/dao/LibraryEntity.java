package com.library.demo.controller.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *  Library Info Table Entity Bean 
 *
 */
@Entity
@Table(name="library_info")
public class LibraryEntity implements Serializable
{	
	private static final long serialVersionUID = 7256909465987524174L;

	public LibraryEntity() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="library_id", updatable = false)
	private Integer id;
	
	@Column(name="library_name",nullable=false)
	private String name;
	
	@OneToMany(mappedBy = "library", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonManagedReference	
	private List<BookEntity> books;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(List<BookEntity> books) {
		this.books = books;
	}	
}
