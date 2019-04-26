package com.assignment.test.Services;

import java.util.List;

import com.assignment.test.models.Group;

public interface ChatGroupService {
	 Group create(Group user);
	 
	 Group findByEmail(String fromemail);

	 List<Group> findAll();

//	 Group delete(int id);

//	 Group findById(int id);

//	 Group update(Group user);

}
