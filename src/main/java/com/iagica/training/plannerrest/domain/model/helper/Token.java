package com.iagica.training.plannerrest.domain.model.helper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_token", schema = "helper")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uidtoken",nullable = false)
    public Integer id;
    @Basic
    @Column(name = "token",unique = true,length = 255)
    public String token;
    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name="tokentype",nullable = false,length = 255)
    public TokenType tokenType = TokenType.BEARER;
    @Basic
    @Column(name = "revoked",nullable = false)
    public boolean revoked;
    @Basic
    @Column(name = "expired",nullable = false)
    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;
}
