package com.elyhouadria.acmeinc.security;


import com.elyhouadria.acmeinc.entities.AcmeUser;
import com.elyhouadria.acmeinc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    //will this work?

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<AcmeUser> optionalAcmeUser = userRepository.findUserByEmail(username);

        return  optionalAcmeUser.map(User ::new).orElseThrow(()->new UsernameNotFoundException(username + " doesn't exist"));
    }

/*    public Collection<? extends GrantedAuthority> getAuthorities(AcmeUser acmeUser) {

        return acmeUser.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+user.getRoles()))
                .collect(Collectors.toList());
    }*/


/*    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{
        User user = repository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }*/



}
