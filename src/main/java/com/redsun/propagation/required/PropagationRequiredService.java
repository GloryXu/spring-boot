package com.redsun.propagation.required;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.redsun.propagation.entity.PropagationEntity;
import com.redsun.propagation.repository.PropagationRepository;

/**
 * @author xuguangrong
 * @description spring事务传播行为为PROPAGATION_REQUIRED服务
 * @date Created at 13:03 2019/1/22
 */
@Service
public class PropagationRequiredService {

    @Autowired
    private PropagationRepository propagationRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(PropagationEntity propagationEntity) {
        propagationRepository.save(propagationEntity);
    }

}
