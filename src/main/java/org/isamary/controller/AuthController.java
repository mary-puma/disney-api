package org.isamary.controller;

import org.isamary.dto.CharacterDetailDTO;
import org.isamary.dto.LoginDTO;
import org.isamary.dto.RegisterDTO;
import org.isamary.entity.IUser;
import org.isamary.entity.Rol;
import org.isamary.repository.RolRepository;
import org.isamary.repository.UserRepository;
import org.isamary.security.JwtAuthResponseDTO;
import org.isamary.security.JwtTokenProvider;
import org.isamary.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


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

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponseDTO> authenticateUser(@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //obtenemos el token del jwtTokenProvider
        String token = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthResponseDTO(token));
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
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));//guarda la password encriptada
        Rol roles = rolRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));
        userRepository.save(user);
        return new ResponseEntity<>("Usuario registrado exitosamente",HttpStatus.OK);
    }

}
