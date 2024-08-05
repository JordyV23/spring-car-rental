package com.dev23.CarRentalSpring.Controller;

import com.dev23.CarRentalSpring.Dto.SignupRequest;
import com.dev23.CarRentalSpring.Dto.UserDto;
import com.dev23.CarRentalSpring.Services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthController es una clase de controlador REST que maneja las solicitudes de autenticación.
 * Utiliza el servicio AuthService para realizar las operaciones de autenticación.
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    // Servicio de autenticación inyectado automáticamente por Spring.
    private final AuthService authService;

    /**
     * Maneja la solicitud de registro de un nuevo cliente.
     *
     * @param signupRequest objeto que contiene la información del cliente para el registro.
     * @return ResponseEntity con el estado de la solicitud y el cuerpo de la respuesta.
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest) {

        // Verifica si ya existe un cliente con el mismo correo electrónico.
        if (authService.hasCustomerWithEmail(signupRequest.getEmail()))
            return new ResponseEntity<>("Customer already exists", HttpStatus.NOT_ACCEPTABLE);

        // Crea un nuevo cliente utilizando el servicio de autenticación.
        UserDto createdCustomerDto = authService.createCustomer(signupRequest);

        // Verifica si el cliente fue creado exitosamente.
        if (createdCustomerDto == null) return new ResponseEntity<>("Customer Not Created", HttpStatus.BAD_REQUEST);

        // Retorna una respuesta con el cliente creado y el estado HTTP 201 (CREATED).
        return new ResponseEntity<>(createdCustomerDto, HttpStatus.CREATED);
    }

}
