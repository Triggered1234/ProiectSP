package com.example.ProiectSP.services;

import com.example.ProiectSP.Book.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }


    public Optional<Book> getBookById(String id) {
        return books.stream().filter(book -> book.getTitle().equals(id)).findFirst();
    }

    public void addBook(Book book) {
        books.add(book);
    }
    public void deleteBook(Book book) {
        books.remove(book);
    }

    public void updateBook(String id, Book updatedBook) {
        books.removeIf(book -> book.getTitle().equals(id));
        books.add(updatedBook);
    }

    public void deleteBook(String id) {
        books.removeIf(book -> book.getTitle().equals(id));
    }
}
