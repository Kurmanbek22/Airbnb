package peaksoft.service.serviceImpl;

import peaksoft.entity.House;
import peaksoft.repository.HouseRepo;
import peaksoft.repository.repoImpl.HouseRepoImpl;
import peaksoft.service.HouseService;

import java.util.List;

public class HouseServiceImpl implements HouseService {
    HouseRepo houseRepo=new HouseRepoImpl();
    @Override
    public String saveHouse(House house) {
        return houseRepo.saveHouse(house);
    }

    @Override
    public House getHouse(Long id) {
        return houseRepo.getHouse(id);
    }

    @Override
    public List<House> getAllHouses() {
        return houseRepo.getAllHouses();
    }

    @Override
    public String updateHouse(Long oldId, House house) {
        return houseRepo.updateHouse(oldId, house);
    }

    @Override
    public String deleteHouse(Long id) {
       return houseRepo.deleteHouse(id);
    }
}
