package com.arnouddev89.storecar_api.repository;

import com.arnouddev89.storecar_api.entity.OwnerPostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
// ALTERADO PARA MONGODB - JpaRepository<OwnerPostEntity, Long> -> MongoRepository<OwnerPostEntity, String>
public interface OwnerPostRepository extends MongoRepository<OwnerPostEntity, String> {
}