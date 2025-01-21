package com.example.ProiectSP.observer;

import com.example.ProiectSP.Book.Book;
import com.example.ProiectSP.repos.BooksRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllBooksSubject {

    private final List<SseObserver> observers = new ArrayList<>();
    private final BooksRepository booksRepository;

    public AllBooksSubject(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public void attach(SseObserver observer) {
        observers.add(observer);
    }

    public void detach(SseObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Book book) {
        // Notify each observer (connected client)
        for (SseObserver observer : observers) {
            observer.update(book);
        }
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();  // Get all books from the repository
    }

    public Book getBookById(Integer id) {
        return booksRepository.findById(id).orElse(null);  // Get book by ID
    }

    public void addBook(Book book) {
        booksRepository.save(book);  // Save new book
        notifyObservers(book);  // Notify observers (clients) about the new book
    }

    public void updateBook(Book book) {
        booksRepository.save(book);  // Save the updated book
        notifyObservers(book);  // Notify observers (clients) about the updated book
    }
}
