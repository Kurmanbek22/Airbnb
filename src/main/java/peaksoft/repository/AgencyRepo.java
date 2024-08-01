package peaksoft.repository;

import peaksoft.entity.Agency;

import java.util.List;

public interface AgencyRepo {
    String saveAgency(Agency agency);
    Agency findAgencyById(Long id);
    List<Agency> findAllAgencies();
    Agency updateAgency(Long oldId,Agency agency);
    String deleteAgency(Long id);

}
