package erp.erp.database.repository;

import erp.erp.database.entity.OrderEntity;
import erp.erp.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAll();
    ProductEntity findAllByNameIgnoreCase(String name);


    @Query("DELETE FROM ProductEntity p WHERE p.uuid = ?1")
    void  deleteProductEntitiesByUuid(UUID uuid);
    Optional<ProductEntity> findByUuid(UUID uuid);



}
