package com.yqc.mapper;

import com.yqc.entity.UserBean;
import java.util.List;
import org.apache.ibatis.annotations.Insert;

/**
 * @author yangqc
 */
public interface UserMapper {

  /**
   * 新增用戶
   */
  @Insert("insert into user (NAME , ADDRESS, AGE , CLASS_ID) values (#{name},#{address},#{age},#{classBean.id})")
  int insertUser(UserBean userBean) throws Exception;

  /**
   * 修改用戶
   * @param userBean
   * @param id
   * @return
   * @throws Exception
   */
  int updateUser(UserBean userBean, int id) throws Exception;

  /**
   * 刪除用戶
   */
  int deleteUser(int id) throws Exception;

  /**
   * 根据id查询用户信息
   */
  UserBean selectUserById(int id) throws Exception;

  /**
   * 查询所有的用户信息
   */
  List<UserBean> selectAllUser() throws Exception;
}
