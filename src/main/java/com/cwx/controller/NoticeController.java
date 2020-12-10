package com.cwx.controller;

import com.cwx.dto.NoticeSearchDTO;
import com.cwx.entity.Notice;
import com.cwx.service.NoticeService;
import com.cwx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    //查询
    @GetMapping(value = "/api/notice/data")
    public ResultVO search(NoticeSearchDTO pageDTO){
        return this.noticeService.search(pageDTO);
    }
    //删除
    @PostMapping(value = "/api/notice/remove")
    public ResultVO remove(String uuid){
        System.out.println(uuid);
        return this.noticeService.remove(uuid);
    }
    //查询
    @GetMapping(value = "/api/notice/findone")
    public ResultVO findOne(String uuid){
        return this.noticeService.selectByPrimaryKey(uuid);
    }

    @PostMapping(value = "/api/notice/add")
    public ResultVO insert( Notice notice){
        return this.noticeService.insert(notice);
    }
}
