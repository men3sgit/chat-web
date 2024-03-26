package com.nlu.fit.chat.documents.token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerificationToken implements Token {
    private Long id;
    private Long userId;
    private LocalDateTime expiry;
    private String token;

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public LocalDateTime getExpiryDate() {
        return this.expiry;
    }

    @Override
    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiry = expiryDate;
    }

}
