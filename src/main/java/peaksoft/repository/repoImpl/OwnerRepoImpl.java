package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Owner;
import peaksoft.repository.OwnerRepo;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public class OwnerRepoImpl implements OwnerRepo {
    private final EntityManager entityManager= HibernateConfig.getEntityManager();

    @Override
    public String saveOwner(Owner owner) {
        entityManager.getTransaction().begin();
        entityManager.persist(owner);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "owner saved";
    }

    @Override
    public Owner getOwnerById(Long id) {
        entityManager.getTransaction().begin();
        Owner owner= entityManager.find(Owner.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return owner;
    }

    @Override
    public List<Owner> getAllOwners() {
        List<Owner> owners= entityManager.createQuery("from Owner", Owner.class).getResultList();
        entityManager.close();
        return owners;
    }

    @Override
    public String updateOwner(Long oldId, Owner owner) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("update Owner o set o.firstName=:firstName, o.lastName=:lastName" +
                ",o.email=:email,o.birthDate=:birthDate,o.gender=:gender where o.id=:oldId")
                .setParameter("firstName", owner.getFirstName())
                .setParameter("lastName", owner.getLastName())
                .setParameter("email", owner.getEmail())
                .setParameter("birthDate", owner.getBirthDate())
                .setParameter("gender", owner.getGender())
                .setParameter("oldId", oldId)
                .executeUpdate();
        return "owner updated";
    }

    @Override
    public String deleteOwnerById(Long id) {
        entityManager.getTransaction().begin();
        Owner owner= entityManager.find(Owner.class, id);
        entityManager.remove(owner);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "owner deleted";
    }
}
