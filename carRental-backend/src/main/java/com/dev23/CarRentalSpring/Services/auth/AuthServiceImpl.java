package com.dev23.CarRentalSpring.Services.auth;

import com.dev23.CarRentalSpring.Dto.SignupRequest;
import com.dev23.CarRentalSpring.Dto.UserDto;
import com.dev23.CarRentalSpring.Entity.User;
import com.dev23.CarRentalSpring.Enums.UserRole;
import com.dev23.CarRentalSpring.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * AuthServiceImpl es una clase de implementación de AuthService que proporciona
 * la lógica de negocio para la autenticación y manejo de usuarios.
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    // Repositorio de usuarios inyectado automáticamente por Spring.
    private final UserRepository userRepository;

    /**
     * Crea un nuevo cliente con la información proporcionada en la solicitud de registro.
     *
     * @param signupRequest objeto que contiene la información del cliente para el registro.
     * @return UserDto que representa el cliente creado.
     */
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
        userDto.setName(createdUser.getName());
        userDto.setEmail(createdUser.getEmail());
        userDto.setUserRole(createdUser.getUserRole());

        return userDto;
    }

    /**
     * Verifica si existe un cliente con el correo electrónico proporcionado.
     *
     * @param email el correo electrónico a verificar.
     * @return true si existe un cliente con el correo electrónico proporcionado, false en caso contrario.
     */
    @Override
    public boolean hasCustomerWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
