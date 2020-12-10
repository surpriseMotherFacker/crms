package com.cwx.service.impl;

import com.cwx.dao.RoleDao;
import com.cwx.dto.PageDTO;
import com.cwx.dto.RoleSearchDTO;
import com.cwx.entity.Role;
import com.cwx.service.RoleService;
import com.cwx.vo.BootstrapTableVO;
import com.cwx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author nick
 */
@Transactional
@Service
public class RoleServiceImpl implements RoleService {

    //框架自动帮我们管理类
    @Autowired
    private RoleDao roleDao;


    @Override
    public ResultVO search(RoleSearchDTO pageDTO) {
        BootstrapTableVO bootstrapTableVO=this.roleDao.search(pageDTO);

        ResultVO  resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("OK");
        resultVO.setData(bootstrapTableVO);

        return resultVO;
    }

    @Override
    public ResultVO insert(Role obj) {
        int i=this.roleDao.insert(obj);

        ResultVO  resultVO=new ResultVO();
        if(i>0){
            resultVO.setCode(0);
            resultVO.setMessage("OK");
        }else{
            resultVO.setCode(500);
            resultVO.setMessage("新增数据失败");
        }

        return resultVO;
    }

    @Override
    public ResultVO update(Role obj) {
        int i=this.roleDao.update(obj);

        ResultVO  resultVO=new ResultVO();
        if(i>0){
            resultVO.setCode(0);
            resultVO.setMessage("OK");
        }else{
            resultVO.setCode(500);
            resultVO.setMessage("更新数据失败");
        }

        return resultVO;
    }

    @Override
    public ResultVO remove(String uuid) {
        int i=this.roleDao.remove(uuid);

        ResultVO  resultVO=new ResultVO();
        if(i>0){
            resultVO.setCode(0);
            resultVO.setMessage("OK");
        }else{
            resultVO.setCode(500);
            resultVO.setMessage("删除数据失败");
        }

        return resultVO;
    }

    @Override
    public ResultVO selectByPrimaryKey(String uuid) {
        Role role=this.roleDao.selectByPrimaryKey(uuid);

        ResultVO  resultVO=new ResultVO();
        if(role!=null){
            resultVO.setCode(0);
            resultVO.setMessage("OK");
            resultVO.setData(role);
        }else{
            resultVO.setCode(404);
            resultVO.setMessage("查询不到该记录");
        }

        return resultVO;
    }
}
