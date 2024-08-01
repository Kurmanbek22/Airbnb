package peaksoft.service.serviceImpl;

import peaksoft.entity.RentInfo;
import peaksoft.repository.RentInfoRepo;
import peaksoft.repository.repoImpl.RentInfoRepoImpl;
import peaksoft.service.RentInfoService;

import java.util.List;

public class RentInfoServiceImpl implements RentInfoService {
    RentInfoRepo rentInfoRepo = new RentInfoRepoImpl();

    @Override
    public String saveRentInfo(RentInfo rentInfo) {
        return rentInfoRepo.saveRentInfo(rentInfo);
    }

    @Override
    public RentInfo getRentInfoById(Long id) {
        return rentInfoRepo.getRentInfoById(id);
    }

    @Override
    public List<RentInfo> getAllRentInfos() {
        return rentInfoRepo.getAllRentInfos();
    }

    @Override
    public String updateRentInfo(Long oldId, RentInfo rentInfo) {
        return rentInfoRepo.updateRentInfo(oldId, rentInfo);
    }

    @Override
    public String deleteRentInfoById(Long id) {
        return rentInfoRepo.deleteRentInfoById(id);
    }
}
