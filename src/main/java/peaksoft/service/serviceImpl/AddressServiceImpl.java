package peaksoft.service.serviceImpl;

import peaksoft.entity.Address;
import peaksoft.repository.AddressRepo;
import peaksoft.repository.repoImpl.AddressRepoImpl;
import peaksoft.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
     AddressRepo addressRepo=new AddressRepoImpl();
    @Override
    public String saveAddress(Address address) {
        return addressRepo.saveAddress(address);
    }

    @Override
    public Address getAddress(Long id) {
        return addressRepo.getAddress(id);
    }

    @Override
    public List<Address> getAddresses() {
        return addressRepo.getAddresses();
    }

    @Override
    public String updateAddress(Long oldId, Address address) {
        return addressRepo.updateAddress(oldId, address);
    }

    @Override
    public String deleteAddress(String id) {
        return addressRepo.deleteAddress(id);
    }
}
