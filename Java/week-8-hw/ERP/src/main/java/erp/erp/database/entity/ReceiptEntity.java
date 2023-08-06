package erp.erp.database.entity;


import erp.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("ALL")
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
public class ReceiptEntity extends BaseEntity {

    @Column
    private List<String> nameList;
    @Column
    private int numberOfProduct;
    @Column
    private BigDecimal priceWithKDV;
    @Column
    private BigDecimal priceWithoutKDV;
    @Column
    private BigDecimal totalPriceWithKDV;
    @Column
    private BigDecimal totalPriceWithoutKDV;





}
