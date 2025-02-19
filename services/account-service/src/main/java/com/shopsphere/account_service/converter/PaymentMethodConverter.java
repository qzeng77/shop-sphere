package com.shopsphere.account_service.converter;

import com.shopsphere.account_service.dto.PaymentMethodDTO;
import com.shopsphere.account_service.entity.PaymentMethod;
import com.shopsphere.account_service.entity.User;

public class PaymentMethodConverter {

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

    public PaymentMethod toPaymentMethodEntity(PaymentMethodDTO dto, User user) {
        if (dto == null) {
            return null;
        }

        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setCardNumber(dto.getCardNumber());
        paymentMethod.setCardHolderName(dto.getCardHolderName());
        paymentMethod.setExpirationDate(dto.getExpirationDate());
        paymentMethod.setUser(user);
        return paymentMethod;
    }
}
