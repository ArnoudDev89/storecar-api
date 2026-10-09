package com.arnouddev89.storecar_api.service;

import com.arnouddev89.storecar_api.dto.OwnerPostDTO;
import com.arnouddev89.storecar_api.entity.OwnerPostEntity;
import com.arnouddev89.storecar_api.repository.OwnerPostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerPostServiceImplTest {

    @Mock
    private OwnerPostRepository ownerPostRepository;

    @InjectMocks
    private OwnerPostServiceImpl ownerPostService;

    @Test
    void deveCriarOwnerPostComSucesso() {
        OwnerPostDTO dto = new OwnerPostDTO();
        dto.setName("Arnoud");
        dto.setType("PF");
        dto.setContactNumber("61999999999");

        OwnerPostEntity saved = new OwnerPostEntity();
        saved.setId(1L);
        saved.setName("Arnoud");

        when(ownerPostRepository.save(any(OwnerPostEntity.class))).thenReturn(saved);

        ownerPostService.createOwnerPost(dto);

        ArgumentCaptor<OwnerPostEntity> captor = ArgumentCaptor.forClass(OwnerPostEntity.class);
        verify(ownerPostRepository).save(captor.capture());

        OwnerPostEntity entitySalva = captor.getValue();
        assertThat(entitySalva.getName()).isEqualTo("Arnoud");
        assertThat(entitySalva.getType()).isEqualTo("PF");
        assertThat(entitySalva.getContactNumber()).isEqualTo("61999999999");
    }

    @Test
    void deveChamarRepositoryAoCriarOwner() {
        OwnerPostDTO dto = new OwnerPostDTO();
        dto.setName("Maria");
        dto.setType("PJ");
        dto.setContactNumber("62988888888");

        when(ownerPostRepository.save(any(OwnerPostEntity.class))).thenAnswer(i -> i.getArgument(0));

        ownerPostService.createOwnerPost(dto);

        verify(ownerPostRepository).save(any(OwnerPostEntity.class));
    }

    @Test
    void deveMapearTodosCamposDoDTOParaEntity() {
        OwnerPostDTO dto = new OwnerPostDTO();
        dto.setName("Teste Nome");
        dto.setType("PF");
        dto.setContactNumber("61911112222");

        when(ownerPostRepository.save(any(OwnerPostEntity.class))).thenAnswer(i -> i.getArgument(0));

        ownerPostService.createOwnerPost(dto);

        ArgumentCaptor<OwnerPostEntity> captor = ArgumentCaptor.forClass(OwnerPostEntity.class);
        verify(ownerPostRepository).save(captor.capture());

        assertThat(captor.getValue().getName()).isEqualTo("Teste Nome");
        assertThat(captor.getValue().getType()).isEqualTo("PF");
        assertThat(captor.getValue().getContactNumber()).isEqualTo("61911112222");
    }
}
