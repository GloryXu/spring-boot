package test.redsun.base;

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
