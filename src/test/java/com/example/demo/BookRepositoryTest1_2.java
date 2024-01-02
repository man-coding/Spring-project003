package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@SpringBootTest
public class BookRepositoryTest1_2 {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	void 검색기능() {
		
		List<Book> list = bookRepository.get1("자바프로그래밍입문");
		for(Book book : list) {
			System.out.println(book);
		}
		
	}
	@Test
	void 검색기능2() {
		List<Book> list = bookRepository.get2(30000,"남가람북스");
		for(Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	void 검색기능3() {
		List<Book> list = bookRepository.get3("한빛출판사", "이지스퍼블리싱");
		for(Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	void 검색기능4() {
		List<Book> list = bookRepository.get4("자바프로그래밍입문");
		for(Book book : list) {
			System.out.println(book);
		}
	}
}
