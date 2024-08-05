package com.dev23.CarRentalSpring.Services.auth;

import com.dev23.CarRentalSpring.Dto.SignupRequest;
import com.dev23.CarRentalSpring.Dto.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);
}
