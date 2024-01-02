package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	// crud 기능과 페이징 기능과 정렬 기능을 사용할 수 있다.

	@Query(value = "select * from tbl_book where title = :title", nativeQuery = true)
	List<Book> get1(@Param("title") String title);

	@Query(value = "select * from tbl_book where price > :price and publisher = :publisher", nativeQuery = true)
	List<Book> get2(@Param("price") int price, @Param("publisher") String publisher);
	
	@Query(value = "select * from tbl_book where publisher in (:publisher1,:publisher2)", nativeQuery = true)
	List<Book> get3(@Param("publisher1") String publisher, @Param("publisher2") String publisher2);
	
	
	//jpql
	@Query("select m from Book m where m.title = :title")
	List<Book> get4(@Param("title") String title);
}
