package com.example.YukawaChat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.YukawaChat.entity.USERS;
import com.example.YukawaChat.repository.USERS_Repository;

@Service
public class USERS_Service {

    @Autowired
    private USERS_Repository repository;

    public void createUser(USERS user) {
        repository.save(user);
    }

    public List<USERS> getUser() {
        return repository.findAll();
    }

    public List<USERS> serchName(String name){
        List<USERS> list = repository.findByNameLike("%" + name + "%");
        return list;
    }

}
