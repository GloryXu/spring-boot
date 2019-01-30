package base;

/**
 * @author xuguangrong
 * @description 测试基类
 * @date Created at 13:02 2019/1/22
 */

import com.redsun.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xuguangrong
 * @description Mysql测试
 * @date Created at 22:11 2018/10/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public abstract class BaseTest {

}
