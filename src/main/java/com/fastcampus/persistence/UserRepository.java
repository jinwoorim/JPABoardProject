package com.fastcampus.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.User;

@Repository // extends JpaRepository<Entity클래스이름, 식별자 변수의 타입>
public interface UserRepository extends JpaRepository<User, Integer>{

	// SELECT * FROM user WHERE username = ?1;
		Optional<User> findByUsername(String username); // find+엔티티이름+By+변수이름인데, extends JpaRepository<User, Integer>의 User가 디폴트이므로 생략가능
		
}
