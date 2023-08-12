package com.myfarm.myfarmv1.repository;

import com.myfarm.myfarmv1.model.Equipment;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentDBRepository extends CrudRepository<Equipment, Long> {
}
