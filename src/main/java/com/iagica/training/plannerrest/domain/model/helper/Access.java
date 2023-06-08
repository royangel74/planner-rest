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
@Table(name = "tab_access", schema = "helper", catalog = "dbplanner")
public class Access {
    @Id
    @Column(name = "uidaccess", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uidaccess;

    @Basic
    @Column(name = "idaccess", nullable = false, length = -1)
    private String idaccess;

    @Basic
    @Column(name = "weight", nullable = false)
    private int weight;

    public Integer getUidaccess() {
        return uidaccess;
    }

    public void setUidaccess(Integer uidaccess) {
        this.uidaccess = uidaccess;
    }

    public String getIdaccess() {
        return idaccess;
    }

    public void setIdaccess(String idaccess) {
        this.idaccess = idaccess;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Access tabAccess = (Access) o;
        return uidaccess == tabAccess.uidaccess && weight == tabAccess.weight && Objects.equals(idaccess, tabAccess.idaccess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uidaccess, idaccess, weight);
    }
}
