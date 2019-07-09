package com.example.got.service;

import java.util.List;
import com.example.got.entity.Book;

public interface BooksService {
    List<Book> getAllBooks();
    Book getSelectedBook(String bookId);
}
