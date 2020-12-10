package com.cwx.dao;

import com.cwx.dto.PageDTO;
import com.cwx.dto.RoleSearchDTO;
import com.cwx.entity.Role;
import com.cwx.vo.BootstrapTableVO;

import java.util.List;

/**
 * @author nick
 */
public interface RoleDao {

    BootstrapTableVO search(RoleSearchDTO pageDTO);

    int  insert(Role obj);

    int update(Role obj);

    int remove(String uuid);

    Role selectByPrimaryKey(String uuid);
}
