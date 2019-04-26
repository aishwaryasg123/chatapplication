package com.assignment.test.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.assignment.test.Services.ChatGroupService;
import com.assignment.test.Services.ChatInfoService;
import com.assignment.test.Services.UserService;
import com.assignment.test.models.ChatInfo;
import com.assignment.test.models.Group;
import com.assignment.test.models.Login;
import com.assignment.test.models.Message;
import com.assignment.test.models.User;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping({"/api"})
@RequestMapping({"/users"})
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ChatGroupService  addTochatGroup;
    @Autowired
    private ChatInfoService chatrepository;
    
    @PostMapping
    public User create(@RequestBody User user){
    	user.setRole("user");
        return userService.create(user);
    }
    
    @PostMapping(path= {"/sendmsg"})
    public Message sendmsg(@RequestBody ChatInfo chat) {
    	Message msg=new Message();
    	msg.setMessage("false");
    	Group fromuser=addTochatGroup.findByEmail(chat.getFromEmail());
    	Group touser=addTochatGroup.findByEmail(chat.getToEmail());
    	
    	if(fromuser.getGroupname().equals(touser.getGroupname())){
    		 chatrepository.create(chat);
    		 msg.setMessage("true");
    		 return msg;
    	}else
    	return msg;
     
    }
    
    
    @PostMapping(path= {"/addToChatGroup"})
    public Group create(@RequestBody Group user) {
        return addTochatGroup.create(user);
    }
    
    @PostMapping(path= {"/getGroupMembers"})
    public List<Group> featchGroupMem(@RequestBody Login user) {
    	 Group g=addTochatGroup.findByEmail(user.getEmail());
    	 List<Group> list = new ArrayList<Group>();
     	for(Group u: addTochatGroup.findAll())
     	{
 			if(u.getGroupname().equals(g.getGroupname())){
 			   list.add(u);
 			  
 			}
 		}
        return list;
    }
  
    
    @PostMapping(path = {"/login"})
    public User loginuser(@RequestBody Login user){ 
      return userService.findByEmail(user.getEmail());	
    }
    
    @GetMapping(path = {"/{id}"})
    public User findOne(@PathVariable("id") int id){
        return userService.findById(id);
    }
    

    @PutMapping(path = {"/{id}"})
    public User update(@PathVariable("id") int id, @RequestBody User user){
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping(path ={"/{id}"})
    public User delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
    @PostMapping(path= {"/getMessages"})
    public List<ChatInfo> findAllmsg(@RequestBody Login user){
    	List<ChatInfo> msglist = new ArrayList<ChatInfo>();
    	for(ChatInfo u: chatrepository.findAll())
    	{
			if(u.getToEmail().equals(user.getEmail())){
			   msglist.add(u);
			   System.out.println(u.getToEmail());
			}
		}
    	return msglist;
    }
    
   

//    @GetMapping(path = {"/login"})
//    public User login(@RequestBody User user){
//    	System.out.println(user);
//    	Messege msg=new Messege();
//    	msg.setMessege("unauthorized");
//     	User u=userService.findByEmail(user.getEmail());
//    	System.out.println(u);
//    	if(u.getRole()=="user")
//    	{
//    		msg.setMessege("user");
//    		System.out.println(msg);
//    		return msg;
//    			
//    	}
//    	else if(u.getRole()=="admin")
//    	{
//    		msg.setMessege("admin");
//    		System.out.println(msg);
//    		return msg;
//    	}
//    	else
//    		System.out.println(msg);
//    	return msg;
//    	System.out.println(u);
//    	return userService.findByEmail(user.getEmail());
//      
//    }
}
