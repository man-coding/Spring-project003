package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class OrderRepositoryTest1_2 {

	@Autowired
	OrderRepository orderRepository;

	@Test
	public void 주소지가인천인주문검색() {

		List<Order> list = orderRepository.get1("인천");

		for (Order order : list) {
			System.out.println(order);
		}
	}

	@Test
	public void 주문일이7월3일인주문검색() {
		List<Order> list = orderRepository.get2(LocalDate.of(2023, 7, 3));
		for (Order order : list) {
			System.out.println(order);
		}

//		for (int i = 0; i < list.size(); i++) {  //짝수를 구하거나 홀수를 구하거나 선별할 때는 일반포문 써야 함.
//			Order order = list.get(i);
//			System.out.println(order);
		}
	}
}
