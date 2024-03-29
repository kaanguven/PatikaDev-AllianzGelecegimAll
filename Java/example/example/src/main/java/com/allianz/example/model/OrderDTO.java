package com.allianz.example.model;

import com.allianz.example.model.enums.OrderStatusEnum;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO extends BaseDTO {

    private CustomerDTO customer;
    private OrderStatusEnum orderStatus;
    private List<OrderItemDTO> orderItemList;
    private BigDecimal totalSellPrice;
}
