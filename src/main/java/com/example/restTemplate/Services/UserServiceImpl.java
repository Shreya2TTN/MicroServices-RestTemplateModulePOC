package com.example.restTemplate.Services;

import com.example.restTemplate.model.User;
import com.example.restTemplate.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    public UserRepo userRepo;
    @Autowired
    RestTemplate restTemplate;
    String url="http://localhost:9090/api/contact/user/";

    @Override
    public User createUser(User user){
        userRepo.save(user);
        return user;
    }
    @Override
    public User getUser(Integer id){
        User user=userRepo.findById(id).orElse(null);
        List contacts=this.restTemplate.getForObject(url+id,List.class);
        user.setContact(contacts);
        return user;
    }
    @Override
    public List<User> getAll(){
        List<User> users=userRepo.findAll();
        return users;
    }
}
