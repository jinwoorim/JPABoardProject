package com.fastcampus.security.jpa;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fastcampus.domain.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {

	// User 엔티티 타입의 참조변수 선언
	private User user;
	
	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}
	
	// User 엔티티가 가지고 있는 권한 목록을 저장하여 리턴한다
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 권한 목록을 저장할 컬렉션
		Collection<GrantedAuthority> roleList = new ArrayList<>();
		
		// 권한 설정
		roleList.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				// TODO Auto-generated method stub
				return "ROLE_" + user.getRole();
			}
		});
		return roleList;
	}

	@Override
	public String getPassword() {
		// "{noop}" 은 security가 제공하는 비밀번호를 자동으로 암호화하지않겠다. 실제 DB 회원의 비밀번호로 대체하겠다
		return "{noop}" + user.getPassword();
	}

	@Override
	public String getUsername() {

		return user.getUsername();
	}

	// 계정이 만료됬는지 여부를 리턴한다
	@Override
	public boolean isAccountNonExpired() {

		return true; // 계정은 만료되지 않았다
	}

	// 계정이 잠겨있는지 여부를 리턴한다
	@Override
	public boolean isAccountNonLocked() {

		return true; // 안 잠겨있다
	}

	// 비밀번호가 만료됬는지 여부를 리턴한다
	@Override
	public boolean isCredentialsNonExpired() {

		return true; // 비밀번호가 만료되지 않았다
	}

	// 계정의 활성화 여부를 리턴한다
	@Override
	public boolean isEnabled() {

		return true; // 계정이 활성화되있다
	}
}
