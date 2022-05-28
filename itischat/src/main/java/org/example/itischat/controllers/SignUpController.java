package org.example.itischat.controllers;

import lombok.RequiredArgsConstructor;
import org.example.itischat.dto.UserDto;
import org.example.itischat.services.SignUpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sign-up")
@RequiredArgsConstructor
public class SignUpController {
    private final SignUpService signUpService;

    public ResponseEntity<?> signUp(@Valid @RequestBody UserDto userDto) {
        signUpService.signUp(userDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
