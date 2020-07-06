package com.example.YukawaChat.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.YukawaChat.entity.USERS;
import com.example.YukawaChat.repository.USERS_Repository_Custom;

@Component
public class USERS_Dao implements USERS_Repository_Custom {

    @Autowired
    EntityManager manager;

    @Override
    public List<USERS> serch(USERS user){
        return null;
    }

    @Override
    public List<USERS> findByName(String name) {
        String sql = "SELECT u FROM users u WHERE u.name LIKE '%" + name + "%'";
        Query query = manager.createQuery(sql);
//        query.setParameter("name", "%" + name + "%");
//        System.out.println(query);
        List<USERS> users = query.getResultList();
        USERS resultUser = new USERS();
        for(USERS user: users) {
            resultUser = user;
        }
//        Optional<USERS> opUser = Optional.of(resultUser);
        return users;
    }
}
