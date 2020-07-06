package com.example.YukawaChat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.YukawaChat.entity.USERS;;

public interface USERS_Repository extends JpaRepository<USERS, Integer> {
    List<USERS> findByNameLike(String name);
}
