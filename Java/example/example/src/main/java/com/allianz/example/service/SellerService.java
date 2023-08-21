package com.allianz.example.service;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService extends BaseService<SellerEntity, SellerDTO, SellerRequestDTO, SellerMapper, SellerEntityRepository> {
    @Autowired
    SellerEntityRepository sellerEntityRepository;

    @Autowired
    SellerMapper sellerMapper;

    @Override
    protected SellerMapper getMapper() {
        return this.sellerMapper;
    }

    @Override
    protected SellerEntityRepository getRepository() {
        return this.sellerEntityRepository;
    }
}
