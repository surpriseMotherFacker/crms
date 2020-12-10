package com.cwx.service;

import com.cwx.entity.User;
import com.cwx.vo.ResultVO;

public interface UserService {
    ResultVO search();

    ResultVO  insert(User obj);

    ResultVO update(User obj);

    ResultVO delete(String uuid);

    ResultVO selectByPrimaryKey(String uuid);
}
