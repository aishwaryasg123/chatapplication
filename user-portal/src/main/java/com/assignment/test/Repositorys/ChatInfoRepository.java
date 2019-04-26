package com.assignment.test.Repositorys;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.assignment.test.models.ChatInfo;

public interface ChatInfoRepository extends Repository<ChatInfo, Integer>{
	ChatInfo save(ChatInfo chat);
	  List<ChatInfo> findAll();
}
