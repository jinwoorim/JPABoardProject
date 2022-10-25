package com.fastcampus.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;



@Data
@Entity // 필수로 있어야됨
public class Post {
	@Id // 식별자 변수(Primary Key) 선언 // 필수로 있어야됨
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id; 
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 아주 긴 문자데이터(GB규모의)를 저장할 수 있는 설정
	@Column(nullable = false)
	private String content;

	// 포스트 : 회원은 N : 1 관계다
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE) 
	private List<Reply> replys = new ArrayList<Reply>();
																   
}

