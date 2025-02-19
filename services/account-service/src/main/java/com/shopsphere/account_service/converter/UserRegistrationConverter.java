package com.shopsphere.account_service.converter;

import com.shopsphere.account_service.dto.UserRegistrationDTO;
import com.shopsphere.account_service.entity.User;

public class UserRegistrationConverter {
    public User toUserEntity(UserRegistrationDTO dto) {
        if (dto == null) {
            return null;
        }

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword()); // Note: password should be encoded before saving
        return user;
    }
}
