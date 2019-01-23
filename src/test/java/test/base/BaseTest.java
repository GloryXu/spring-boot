package test.base;

/**
 * @author xuguangrong
 * @description 测试基类
 * @date Created at 13:02 2019/1/22
 */

import com.redsun.common.JpaConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xuguangrong
 * @description Mysql测试
 * @date Created at 22:11 2018/10/27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public abstract class BaseTest {

}
