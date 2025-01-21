package com.example.ProiectSP.observer;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import com.example.ProiectSP.Book.Book;

public class SseObserver implements Observer {

    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
        configureEmitter();
    }

    private void configureEmitter() {
        emitter.onCompletion(() -> System.out.println("SSE connection completed"));
        emitter.onTimeout(() -> System.out.println("SSE connection timed out"));
        emitter.onError(e -> System.out.println("SSE connection error: " + e.getMessage()));
    }

    public SseEmitter getEmitter() {
        return emitter;
    }

    @Override
    public void update(Book book) {
        try {
            emitter.send(book, MediaType.APPLICATION_JSON);
        } catch (Exception e) {
            emitter.completeWithError(e);
        }
    }
}