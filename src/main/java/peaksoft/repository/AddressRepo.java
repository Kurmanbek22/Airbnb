package peaksoft.repository;

import peaksoft.entity.Address;

import java.util.List;

public interface AddressRepo {
    String saveAddress(Address address);
    Address getAddress(Long id);
    List<Address> getAddresses();
    String updateAddress(Long oldId,Address address);
    String deleteAddress(String id);
}
