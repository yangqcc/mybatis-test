import com.yqc.entity.ClassBean;
import com.yqc.entity.UserBean;
import com.yqc.mapper.UserMapper;
import com.yqc.util.DbTools;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-08-07
 * @modified By yangqc
 */
@Slf4j
public class TestMyBatis {

  @Test
  public void insertUser() {
    SqlSession session = DbTools.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    UserBean user = new UserBean("nicholas", "berlin", 29, new ClassBean("一班", "这里是一年级一班!"));
    try {
      int index = mapper.insertUser(user);
      boolean bool = index > 0 ? true : false;
      log.error("新增用户user对象:{},操作状态:{}", new Object[]{user, bool});
      session.commit();
    } catch (Exception e) {
      e.printStackTrace();
      session.rollback();
    } finally {
      session.close();
    }
  }

  /**
   * 根据id查询用户
   */
  @Test
  public void selectUserById() {
    SqlSession session = DbTools.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    try {
      int id = 1;
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

}
