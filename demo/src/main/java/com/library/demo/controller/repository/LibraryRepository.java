package com.library.demo.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.demo.controller.dao.LibraryEntity;

/**
 * Library specific CURD operation Jpa Repository
 * 
 */
@Repository
public interface LibraryRepository extends JpaRepository<LibraryEntity, Integer> {

}
