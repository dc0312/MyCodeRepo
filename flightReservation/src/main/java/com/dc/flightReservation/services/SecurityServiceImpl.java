package com.dc.flightReservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private UserDetailsServiceImpl service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public boolean login(String userName, String passWord) {
        UserDetails userDetails = service.loadUserByUsername(userName);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails,passWord,userDetails.getAuthorities());
        authenticationManager.authenticate(token);
        boolean result = token.isAuthenticated();

        if(result){
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        return result;
    }
}
