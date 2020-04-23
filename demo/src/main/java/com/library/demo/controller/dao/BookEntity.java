package com.library.demo.controller.dao;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Book Info table Entity class
 *
 */

@Entity
@Table(name="book_info")
public class BookEntity implements Serializable
{
	private static final long serialVersionUID = -4436592196273644591L;

	public BookEntity()
	{	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="book_id", updatable = false)
	private Integer id;
	
	@Column(name="book_name", nullable=false)
	private String name;
	
	@Column(name="author_name", nullable=false)
	private String author;
		
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	@JoinColumn(name="library_id")
	@JsonBackReference
	private LibraryEntity library;
	
    //Create a builder of this
	public Integer getId() 
	{
		return (id == null)? 0 : id;
	}
	
	public void setId(Integer id) {
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

	
	public LibraryEntity getLibrary() {
		return library;
	}	
	
	public void setLibrary(LibraryEntity library) {
		this.library = library;
	}
}
