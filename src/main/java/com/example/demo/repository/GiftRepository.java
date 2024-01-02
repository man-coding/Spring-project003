package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Gift;

public interface GiftRepository extends JpaRepository<Gift, Integer> {

	// 순수SQL
	@Query(value = "select * from tbl_gift m where price >= :price", nativeQuery = true)
	List<Gift> get1(@Param("price") int price);

	@Query(value = "select * from tbl_gift where name like %:name", nativeQuery = true)
	List<Gift> get2(@Param("name") String name);

	@Query(value = "select * from tbl_gift where price <= :price and type=:type", nativeQuery = true)
	List<Gift> get3(@Param("price") int price, @Param("type") String type);

	// JPQL
	// 선물의 가격이 '50000'원 이상인 데이터 검색
	// select * from gift where price >= 50000
	@Query("select m from Gift m where m.price >=:price")
	List<Gift> get4(@Param("price") int price);

	// 상품명이 '세트'로 끝나는 데이터 검색
	// SELECT * FROM GIFT WHERE NAME LIKE '%세트';
	@Query("select m from Gift m where m.name like %:name")
	List<Gift> get5(@Param("name") String name);

	// 선물의 가격이 '40000'원 이하이고 품목이 '생활용품'인 데이터 검색
	// select * from gift where price <= 40000 and type = 생활용품
	@Query("select m from Gift m where m.price <= :price and m.type= :type")
	List<Gift> get6(@Param("price") int price, @Param("type") String type);

}
