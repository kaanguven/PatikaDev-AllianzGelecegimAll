package erp.erp.database.repository;


import erp.erp.database.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findAll();

    void  deleteOrderEntitiesByUuid(UUID uuid);
    Optional<OrderEntity> findByUuid(UUID uuid);



}
