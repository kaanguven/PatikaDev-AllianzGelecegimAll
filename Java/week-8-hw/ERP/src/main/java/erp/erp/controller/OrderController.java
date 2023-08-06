package erp.erp.controller;


import erp.erp.database.entity.OrderEntity;

import erp.erp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;


    @GetMapping("order")
    public ResponseEntity<List<OrderEntity>> getOrderList() {

        return new ResponseEntity<>(orderService.getOrderList(), HttpStatus.OK);
    }

    @PostMapping("order/{customer_id}")
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity orderEntity, @PathVariable Long customer_id) throws Exception {

        OrderEntity order = orderService.createOrder(orderEntity, customer_id);


        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PutMapping("order/{order_id}/product/{product_id}")
    public OrderEntity addProductToOrder(@PathVariable Long order_id, @PathVariable Long product_id){
            return  orderService.addProductToOrder(order_id,product_id);
    }

    @DeleteMapping("order/{uuid}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable UUID uuid) {

        Boolean isDeleted = orderService.deleteOrderByUUID(uuid);
        if(isDeleted){
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.NOT_FOUND);

        }else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);

        }
    }

    @PutMapping("order/{uuid}/{customer_id}/{product_id}")
    public ResponseEntity<OrderEntity> updateOrderByUUID(@PathVariable UUID uuid, @RequestBody OrderEntity newOrderEntity
    ,@PathVariable Long customer_id, @PathVariable Long product_id){
        OrderEntity orderEntity = orderService.updateOrderByUUID(uuid, newOrderEntity, customer_id, product_id);
        if(orderEntity!=null){
            return new ResponseEntity<>(orderEntity, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
