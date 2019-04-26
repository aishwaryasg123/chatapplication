package com.assignment.test.ServiceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.test.Repositorys.GroupRepository;
import com.assignment.test.Services.ChatGroupService;
import com.assignment.test.models.Group;
import com.assignment.test.models.User;

@Service
public class ChatGroupServiceImpl implements ChatGroupService {

	@Autowired
    private GroupRepository addToChatGroup;
	
	 @Override
	 public Group create(Group user) 
	 {
	    return addToChatGroup.save(user);
	 }
	 @Override
	 public Group findByEmail(String email)
	 {
	   	return addToChatGroup.findByEmail(email);
	 }
	 @Override
	 public List<Group> findAll()
	 {
		 return addToChatGroup.findAll();
	 }
}
