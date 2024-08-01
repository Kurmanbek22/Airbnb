package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.RentInfo;
import peaksoft.repository.RentInfoRepo;

import java.util.List;

public class RentInfoRepoImpl implements RentInfoRepo {
    private final EntityManager entityManager= HibernateConfig.getEntityManager();
    @Override
    public String saveRentInfo(RentInfo rentInfo) {
        entityManager.getTransaction().begin();
        entityManager.persist(rentInfo);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "successfully saved";
    }

    @Override
    public RentInfo getRentInfoById(Long id) {
        entityManager.getTransaction().begin();
        RentInfo rentInfo= entityManager.find(RentInfo.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return rentInfo;
    }

    @Override
    public List<RentInfo> getAllRentInfos() {
        List<RentInfo>rentInfos=entityManager.createQuery("from RentInfo", RentInfo.class).getResultList();
        return rentInfos;
    }

    @Override
    public String updateRentInfo(Long oldId, RentInfo rentInfo) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("update RentInfo r set r.checkInDate=:checkInDate," +
                "r.checkOutDate=:checkOutDate where id=:oldId")
                .setParameter("checkInDate", rentInfo.getCheckInDate())
                .setParameter("checkOutDate", rentInfo.getCheckOutDate())
                .setParameter("oldId", oldId)
                .executeUpdate();
        return "successfully updated";
    }

    @Override
    public String deleteRentInfoById(Long id) {
        entityManager.getTransaction().begin();
        RentInfo rentInfo= entityManager.find(RentInfo.class, id);
        entityManager.remove(rentInfo);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "successfully deleted";
    }
}
