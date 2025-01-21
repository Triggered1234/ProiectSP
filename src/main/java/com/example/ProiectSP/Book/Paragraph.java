package com.example.ProiectSP.Book;

import com.example.ProiectSP.services.AlignRight;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paragraph extends BaseElement {
    private String text;

    @Override
    public void print() {
        System.out.println(text);
    }

    @Override
    public void add(Element element) {
        // Nu este suportat pentru Paragraph
    }

    @Override
    public void remove(Element element) {
        // Nu este suportat pentru Paragraph
    }

    @Override
    public Element get(int index) {
        return null; // Nu este suportat pentru Paragraph
    }

    public String getText(AlignRight alignRight) {
        return text;
    }
}
