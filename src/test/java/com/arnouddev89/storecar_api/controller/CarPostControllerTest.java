package com.arnouddev89.storecar_api.controller;

import com.arnouddev89.storecar_api.dto.CarPostDTO;
import com.arnouddev89.storecar_api.service.CarPostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CarPostController.class)
class CarPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CarPostService carPostService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarVendaDeCarroCom201() throws Exception {
        var dto = new CarPostDTO(); // Se tiver campos obrigatórios, preencha aqui
        doNothing().when(carPostService).newCarPost(any(CarPostDTO.class));

        mockMvc.perform(post("/sales/car")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated());

        verify(carPostService).newCarPost(any(CarPostDTO.class));
    }

    @Test
    void deveListarVendasDeCarrosCom200() throws Exception {
        CarPostDTO dto = new CarPostDTO();
        when(carPostService.getCarSales()).thenReturn(List.of(dto));

        mockMvc.perform(get("/sales/cars"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1));

        verify(carPostService).getCarSales();
    }

    @Test
    void deveListarVazioQuandoNaoHaVendas() throws Exception {
        when(carPostService.getCarSales()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/sales/cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    void deveAlterarVendaDeCarroCom200() throws Exception {
        var dto = new CarPostDTO();
        String id = "1";
        doNothing().when(carPostService).changeCarSale(any(CarPostDTO.class), eq(1L));

        mockMvc.perform(put("/sales/car/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

        verify(carPostService).changeCarSale(any(CarPostDTO.class), eq(1L));
    }

    @Test
    void deveDeletarVendaDeCarroCom200() throws Exception {
        String id = "10";
        doNothing().when(carPostService).removeCarSale(eq(10L));

        mockMvc.perform(delete("/sales/car/{id}", id))
                .andExpect(status().isOk());

        verify(carPostService).removeCarSale(eq(10L));
    }
}
