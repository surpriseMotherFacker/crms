package com.cwx.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.cwx.dto.PageDTO;
import com.cwx.dto.RoleSearchDTO;
import com.cwx.entity.Role;
import com.cwx.service.RoleService;
import com.cwx.util.UUIDUtil;
import com.cwx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


/** 以前的Servlet写法，现在变为最新的框架写法
 * @author nick
 */
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    //查询
    @GetMapping(value = "/api/role/data")
    public ResultVO search(RoleSearchDTO pageDTO){
       return this.roleService.search(pageDTO);
    }
    //删除
    @PostMapping(value = "/api/role/remove")
    public ResultVO remove(String uuid){
        System.out.println(uuid);
        return this.roleService.remove(uuid);
    }
    //查询
    @GetMapping(value = "/api/role/findone")
    public ResultVO findOne(String uuid){
        return this.roleService.selectByPrimaryKey(uuid);
    }

    @PostMapping(value = "/api/role/add")
    public ResultVO insert( Role role){
        role.setUuid(UUIDUtil.getUUID());
        return this.roleService.insert(role);
    }



}
