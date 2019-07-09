package com.example.got.service.impl;

import java.util.Arrays;
import java.util.List;

import com.example.got.entity.Book;
import com.example.got.service.BooksService;
import com.example.got.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class BooksServiceimpl implements BooksService {
    @Autowired
    RestTemplate restTemplate;

    HttpEntity<String> reqEntity;

    public BooksServiceimpl() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 "+
                "(Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, "+
                "like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        reqEntity = new HttpEntity<String>("parameters", headers);

    }


    @Override
    public List<Book> getAllBooks() {
        ResponseEntity<List<Book>> response = restTemplate.exchange(
                Constants.GET_ALL_BOOKS_TARGET_URL,
                HttpMethod.GET,
                reqEntity,
                new ParameterizedTypeReference<List<Book>>() {
                });
        return response.getBody();

    }
    @Override
    public Book getSelectedBook(String bookId){

        ResponseEntity<Book> response = restTemplate.exchange(
                Constants.GET_DETAILS_OF_BOOK_TARGET_URL,
                HttpMethod.GET,
                reqEntity,
                Book.class,
                bookId
               );
        return response.getBody();
    }
}
