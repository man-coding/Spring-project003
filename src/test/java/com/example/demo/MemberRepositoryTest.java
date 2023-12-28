package com.example.demo;

import java.util.ArrayList;
import java.util.List;

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
		
		Member member1 = new Member("admin","관리자","1234",null);
		Member member2 = new Member("user","사용자","1234",null);
		
		memberList.add(member1);
		memberList.add(member2);
		
		memberRepository.saveAll(memberList);
		
	}

}
