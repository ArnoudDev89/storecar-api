package com.arnouddev89.storecar_api.service;

import com.arnouddev89.storecar_api.dto.OwnerPostDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OwnerPostServiceTest {

    @Mock
    private OwnerPostService ownerPostService;

    @Test
    void deveChamarCreateOwnerPost() {
        OwnerPostDTO dto = new OwnerPostDTO();
        dto.setName("Arnoud");
        dto.setType("PF");
        dto.setContactNumber("61999999999");

        doNothing().when(ownerPostService).createOwnerPost(any(OwnerPostDTO.class));

        ownerPostService.createOwnerPost(dto);

        verify(ownerPostService).createOwnerPost(dto);
    }

    @Test
    void deveChamarCreateOwnerPostComQualquerDTO() {
        OwnerPostDTO dto = new OwnerPostDTO();
        doNothing().when(ownerPostService).createOwnerPost(any(OwnerPostDTO.class));

        ownerPostService.createOwnerPost(dto);

        verify(ownerPostService).createOwnerPost(any(OwnerPostDTO.class));
    }
}
