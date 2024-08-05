package com.dev23.CarRentalSpring.Dto;

import lombok.Data;

@Data
public class SignupRequest {

    private String email;
    private String name;
    private String password;

}
