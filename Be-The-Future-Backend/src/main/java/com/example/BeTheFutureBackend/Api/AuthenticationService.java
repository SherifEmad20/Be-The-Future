package com.example.BeTheFutureBackend.Api;

import com.example.BeTheFutureBackend.Configuration.JwtService;
import com.example.BeTheFutureBackend.Role.Role;
import com.example.BeTheFutureBackend.Users.User;
import com.example.BeTheFutureBackend.Users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        if (request.getRole() == null) {
            request.setRole(Role.ROLE_USER);
            request.setRole(Role.ROLE_CUSTOMER);
        }
        var user = User.builder()
                .username(request.getUsername())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .city(request.getCity())
                .photo(request.getPhoto())
                .role(request.getRole())
                .build();
        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .message("success")
                .build();
    }

    public AuthenticationResponse login(authenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .message("success")
                .build();
    }
}

