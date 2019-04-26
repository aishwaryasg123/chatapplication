package com.assignment.test.ServiceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.test.Repositorys.ChatInfoRepository;
import com.assignment.test.Services.ChatInfoService;
import com.assignment.test.models.ChatInfo;

@Service
public class ChatInfoServiceImpl implements ChatInfoService{
	 @Autowired
	    private ChatInfoRepository repository;
	    @Override
	    public List<ChatInfo> findAll() {
	        return repository.findAll();
	    }

	    @Override
	    public ChatInfo create(ChatInfo chat) {
	        return repository.save(chat);
	    }

}
