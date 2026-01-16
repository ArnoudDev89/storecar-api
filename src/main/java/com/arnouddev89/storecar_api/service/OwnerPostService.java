package com.arnouddev89.storecar_api.service;

import com.arnouddev89.storecar_api.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createOwnerPost(OwnerPostDTO ownerPostDTO);
}