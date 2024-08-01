package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Customer;
import peaksoft.repository.CustomerRepo;

import java.util.List;

public class CustomerRepoImpl implements CustomerRepo {
    private final EntityManager entityManager= HibernateConfig.getEntityManager();
    @Override
    public String saveCustomer(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "customer saved successfully";
    }

    @Override
    public Customer findCustomerById(Long id) {
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, id);

        return customer;
    }

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customers = entityManager.createQuery("SELECT c FROM Customer c").getResultList();
        return customers;
    }

    @Override
    public String updateCustomer(Long oldId, Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("update Customer c set c.firstName = :firstName,c.lastName=:lastName," +
                "c.email=:email,c.birthDate=:birthDate,c.gender=:gender,c.nationality=:nationality," +
                "c.familyStatus=:familyStatus where c.id = :oldId")
                .setParameter("firstName", customer.getFirstName())
                .setParameter("lastName", customer.getLastName())
                .setParameter("email", customer.getEmail())
                .setParameter("birthDate", customer.getBirthDate())
                .setParameter("gender", customer.getGender())
                .setParameter("nationality", customer.getNationality())
                .setParameter("familyStatus", customer.getFamilyStatus())
                .setParameter("oldId", oldId)
                .executeUpdate();

        return "customer updated successfully";
    }

    @Override
    public String deleteCustomer(Long id) {
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.remove(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "customer deleted successfully";
    }
}
