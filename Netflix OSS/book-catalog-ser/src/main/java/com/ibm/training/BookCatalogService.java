package com.ibm.training;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCatalogService {
	
	@Autowired
	BookRepository repo;
	
	List<Book> getBooks(){
		return (List<Book>) repo.findAll();
	}

	public void addBook(Book book) {
		repo.save(book);
	}

	public Optional<Book> getBookByID(int id) {
		return repo.findById(id);
	}


}
