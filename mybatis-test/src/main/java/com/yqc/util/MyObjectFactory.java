package com.yqc.util;

import com.yqc.entity.UserBean;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-08-08
 * @modified By yangqc
 */
public class MyObjectFactory extends DefaultObjectFactory {

  @Override
  public <T> T create(Class<T> type) {
    if (UserBean.class == type) {
      UserBean t = (UserBean) super.create(type);
      return (T) t;
    }
    return super.create(type);
  }
}
