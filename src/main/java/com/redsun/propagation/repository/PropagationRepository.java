package com.redsun.propagation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.redsun.propagation.entity.PropagationEntity;

@Repository
public interface PropagationRepository extends JpaRepository<PropagationEntity, Long> {

}
