package com.dev23.CarRentalSpring.Entity;

import com.dev23.CarRentalSpring.Enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

/**
 * User es una entidad que representa un usuario en la base de datos.
 * Esta clase se mapea a la tabla "users" en la base de datos.
 */
@Entity
@Data
@Table(name = "users")
public class User {

    // El identificador único del usuario, generado automáticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // El nombre del usuario.
    private String name;

    // El correo electrónico del usuario.
    private String email;

    // La contraseña del usuario.
    private String password;

    // El rol del usuario.
    private UserRole userRole;
}
