package peaksoft.service;

import peaksoft.entity.House;

import java.util.List;

public interface HouseService {
    String saveHouse(House house);
    House getHouse(Long id);
    List<House> getAllHouses();
    String updateHouse(Long oldId,House house);
    String deleteHouse(Long id);
}
