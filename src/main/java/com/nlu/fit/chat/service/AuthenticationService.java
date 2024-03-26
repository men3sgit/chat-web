package com.nlu.fit.chat.service;

import com.nlu.fit.chat.payload.registration.req.RegistrationRequest;
import com.nlu.fit.chat.payload.registration.res.RegistrationResponse;

public interface AuthenticationService {
    RegistrationResponse addNewUser(RegistrationRequest request);






}
