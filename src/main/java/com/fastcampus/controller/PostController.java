package com.fastcampus.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.domain.Post;
import com.fastcampus.domain.Reply;
import com.fastcampus.domain.User;
import com.fastcampus.security.jpa.UserDetailsImpl;
import com.fastcampus.service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	// index 페이지로 이동
	@GetMapping({"", "/"})
	public String getPostList(Model model, @PageableDefault(size = 3, page = 0, sort = "id", direction = Direction.DESC) Pageable pageable) {
		model.addAttribute("postList", postService.getPostList(pageable));
		return "welcome";
	}
	
	// 1:1 문의 화면으로 이동
	@GetMapping("/post/insertPost")
	public String insertPost() {
		return "post/insertPost";
	}
	
	// 1:1 문의 등록
	@PostMapping("/post/insertPost")
	@ResponseBody
	public String insertPost(@RequestBody Post post, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		User user = userDetails.getUser();
		post.setUser(user);
		postService.insertPost(post);
		return "새로운 1:1 문의를 등록했습니다";
	}
	
	// 상세 보기 화면으로 이동
	@GetMapping("/post/getPost/{id}")
	public String getPost(Model model, @PathVariable int id, HttpSession session) {
		model.addAttribute("post", postService.getPost(id));
		List<Reply> replyList = postService.getReplyList(id);
		model.addAttribute("reply", replyList);
		session.setAttribute("PostIdNumber", id);
		return "post/getPost";
	}
	
	// 수정하기 화면으로 이동
	@GetMapping("/post/updatePost/{id}")
	public String goUpdatePost(@PathVariable int id) {
		return "post/updatePost";
	}
	
	// 포스트 수정하기
	@PostMapping("/updatePost")
	@ResponseBody
	public String updatePost(@RequestBody Post post, HttpSession session) {
		post.setId((int)session.getAttribute("PostIdNumber"));
		postService.updatePost(post);
		return "1:1 문의가 수정되었습니다";
	}
	
	// 포스트 삭제하기
	@PostMapping("/deletePost")
	@ResponseBody
	public String deletePost(@RequestBody Post post, HttpSession session) {
		post.setId((int)session.getAttribute("PostIdNumber"));
		postService.deletePost(post);
		return "1:1 문의가 삭제되었습니다";
	}
}

