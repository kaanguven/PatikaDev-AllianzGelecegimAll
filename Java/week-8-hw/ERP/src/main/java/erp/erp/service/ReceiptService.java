package erp.erp.service;


import erp.erp.database.entity.ReceiptEntity;
import erp.erp.database.entity.OrderEntity;
import erp.erp.database.entity.ProductEntity;
import erp.erp.database.repository.ReceiptRepository;
import erp.erp.database.repository.OrderRepository;
import erp.erp.model.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiptService {

    @Value("${tax.rate}")
    private double taxRate;


    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ReceiptRepository receiptRepository;


    public ReceiptEntity createReceipt(ReceiptEntity receiptEntity, Long order_id) {
        ReceiptEntity receiptEntity1 = receiptEntity;
        addOrderToReceiptIfAvailable(receiptEntity1, order_id);
        receiptRepository.save(receiptEntity1);
        return receiptEntity;
    }

    public List<ReceiptEntity> getReceiptList() {

        return receiptRepository.findAll();
    }

    public void addOrderToReceiptIfAvailable(ReceiptEntity receiptEntity, Long order_id) {
        BigDecimal totalPriceWithKDV = BigDecimal.ZERO;
        BigDecimal totalPriceWithoutKDV = BigDecimal.ZERO;
        OrderEntity orderEntity = orderRepository.findById(order_id).get();
        boolean allProductsAvailable = true;
        for (ProductEntity product : orderEntity.getProductList()) {
            if (product.getQuantity() <= 0) {
                allProductsAvailable = false;
                break;
            }
        }

        if (!allProductsAvailable) {
            orderEntity.setOrderStatusEnum(OrderStatusEnum.REJECTED);
            System.out.println("There is an product in your list that is out of stock. Please try again after removing it.");
            return;
        }

        orderEntity.setOrderStatusEnum(OrderStatusEnum.APPROVED);

        receiptEntity.setNumberOfProduct(orderEntity.getProductList().size());
        for (ProductEntity product : orderEntity.getProductList()) {
            if (receiptEntity.getNameList() != null) {
                receiptEntity.getNameList().add(product.getName());
                if (product.getIsKdvNotApplied()) {
                    receiptEntity.setPriceWithKDV(product.getPrice().multiply(BigDecimal.valueOf(1 + taxRate)));
                    receiptEntity.setPriceWithoutKDV(product.getPrice());
                    totalPriceWithoutKDV = totalPriceWithoutKDV.add(product.getPrice());
                    totalPriceWithKDV = totalPriceWithKDV.add(product.getPrice().multiply(BigDecimal.valueOf(1 + taxRate))).add(totalPriceWithoutKDV);
                } else {
                    receiptEntity.setPriceWithoutKDV(product.getPrice());
                    totalPriceWithoutKDV = totalPriceWithoutKDV.add(product.getPrice());
                }
            } else {
                List<String> nameList = new ArrayList<>();
                nameList.add(product.getName());
                receiptEntity.setNameList(nameList);
                if (product.getIsKdvNotApplied()) {
                    receiptEntity.setPriceWithKDV(product.getPrice().multiply(BigDecimal.valueOf(1 + taxRate)));
                    receiptEntity.setPriceWithoutKDV(product.getPrice());
                    receiptEntity.setTotalPriceWithoutKDV(totalPriceWithoutKDV.add(product.getPrice()));
                    receiptEntity.setTotalPriceWithKDV(totalPriceWithKDV.add(product.getPrice().multiply(BigDecimal.valueOf(1 + taxRate))).add(totalPriceWithoutKDV));
                } else {
                    receiptEntity.setPriceWithoutKDV(product.getPrice());
                    totalPriceWithoutKDV = totalPriceWithoutKDV.add(product.getPrice());
                }

            }
        }

        orderRepository.save(orderEntity);
    }


}
