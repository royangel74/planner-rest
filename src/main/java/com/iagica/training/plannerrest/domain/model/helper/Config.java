package com.iagica.training.plannerrest.domain.model.helper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_config", schema = "helper", catalog = "dbplanner")
public class Config {
    @Id
    @Column(name = "uidconfig", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uidconfig;

    @Basic
    @Column(name = "keyname", nullable = false, length = 256)
    private String keyname;

    @Basic
    @Column(name = "keyvalue", nullable = false, length = 512)
    private String keyvalue;

    @Basic
    @Column(name = "explanation", nullable = false, length = 512)
    private String explanation;

    @Basic
    @Column(name = "expiration", nullable = false)
    private Timestamp expiration;

    public Integer getUidconfig() {
        return uidconfig;
    }

    public void setUidconfig(Integer uidconfig) {
        this.uidconfig = uidconfig;
    }

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname;
    }

    public String getKeyvalue() {
        return keyvalue;
    }

    public void setKeyvalue(String keyvalue) {
        this.keyvalue = keyvalue;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Timestamp getExpiration() {
        return expiration;
    }

    public void setExpiration(Timestamp expiration) {
        this.expiration = expiration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Config tabConfig = (Config) o;
        return uidconfig == tabConfig.uidconfig && Objects.equals(keyname, tabConfig.keyname) && Objects.equals(keyvalue, tabConfig.keyvalue) && Objects.equals(explanation, tabConfig.explanation) && Objects.equals(expiration, tabConfig.expiration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uidconfig, keyname, keyvalue, explanation, expiration);
    }
}
