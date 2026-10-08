package com.arnouddev89.storecar_api.controller;

import com.arnouddev89.storecar_api.dto.CarPostDTO;
import com.arnouddev89.storecar_api.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class CarPostController {

    @Autowired
    private CarPostService carPostService;

    @PostMapping("/car")
    public ResponseEntity<Void> postCarSale(@RequestBody CarPostDTO carPostDTO) {
        carPostService.newCarPost(carPostDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarPostDTO>> getCarSales() {
        return ResponseEntity.ok(carPostService.getCarSales());
    }

    @PutMapping("/car/{id}")
    public ResponseEntity changeCarSale (@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id) {
        carPostService.changeCarSale(carPostDTO, Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity deleteCarSale(@PathVariable("id") String id) {
        carPostService.removeCarSale(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}