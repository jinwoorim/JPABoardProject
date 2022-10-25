package com.fastcampus.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fastcampus.domain.Post;
import com.fastcampus.domain.Reply;
import com.fastcampus.persistence.PostRepository;
import com.fastcampus.persistence.ReplyRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Transactional
	public void insertPost(Post post) {
		postRepository.save(post);
	}
	
	@Transactional
	public Page<Post> getPostList(Pageable pageable){
		return postRepository.findAll(pageable);
	}
	
	@Transactional
	public Post getPost(@PathVariable int idd) {

		Optional<Post> findPost = postRepository.findById(idd);
		if(findPost.isPresent()) {
			return findPost.get();
		}else {
			return new Post();  
		}
	}
	
	@Transactional
	public List<Reply> getReplyList(@PathVariable int idd){
		
		return replyRepository.getReplyList(idd);
		
	}
	
	@Transactional
	public String updatePost(Post post) {
		Optional<Post> findEntity = postRepository.findById(post.getId());
	
		if(findEntity.isPresent()) {
			Post findPost = findEntity.get();
			findPost.setTitle(post.getTitle());
			findPost.setContent(post.getContent());
			postRepository.save(findPost);
		}
		return "회원 수정 성공";
		
	}
	
	@Transactional
	public void deletePost(Post post) {
		postRepository.deleteById(post.getId());
	}
}

