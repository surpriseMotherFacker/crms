package com.cwx.controller;

import com.cwx.entity.User;
import com.cwx.service.UserService;
import com.cwx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //查询
    @GetMapping(value = "/api/user/data")
    public ResultVO search(){
        return this.userService.search();
    }

    //查询
    @GetMapping(value = "/api/user/findone")
    public ResultVO findOne(String uuid){
        return this.userService.selectByPrimaryKey(uuid);
    }

    @PostMapping(value = "/api/user/add")
    public ResultVO insert( User user){
        return this.userService.insert(user);
    }
}
