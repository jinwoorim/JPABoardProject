package com.fastcampus.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.Reply;

@Repository // extends JpaRepository<Entity클래스이름, 식별자 변수의 타입>
public interface ReplyRepository extends JpaRepository<Reply, Integer>{

	@Query(value = "select * from reply where post_id = :keyword", nativeQuery=true)
	List<Reply> getReplyList(@Param("keyword") int keyword);
}
