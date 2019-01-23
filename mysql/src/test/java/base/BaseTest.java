package base;

/**
 * @author xuguangrong
 * @description 测试基类
 * @date Created at 13:02 2019/1/22
 */

import com.redsun.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xuguangrong
 * @description Mysql测试
 * @date Created at 22:11 2018/10/27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@Rollback
@Transactional(transactionManager = "transactionManager")
public abstract class BaseTest {

}
