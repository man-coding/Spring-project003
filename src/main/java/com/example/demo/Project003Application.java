package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//jpa 검사 기능을 활성화하여 데이터가 생성 및 수정되는 것을 추적함
@EnableJpaAuditing
@SpringBootApplication
public class Project003Application {

	public static void main(String[] args) {
		SpringApplication.run(Project003Application.class, args);
	}

}
