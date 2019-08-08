package com.yqc.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * <p>title:配置文件注册自定义类型转换器,布尔类型转换器</p>
 * <p>description:代理模式</p>
 *
 * @author yangqc
 * @date Created in 2019-08-08
 * @modified By yangqc
 */
public class MyTypeHandler implements TypeHandler {

  /**
   * 设置值转换
   *
   * @param ps
   * @param i
   * @param parameter
   * @param jdbcType
   * @throws SQLException
   */
  @Override
  public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
      throws SQLException {
    //flag设置为0
    if (parameter == null) {
      ps.setInt(i, 0);
    }
    Boolean flag = (Boolean) parameter;
    if (flag) {
      ps.setInt(i, 1);
    } else {
      ps.setInt(i, 0);
    }
  }

  /**
   * 查询结束后，将ResultSet数据行转换为实体类对象。 将我们当前数据行中某个字段转换为指定类型
   *
   * @param rs
   * @param columnName
   * @return
   * @throws SQLException
   */
  @Override
  public Object getResult(ResultSet rs, String columnName) throws SQLException {
    int flag = rs.getInt(columnName);
    return flag == 1;
  }

  @Override
  public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
    return null;
  }

  @Override
  public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
    return null;
  }
}
