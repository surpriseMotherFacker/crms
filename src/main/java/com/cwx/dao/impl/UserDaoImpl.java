package com.cwx.dao.impl;

import com.cwx.dao.UserDao;
import com.cwx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nick
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> search() {
        String sql="select * from sys_user";
        List<User> arr=this.jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
        return arr;
    }

    @Override
    public int insert(User obj) {
        String sql="insert into sys_user(uuid,login_name,lgoin_password,user_real_name,user_nick_name,user_contact_phone,user_contact_address) values(?,?,?,?,?,?,?)";
        List params=new ArrayList();
        params.add(obj.getUuid());
        params.add(obj.getLoginName());
        params.add(obj.getLoginPassword());
        params.add(obj.getUserRealName());
        params.add(obj.getUserNickName());
        params.add(obj.getUserContactPhone());
        params.add(obj.getUserContactAddress());
        int i=this.jdbcTemplate.update(sql, params.toArray());

        return i;
    }

    @Override
    public int update(User obj) {
        String sql="update sys_user set login_name=?,lgoin_password=?,user_real_name=?,user_nick_name=?,user_contact_phone=?,user_contact_address=? where uuid=?";
        List params=new ArrayList();
        params.add(obj.getLoginName());
        params.add(obj.getLoginPassword());
        params.add(obj.getUserRealName());
        params.add(obj.getUserNickName());
        params.add(obj.getUserContactPhone());
        params.add(obj.getUserContactAddress());
        params.add(obj.getUuid());

        int i=this.jdbcTemplate.update(sql, params.toArray());

        return i;
    }

    @Override
    public int delete(String uuid) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(String uuid) {
        String sql="select * from sys_user where uuid=?";

        User  user=this.jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class), uuid);
        return user;
    }
}
