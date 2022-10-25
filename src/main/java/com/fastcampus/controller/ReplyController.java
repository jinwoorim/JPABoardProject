package com.fastcampus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fastcampus.domain.Post;
import com.fastcampus.domain.Reply;
import com.fastcampus.domain.User;
import com.fastcampus.security.jpa.UserDetailsImpl;
import com.fastcampus.service.PostService;
import com.fastcampus.service.ReplyService;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private PostService postService;
	
	// 덧글 등록
	@PostMapping("/insertReply/{id}")
	public String insertReply(Model model, @PathVariable Post id, HttpServletRequest request, @AuthenticationPrincipal UserDetailsImpl userDetails, HttpSession session) {
		Reply reply = new Reply();
		User user = userDetails.getUser();
		reply.setContent(request.getParameter("content"));
		reply.setPost(id);
		reply.setUser(user);
		replyService.insertReply(reply);
		model.addAttribute("post", postService.getPost((int)session.getAttribute("PostIdNumber")));
		List<Reply> replyList = postService.getReplyList((int)session.getAttribute("PostIdNumber"));
		model.addAttribute("reply", replyList);
		return "post/getPost"; 
	}
	
	// 덧글 삭제하기
	@PostMapping("/deleteReply/{id}")
	public String deleteReply(Model model, @PathVariable int id, HttpSession session) {
		replyService.deleteReply(id);
		model.addAttribute("post", postService.getPost((int)session.getAttribute("PostIdNumber")));
		List<Reply> replyList = postService.getReplyList((int)session.getAttribute("PostIdNumber"));
		model.addAttribute("reply", replyList);
		return "post/getPost";
	}
}

