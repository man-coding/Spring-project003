package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // 엔티티로 선언 jpa가 관리하는 객체다. 표시
@Table(name = "tbl_memo") // 실제 DB의 table 이름

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memo {

	@Id // PK 표시
	@GeneratedValue(strategy = GenerationType.IDENTITY) // enum.. static int 같은 것
	int no; // -> pk "auto increment"

	@Column(length = 200, nullable = true) // false 몀ㄴ 빈값x
	String text;
}
