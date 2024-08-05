package com.dev23.CarRentalSpring.Repository;

import com.dev23.CarRentalSpring.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * UserRepository es una interfaz que extiende JpaRepository para proporcionar métodos CRUD
 * y consultas personalizadas para la entidad User.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Busca el primer usuario que coincida con el correo electrónico proporcionado.
     *
     * @param email el correo electrónico del usuario a buscar.
     * @return un Optional que contiene el usuario si se encuentra, o vacío si no se encuentra.
     */
    Optional<User> findFirstByEmail(String email);
}
