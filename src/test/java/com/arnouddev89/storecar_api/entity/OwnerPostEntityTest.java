package com.arnouddev89.storecar_api.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OwnerPostEntityTest {

    @Test
    void deveCriarEntityComGettersESetters() {
        OwnerPostEntity entity = new OwnerPostEntity();
        entity.setId(1L);
        entity.setName("Arnoud");
        entity.setType("PF");
        entity.setContactNumber("61999999999");

        assertThat(entity.getId()).isEqualTo(1L);
        assertThat(entity.getName()).isEqualTo("Arnoud");
        assertThat(entity.getType()).isEqualTo("PF");
        assertThat(entity.getContactNumber()).isEqualTo("61999999999");
    }

    @Test
    void deveTestarEqualsEHashCodeGeradosPeloLombok() {
        OwnerPostEntity entity1 = new OwnerPostEntity();
        entity1.setId(1L);
        entity1.setName("Arnoud");

        OwnerPostEntity entity2 = new OwnerPostEntity();
        entity2.setId(1L);
        entity2.setName("Arnoud");

        assertThat(entity1).isEqualTo(entity2);
        assertThat(entity1.hashCode()).isEqualTo(entity2.hashCode());
    }

    @Test
    void deveTestarNoArgsConstructor() {
        OwnerPostEntity entity = new OwnerPostEntity();
        assertThat(entity).isNotNull();
    }
}
