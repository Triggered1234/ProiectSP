package com.example.ProiectSP.repos;
import com.example.ProiectSP.Book.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepos extends JpaRepository<Author, Integer> {
}