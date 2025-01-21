package com.example.ProiectSP.services;

import com.example.ProiectSP.Book.Paragraph;

public interface Strategy {
    public default void render(Paragraph paragraph, int width){}
}

