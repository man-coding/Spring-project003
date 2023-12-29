package com.example.demo;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemoRepository;

@SpringBootTest
public class MemoRepositoryTest1_2 {

	@Autowired
	MemoRepository memoRepository;

	@Test
	void 메모데이터100개등록() {

		// 1~100까지 숫자를 가지는 스트림을 생성하고, forEach 최종연산
		IntStream.rangeClosed(1, 50).forEach(i -> {
			Memo memo = Memo.builder().text("sample.." + i).build();
			memoRepository.save(memo);
		});
		IntStream.rangeClosed(51, 100).forEach(i -> {
			Memo memo = Memo.builder().build();
			memoRepository.save(memo);
		});
	}

	@Test
	void 페이징처리() {
		// 페이지번호와 데이터개수를 담아서 페이지 정보 생성
		Pageable pageable = PageRequest.of(1, 10);

		// 페이지 정보를 전달하여 데이터 조회하기
		Page<Memo> page = memoRepository.findAll(pageable);

		// 페이지 안에 담긴 데이터 꺼내기
		List<Memo> list = page.getContent();
		System.out.println(list);

		System.out.println("총 페이지:" + page.getTotalPages());
		System.out.println("현재 페이지 번호:" + page.getNumber());
		System.out.println("페이지당 데이터 개수:" + page.getSize());
		System.out.println("다음 페이지 존재 여부:" + page.hasNext());
		System.out.println("시작 페이지 여부:" + page.isFirst());
	}

	@Test
	void 정렬조건추가하기() {

		// no 필드를 기준으로 역정렬하는 족너을 생성
		Sort sort = Sort.by("no").descending();

		// 페이지번호, 데이터개수, 정렬조건을 담아서 페이지 정보 생성
		Pageable pageable = PageRequest.of(0, 10, sort);

		// 페이지 정보를 전달하여 데이터 조회
		Page<Memo> page = memoRepository.findAll(pageable);

		List<Memo> list = page.getContent();

		// 메모번호를 기준으로 역정렬된 데이터가 조회됨
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}

	@Test // 여기서부터 레포지토리 쿼리메소드
	public void 번호가10과20사이인_메모검색() {

		List<Memo> list = memoRepository.findByNoBetween(10, 20);

		for (Memo memo : list) {
			System.out.println(memo);
		}
	}

	@Test
	public void 번호가10보다작은_메모검색() { // jpa는 컨테이너를 1개로 쓰기 때문에 하나가 오류나면 전부 실행이 안됨..
		List<Memo> list = memoRepository.findByNoLessThan(30);

		for (Memo memo : list) {
			System.out.println(memo);
		}
	}

	@Test
	public void text내용이있는것검색() {

		List<Memo> list = memoRepository.findByTextIsNotNull();

		for (Memo memo : list) {
			System.out.println(memo);
		}
	}

	@Test
	public void 번호를기준으로역정렬한_메모검색() {
		List<Memo> list = memoRepository.findAllByOrderByNoDesc();

		for (Memo memo : list) {
			System.out.println(memo);
		}
	}

	@Test
	public void 번호가5보다작은_메모삭제() {

		memoRepository.deleteMemoByNoLessThan(10);
		// @transactional이 없다면 에러남
		// deleteby는 기본적으로 롤백처리가 되어 결과가 반영되지 않음. 나머지 위에 것들은 내부적으로 트랜잭셔널을 가지고 있기 때문에 에러가
		// 안 난다.
	}

}
