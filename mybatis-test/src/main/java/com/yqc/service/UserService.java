package com.yqc.service;

import com.yqc.entity.ClassBean;
import com.yqc.entity.UserBean;
import com.yqc.mapper.ClassMapper;
import com.yqc.mapper.UserMapper;
import com.yqc.util.DbTools;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

/**
 * @author yangqc
 */
@Slf4j
public class UserService {

  public static void main(String[] args) {
    // insertUser();
    //deleteUser(1);
    //selectUserById(2);
    selectAllUser();
  }

  /**
   * 新增用户
   */
  private static boolean insertUser() {
    SqlSession session = DbTools.getSession();
    UserMapper userMapper = session.getMapper(UserMapper.class);
    ClassMapper classMapper = session.getMapper(ClassMapper.class);
    ClassBean classBean = new ClassBean(1, "一班", "这里是一年级一班!");
    UserBean user = new UserBean("nicholas", "berlin", 29, classBean);
    try {
      classMapper.insertClass(classBean);
      int index = userMapper.insertUser(user);
      boolean bool = index > 0;
      log.error("新增用户user对象:{},操作状态:{}", new Object[]{user, bool});
      session.commit();
      return bool;
    } catch (Exception e) {
      e.printStackTrace();
      session.rollback();
      return false;
    } finally {
      session.close();
    }
  }


  /**
   * 删除用户
   *
   * @param id 用户ID
   */
  private static boolean deleteUser(int id) {
    SqlSession session = DbTools.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    try {
      int index = mapper.deleteUser(id);
      boolean bool = index > 0 ? true : false;
      log.debug("根据用户id:{},操作状态{}", new Object[]{id, bool});
      session.commit();
      return bool;
    } catch (Exception e) {
      e.printStackTrace();
      session.rollback();
      return false;
    } finally {
      session.close();
    }
  }


  /**
   * 根据id查询用户
   */
  private static void selectUserById(int id) {
    SqlSession session = DbTools.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    try {
      UserBean userBean = mapper.selectUserById(id);
      log.debug("根据用户Id:{},查询用户信息:{}", new Object[]{id, userBean});
      session.commit();
    } catch (Exception e) {
      e.printStackTrace();
      session.rollback();
    } finally {
      session.close();
    }
  }

  /**
   * 查询所有的用户
   */
  private static void selectAllUser() {
    SqlSession session = DbTools.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    try {
      List<UserBean> userBean = mapper.selectAllUser();
      log.debug("获取所用的用户:{}", userBean);
      session.commit();
    } catch (Exception e) {
      e.printStackTrace();
      session.rollback();
    } finally {
      session.close();
    }
  }
}
