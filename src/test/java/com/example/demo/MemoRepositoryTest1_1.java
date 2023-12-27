package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemoRepository;

//메모 리파지토리를 사용하여
//메모테이블의 데이터를 등록, 조회, 수정, 삭제한다
@SpringBootTest
public class MemoRepositoryTest1_1 {

	@Autowired
	MemoRepository memoRepository;

	@Test
	public void 리파지토리객체를가져왔는지확인() {

		System.out.println("memoRepository = " + memoRepository);
	}

	@Test
	public void 데이터등록() {
		Memo memo = Memo.builder().text("새글입니다").build();
		memoRepository.save(memo);

	}

	@Test
	public void 데이터일괄등록() {

		List<Memo> list = new ArrayList<>();

		Memo memo1 = new Memo(0, "새글입니다");
		Memo memo2 = new Memo(0, null);

		list.add(memo1);
		list.add(memo2);

		memoRepository.saveAll(list); // 일괄 등록
	}
}
