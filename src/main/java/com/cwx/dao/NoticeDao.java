package com.cwx.dao;

import com.cwx.dto.NoticeSearchDTO;
import com.cwx.entity.Notice;
import com.cwx.vo.BootstrapTableVO;

public interface NoticeDao {
    BootstrapTableVO search(NoticeSearchDTO pageDTO);

    int  insert(Notice obj);

    int update(Notice obj);

    int remove(String uuid);

    Notice selectByPrimaryKey(String uuid);
}
