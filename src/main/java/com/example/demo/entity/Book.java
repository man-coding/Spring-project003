package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_book")

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bookNo;
	
	@Column(nullable = true)   //int 자료형은 notnull이 기본값이라 true 써줘야 함
	int price;
	
	@Column(length = 100, nullable = true)
	String publisher;
	
	@Column(length = 30, nullable = false)
	String title;
	
	
	
	
}
