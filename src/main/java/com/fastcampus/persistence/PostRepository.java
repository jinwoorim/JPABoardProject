package com.fastcampus.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.Post;
import com.fastcampus.domain.User;

@Repository // extends JpaRepository<Entity클래스이름, 식별자 변수의 타입>
public interface PostRepository extends JpaRepository<Post, Integer>{

		
}
