package com.dev23.CarRentalSpring.Services.auth;

import com.dev23.CarRentalSpring.Dto.SignupRequest;
import com.dev23.CarRentalSpring.Dto.UserDto;
import com.dev23.CarRentalSpring.Entity.User;
import com.dev23.CarRentalSpring.Enums.UserRole;
import com.dev23.CarRentalSpring.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public UserDto createCustomer(SignupRequest signupRequest) {
        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        user.setUserRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());
        return userDto;
    }

    @Override
    public boolean hasCustomerWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
