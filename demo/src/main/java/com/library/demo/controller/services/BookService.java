package com.library.demo.controller.services;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.demo.controller.dao.BookEntity;
import com.library.demo.controller.exception.RecordNotFoundException;
import com.library.demo.controller.repository.BookRepository;
import com.library.demo.controller.result.Result;

/**
 * Defines different types of Book Service 
 *
 */
@Service
public class BookService {
	
    @Autowired
    BookRepository repository;
    
    /**
     * Return all available looks.
     * 
     * @return
     */
    public List<BookEntity> getAllBook()
    {
        List<BookEntity> books = repository.findAll();         
        if(!books.isEmpty())
        {
            return books;
        }
        
        return Collections.emptyList();        
    }
     
    /**
     * Returns particular book details as per input book {id}
     * 
     * @param id
     * @return
     * @throws RecordNotFoundException
     */
    public BookEntity getBookById(int id) throws RecordNotFoundException 
    {
        Optional<BookEntity> book = repository.findById(id);         
        if(book.isPresent())
        {
            return book.get();
        } 
        
        throw new RecordNotFoundException("No book exist for given book Id");        
    }
    
    /**
     *  Create and update existing Book
     *  
     * @param entity
     * @return
     */
    public Result createOrUpdateBook(BookEntity entity) 
    {
    	try 
    	{    		
	        Optional<BookEntity> book = repository.findById(entity.getId());  	        
	        if(book.isPresent()) 
	        {
	        	boolean isDirty = false;
	        	BookEntity newEntity = book.get();	        	
				if(Objects.nonNull(entity.getName()))
				{
				  newEntity.setName(entity.getName());
				  isDirty = true;
				}
				
				if(Objects.nonNull(entity.getAuthor()))
				{
				  newEntity.setAuthor(entity.getAuthor());
				  isDirty = true;
				}
				
				if(Objects.nonNull(entity.getLibrary()))
				{
				  newEntity.setLibrary(entity.getLibrary());
				  isDirty = true;
				}         
	          
	            entity = newEntity;
	            if(isDirty && Objects.nonNull(repository.save(entity)))
		        {
		        	return Result.UPDATED;
		        }
	            return Result.UPDATED;
	        }  
	        else
	        {
        	   if(Objects.nonNull(repository.save(entity)))
		        {
		        	return Result.SUCCESS;
		        }
	        }
    	} 
    	catch(RecordNotFoundException ex)
    	{
    		return Result.BOOK_NOT_FOUND;
    	}
    	return Result.FAILURE;
    }
}