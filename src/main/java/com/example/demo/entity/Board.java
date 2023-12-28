package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//엔티티에 변화를 감지하는 리스너 지정
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "tbl_board") // 실제 테이블의 이름

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 키 생성 방식
	int boardNo;

	@Column(length = 30, nullable = false) // false -> 낫널
	String title;

	@Column(length = 200) // 기본값이 true -> null 허용
	String content;

	@CreatedDate // 인스턴스가 생성되는 것을 감지하여 날짜를 저장
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 날짜표준: iso8601
	LocalDateTime createDate;

	@LastModifiedDate // 인스턴스가 수정되는 것을 감지하여 날짜를 저장
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime modifiedDate;
}
