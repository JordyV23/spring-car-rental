package com.dev23.CarRentalSpring.Dto;

import lombok.Data;

/**
 * SignupRequest es una clase que representa una solicitud de registro de usuario.
 * Esta clase se utiliza para transferir los datos necesarios para registrar un nuevo usuario.
 */
@Data
public class SignupRequest {

    // El correo electrónico del usuario.
    private String email;

    // El nombre del usuario.
    private String name;

    // La contraseña del usuario.
    private String password;
}
