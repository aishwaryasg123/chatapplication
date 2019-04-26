package com.assignment.test.Services;

import java.util.List;

import com.assignment.test.models.ChatInfo;

public interface ChatInfoService {
	 ChatInfo create(ChatInfo chat);
	 List<ChatInfo> findAll();
	
}
