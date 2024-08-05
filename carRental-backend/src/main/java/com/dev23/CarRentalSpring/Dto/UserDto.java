package com.dev23.CarRentalSpring.Dto;

import com.dev23.CarRentalSpring.Enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private UserRole userRole;
}
