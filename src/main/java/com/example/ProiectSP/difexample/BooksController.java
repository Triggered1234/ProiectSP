package com.example.ProiectSP.difexample;

import com.example.ProiectSP.Book.Book;
import com.example.ProiectSP.services.BookService;
import com.example.ProiectSP.repos.BooksRepository;
import com.example.ProiectSP.observer.AllBooksSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;
    private final AllBooksSubject allBooksSubject;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    public BooksController(BookService bookService, AllBooksSubject allBooksSubject) {
        this.bookService = bookService;
        this.allBooksSubject = allBooksSubject; // Spring will inject this automatically
    }

    @PostMapping("/new")
    public ResponseEntity<Book> addBook(@RequestBody Book newBook) {
        // Add the book to the database
        booksRepository.save(newBook);

        // Notify all connected clients (SSE observers) about the new book
        allBooksSubject.addBook(newBook); // This will notify all SSE observers about the new book
        return ResponseEntity.ok(newBook);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return booksRepository.getReferenceById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        booksRepository.deleteById(id);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }
}
