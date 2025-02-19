package com.shopsphere.account_service.converter;


import com.shopsphere.account_service.dto.AddressDTO;
import com.shopsphere.account_service.dto.PaymentMethodDTO;
import com.shopsphere.account_service.dto.UserResponseDTO;
import com.shopsphere.account_service.entity.Address;
import com.shopsphere.account_service.entity.PaymentMethod;
import com.shopsphere.account_service.entity.User;

public class UserResponseConverter {

    public UserResponseDTO toUserDTO(User user) {
        if (user == null) {
            return null;
        }

        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());

        // Convert the first address if exists
        if (user.getAddresses() != null && !user.getAddresses().isEmpty()) {
            dto.setAddress(toAddressDTO(user.getAddresses().get(0)));
        }

        // Convert the first payment method if exists
        if (user.getPaymentMethods() != null && !user.getPaymentMethods().isEmpty()) {
            dto.setPaymentMethod(toPaymentMethodDTO(user.getPaymentMethods().get(0)));
        }

        return dto;
    }

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

    public PaymentMethodDTO toPaymentMethodDTO(PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            return null;
        }

        PaymentMethodDTO dto = new PaymentMethodDTO();
        dto.setCardNumber(paymentMethod.getCardNumber());
        dto.setCardHolderName(paymentMethod.getCardHolderName());
        dto.setExpirationDate(paymentMethod.getExpirationDate());
        return dto;
    }
}
