package com.fastcampus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Data;



@Data
@Entity // 필수로 있어야됨
public class Reply {
	@Id // 식별자 변수(Primary Key) 선언 // 필수로 있어야됨
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id; 

	@Lob // 아주 긴 문자데이터(GB규모의)를 저장할 수 있는 설정
	@Column(nullable = false)
	private String content;
	
	// 덧글 : 포스트는 N : 1 관계다
	@ManyToOne
	@JoinColumn(name = "POST_ID")
	private Post post;
	
	// 덧글 : 회원은 N :1 관계다
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
}

