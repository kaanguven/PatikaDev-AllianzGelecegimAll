package com.allianz.example.service;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<OrderEntity, OrderDTO, OrderRequestDTO,
        OrderMapper, OrderEntityRepository> {

    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Autowired
    OrderMapper orderMapper;

    @Override
    protected OrderMapper getMapper() {
        return this.orderMapper;
    }

    @Override
    protected OrderEntityRepository getRepository() {
        return this.orderEntityRepository;
    }
}
