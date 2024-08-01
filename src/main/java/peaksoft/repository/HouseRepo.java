package peaksoft.repository;

import peaksoft.entity.House;

import java.util.List;

public interface HouseRepo {
    String saveHouse(House house);
    House getHouse(Long id);
    List<House> getAllHouses();
    String updateHouse(Long oldId,House house);
    String deleteHouse(Long id);
}
