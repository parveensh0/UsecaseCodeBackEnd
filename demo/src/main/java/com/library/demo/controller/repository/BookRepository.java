package com.library.demo.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.demo.controller.dao.BookEntity;

/**
 * Book specific CURD operation Jpa Repository
 * 
 */
@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

}
