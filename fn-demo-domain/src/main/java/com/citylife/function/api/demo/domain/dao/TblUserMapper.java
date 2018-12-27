package com.citylife.function.api.demo.domain.dao;

import com.citylife.function.api.demo.domain.model.TblUser;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TblUserMapper {
    @Delete({
        "delete from tbl_user",
        "where userid = #{userid,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userid);

    @Insert({
        "insert into tbl_user (userid, account, ",
        "password, username, ",
        "mobile)",
        "values (#{userid,jdbcType=BIGINT}, #{account,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR}, ",
        "#{mobile,jdbcType=VARCHAR})"
    })
    int insert(TblUser record);

    @Select({
        "select",
        "userid, account, password, username, mobile",
        "from tbl_user",
        "where userid = #{userid,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="userid", property="userid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR)
    })
    TblUser selectByPrimaryKey(Long userid);

    @Select({
        "select",
        "userid, account, password, username, mobile",
        "from tbl_user"
    })
    @Results({
        @Result(column="userid", property="userid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR)
    })
    List<TblUser> selectAll();

    @Update({
        "update tbl_user",
        "set account = #{account,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "username = #{username,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR}",
        "where userid = #{userid,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TblUser record);
}