package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
 //crud 기능과 페이징 기능과 정렬 기능을 사용할 수 있다.
}
