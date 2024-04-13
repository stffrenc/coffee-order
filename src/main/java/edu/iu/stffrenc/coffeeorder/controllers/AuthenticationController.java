package edu.iu.stffrenc.coffeeorder.controllers;

import edu.iu.stffrenc.coffeeorder.model.Customer;
import edu.iu.stffrenc.coffeeorder.repository.CustomerRepository;
import edu.iu.stffrenc.coffeeorder.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    CustomerRepository customerRepository;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService,
                                    CustomerRepository customerRepository) {

        this.authenticationManager = authenticationManager;

        //initializing the variables in the constructor

        this.tokenService = tokenService;

        this.customerRepository = customerRepository;
    }
    //signup api point
    @PostMapping("/signup")
    public void signup(@RequestBody Customer customer) {

        //error handling
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//signin api point
    @PostMapping("/signin")
    public String login(@RequestBody Customer customer) {
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(customer.username(), customer.password()));
        return tokenService.generateToken(authentication);
    }
}