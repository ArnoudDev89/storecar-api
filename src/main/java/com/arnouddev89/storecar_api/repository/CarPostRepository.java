package com.arnouddev89.storecar_api.repository;

import com.arnouddev89.storecar_api.entity.CarPostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
// ALTERADO PARA MONGODB - JpaRepository<CarPostEntity, Long> -> MongoRepository<CarPostEntity, String>
public interface CarPostRepository extends MongoRepository<CarPostEntity, String> {

}