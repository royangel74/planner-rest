package com.iagica.training.plannerrest.domain.model.helper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_token", schema = "helper", catalog = "dbplanner")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uidtoken", nullable = false, insertable = false)
    private Integer uidtoken;
    @Basic
    @Column(name = "expired", nullable = false)
    private boolean expired;
    @Basic
    @Column(name = "revoked", nullable = false)
    private boolean revoked;
    @Basic
    @Column(name = "token", nullable = true, length = 255)
    private String token;
    @Enumerated(EnumType.STRING)
    @Column(name = "tokentype", nullable = true, length = 255)
    private TokenType tokentype;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uiduser")
    public User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token that = (Token) o;
        return uidtoken == that.uidtoken && expired == that.expired && revoked == that.revoked && Objects.equals(token, that.token) && Objects.equals(tokentype, that.tokentype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uidtoken, expired, revoked, token, tokentype);
    }
}
