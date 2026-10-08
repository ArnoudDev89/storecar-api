package com.arnouddev89.storecar_api.service;

import com.arnouddev89.storecar_api.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostService {

    void newPostDetails(CarPostDTO carPostDTO);
    List<CarPostDTO> getCarSales();
    void changeCarSale(CarPostDTO carPostDTO, Long postId);
    void removeCarSale(Long postId);
}