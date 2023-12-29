package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

@SpringBootTest
public class MemberRepositoryTest {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void 데이터추가() {
		
		List<Member> memberList = new ArrayList<>();
		
		Member member1 = Member.builder().userId("admin").password("1234").grade("관리자").build();
		Member member2 = Member.builder().userId("user").password("1234").grade("사용자").build();
	
		
		
		memberList.add(member1);
		memberList.add(member2);
		
		memberRepository.saveAll(memberList);
		
	}
	
	@Test
	public void 데이터조회() {
		
		Optional<Member> result = memberRepository.findById("user");
		
		if(result.isPresent()) {
			Member member = result.get();
			System.out.println(member);
		}
	}
	
	@Test
	public void 수정() {
	Optional<Member> result = memberRepository.findById("user");
	Member member = result.get();
	member.setPassword("12423523");
	
	memberRepository.save(member);
	}
	
	@Test
	public void 삭제() {
		memberRepository.deleteById("user");
	}

}
