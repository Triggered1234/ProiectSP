package com.example.ProiectSP.difexample;

import com.example.ProiectSP.Book.Book;
import com.example.ProiectSP.observer.AllBooksSubject;
import com.example.ProiectSP.observer.SseObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class BooksSseController {

    private final AllBooksSubject allBooksSubject;

    @Autowired
    public BooksSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping(value = "/books-sse", produces = "text/event-stream")
    public SseEmitter streamBooks() {
        SseEmitter emitter = new SseEmitter();
        SseObserver observer = new SseObserver(emitter);
        allBooksSubject.attach(observer);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            for (Book book : allBooksSubject.getAllBooks()) {
                // Serialize the book object to JSON
                String json = objectMapper.writeValueAsString(book);

                // Send the serialized book JSON as an event
                emitter.send(json);  // Prefix with 'data: ' (single prefix)
            }
        } catch (Exception e) {
            emitter.completeWithError(e);
        }

        // Clean up observer when the connection is completed, timed out, or errored
        emitter.onCompletion(() -> {
            System.out.println("Client disconnected");
            allBooksSubject.detach(observer);  // Detach observer from subject
        });

        emitter.onTimeout(() -> {
            System.out.println("Client connection timed out");
            allBooksSubject.detach(observer);  // Detach observer from subject
        });

        emitter.onError((e) -> {
            System.out.println("Error occurred with SSE client: " + e.getMessage());
            allBooksSubject.detach(observer);  // Detach observer from subject
        });

        // Return the emitter for the SSE stream to the client
        return emitter;
    }
}
