package com.library.demo.controller.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.library.demo.controller.repository.BookRepository;
import com.library.demo.controller.repository.LibraryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookEntityTest {
	 @Autowired
	 BookRepository bookRepository;
	 
	 @Autowired
	 LibraryRepository libRepository;
	 
	 BookEntity myBook;
	 
	 @Before
	 public void createData()
	 {
		 LibraryEntity library = new LibraryEntity();
		 library.setName("Delhi Library");
		   
		 myBook = new BookEntity();
		 myBook.setName("Food Festival");
		 myBook.setAuthor("Ran vijay");
		 myBook.setLibrary(library);
	 }
	 
	 @After
	 public void clearData()
	 {
		 myBook = null;
	 }
	 
	 @Test
	 public void createBookEntity()
	 {
	     BookEntity expectedBook = bookRepository.save(myBook);
		 
		 assertNotNull(expectedBook);
		 assertThat(expectedBook.getId()).isGreaterThan(0);
		 assertThat(myBook.getName()).isEqualTo(expectedBook.getName());
		 
		 assertNotNull(expectedBook.getLibrary());
		 assertThat(expectedBook.getLibrary().getId()).isGreaterThan(0);
		 assertThat(expectedBook.getLibrary().getName()).isEqualTo(myBook.getLibrary().getName());
	 }	 
	 
	@Test
	 public void updateBookEntity()
	 {
		 BookEntity bookEntity = bookRepository.save(myBook);
		 
		 assertNotNull(bookEntity);
		 assertThat(bookEntity.getId()).isGreaterThan(0);
		 assertThat(myBook.getName()).isEqualTo(bookEntity.getName());
		 
		 assertNotNull(bookEntity.getLibrary());
		 assertThat(bookEntity.getLibrary().getId()).isGreaterThan(0);
		
		 BookEntity newBookEntity = new BookEntity();		 
		 newBookEntity.setName("Food Festival1");
		 newBookEntity.setAuthor("French");
		 newBookEntity.setLibrary(bookEntity.getLibrary());
		 newBookEntity.setId(bookEntity.getId());
		 
		 BookEntity expectedBook = bookRepository.save(newBookEntity);
		 
		 assertNotNull(expectedBook);
		 assertThat(bookEntity.getId()).isEqualTo(expectedBook.getId());
		 assertThat(newBookEntity.getName()).isEqualTo(expectedBook.getName());
		 assertThat(newBookEntity.getAuthor()).isEqualTo(expectedBook.getAuthor());
		 
		 assertNotNull(expectedBook.getLibrary());
	 }
	 
	 @Test
	 public void getBookEntity()
	 {
		 BookEntity bookEntity = bookRepository.save(myBook);
		 
		 assertNotNull(bookEntity);
		 assertThat(bookEntity.getId()).isGreaterThan(0);
		 assertThat(myBook.getName()).isEqualTo(bookEntity.getName());
		 
		 Optional<BookEntity> optionalBookEntity = bookRepository.findById(bookEntity.getId());
		 
		 assertNotNull(optionalBookEntity.get());
		 assertThat(optionalBookEntity.get()).isEqualTo(bookEntity);
	 }
}