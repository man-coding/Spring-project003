package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query(value = "select * from tbl_order where address like :address%", nativeQuery = true)
	List<Order> get1(@Param("address") String address);

	// 필드명 //테스트코드에서 받을 변수명(param)
	@Query(value = "select * from tbl_order where local_date = :localDate", nativeQuery = true)
	List<Order> get2(@Param("localDate") LocalDate localDate);
}
