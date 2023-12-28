package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class OrderRepositoryTest {

	@Autowired
	OrderRepository orderRepository;

	@Test
	public void 데이터추가테스트() {

		List<Order> orderList = new ArrayList<>();

		Order order1 = new Order(0, "둘리", LocalDate.of(2023, 7, 1), "인천 구월동");
		orderList.add(order1);
		Order order2 = new Order(0, "또치", LocalDate.of(2023, 7, 2), "인천 연수동");
		orderList.add(order2);
		Order order3 = new Order(0, "도우너", LocalDate.of(2023, 7, 3), "부산 동래동");
		orderList.add(order3);

		orderRepository.saveAll(orderList);
	}

	@Test
	public void 데이터전체조회() {
		List<Order> orderList = new ArrayList<>();

		for (Order order : orderList) {
			System.out.println(order);
		}

	}

	@Test
	public void 데이터단건조회() {
		Optional<Order> result = orderRepository.findById(4);
		if (result.isPresent()) {
			Order order = result.get();
			System.out.println(order);
		}
	}

	@Test
	public void 데이터수정() {
		
		Optional<Order> result = orderRepository.findById(2);
		Order order = result.get();
		order.setAddress("인천 서구");
		
		
		Order order2 = new Order(1, "민수", null, "수정했습니다");
		orderRepository.save(order);
	}

	@Test
	public void 데이터삭제() {
		orderRepository.deleteById(3);
	}
}
