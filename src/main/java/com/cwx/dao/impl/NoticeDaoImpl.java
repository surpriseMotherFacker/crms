package com.cwx.dao.impl;

import com.cwx.dao.NoticeDao;
import com.cwx.dto.NoticeSearchDTO;
import com.cwx.dto.RoleSearchDTO;
import com.cwx.entity.Notice;
import com.cwx.entity.Role;
import com.cwx.util.SqlUtil;
import com.cwx.vo.BootstrapTableVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NoticeDaoImpl implements NoticeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BootstrapTableVO search(NoticeSearchDTO pageDTO) {
        BootstrapTableVO  bootstrapTableVO=new BootstrapTableVO();

        List params=new ArrayList();

        StringBuffer sql=new StringBuffer("select * from sys_notice where 1=1");
        //有可能带条件的
        if (StringUtils.isNotBlank(pageDTO.getNoticeTitle())){
            sql.append(" and notice_title like ?");
            params.add("%"+pageDTO.getNoticeTitle()+"%");
        }
        //分页必须有
        sql.append("   limit ? , ?  ");
        params.add(pageDTO.getOffset());
        params.add(pageDTO.getLimit());

        List<Notice> arr=this.jdbcTemplate.query(sql.toString(),new BeanPropertyRowMapper<Notice>(Notice.class),params.toArray());

        bootstrapTableVO.setRows(arr);

        //查询总记录数
        String sqlCount= SqlUtil.sqlCount(sql.toString());
        //移出分页参数
        params.remove(params.size()-1);
        params.remove(params.size()-1);

        this.jdbcTemplate.query(sqlCount, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                long count=resultSet.getLong(1);
                bootstrapTableVO.setTotal(count);
            }
        }, params.toArray());

        return bootstrapTableVO;
    }

    @Override
    public int insert(Notice obj) {
        String sql="insert into sys_notice(user_uuid,user_name,notice_title,notice_content,create_time) values(?,?,?,?,?)";
        List params=new ArrayList();
        params.add(obj.getUserUuid());
        params.add(obj.getUserName());
        params.add(obj.getNoticeTitle());
        params.add(obj.getNoticeContent());
        params.add(obj.getCreateTime());
        int i=this.jdbcTemplate.update(sql, params.toArray());

        return i;
    }

    @Override
    public int update(Notice obj) {
        String sql="update sys_notice set user_name=?,notice_title=?,notice_content=?,create_time=? where user_uuid=?";
        List params=new ArrayList();
        params.add(obj.getUserName());
        params.add(obj.getNoticeTitle());
        params.add(obj.getNoticeContent());
        params.add(obj.getCreateTime());
        params.add(obj.getUserUuid());
        int i=this.jdbcTemplate.update(sql, params.toArray());

        return i;
    }

    @Override
    public int remove(String uuid) {
        String sql="delete from sys_notice where user_uuid=?";
        int i=this.jdbcTemplate.update(sql, uuid);

        return i;
    }

    @Override
    public Notice selectByPrimaryKey(String uuid) {
        String sql="select id,uuid,role_name as roleName,role_remark as roleRemark from sys_role where uuid=?";

        Notice  notice=this.jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Notice>(Notice.class), uuid);
        return notice;
    }
}
