package com.arnouddev89.storecar_api.controller;

import com.arnouddev89.storecar_api.dto.OwnerPostDTO;
import com.arnouddev89.storecar_api.service.OwnerPostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OwnerPostControllerTest {

    @Mock
    private OwnerPostService ownerPostService;

    @InjectMocks
    private OwnerPostController ownerPostController;

    @Test
    void deveCriarOwnerCom200() {
        var dto = new OwnerPostDTO();
        doNothing().when(ownerPostService).createOwnerPost(any(OwnerPostDTO.class));

        ResponseEntity response = ownerPostController.createOwner(dto);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(ownerPostService).createOwnerPost(any(OwnerPostDTO.class));
    }

    @Test
    void deveChamarServiceAoCriarOwner() {
        var dto = new OwnerPostDTO();
        doNothing().when(ownerPostService).createOwnerPost(any(OwnerPostDTO.class));

        ownerPostController.createOwner(dto);

        verify(ownerPostService).createOwnerPost(dto);
    }
}
