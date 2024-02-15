package com.hotel_booking.controller;

import com.hotel_booking.model.User;
import com.hotel_booking.repository.RoleRepository;
import com.hotel_booking.repository.UserRepository;
import com.hotel_booking.model.Role;
import com.hotel_booking.payload.LoginDto;
import com.hotel_booking.payload.SignUpDto;
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
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {

        // add check for email exists in DB
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setRole(signUpDto.getRole());

        Optional<Role> optionalRole = roleRepository.findByName("ROLE_ADMIN");
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            user.setRoles(Collections.singleton(role));
        } else {
            // Create a default role if "ROLE_ADMIN" role is not found
            Role defaultRole = new Role();
            defaultRole.setName("ROLE_USER"); // Set a default role name
            // Set any other default role properties as needed

            // Save the default role to the database (if required)
            roleRepository.save(defaultRole);

            user.setRoles(Collections.singleton(defaultRole));
        }


        userRepository.save(user);

        return new ResponseEntity<>(signUpDto.getRole(), HttpStatus.OK);
    }

}
