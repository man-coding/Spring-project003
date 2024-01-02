package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;
import com.example.demo.repository.GiftRepository;

@SpringBootTest
public class GiftRepositoryTest1_2 {

	@Autowired
	GiftRepository giftRepository;

	@Test
	public void 검색기능1() {

		List<Gift> list = giftRepository.get1(50000);

		for (Gift gift : list) {
			System.out.println(gift);
		}

	}

	@Test
	public void 검색기능2() {
		List<Gift> list = giftRepository.get2("세트");
		for (Gift gift : list) {
			System.out.println(gift);
		}
	}

	@Test
	public void 검색기능3() {
		List<Gift> list = giftRepository.get3(40000, "생활용품");
		for (Gift gift : list) {
			System.out.println(gift);
		}
	}

	@Test
	void 검색기능4() {

		List<Gift> list = giftRepository.get1(50000);

		for (Gift gift : list) {
			System.out.println(gift);
		}

	}

	@Test
	public void 검색기능5() {
		List<Gift> list = giftRepository.get2("세트");
		for (Gift gift : list) {
			System.out.println(gift);
		}
	}

	@Test
	public void 검색기능6() {
		List<Gift> list = giftRepository.get3(40000, "생활용품");
		for (Gift gift : list) {
			System.out.println(gift);
		}
	}

}
