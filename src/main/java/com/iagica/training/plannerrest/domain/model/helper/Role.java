package com.iagica.training.plannerrest.domain.model.helper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_role", schema = "helper", catalog = "dbplanner")
public class Role implements Serializable {
    @Id
    @Column(name = "uidrole", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uidrole;

    @Basic
    @Column(name = "idrole", nullable = false, length = -1)
    private String idrole;

    @Basic
    @Column(name = "weight", nullable = false)
    private Integer weight;

    public Integer getUidrole() {
        return uidrole;
    }

    public void setUidrole(Integer uidrole) {
        this.uidrole = uidrole;
    }

    public String getIdrole() {
        return idrole;
    }

    public void setIdrole(String idrole) {
        this.idrole = idrole;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role tabRole = (Role) o;
        return uidrole == tabRole.uidrole && weight == tabRole.weight && Objects.equals(idrole, tabRole.idrole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uidrole, idrole, weight);
    }

    @Override
    public String toString() {
        return String.format("uidRole:%d,idRole:%s,weight:%d", this.uidrole, this.idrole, this.weight);
    }
}
