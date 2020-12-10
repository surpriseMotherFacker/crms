package com.cwx.util;

/**
 * @author nick
 */
public class SqlUtil {

    /**  select *            from 表  where 列=?  and 列 like ?  limit ?,?
     *   select count(*)     from 表  where 列=?  and 列 like ?
     * 生成sql count语句
     * @param sql
     * @return
     */
    public static String sqlCount(String sql){
        sql=sql.toLowerCase();

         int fromIndex=sql.indexOf("from ");
         int limitIndex=sql.lastIndexOf("limit");
         String tempSql="select count(*) "+sql.substring(fromIndex,limitIndex);
         return tempSql;
    }
}
