package com.elyhouadria.acmeinc.security;

import com.elyhouadria.acmeinc.entities.AcmeUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class User implements UserDetails {

    private static final long serialVersionUID = 3592549577903104696L;

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<GrantedAuthority> authorities;


    public User(AcmeUser acmeUser){
        this.id = acmeUser.getId();
        this.firstName = acmeUser.getFirstName();
        this.lastName = acmeUser.getLastName();
        this.email = acmeUser.getEmail();
        this.password = acmeUser.getPassword();
        this.authorities = Arrays.stream(acmeUser.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        System.out.println(authorities);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return authorities; }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
