package com.library.demo.controller.dao1;

import java.util.Set;
import java.io.Serializable;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="book")
public class LibraryEntity implements Serializable{
	
	private static final long serialVersionUID = -3913335609083602088L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="book_id", nullable=false)
	@OneToMany(targetEntity=LibraryEntity.class) 
	private Set<LibraryEntity> bookIds = new HashSet<>();	
}
