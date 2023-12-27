package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	@Test
	public void 데이터단건조회() {

		Optional<Memo> result = memoRepository.findById(1); // find -> select sql

		if (result.isPresent()) { // 결과값이 있는지 확인 , 확인 안 하면 오류남
			Memo memo = result.get(); // 값 꺼내기
			System.out.println(memo);
		}
	}

	@Test
	public void 데이터전체조회() {

		List<Memo> list = memoRepository.findAll(); // 리스트에 담아준다

		for (Memo memo : list) {
			System.out.println(memo);
		}

	}

	@Test
	public void 데이터수정() {
		Memo memo = new Memo(16, "글이수정되었습니다");

		// 1번이 존재하는지 확인하고 update 실행
		memoRepository.save(memo);

	}

	@Test
	public void 데이터삭제() {

		// 1번이 존재하는지 확인하고 delete 실행
		memoRepository.deleteById(1);
	}

	@Test
	public void 데이터전체삭제() {

		memoRepository.deleteAll();
	}
}
