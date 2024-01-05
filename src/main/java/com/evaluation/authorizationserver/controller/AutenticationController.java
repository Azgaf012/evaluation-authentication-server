package com.evaluation.authorizationserver.controller;

import com.evaluation.authorizationserver.service.JwtService;
import com.evaluation.authorizationserver.dto.AutenticationResponse;
import com.evaluation.authorizationserver.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticationController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/auth/login")
    public ResponseEntity<AutenticationResponse> createAuthenticationToken(@RequestBody UserDTO userDTO) {
        String jwt = jwtService.generateToken(userDTO.getUsername());
        return ResponseEntity.ok(new AutenticationResponse(jwt));
    }

}
