package com.example.YukawaChat.repository;

import java.util.List;

import com.example.YukawaChat.entity.USERS;

public interface USERS_Repository_Custom {

    public List<USERS> serch(USERS user);

    public List<USERS> findByName(String name);
}
