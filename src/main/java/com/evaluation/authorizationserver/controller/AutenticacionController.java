package com.evaluation.authorizationserver.controller;

import com.evaluation.authorizationserver.config.JwtService;
import com.evaluation.authorizationserver.dto.AutenticacionResponse;
import com.evaluation.authorizationserver.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticacionController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/auth/login")
    public ResponseEntity<AutenticacionResponse> createAuthenticationToken(@RequestBody UsuarioDTO usuarioDTO) {
        String jwt = jwtService.generateToken(usuarioDTO.getUsername());
        return ResponseEntity.ok(new AutenticacionResponse(jwt));
    }

}
