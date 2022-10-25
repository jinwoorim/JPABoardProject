package com.fastcampus.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fastcampus.domain.Post;
import com.fastcampus.domain.Reply;
import com.fastcampus.persistence.ReplyRepository;

@Service
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository;
	
	@Transactional
	public void insertReply(Reply reply) {
		replyRepository.save(reply);
	}
	
	@Transactional
	public void deleteReply(@PathVariable int idd) {
		replyRepository.deleteById(idd);
	}
	
	@Transactional
	public Reply getReply(@PathVariable int idd) {

		Optional<Reply> findReply = replyRepository.findById(idd);
		if(findReply.isPresent()) {
			return findReply.get();
		}else {
			return new Reply();  
		}
	}
}

