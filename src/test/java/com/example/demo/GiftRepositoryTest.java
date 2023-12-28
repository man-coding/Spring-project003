package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;
import com.example.demo.repository.GiftRepository;

@SpringBootTest
public class GiftRepositoryTest {

	@Autowired
	GiftRepository giftRepository;

	@Test
	public void 데이터추가() {

		List<Gift> giftList = new ArrayList<>();

		Gift gift1 = new Gift(0, "참치세트", 10000, "식품");
		Gift gift2 = new Gift(0, "햄세트", 20000, "식품");
		Gift gift3 = new Gift(0, "샴푸세트", 30000, "생활용품");
		Gift gift4 = new Gift(0, "세차용품", 40000, "생활용품");
		Gift gift5 = new Gift(0, "주방용품", 50000, "생활용품");
		Gift gift6 = new Gift(0, "노트북", 60000, "가전제품");
		Gift gift7 = new Gift(0, "벽걸이TV", 70000, "가전제품");
		
		

		giftList.add(gift1);
		giftList.add(gift2);
		giftList.add(gift3);
		giftList.add(gift4);
		giftList.add(gift5);
		giftList.add(gift6);
		giftList.add(gift7);
		
		Gift gift8 = Gift.builder().giftNo(2).name("컴퓨터세트").build();
		giftRepository.save(gift8); //하나만 넣을 때.

		giftRepository.saveAll(giftList);
	}

	@Test
	public void 데이터조회() {

		Optional<Gift> result = giftRepository.findById(1);

		if (result.isPresent()) {
			Gift gift = result.get();
			System.out.println(gift);

		}
	}

	@Test
	public void 데이터수정() {
		Optional<Gift> result = giftRepository.findById(44);
		Gift gift = result.get(); // 엔티티 꺼내기
		//일부 값 변경
		gift.setName("내용이 수정되었습니다~");  //일부 내용만 변경 가능
		
		//1번이 존재하는지 확인하고 update 실행
		giftRepository.save(gift);
		
		Gift gift2 = new Gift(45, "햄세트", 20000, "식품"); //모든 내용 변경
		giftRepository.save(gift2);
	}

	@Test
	public void 데이터삭제() {

		giftRepository.deleteAll();

	}
}
