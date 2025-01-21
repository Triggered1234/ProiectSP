package com.example.ProiectSP.services;

import com.example.ProiectSP.Book.Paragraph;

public class AlignLeft extends AlignRight implements Strategy {
    @Override
    public void render(Paragraph paragraph, int width) {
        String text = paragraph.getText(new AlignRight());
        System.out.println("Align Left:");

        while (text.length() > width) {
            int breakPoint = text.lastIndexOf(' ', width);
            if (breakPoint == -1) { // no spaces in the range, split at the width
                breakPoint = width;
            }
            System.out.println(text.substring(0, breakPoint));
            text = text.substring(breakPoint).trim(); // move to the next part, trimming leading spaces
        }
        System.out.println(text); // print the remaining part
    }
}