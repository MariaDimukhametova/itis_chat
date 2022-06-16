package org.example.itischat.controllers;

import lombok.RequiredArgsConstructor;
import org.example.itischat.dto.UserDto;
import org.example.itischat.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/signUp")
@RequiredArgsConstructor
public class SignUpController {
    @Autowired
    private final SignUpService signUpService;

    @PostMapping
    public ResponseEntity<?> signUp(@Valid @RequestBody UserDto userDto) {
        signUpService.signUp(userDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
