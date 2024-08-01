package peaksoft.service;

import peaksoft.entity.RentInfo;

import java.util.List;

public interface RentInfoService {
    String saveRentInfo(RentInfo rentInfo);
    RentInfo getRentInfoById(Long id);
    List<RentInfo> getAllRentInfos();
    String updateRentInfo(Long oldId,RentInfo rentInfo);
    String deleteRentInfoById(Long id);
}
