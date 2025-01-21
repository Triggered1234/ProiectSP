package com.example.ProiectSP.repos;

import com.example.ProiectSP.Book.BaseElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseElementRepos extends JpaRepository<BaseElement, Integer> {
}