package com.elyhouadria.acmeinc.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        System.out.println("Request :");
        System.out.println(authenticationRequest);

        final User user = authenticate(authenticationRequest);
        final JwtTokenUtil jwtTokenUtil = JwtTokenUtil.generateToken(user);

        System.out.println("security class user:");
        System.out.println(user);


        final String token = jwtTokenUtil.getToken();
        Long expirationDate = jwtTokenUtil.getExpirationDateFromToken().getTime();

        System.out.println("Token :");
        System.out.println(token);

        return ResponseEntity.ok(new JwtResponse(token, user, expirationDate));
    }


    private User authenticate(JwtRequest request) throws Exception {
        System.out.println("Authenticate request:");
        System.out.println(request);
        User user = null;


        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            user = (User)auth.getPrincipal();

            System.out.println("after authentication:");
            System.out.println(user);

        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        System.out.println(user);
        return user;

    }
}
