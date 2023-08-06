package erp.erp.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
public class Product {

    private UUID uuid;
    private String name;
    private int quantity;
    private BigDecimal price;
    private ArrayList<Order> orderList;



    public Product(){this.uuid = UUID.randomUUID();}


}
