package com.nlu.fit.chat.service.impl;

import com.nlu.fit.chat.documents.User;
import com.nlu.fit.chat.documents.token.VerificationToken;
import com.nlu.fit.chat.payload.registration.req.RegistrationRequest;
import com.nlu.fit.chat.payload.registration.res.RegistrationResponse;
import com.nlu.fit.chat.respository.UserRepository;
import com.nlu.fit.chat.service.AuthenticationService;
import com.nlu.fit.chat.service.TokenService;
import com.nlu.fit.chat.utils.DataUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Override
    public RegistrationResponse addNewUser(RegistrationRequest request) {
        // create new user
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UsernameNotFoundException("Email doesn't exist");
        }
        // create new user
        var newUser = DataUtil.copyProperties(request, User.class);
        newUser.setEmail(request.getEmail());
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(newUser);


        // create new token
        var newVerificationToken = VerificationToken.builder()
                .token(UUID.randomUUID().toString())
                .userId(newUser.getId())
                .expiry(LocalDateTime.now().minusMinutes(30))
                .build();
        tokenService.saveToken(newVerificationToken);

        return new RegistrationResponse(newUser.getId());
    }
}
