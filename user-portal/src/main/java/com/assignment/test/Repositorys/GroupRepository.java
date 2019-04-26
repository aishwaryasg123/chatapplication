package com.assignment.test.Repositorys;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.assignment.test.models.Group;

public interface GroupRepository extends Repository<Group, Integer> {
	 List<Group> findAll();
	 Group save(Group user);
	 Group findByEmail(String email);
//	 Group create(Group user);

//	 Group delete(int id);
	 
//	 Group findById(int id);

//	 Group update(Group user);


}
