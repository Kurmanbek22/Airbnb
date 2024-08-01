package peaksoft.service.serviceImpl;

import peaksoft.entity.Owner;
import peaksoft.repository.OwnerRepo;
import peaksoft.repository.repoImpl.OwnerRepoImpl;
import peaksoft.service.OwnerService;

import java.util.List;

public class OwnerServiceImpl implements OwnerService {
    OwnerRepo ownerRepo=new OwnerRepoImpl();
    @Override
    public String saveOwner(Owner owner) {
        return ownerRepo.saveOwner(owner);
    }

    @Override
    public Owner getOwnerById(Long id) {
        return ownerRepo.getOwnerById(id);
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepo.getAllOwners();
    }

    @Override
    public String updateOwner(Long oldId, Owner owner) {
        return ownerRepo.updateOwner(oldId, owner);
    }

    @Override
    public String deleteOwnerById(Long id) {
        return ownerRepo.deleteOwnerById(id);
    }
}
