package peaksoft.repository;

import peaksoft.entity.Owner;

import java.util.List;

public interface OwnerRepo {
    String saveOwner(Owner owner);
    Owner getOwnerById(Long id);
    List<Owner> getAllOwners();
    String  updateOwner(Long oldId,Owner owner);
    String deleteOwnerById(Long id);
}
