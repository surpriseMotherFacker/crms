package com.cwx.service.impl;

import com.cwx.dao.NoticeDao;
import com.cwx.dao.RoleDao;
import com.cwx.dto.NoticeSearchDTO;
import com.cwx.dto.RoleSearchDTO;
import com.cwx.entity.Notice;
import com.cwx.entity.Role;
import com.cwx.service.NoticeService;
import com.cwx.vo.BootstrapTableVO;
import com.cwx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {

    //框架自动帮我们管理类
    @Autowired
    private NoticeDao noticeDao;


    @Override
    public ResultVO search(NoticeSearchDTO pageDTO) {
        BootstrapTableVO bootstrapTableVO=this.noticeDao.search(pageDTO);

        ResultVO  resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("OK");
        resultVO.setData(bootstrapTableVO);

        return resultVO;
    }

    @Override
    public ResultVO insert(Notice obj) {
        int i=this.noticeDao.insert(obj);

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
    public ResultVO update(Notice obj) {
        int i=this.noticeDao.update(obj);

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
        int i=this.noticeDao.remove(uuid);

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
        Notice notice=this.noticeDao.selectByPrimaryKey(uuid);

        ResultVO  resultVO=new ResultVO();
        if(notice!=null){
            resultVO.setCode(0);
            resultVO.setMessage("OK");
            resultVO.setData(notice);
        }else{
            resultVO.setCode(404);
            resultVO.setMessage("查询不到该记录");
        }

        return resultVO;
    }
}
