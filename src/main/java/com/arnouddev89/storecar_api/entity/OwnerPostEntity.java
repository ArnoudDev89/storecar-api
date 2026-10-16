package com.arnouddev89.storecar_api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

// ALTERADO PARA MONGODB
@Document(collection = "owner_post") // ANTES: @Entity @Table(name = "owner_post")
@Data
@NoArgsConstructor
public class OwnerPostEntity {

    @Id
    // ALTERADO: String + sem @GeneratedValue
    private String id;

    private String name;

    @Field("owner_type") // ANTES: @Column(name = "owner_type")
    private String type;

    @Field("owner_contact")
    private String contactNumber;
}