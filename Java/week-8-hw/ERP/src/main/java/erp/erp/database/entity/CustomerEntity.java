package erp.erp.database.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import erp.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "customer_uuid"
        )
)
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "customer_id"
        )
)
@Data
public class CustomerEntity extends BaseEntity {

    @Column
    private String name;
    @Column
    private String surname;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orderList;


}
