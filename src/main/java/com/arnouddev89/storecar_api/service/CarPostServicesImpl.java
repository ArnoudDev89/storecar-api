package com.arnouddev89.storecar_api.service;

import com.arnouddev89.storecar_api.dto.CarPostDTO;
import com.arnouddev89.storecar_api.entity.CarPostEntity;
import com.arnouddev89.storecar_api.repository.CarPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarPostServicesImpl implements CarPostService {


    @Autowired
    private CarPostRepository carPostRepository;


    @Override
    public List<CarPostDTO> getCarSales() {
        List<CarPostDTO> listCarSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item -> {
            listCarSales.add(mapCarEntityToDTO(item));
        });
        return listCarSales;
    }

    private CarPostDTO mapCarEntityToDTO(CarPostEntity carPostEntity) {

        return CarPostDTO.builder()
                .brand(carPostEntity.getBrand())
                .city(carPostEntity.getCity())
                .model(carPostEntity.getModel())
                .description(carPostEntity.getDescription())
                .engineVersion(carPostEntity.getEngineVersion())
                .createdDate(carPostEntity.getCreatedDate())
                .ownerName(carPostEntity.getOwnerPost().getName())
                .price(carPostEntity.getPrice()).build();
    }
}
