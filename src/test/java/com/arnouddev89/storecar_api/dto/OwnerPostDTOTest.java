package com.arnouddev89.storecar_api.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OwnerPostDTOTest {

    @Test
    void deveCriarDTOComBuilder() {
        OwnerPostDTO dto = OwnerPostDTO.builder()
                .name("Arnoud")
                .type("PF")
                .contactNumber("61999999999")
                .build();

        assertThat(dto.getName()).isEqualTo("Arnoud");
        assertThat(dto.getType()).isEqualTo("PF");
        assertThat(dto.getContactNumber()).isEqualTo("61999999999");
    }

    @Test
    void deveTestarGettersESetters() {
        OwnerPostDTO dto = new OwnerPostDTO();
        dto.setName("Maria");
        dto.setType("PJ");
        dto.setContactNumber("62988888888");

        assertThat(dto.getName()).isEqualTo("Maria");
        assertThat(dto.getType()).isEqualTo("PJ");
        assertThat(dto.getContactNumber()).isEqualTo("62988888888");
    }

    @Test
    void deveTestarEqualsEHashCodeGeradosPeloLombok() {
        OwnerPostDTO dto1 = OwnerPostDTO.builder().name("Arnoud").type("PF").contactNumber("6199999").build();
        OwnerPostDTO dto2 = OwnerPostDTO.builder().name("Arnoud").type("PF").contactNumber("6199999").build();

        assertThat(dto1).isEqualTo(dto2);
        assertThat(dto1.hashCode()).isEqualTo(dto2.hashCode());
    }

    @Test
    void deveTestarNoArgsConstructor() {
        OwnerPostDTO dto = new OwnerPostDTO();
        assertThat(dto).isNotNull();
    }

    @Test
    void deveTestarAllArgsConstructor() {
        OwnerPostDTO dto = new OwnerPostDTO("Arnoud", "PF", "61999999999");

        assertThat(dto.getName()).isEqualTo("Arnoud");
        assertThat(dto.getType()).isEqualTo("PF");
        assertThat(dto.getContactNumber()).isEqualTo("61999999999");
    }
}
