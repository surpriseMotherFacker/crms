package com.cwx.service;

import com.cwx.dto.PageDTO;
import com.cwx.dto.RoleSearchDTO;
import com.cwx.entity.Role;
import com.cwx.vo.ResultVO;


/**
 * @author nick
 */
public interface RoleService {

    ResultVO search(RoleSearchDTO pageDTO);

    ResultVO  insert(Role obj);

    ResultVO update(Role obj);

    ResultVO remove(String uuid);

    ResultVO selectByPrimaryKey(String uuid);
}
