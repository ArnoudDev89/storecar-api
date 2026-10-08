package com.arnouddev89.storecar_api.controller;

import com.arnouddev89.storecar_api.dto.CarPostDTO;
import com.arnouddev89.storecar_api.service.CarPostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarPostControllerTest {

    @Mock
    private CarPostService carPostService;

    @InjectMocks
    private CarPostController carPostController;

    @Test
    void deveCriarVendaDeCarroCom201() {
        var dto = new CarPostDTO();
        doNothing().when(carPostService).newCarPost(any(CarPostDTO.class));

        ResponseEntity<Void> response = carPostController.postCarSale(dto);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        verify(carPostService).newCarPost(any(CarPostDTO.class));
    }

    @Test
    void deveListarVendasDeCarrosCom200() {
        var dto = new CarPostDTO();
        when(carPostService.getCarSales()).thenReturn(List.of(dto));

        ResponseEntity<List<CarPostDTO>> response = carPostController.getCarSales();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(1);
        verify(carPostService).getCarSales();
    }

    @Test
    void deveListarVazioQuandoNaoHaVendas() {
        when(carPostService.getCarSales()).thenReturn(Collections.emptyList());

        ResponseEntity<List<CarPostDTO>> response = carPostController.getCarSales();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEmpty();
    }

    @Test
    void deveAlterarVendaDeCarroCom200() {
        var dto = new CarPostDTO();
        String id = "1";
        doNothing().when(carPostService).changeCarSale(any(CarPostDTO.class), eq(1L));

        ResponseEntity response = carPostController.changeCarSale(dto, id);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(carPostService).changeCarSale(any(CarPostDTO.class), eq(1L));
    }

    @Test
    void deveDeletarVendaDeCarroCom200() {
        String id = "10";
        doNothing().when(carPostService).removeCarSale(eq(10L));

        ResponseEntity response = carPostController.deleteCarSale(id);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(carPostService).removeCarSale(eq(10L));
    }
}
