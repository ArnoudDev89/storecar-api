package com.arnouddev89.storecar_api.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarPostEntityTest {

    @Test
    void deveCriarEntityComGettersESetters() {
        CarPostEntity entity = new CarPostEntity();
        OwnerPostEntity owner = new OwnerPostEntity();
        owner.setId(1L);

        entity.setId(10L);
        entity.setModel("Civic");
        entity.setBrand("Honda");
        entity.setPrice(95000.0);
        entity.setDescription("Bem conservado");
        entity.setEngineVersion("2.0 Flex");
        entity.setCity("Brasilia");
        entity.setCreatedDate("2026-01-01");
        entity.setContact("61999999999");
        entity.setOwnerPost(owner);

        assertThat(entity.getId()).isEqualTo(10L);
        assertThat(entity.getModel()).isEqualTo("Civic");
        assertThat(entity.getBrand()).isEqualTo("Honda");
        assertThat(entity.getPrice()).isEqualTo(95000.0);
        assertThat(entity.getDescription()).isEqualTo("Bem conservado");
        assertThat(entity.getEngineVersion()).isEqualTo("2.0 Flex");
        assertThat(entity.getCity()).isEqualTo("Brasilia");
        assertThat(entity.getCreatedDate()).isEqualTo("2026-01-01");
        assertThat(entity.getContact()).isEqualTo("61999999999");
        assertThat(entity.getOwnerPost()).isEqualTo(owner);
        assertThat(entity.getOwnerPost().getId()).isEqualTo(1L);
    }

    @Test
    void deveTestarEqualsEHashCodeGeradosPeloLombok() {
        CarPostEntity entity1 = new CarPostEntity();
        entity1.setId(1L);
        entity1.setModel("Civic");

        CarPostEntity entity2 = new CarPostEntity();
        entity2.setId(1L);
        entity2.setModel("Civic");

        assertThat(entity1).isEqualTo(entity2);
        assertThat(entity1.hashCode()).isEqualTo(entity2.hashCode());
    }

    @Test
    void deveTestarNoArgsConstructor() {
        CarPostEntity entity = new CarPostEntity();
        assertThat(entity).isNotNull();
    }
}
