package com.nlu.fit.chat.controller;

import com.nlu.fit.chat.payload.ApiResponse;
import com.nlu.fit.chat.payload.registration.req.RegistrationRequest;
import com.nlu.fit.chat.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(path = "/sign-up")
    public ApiResponse<?> register(@RequestBody @Validated RegistrationRequest request) {
        var response = authenticationService.addNewUser(request);
        return new ApiResponse<>(response);
    }

    @GetMapping(path ="/verify")
    public ApiResponse<?> verify(@RequestParam String token){

        return null;
    }


}
