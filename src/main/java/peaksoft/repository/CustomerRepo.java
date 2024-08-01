package peaksoft.repository;

import peaksoft.entity.Customer;

import java.util.List;

public interface CustomerRepo {
    String saveCustomer(Customer customer);
    Customer findCustomerById(Long id);
    List<Customer> findAllCustomers();
    String updateCustomer(Long oldId,Customer customer);
    String deleteCustomer(Long id);


}
