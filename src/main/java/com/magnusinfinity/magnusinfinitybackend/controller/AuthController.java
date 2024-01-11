package com.magnusinfinity.magnusinfinitybackend.controller;

import com.magnusinfinity.magnusinfinitybackend.exception.BadRequestException;
import com.magnusinfinity.magnusinfinitybackend.model.AuthProvider;
import com.magnusinfinity.magnusinfinitybackend.dao.entity.User;
import com.magnusinfinity.magnusinfinitybackend.model.ApiResponse;
import com.magnusinfinity.magnusinfinitybackend.model.AuthResponse;
import com.magnusinfinity.magnusinfinitybackend.model.LoginRequest;
import com.magnusinfinity.magnusinfinitybackend.model.SignUpRequest;
import com.magnusinfinity.magnusinfinitybackend.dao.repository.UserRepository;
import com.magnusinfinity.magnusinfinitybackend.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
//        Optional<User> fetchUser = userRepository.findByEmail(loginRequest.getEmail());
//        fetchUser.orElseThrow(() -> new NotFoundException("User Not Found"));
//        fetchUser = userRepository.findById(fetchUser.get().getId());
//        Iterable<User> users = userRepository.findAll();
//         if( passwordEncoder.matches(loginRequest.getPassword(), fetchUser.get().getPassword() )){
//             return ResponseEntity.ok("true");
//         } else {
//             return ResponseEntity.badRequest().body("false");
//         }
//        String token = tokenProvider.createToken(authentication);
//        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }

        // Creating user's account
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setProvider(AuthProvider.local);

        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "User registered successfully@"));
    }

}
