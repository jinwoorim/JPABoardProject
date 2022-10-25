package com.fastcampus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//DROP TABLE USER;
//
//CREATE TABLE USER (
//	ID 		NUMBER(5) 	PRIMARY KEY,
//	USERNAME 	VARCHAR2(30),
//	PASSWORD 	VARCHAR2(100),
//	EMAIL 	VARCHAR2(30)
//);

@Data
@Table(name = "USERS") // H2에서 테이블이름이랑 같아야됨
@Entity // 필수로 있어야됨
public class User {
	@Id // 식별자 변수(Primary Key) 선언 // 필수로 있어야됨
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 1부터 시작하여 자동으로 1씩 값이 증가하도록 설정한다.// @Id랑@GeneratedValue는 보통 쌍으로쓴다
	private int id; // 회원 일련번호
	
	@Column(nullable = false, length = 50, unique = true) // nullable = false : null을 허용하지않겠다(NOT NULL)
	private String username; // 아이디
	
	@Column(length = 50)
	private String password; // 비밀번호
	
	@Column(nullable = false, length = 100)
	private String email; // 이메일
	
	private String role;
	
}

