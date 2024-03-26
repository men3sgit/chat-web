package com.nlu.fit.chat.documents.token;

import java.time.LocalDateTime;

public interface Token {


    String getToken();

    void setToken(String token);

    LocalDateTime getExpiryDate();

    void setExpiryDate(LocalDateTime expiryDate);


}
