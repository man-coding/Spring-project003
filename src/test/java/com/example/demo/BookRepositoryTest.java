package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@SpringBootTest
public class BookRepositoryTest {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void 데이터조회() {
		
		List<Book> bookList = new ArrayList<>();
		
		Book book1 = new Book(0, 20000, "한빛출판사", "자바프로그래밍입문");
		Book book2 = new Book(0, 25000, "남가람북스", "스프링부트프로젝트");
		Book book3 = new Book(0, 40000, "남가람북스", "실무로 끝내는 PHP");
		Book book4 = new Book(0, 35000, "이지스퍼블리싱", "알고리즘코딩테스트");
		
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);
		
		bookRepository.saveAll(bookList);
	}
	
	@Test
	public void 데이터단건조회() {
		
		Optional<Book> result = bookRepository.findById(1);
		if(result.isPresent()) {
			Book book = result.get();
			System.out.println(result);
		}
		
	}
}
