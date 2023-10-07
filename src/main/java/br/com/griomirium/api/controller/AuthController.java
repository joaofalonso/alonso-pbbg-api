package br.com.griomirium.api.controller;

import br.com.griomirium.api.domain.user.LoginData;
import br.com.griomirium.api.domain.user.User;
import br.com.griomirium.api.security.ResponseTokenJWT;
import br.com.griomirium.api.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    public AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid LoginData loginData){
        try {
            var token = new UsernamePasswordAuthenticationToken(loginData.login(), loginData.password());
            var authentication = this.manager.authenticate(token);

            var tokenJWT = tokenService.createToken((User) authentication.getPrincipal());

            return ResponseEntity.ok(new ResponseTokenJWT(tokenJWT));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
}
