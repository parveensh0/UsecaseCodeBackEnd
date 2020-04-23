package com.library.demo.controller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.demo.controller.dao.LibraryEntity;
import com.library.demo.controller.exception.RecordNotFoundException;
import com.library.demo.controller.repository.LibraryRepository;

/**
 * Defines different types of Library Service 
 *
 */
@Service
public class LibraryService {
	 
	  @Autowired
	  private LibraryRepository repository;
	 
	 /**
	  * Returns all library information
	  *  
	  * @return
	  * @throws RecordNotFoundException
	  */
	 public List<LibraryEntity> getAllLibrary() 
     {
    	return repository.findAll(); 	        	               
	 }

	/**
     * Returns particular library information as per input library {id}
     * 
     * @param id
     * @return
     * @throws RecordNotFoundException
     */
    public LibraryEntity getAllBookByLibraryId(Integer id) throws RecordNotFoundException 
    {
        Optional<LibraryEntity> library = repository.findById(id);         
        if(library.isPresent())
        {
            return library.get();
        } 
        
        throw new RecordNotFoundException("No book exist for given book Id");        
    }   
}
