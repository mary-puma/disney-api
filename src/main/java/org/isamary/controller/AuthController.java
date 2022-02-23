package org.isamary.controller;

import org.isamary.dto.LoginDTO;
import org.isamary.dto.RegisterDTO;
import org.isamary.entity.IUser;
import org.isamary.entity.Rol;
import org.isamary.repository.RolRepository;
import org.isamary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("Ha iniciado exito", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterDTO registerDTO){
        if(userRepository.existsByUsername(registerDTO.getUsername())) {
            return new ResponseEntity<>("Ese nombre de usuario ya existe",HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(registerDTO.getEmail())) {
            return new ResponseEntity<>("Ese email de usuario ya existe",HttpStatus.BAD_REQUEST);
        }

        IUser user = new IUser();
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        //user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));//guarda la password encriptada
        user.setPassword(registerDTO.getPassword());

        Rol roles = rolRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);
        return new ResponseEntity<>("Usuario registrado exitosamente",HttpStatus.OK);
    }
}
