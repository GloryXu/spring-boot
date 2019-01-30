package test.redsun;

import com.redsun.config.RedisConfig;
import com.redsun.dbdemo.entity.Department;
import com.redsun.dbdemo.entity.Role;
import com.redsun.dbdemo.entity.User;
import com.redsun.repository.UserRedis;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;
import test.redsun.base.BaseTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author xuguangrong
 * @description redis测试类
 * @date Created at 17:45 2019/1/28
 */
@ContextConfiguration(classes = {RedisConfig.class, UserRedis.class})
public class RedisTest extends BaseTest {
    private static Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    UserRedis userRedis;

    @Before
    public void setup() {
        Department department = new Department();
        department.setName("开发部");

        Role role = new Role();
        role.setName("admin");

        User user = new User();
        user.setName("user");
        user.setCreatedate(new Date());
        user.setDepartment(department);

        List<Role> roles = new ArrayList<>();
        roles.add(role);

        user.setRoles(roles);

        userRedis.delete(this.getClass().getName() + ":userByname:" + user.getName());
        userRedis.add(this.getClass().getName() + ":userByname:" + user.getName(), 10L, user);
    }

    @Test
    public void get() {
        User user = userRedis.get(this.getClass().getName() + ":userByname:user");

        Assert.notNull(user, "user is null!");
        logger.info("==========user========= name:{}, department:{}, role:{}",user.getName(), user.getDepartment().getName()
        , user.getRoles().get(0).getName());
    }

}
