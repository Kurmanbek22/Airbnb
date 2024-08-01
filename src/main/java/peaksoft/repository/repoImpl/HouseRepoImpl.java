package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.House;
import peaksoft.repository.HouseRepo;

import java.util.List;

public class HouseRepoImpl implements HouseRepo {
private final EntityManager entityManager= HibernateConfig.getEntityManager();
    @Override
    public String saveHouse(House house) {
        entityManager.getTransaction().begin();
        entityManager.persist(house);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "house saved successfully";
    }

    @Override
    public House getHouse(Long id) {
        entityManager.getTransaction().begin();
        House house = entityManager.find(House.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return house;
    }

    @Override
    public List<House> getAllHouses() {
        List<House> houses = entityManager.createQuery("from House", House.class).getResultList();
        entityManager.close();
        return houses;
    }

    @Override
    public String updateHouse(Long oldId, House house) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("update House h set h.houseType = :housType,h.price=:price,h.rating=:rating" +
                ",h.description=:description,h.room=:room,h.furniture =:furnitire where id = :oldId")
                .setParameter("housType", house.getHouseType())
                .setParameter("price", house.getPrice())
                .setParameter("rating", house.getRating())
                .setParameter("description", house.getDescription())
                .setParameter("room", house.getRoom())
                .setParameter("oldId", oldId)
                .executeUpdate();
        return "house updated successfully";
    }

    @Override
    public String deleteHouse(Long id) {
        entityManager.getTransaction().begin();
        House house = entityManager.find(House.class, id);
        entityManager.remove(house);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "house deleted successfully";
    }
}
