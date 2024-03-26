package com.nlu.fit.chat.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    @Id
    private Long id;
    private String email;
    private String password;
    private String appName;
    private String fullName;
    private Status status;

    private String roles; // TODO javatechie

    private boolean locked;

}