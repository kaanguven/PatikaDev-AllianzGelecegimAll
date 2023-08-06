package erp.erp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Customer {

    private UUID uuid;
    private String name;
    private String surname;
    private List<Order> orderList;



    public Customer() {
        this.uuid = UUID.randomUUID();
    }

}
