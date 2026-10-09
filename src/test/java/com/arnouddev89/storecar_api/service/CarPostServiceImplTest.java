package com.arnouddev89.storecar_api.service;

import com.arnouddev89.storecar_api.dto.CarPostDTO;
import com.arnouddev89.storecar_api.entity.CarPostEntity;
import com.arnouddev89.storecar_api.entity.OwnerPostEntity;
import com.arnouddev89.storecar_api.repository.CarPostRepository;
import com.arnouddev89.storecar_api.repository.OwnerPostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarPostServiceImplTest {

    @Mock
    private CarPostRepository carPostRepository;

    @Mock
    private OwnerPostRepository ownerPostRepository;

    @InjectMocks
    private CarPostServiceImpl carPostService;

    @Test
    void deveCriarNewPostDetailsSemOwner() {
        CarPostDTO dto = CarPostDTO.builder()
                .model("Civic")
                .brand("Honda")
                .price(95000.0)
                .city("Brasilia")
                .build();

        when(carPostRepository.save(any(CarPostEntity.class))).thenAnswer(i -> i.getArgument(0));

        carPostService.newPostDetails(dto);

        verify(carPostRepository).save(any(CarPostEntity.class));
    }

    @Test
    void deveCriarNewPostDetailsComOwner() {
        OwnerPostEntity owner = new OwnerPostEntity();
        owner.setId(1L);
        owner.setName("Arnoud");
        owner.setContactNumber("61999999999");

        CarPostDTO dto = CarPostDTO.builder()
                .model("Civic")
                .ownerId(1L)
                .build();

        when(ownerPostRepository.findById(1L)).thenReturn(Optional.of(owner));
        when(carPostRepository.save(any(CarPostEntity.class))).thenAnswer(i -> i.getArgument(0));

        carPostService.newPostDetails(dto);

        verify(ownerPostRepository).findById(1L);
        verify(carPostRepository).save(any(CarPostEntity.class));
    }

    @Test
    void deveLancarExcecaoQuandoOwnerNaoEncontrado() {
        CarPostDTO dto = CarPostDTO.builder().ownerId(99L).build();
        when(ownerPostRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> carPostService.newPostDetails(dto))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Owner não encontrado");
    }

    @Test
    void deveListarCarSales() {
        OwnerPostEntity owner = new OwnerPostEntity();
        owner.setName("Joao");

        CarPostEntity entity = new CarPostEntity();
        entity.setModel("Corolla");
        entity.setBrand("Toyota");
        entity.setPrice(100000.0);
        entity.setOwnerPost(owner);

        when(carPostRepository.findAll()).thenReturn(List.of(entity));

        List<CarPostDTO> result = carPostService.getCarSales();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getModel()).isEqualTo("Corolla");
        assertThat(result.get(0).getOwnerName()).isEqualTo("Joao");
    }

    @Test
    void deveAlterarVendaComSucesso() {
        CarPostEntity existing = new CarPostEntity();
        existing.setModel("Antigo");

        CarPostDTO dto = CarPostDTO.builder()
                .model("Novo")
                .brand("Honda")
                .price(90000.0)
                .description("Nova desc")
                .contact("619999")
                .engineVersion("2.0")
                .build();

        when(carPostRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(carPostRepository.save(any(CarPostEntity.class))).thenAnswer(i -> i.getArgument(0));

        carPostService.changeCarSale(dto, 1L);

        verify(carPostRepository).save(any(CarPostEntity.class));
        assertThat(existing.getModel()).isEqualTo("Novo");
    }

    @Test
    void deveLancarExcecaoQuandoCarroNaoEncontradoNoChange() {
        CarPostDTO dto = new CarPostDTO();
        when(carPostRepository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> carPostService.changeCarSale(dto, 1L))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("Carro não encontrado");
    }

    @Test
    void deveRemoverVenda() {
        doNothing().when(carPostRepository).deleteById(10L);

        carPostService.removeCarSale(10L);

        verify(carPostRepository).deleteById(10L);
    }

    @Test
    void deveCriarNewCarPost() {
        CarPostDTO dto = CarPostDTO.builder()
                .model("Uno")
                .brand("Fiat")
                .city("Goiania")
                .build();

        when(carPostRepository.save(any(CarPostEntity.class))).thenAnswer(i -> i.getArgument(0));

        carPostService.newCarPost(dto);

        verify(carPostRepository).save(any(CarPostEntity.class));
    }
}
