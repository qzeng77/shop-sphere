package com.shopsphere.account_service.converter;
import com.shopsphere.account_service.dto.AddressDTO;
import com.shopsphere.account_service.entity.Address;
import com.shopsphere.account_service.entity.User;


public class AddressConverter {

    public AddressDTO toAddressDTO(Address address) {
        if (address == null) {
            return null;
        }

        AddressDTO dto = new AddressDTO();
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setCountry(address.getCountry());
        dto.setZipCode(address.getZipCode());
        return dto;
    }

    public Address toAddressEntity(AddressDTO dto, User user) {
        if (dto == null) {
            return null;
        }

        Address address = new Address();
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        address.setZipCode(dto.getZipCode());
        address.setUser(user);
        return address;
    }

}
