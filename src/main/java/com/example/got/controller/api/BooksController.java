package com.example.got.controller.api;
import com.example.got.entity.Book;
import com.example.got.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.got.utils.Constants;

import java.util.List;

@RestController
public class BooksController {
	@Autowired
	BooksService booksService;

	@RequestMapping(Constants.GET_ALL_BOOKS_SELF_URL)
	public List<Book> getAllBooks() {
		return booksService.getAllBooks();
	}
	@RequestMapping(Constants.GET_DETAILS_OF_BOOK_SELF_URL)
	public Book getBook(@PathVariable String bookId){
		return booksService.getSelectedBook(bookId);
	}
}
