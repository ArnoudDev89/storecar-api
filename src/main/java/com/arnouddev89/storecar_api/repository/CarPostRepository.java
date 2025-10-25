package com.arnouddev89.storecar_api.repository;

import com.arnouddev89.storecar_api.entity.CarPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPostRepository extends JpaRepository<CarPostEntity, Long> {


}
