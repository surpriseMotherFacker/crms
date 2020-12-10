package com.cwx.service;

import com.cwx.dto.NoticeSearchDTO;
import com.cwx.entity.Notice;
import com.cwx.vo.ResultVO;

public interface NoticeService {
    ResultVO search(NoticeSearchDTO pageDTO);

    ResultVO  insert(Notice obj);

    ResultVO update(Notice obj);

    ResultVO remove(String uuid);

    ResultVO selectByPrimaryKey(String uuid);
}
