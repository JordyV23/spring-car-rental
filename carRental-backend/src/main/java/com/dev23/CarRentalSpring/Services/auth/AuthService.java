package com.dev23.CarRentalSpring.Services.auth;

import com.dev23.CarRentalSpring.Dto.SignupRequest;
import com.dev23.CarRentalSpring.Dto.UserDto;

/**
 * AuthService es una interfaz que define los métodos de autenticación y manejo de usuarios.
 */
public interface AuthService {

    /**
     * Crea un nuevo cliente con la información proporcionada en la solicitud de registro.
     *
     * @param signupRequest objeto que contiene la información del cliente para el registro.
     * @return UserDto que representa el cliente creado.
     */
    UserDto createCustomer(SignupRequest signupRequest);

    /**
     * Verifica si existe un cliente con el correo electrónico proporcionado.
     *
     * @param email el correo electrónico a verificar.
     * @return true si existe un cliente con el correo electrónico proporcionado, false en caso contrario.
     */
    boolean hasCustomerWithEmail(String email);
}
