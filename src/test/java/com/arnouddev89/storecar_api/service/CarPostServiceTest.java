package com.arnouddev89.storecar_api.service;

import com.arnouddev89.storecar_api.dto.CarPostDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarPostServiceTest {

    @Mock
    private CarPostService carPostService;

    @Test
    void deveChamarNewPostDetails() {
        CarPostDTO dto = new CarPostDTO();
        doNothing().when(carPostService).newPostDetails(any(CarPostDTO.class));

        carPostService.newPostDetails(dto);

        verify(carPostService).newPostDetails(dto);
    }

    @Test
    void deveChamarGetCarSales() {
        CarPostDTO dto = new CarPostDTO();
        when(carPostService.getCarSales()).thenReturn(List.of(dto));

        List<CarPostDTO> result = carPostService.getCarSales();

        assertThat(result).hasSize(1);
        verify(carPostService).getCarSales();
    }

    @Test
    void deveChamarChangeCarSale() {
        CarPostDTO dto = new CarPostDTO();
        doNothing().when(carPostService).changeCarSale(any(CarPostDTO.class), eq("1")); // CORRIGIDO

        carPostService.changeCarSale(dto, "1"); // CORRIGIDO

        verify(carPostService).changeCarSale(dto, "1"); // CORRIGIDO
    }

    @Test
    void deveChamarRemoveCarSale() {
        doNothing().when(carPostService).removeCarSale(eq("10")); // CORRIGIDO

        carPostService.removeCarSale("10"); // CORRIGIDO

        verify(carPostService).removeCarSale("10"); // CORRIGIDO
    }

    @Test
    void deveChamarNewCarPost() {
        CarPostDTO dto = new CarPostDTO();
        doNothing().when(carPostService).newCarPost(any(CarPostDTO.class));

        carPostService.newCarPost(dto);

        verify(carPostService).newCarPost(dto);
    }
}