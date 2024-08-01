package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Address;
import peaksoft.repository.AddressRepo;

import java.util.List;

public class AddressRepoImpl implements AddressRepo {
    private  final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String saveAddress(Address address) {
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Address saved";
    }

    @Override
    public Address getAddress(Long id) {
        Address address = entityManager.find(Address.class, id);
        return address;
    }

    @Override
    public List<Address> getAddresses() {
        List<Address> addresses = entityManager.createQuery("from Address", Address.class).getResultList();
        return addresses;
    }

    @Override
    public String updateAddress(Long oldId, Address address) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("update Address a set a.city=:city,a.region=:region,a.street=:street" +
                        " where a.id=:oldId")
                .setParameter("city", address.getCity())
                .setParameter("region", address.getRegion())
                .setParameter("street", address.getStreet())
                .setParameter("oldId",oldId).executeUpdate();
        return "Address updated";
    }

    @Override
    public String deleteAddress(String id) {
        entityManager.getTransaction().begin();
        Address address = entityManager.find(Address.class, Long.parseLong(id));
        entityManager.remove(address);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Address deleted";
    }
}
