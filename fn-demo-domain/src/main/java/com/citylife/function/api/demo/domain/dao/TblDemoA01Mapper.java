package com.citylife.function.api.demo.domain.dao;

import com.citylife.function.api.demo.domain.model.TblDemoA01;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TblDemoA01Mapper {
    @Delete({
        "delete from tbl_demo_a01",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into tbl_demo_a01 (id, productid, ",
        "productname, price)",
        "values (#{id,jdbcType=BIGINT}, #{productid,jdbcType=VARCHAR}, ",
        "#{productname,jdbcType=VARCHAR}, #{price,jdbcType=INTEGER})"
    })
    int insert(TblDemoA01 record);

    @Select({
        "select",
        "id, productid, productname, price",
        "from tbl_demo_a01",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="productid", property="productid", jdbcType=JdbcType.VARCHAR),
        @Result(column="productname", property="productname", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER)
    })
    TblDemoA01 selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, productid, productname, price",
        "from tbl_demo_a01"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="productid", property="productid", jdbcType=JdbcType.VARCHAR),
        @Result(column="productname", property="productname", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER)
    })
    List<TblDemoA01> selectAll();

    @Update({
        "update tbl_demo_a01",
        "set productid = #{productid,jdbcType=VARCHAR},",
          "productname = #{productname,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TblDemoA01 record);
}