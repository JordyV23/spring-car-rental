package com.dev23.CarRentalSpring.Dto;

import com.dev23.CarRentalSpring.Enums.UserRole;
import lombok.Data;

/**
 * UserDto es una clase que representa los datos de un usuario.
 * Esta clase se utiliza para transferir la información del usuario entre las capas de la aplicación.
 */
@Data
public class UserDto {

    // El identificador único del usuario.
    private Long id;

    // El nombre del usuario.
    private String name;

    // El correo electrónico del usuario.
    private String email;

    // El rol del usuario.
    private UserRole userRole;
}
