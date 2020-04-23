package com.library.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.library.demo.controller.dao.BookEntity;
import com.library.demo.controller.exception.RecordNotFoundException;
import com.library.demo.controller.result.Result;
import com.library.demo.controller.services.BookService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/books")
public class BookController 
{	
	@Autowired
	private BookService bookService;
	
	/**
	 *  API to return list of books
	 *  
	 * @return
	 */
	@GetMapping
    public ResponseEntity<List<BookEntity>> getAllBooks() 
	{
        List<BookEntity> list = bookService.getAllBook(); 
        return new ResponseEntity<List<BookEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    /**
     *  API to return book by {id}
     *  
     * @param id - Book Id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable("id") int id)
    {
    	try
    	{
	    	BookEntity entity = bookService.getBookById(id); 
	        return new ResponseEntity<Object>(entity, new HttpHeaders(), HttpStatus.OK);
    	}
    	catch(RecordNotFoundException ex)
    	{
    		return new ResponseEntity<Object>(Result.BOOK_NOT_FOUND, new HttpHeaders(), HttpStatus.OK); 
    	}
    }    
    /**
     * API to create a new book
     * 
     * @param book
     * @return
     */
    @PostMapping 
    public ResponseEntity<Result> createBook(@RequestBody BookEntity book) {
    	 
    	Result updated = bookService.createOrUpdateBook(book);    	
        return new ResponseEntity<Result>(updated, new HttpHeaders(), HttpStatus.OK);
    } 
    
    /**
     * API to update existing book 
     * 
     * @param book
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Result> updateNewBook(@RequestBody BookEntity book, @PathVariable("id") int id) {
    	
    	book.setId(id);    	
    	Result updated = bookService.createOrUpdateBook(book);    	
        return new ResponseEntity<Result>(updated, new HttpHeaders(), HttpStatus.OK);
    } 
}