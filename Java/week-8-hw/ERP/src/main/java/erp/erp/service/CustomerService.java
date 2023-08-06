package erp.erp.service;


import erp.erp.database.entity.CustomerEntity;
import erp.erp.database.repository.CustomerRepository;
import erp.erp.database.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;


    public CustomerEntity createCustomer(String name, String surname) {
        CustomerEntity customer = new CustomerEntity();
        customer.setName(name);
        customer.setSurname(surname);

        customerRepository.save(customer);
        return customer;
    }

    public List<CustomerEntity> getCustomerList() {

        return customerRepository.findAll();
    }
    public CustomerEntity getCustomerByName(String name) {

        return customerRepository.findAllByNameIgnoreCase(name);
    }

    public CustomerEntity getCustomerByUUID(UUID uuid) {
        Optional<CustomerEntity> customerEntityOptional = customerRepository.findByUuid(uuid);

        if (customerEntityOptional.isPresent()) {
            return customerEntityOptional.get();
        } else {
            return null;
        }
    }

    @Transactional
    public Boolean deleteCustomerByUUID(UUID uuid) {
        CustomerEntity customerEntity = getCustomerByUUID(uuid);

        if (customerEntity != null) {
            customerRepository.deleteCustomerEntitiesByUuid(uuid);
            return true;
        } else {
            return false;
        }
    }
    public CustomerEntity updateCustomerByUUID(UUID uuid, CustomerEntity newCustomerEntity) {
        CustomerEntity customerEntity = getCustomerByUUID(uuid);

        if (customerEntity != null) {
            customerEntity.setName(newCustomerEntity.getName());
            customerEntity.setSurname(newCustomerEntity.getSurname());

            customerRepository.save(customerEntity);
            return customerEntity;
        } else {
            return null;
        }
    }



}
