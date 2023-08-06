package erp.erp.database.repository;


import erp.erp.database.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findAll();

    CustomerEntity findAllByNameIgnoreCase(String name);


    void deleteCustomerEntitiesByUuid(UUID uuid);

    Optional<CustomerEntity> findByUuid(UUID uuid);

    @Query("SELECT c FROM CustomerEntity c WHERE c.surname = :surnamename")
    List<CustomerEntity> findCustomersBySurname(String surname);

}
