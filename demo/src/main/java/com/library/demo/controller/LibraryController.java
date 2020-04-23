package com.library.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.demo.controller.dao.LibraryEntity;
import com.library.demo.controller.exception.RecordNotFoundException;
import com.library.demo.controller.result.Result;
import com.library.demo.controller.services.LibraryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/libraries")
public class LibraryController
{
	@Autowired
	private LibraryService libraryService;	
	
	/**
	 * API to return list of libraries
	 * 
	 * @return all libraries.
	 */
	@GetMapping
    public ResponseEntity<List<LibraryEntity>> getLibraries() 
    {
		List<LibraryEntity> libbooks = libraryService.getAllLibrary();
        return new ResponseEntity<List<LibraryEntity>>(libbooks, new HttpHeaders(), HttpStatus.OK);
    }	
	
	/**
	 * API to return library details by library {id}
	 * 
	 * @param id - Library ID
	 * @return
	 */
	@GetMapping("/{id}")
    public ResponseEntity<Object> getLibraryBooksById(@PathVariable("id") Integer id)
    {	
		try
		{
			LibraryEntity libbooks = libraryService.getAllBookByLibraryId(id);
			return new ResponseEntity<Object>(libbooks, new HttpHeaders(), HttpStatus.OK);
		} 
		catch(RecordNotFoundException e)
		{
			return new ResponseEntity<Object>(Result.LIBRARY_NOT_FOUND, new HttpHeaders(), HttpStatus.NOT_FOUND);	
		}
    }	
}
