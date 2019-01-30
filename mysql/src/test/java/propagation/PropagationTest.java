package propagation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.redsun.propagation.entity.PropagationEntity;
import com.redsun.propagation.required.PropagationRequiredService;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import base.BaseTest;

import java.util.UUID;

/**
 * @author xuguangrong
 * @description spring事务传播Test类
 * @date Created at 13:01 2019/1/22
 */
public class PropagationTest extends BaseTest {

    @Autowired
    private PropagationRequiredService propagationRequiredService;

    @Test
    @Rollback
    @Transactional
    public void testInsert() {
        PropagationEntity propagationEntity = new PropagationEntity();
        propagationEntity.setName(UUID.randomUUID().toString());
        PropagationEntity result = propagationRequiredService.save(propagationEntity);
        Assert.notNull(result.getId(), "result id is null!");
    }

}
