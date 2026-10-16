package com.arnouddev89.storecar_api.repository;

import com.arnouddev89.storecar_api.entity.CarPostEntity;
import com.arnouddev89.storecar_api.entity.OwnerPostEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarPostRepositoryTest {

    @Mock
    private CarPostRepository carPostRepository;

    @Test
    void deveSalvarCarPost() {
        OwnerPostEntity owner = new OwnerPostEntity();
        owner.setId("1"); // CORRIGIDO - era 1L

        CarPostEntity entity = new CarPostEntity();
        entity.setId("10"); // CORRIGIDO - era 10L
        entity.setModel("Civic");
        entity.setOwnerPost(owner);

        when(carPostRepository.save(any(CarPostEntity.class))).thenReturn(entity);

        CarPostEntity saved = carPostRepository.save(entity);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isEqualTo("10"); // CORRIGIDO
        assertThat(saved.getModel()).isEqualTo("Civic");
        verify(carPostRepository).save(entity);
    }

    @Test
    void deveBuscarPorId() {
        CarPostEntity entity = new CarPostEntity();
        entity.setId("1"); // CORRIGIDO
        entity.setModel("Corolla");

        when(carPostRepository.findById("1")).thenReturn(Optional.of(entity)); // CORRIGIDO

        Optional<CarPostEntity> found = carPostRepository.findById("1"); // CORRIGIDO

        assertThat(found).isPresent();
        assertThat(found.get().getModel()).isEqualTo("Corolla");
    }

    @Test
    void deveListarTodos() {
        when(carPostRepository.findAll()).thenReturn(List.of(new CarPostEntity(), new CarPostEntity()));

        var list = carPostRepository.findAll();

        assertThat(list).hasSize(2);
    }

    @Test
    void deveDeletarPorId() {
        doNothing().when(carPostRepository).deleteById("1"); // CORRIGIDO

        carPostRepository.deleteById("1"); // CORRIGIDO

        verify(carPostRepository).deleteById("1"); // CORRIGIDO
    }
}