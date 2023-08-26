package com.myfarm.myfarmv1.repository;

import com.myfarm.myfarmv1.model.Activity;
import org.springframework.data.repository.CrudRepository;

public interface ActivityDBRepository extends CrudRepository<Activity, Long> {
}
