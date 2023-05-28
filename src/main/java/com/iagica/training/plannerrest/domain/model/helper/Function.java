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
@Table(name = "tab_function", schema = "helper", catalog = "dbplanner")
public class Function {
    @Id
    @Column(name = "uidfunction", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uidfunction;

    @Basic
    @Column(name = "idfunction", nullable = false, length = -1)
    private String idfunction;

    @Basic
    @Column(name = "accesslevel", nullable = false)
    private Integer accesslevel;

    public Integer getUidfunction() {
        return uidfunction;
    }

    public void setUidfunction(Integer uidfunction) {
        this.uidfunction = uidfunction;
    }

    public String getIdfunction() {
        return idfunction;
    }

    public void setIdfunction(String idfunction) {
        this.idfunction = idfunction;
    }

    public Integer getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(Integer accesslevel) {
        this.accesslevel = accesslevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Function that = (Function) o;
        return uidfunction == that.uidfunction && accesslevel == that.accesslevel && Objects.equals(idfunction, that.idfunction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uidfunction, idfunction, accesslevel);
    }
}
