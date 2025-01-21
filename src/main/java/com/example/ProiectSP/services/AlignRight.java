package com.example.ProiectSP.services;

import com.example.ProiectSP.Book.Paragraph;

public class AlignRight implements Strategy {
    @Override
    public void render(Paragraph paragraph, int width) {
        String text = paragraph.getText(new AlignRight());
        System.out.println("Align Right:");

        while (text.length() > width) {
            int breakPoint = text.lastIndexOf(' ', width);
            if (breakPoint == -1) { // no spaces in the range, split at the width
                breakPoint = width;
            }
            System.out.println(padLeft(text.substring(0, breakPoint), width));
            text = text.substring(breakPoint).trim(); // move to the next part, trimming leading spaces
        }
        System.out.println(padLeft(text, width)); // print the remaining part
    }

    private String padLeft(String text, int width) {
        return String.format("%" + width + "s", text);
    }
}