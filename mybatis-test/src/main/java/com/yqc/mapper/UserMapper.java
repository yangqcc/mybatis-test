package com.yqc.mapper;

import com.yqc.entity.UserBean;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * Created by yangqc on 2017/10/30
 */
public interface UserMapper {

    /**
     * 新增用戶
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Insert("insert into user (NAME , ADDRESS, AGE) values (#{name},#{address},#{age})")
    int insertUser(UserBean user) throws Exception;

    /**
     * 修改用戶
     *
     * @param user
     * @param id
     * @return
     * @throws Exception
     */
    int updateUser(UserBean user, int id) throws Exception;

    /**
     * 刪除用戶
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteUser(int id) throws Exception;

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserBean selectUserById(int id) throws Exception;

    /**
     * 查询所有的用户信息
     *
     * @return
     * @throws Exception
     */
    List<UserBean> selectAllUser() throws Exception;
}
