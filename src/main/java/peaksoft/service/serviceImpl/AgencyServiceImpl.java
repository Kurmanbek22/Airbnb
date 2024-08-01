package peaksoft.service.serviceImpl;

import peaksoft.entity.Agency;
import peaksoft.repository.AgencyRepo;
import peaksoft.repository.repoImpl.AgencyRepoImpl;
import peaksoft.service.AgencyService;

import java.util.List;

public class AgencyServiceImpl implements AgencyService {
    AgencyRepo agencyRepo=new AgencyRepoImpl();
    @Override
    public String saveAgency(Agency agency) {
        return agencyRepo.saveAgency(agency);
    }

    @Override
    public Agency findAgencyById(Long id) {
        return agencyRepo.findAgencyById(id);
    }

    @Override
    public List<Agency> findAllAgencies() {
        return agencyRepo.findAllAgencies();
    }

    @Override
    public String updateAgency(Long oldId, Agency agency) {
        return agencyRepo.updateAgency(oldId,agency);
    }

    @Override
    public String deleteAgency(Long id) {

        return agencyRepo.deleteAgency(id);
    }
}
