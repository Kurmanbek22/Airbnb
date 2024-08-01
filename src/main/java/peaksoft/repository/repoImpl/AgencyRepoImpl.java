package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Agency;
import peaksoft.repository.AgencyRepo;

import java.util.List;

public class AgencyRepoImpl implements AgencyRepo {
    private final EntityManager entityManager= HibernateConfig.getEntityManager();

    @Override
    public String saveAgency(Agency agency) {
        entityManager.getTransaction().begin();
        entityManager.persist(agency);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Agency saved";
    }

    @Override
    public Agency findAgencyById(Long id) {
        entityManager.getTransaction().begin();
        Agency agency = entityManager.find(Agency.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return agency;
    }

    @Override
    public List<Agency> findAllAgencies() {
        List<Agency> agencies = entityManager.createQuery("from Agency ", Agency.class).getResultList();
        return agencies;
    }

    @Override
    public String updateAgency(Long oldId, Agency agency) {
        entityManager.getTransaction().begin();
       entityManager.createQuery("update Agency a set a.name = :name,a.phoneNumber=:phoneNumber where id = :oldId")
               .setParameter("name", agency.getName())
               .setParameter("phoneNumber", agency.getPhoneNumber())
               .setParameter("oldId", oldId)
               .executeUpdate();
        return "Agency updated";
    }

    @Override
    public String deleteAgency(Long id) {
        entityManager.getTransaction().begin();
        Agency agency = entityManager.find(Agency.class, id);
        entityManager.remove(agency);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Agency deleted";
    }


}
