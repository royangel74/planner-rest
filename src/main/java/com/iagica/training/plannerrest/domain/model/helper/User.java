package com.iagica.training.plannerrest.domain.model.helper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Stream;

@Log
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_user", schema = "helper")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uiduser",nullable = false)
    private Integer uidUser;
    @Basic
    @Column(name="name",nullable = false,length = 255)
    private String name;
    @Basic
    @Column(name="surname",nullable = false,length = 255)
    private String surname;
    @Column(name="email",unique = true)
    private String username;
    @Basic
    @Column(name="password",nullable = false,length = 128)
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role")
    private Role role;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info("CHE SUCCEDEEEEEEEEEEEEEEEEEEEEEE"+List.of(new SimpleGrantedAuthority(role.toString())));
        //return List.of(new SimpleGrantedAuthority(role.getRuolo()));
        List<GrantedAuthority> authorities
                = new ArrayList<>();

            authorities.add(new SimpleGrantedAuthority(role.toString()));
            return authorities;

    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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





}
