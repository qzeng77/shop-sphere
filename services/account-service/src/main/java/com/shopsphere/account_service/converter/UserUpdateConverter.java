package com.shopsphere.account_service.converter;

import com.shopsphere.account_service.dto.UserUpdateDTO;
import com.shopsphere.account_service.entity.User;

public class UserUpdateConverter {
    public void updateUserFromDTO(User user, UserUpdateDTO dto) {
        if (dto.getEmail() != null) {
            user.setEmail(dto.getEmail());
        }
        if (dto.getUsername() != null) {
            user.setUsername(dto.getUsername());
        }
        if (dto.getPassword() != null) {
            user.setPassword(dto.getPassword()); // Note: password should be encoded before saving
        }
    }
}
