package test.propagation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.redsun.propagation.entity.PropagationEntity;
import com.redsun.propagation.required.PropagationRequiredService;
import test.base.BaseTest;

/**
 * @author xuguangrong
 * @description spring事务传播Test类
 * @date Created at 13:01 2019/1/22
 */
public class PropagationTest extends BaseTest {

    @Autowired
    private PropagationRequiredService propagationRequiredService;

    @Test
    public void testInsert() {
        PropagationEntity propagationEntity = new PropagationEntity();
        propagationEntity.setName("111");
        propagationRequiredService.save(propagationEntity);
    }

}
