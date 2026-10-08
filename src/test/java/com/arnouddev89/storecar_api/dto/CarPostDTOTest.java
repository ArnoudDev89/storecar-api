package com.arnouddev89.storecar_api.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarPostDTOTest {

    @Test
    void deveCriarDTOComBuilder() {
        CarPostDTO dto = CarPostDTO.builder()
                .model("Civic")
                .brand("Honda")
                .price(95000.0)
                .description("Carro bem conservado")
                .engineVersion("2.0 Flex")
                .city("Brasilia")
                .createdDate("2026-01-01")
                .ownerId(1L)
                .ownerName("Arnoud")
                .ownerType("PF")
                .contact("61999999999")
                .build();

        assertThat(dto.getModel()).isEqualTo("Civic");
        assertThat(dto.getBrand()).isEqualTo("Honda");
        assertThat(dto.getPrice()).isEqualTo(95000.0);
        assertThat(dto.getOwnerId()).isEqualTo(1L);
    }

    @Test
    void deveTestarGettersESetters() {
        CarPostDTO dto = new CarPostDTO();
        dto.setModel("Corolla");
        dto.setBrand("Toyota");
        dto.setPrice(105000.0);
        dto.setDescription("Unico dono");
        dto.setEngineVersion("1.8 Hybrid");
        dto.setCity("Goiania");
        dto.setCreatedDate("2026-05-08");
        dto.setOwnerId(10L);
        dto.setOwnerName("Maria");
        dto.setOwnerType("PJ");
        dto.setContact("62988888888");

        assertThat(dto.getModel()).isEqualTo("Corolla");
        assertThat(dto.getBrand()).isEqualTo("Toyota");
        assertThat(dto.getPrice()).isEqualTo(105000.0);
        assertThat(dto.getDescription()).isEqualTo("Unico dono");
        assertThat(dto.getEngineVersion()).isEqualTo("1.8 Hybrid");
        assertThat(dto.getCity()).isEqualTo("Goiania");
        assertThat(dto.getCreatedDate()).isEqualTo("2026-05-08");
        assertThat(dto.getOwnerId()).isEqualTo(10L);
        assertThat(dto.getOwnerName()).isEqualTo("Maria");
        assertThat(dto.getOwnerType()).isEqualTo("PJ");
        assertThat(dto.getContact()).isEqualTo("62988888888");
    }

    @Test
    void deveTestarEqualsEHashCodeGeradosPeloLombok() {
        CarPostDTO dto1 = CarPostDTO.builder().model("Civic").brand("Honda").price(95000.0).build();
        CarPostDTO dto2 = CarPostDTO.builder().model("Civic").brand("Honda").price(95000.0).build();

        assertThat(dto1).isEqualTo(dto2);
        assertThat(dto1.hashCode()).isEqualTo(dto2.hashCode());
    }

    @Test
    void deveTestarNoArgsConstructor() {
        CarPostDTO dto = new CarPostDTO();
        assertThat(dto).isNotNull();
    }

    @Test
    void deveTestarAllArgsConstructor() {
        CarPostDTO dto = new CarPostDTO("Civic", "Honda", 95000.0, "desc", "2.0", "Brasilia", "2026-01-01", 1L, "Arnoud", "PF", "6199999");

        assertThat(dto.getModel()).isEqualTo("Civic");
        assertThat(dto.getBrand()).isEqualTo("Honda");
        assertThat(dto.getOwnerName()).isEqualTo("Arnoud");
    }
}
