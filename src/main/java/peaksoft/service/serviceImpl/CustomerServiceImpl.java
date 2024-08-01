package peaksoft.service.serviceImpl;

import peaksoft.entity.Customer;
import peaksoft.repository.CustomerRepo;
import peaksoft.repository.repoImpl.CustomerRepoImpl;
import peaksoft.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepo customerRepo= new CustomerRepoImpl();
    @Override
    public String saveCustomer(Customer customer) {
        return customerRepo.saveCustomer(customer);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepo.findCustomerById(id);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepo.findAllCustomers();
    }

    @Override
    public String updateCustomer(Long oldId, Customer customer) {
        return customerRepo.updateCustomer(oldId, customer);
    }

    @Override
    public String deleteCustomer(Long id) {
        return customerRepo.deleteCustomer(id);
    }
}
