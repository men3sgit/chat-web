package com.nlu.fit.chat.service.impl;

import com.nlu.fit.chat.documents.token.Token;
import com.nlu.fit.chat.respository.TokenRepository;
import com.nlu.fit.chat.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final TokenRepository tokenRepository;
    @Override
    public String generateToken(Token token) {
        token.setToken(UUID.randomUUID().toString());
        return token.getToken();
    }

    @Override
    public LocalDateTime calculateExpiryDate(int hours) {
        return null;
    }

    @Override
    public boolean isTokenExpired(String token) {
        return false;
    }

    @Override
    public Token getToken(String token) {
        return null;
    }

    @Override
    public void saveToken(Token token) {
        tokenRepository.save(token);
    }
}
