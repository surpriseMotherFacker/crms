package com.cwx.dao.impl;

import com.cwx.dao.RoleDao;
import com.cwx.dto.PageDTO;
import com.cwx.dto.RoleSearchDTO;
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

/**
 * @author nick
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BootstrapTableVO search(RoleSearchDTO pageDTO) {
        BootstrapTableVO  bootstrapTableVO=new BootstrapTableVO();

        List params=new ArrayList();

        StringBuffer sql=new StringBuffer("select * from sys_role where 1=1");
        //有可能带条件的
        if (StringUtils.isNotBlank(pageDTO.getRoleName())){
            sql.append(" and role_name like ?");
            params.add("%"+pageDTO.getRoleName()+"%");
        }
        //分页必须有
        sql.append("   limit ? , ?  ");
        params.add(pageDTO.getOffset());
        params.add(pageDTO.getLimit());

        List<Role> arr=this.jdbcTemplate.query(sql.toString(),new BeanPropertyRowMapper<Role>(Role.class),params.toArray());

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
    public int insert(Role obj) {
        String sql="insert into sys_role(uuid,role_name,role_remark) values(?,?,?)";
        List params=new ArrayList();
        params.add(obj.getUuid());
        params.add(obj.getRoleName());
        params.add(obj.getRoleRemark());

        int i=this.jdbcTemplate.update(sql, params.toArray());

        return i;
    }

    @Override
    public int update(Role obj) {
        String sql="update sys_role set role_name=?,role_remark=?  where uuid=?";
        List params=new ArrayList();
        params.add(obj.getRoleName());
        params.add(obj.getRoleRemark());
        params.add(obj.getUuid());

        int i=this.jdbcTemplate.update(sql, params.toArray());

        return i;
    }

    @Override
    public int remove(String uuid) {
        String sql="delete from sys_role where uuid=?";
        int i=this.jdbcTemplate.update(sql, uuid);

        return i;
    }

    @Override
    public Role selectByPrimaryKey(String uuid) {
        String sql="select id,uuid,role_name as roleName,role_remark as roleRemark from sys_role where uuid=?";

        Role  role=this.jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Role>(Role.class), uuid);
        return role;
    }
}
