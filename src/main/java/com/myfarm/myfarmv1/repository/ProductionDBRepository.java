package com.myfarm.myfarmv1.repository;

import com.myfarm.myfarmv1.model.Production;
import org.springframework.data.repository.CrudRepository;

public interface ProductionDBRepository extends CrudRepository<Production, Long> {
}
