package com.nlu.fit.chat.documents.token;

public interface Token {

    String getToken();

    void setToken(String token);

    long getExpiryDate();

    void setExpiryDate(long expiryDate);


}
