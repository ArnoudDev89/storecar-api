package com.arnouddev89.storecar_api.repository;

import com.arnouddev89.storecar_api.entity.OwnerPostEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerPostRepositoryTest {

    @Mock
    private OwnerPostRepository ownerPostRepository;

    @Test
    void deveSalvarOwner() {
        OwnerPostEntity entity = new OwnerPostEntity();
        entity.setId(1L);
        entity.setName("Arnoud");
        entity.setType("PF");
        entity.setContactNumber("61999999999");

        when(ownerPostRepository.save(any(OwnerPostEntity.class))).thenReturn(entity);

        OwnerPostEntity saved = ownerPostRepository.save(entity);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isEqualTo(1L);
        assertThat(saved.getName()).isEqualTo("Arnoud");
        verify(ownerPostRepository).save(entity);
    }

    @Test
    void deveBuscarPorId() {
        OwnerPostEntity entity = new OwnerPostEntity();
        entity.setId(1L);
        entity.setName("Maria");

        when(ownerPostRepository.findById(1L)).thenReturn(Optional.of(entity));

        var found = ownerPostRepository.findById(1L);

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Maria");
    }

    @Test
    void deveListarTodos() {
        when(ownerPostRepository.findAll()).thenReturn(List.of(new OwnerPostEntity(), new OwnerPostEntity()));

        var list = ownerPostRepository.findAll();

        assertThat(list).hasSize(2);
    }

    @Test
    void deveDeletarPorId() {
        doNothing().when(ownerPostRepository).deleteById(1L);

        ownerPostRepository.deleteById(1L);

        verify(ownerPostRepository).deleteById(1L);
    }
}
