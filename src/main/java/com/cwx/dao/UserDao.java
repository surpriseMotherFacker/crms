package com.cwx.dao;

import com.cwx.entity.User;

import java.util.List;

public interface UserDao {
    List<User> search();

    int  insert(User obj);

    int update(User obj);

    int delete(String uuid);

    User selectByPrimaryKey(String uuid);
}
