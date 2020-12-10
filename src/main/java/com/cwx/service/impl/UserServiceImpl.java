package com.cwx.service.impl;

import com.cwx.dao.RoleDao;
import com.cwx.dao.UserDao;
import com.cwx.entity.Role;
import com.cwx.entity.User;
import com.cwx.service.RoleService;
import com.cwx.service.UserService;
import com.cwx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nick
 */
@Service
public class UserServiceImpl implements UserService {

    //框架自动帮我们管理类
    @Autowired
    private UserDao userDao;


    @Override
    public ResultVO search() {
        List<User> arr=this.userDao.search();

        ResultVO  resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("OK");
        resultVO.setData(arr);

        return resultVO;
    }

    @Override
    public ResultVO insert(User obj) {
        int i=this.userDao.insert(obj);

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
    public ResultVO update(User obj) {
        int i=this.userDao.update(obj);

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
    public ResultVO delete(String uuid) {
        int i=this.userDao.delete(uuid);

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
        User user=this.userDao.selectByPrimaryKey(uuid);

        ResultVO  resultVO=new ResultVO();
        if(user!=null){
            resultVO.setCode(0);
            resultVO.setMessage("OK");
            resultVO.setData(user);
        }else{
            resultVO.setCode(404);
            resultVO.setMessage("查询不到该记录");
        }

        return resultVO;
    }
}
