package erp.erp.service;


import erp.erp.database.entity.CustomerEntity;
import erp.erp.database.entity.OrderEntity;
import erp.erp.database.entity.ProductEntity;
import erp.erp.database.repository.CustomerRepository;
import erp.erp.database.repository.OrderRepository;
import erp.erp.database.repository.ProductRepository;
import erp.erp.model.OrderStatusEnum;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;


    public OrderEntity createOrder(OrderEntity order, Long customer_id) {
        CustomerEntity customerEntity = customerRepository.findById(customer_id).orElse(null);
        OrderEntity orderEntity = order;
        orderEntity.setOrderStatusEnum(OrderStatusEnum.PENDING);
        orderEntity.setCustomer(customerEntity);
        orderRepository.save(order);
        customerEntity.getOrderList().add(order);
        return order;
    }

    public List<OrderEntity> getOrderList(){
        return orderRepository.findAll();
    }
    public OrderEntity addProductToOrder(Long order_id,  Long product_id){
        List<ProductEntity> productList = null;
        OrderEntity orderEntity = orderRepository.findById(order_id).get();
        ProductEntity productEntity = productRepository.findById(product_id).get();
        productList = orderEntity.getProductList();
        if(productEntity.getQuantity()>0){
            productList.add(productEntity);
            productEntity.setQuantity(productEntity.getQuantity()-1);
            orderEntity.setProductList(productList);
        }else {
            return null;
        }
        return orderRepository.save(orderEntity);

    }

    public OrderEntity getOrderByUUID(UUID uuid){
        Optional<OrderEntity> orderEntityOptional = orderRepository.findByUuid(uuid);

        if(orderEntityOptional.isPresent()){
            return  orderEntityOptional.get();
        }else {
            return null;
        }
    }

   @Transactional
    public  Boolean deleteOrderByUUID(UUID uuid){
        OrderEntity orderEntity = getOrderByUUID(uuid);

        if(orderEntity!=null){
            orderRepository.deleteOrderEntitiesByUuid(uuid);
            return true;
        }else {
            return  false;
        }
    }
    public  OrderEntity updateOrderByUUID(UUID uuid, OrderEntity newOrderEntity, long customer_id, long product_id){
        OrderEntity orderEntity = getOrderByUUID(uuid);
        CustomerEntity customer = customerRepository.findById(customer_id).get();
        ProductEntity product = productRepository.findById(product_id).get();

        if(orderEntity!=null){
            orderEntity.setOrderStatusEnum(orderEntity.getOrderStatusEnum());
            orderEntity.setCustomer(customer);
            if(product.getQuantity()>0){
                orderEntity.getProductList().add(product);
                product.setQuantity(product.getQuantity()-1);
            }
            orderRepository.save(orderEntity);
            return orderEntity;
        }else{
            return null;
        }
    }




}
