package com.arnouddev89.storecar_api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

// ALTERADO PARA MONGODB
@Document(collection = "car_post") // ANTES: @Entity @Table(name="car_post")
@Data
@NoArgsConstructor
public class CarPostEntity {

    @Id
    // ALTERADO PARA MONGODB - String no lugar de Long + sem @GeneratedValue (Mongo gera ObjectId sozinho)
    private String id;

    @Field("car_model") // ANTES: @Column(name = "car_model")
    private String model;

    @Field("car_brand")
    private String brand;

    @Field("car_price")
    private Double price;

    @Field("car_description")
    private String description;

    @Field("car_engine")
    private String engineVersion;

    @Field("car_city")
    private String city;

    @Field("car_created")
    private String createdDate;

    @Field("car_post_contact")
    private String contact;

    // ALTERADO PARA MONGODB - @ManyToOne + @JoinColumn viram @DBRef
    // Isso cria uma referência pra outra collection igual JOIN fazia
    @DBRef
    private OwnerPostEntity ownerPost;
}