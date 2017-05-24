/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Angel Córdova
 */
@Entity
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculos_1.findAll", query = "SELECT v FROM Vehiculos_1 v")
    , @NamedQuery(name = "Vehiculos_1.findByIdVehiculos", query = "SELECT v FROM Vehiculos_1 v WHERE v.idVehiculos = :idVehiculos")
    , @NamedQuery(name = "Vehiculos_1.findByMarca", query = "SELECT v FROM Vehiculos_1 v WHERE v.marca = :marca")
    , @NamedQuery(name = "Vehiculos_1.findByTipo", query = "SELECT v FROM Vehiculos_1 v WHERE v.tipo = :tipo")
    , @NamedQuery(name = "Vehiculos_1.findByColor", query = "SELECT v FROM Vehiculos_1 v WHERE v.color = :color")
    , @NamedQuery(name = "Vehiculos_1.findByCilindraje", query = "SELECT v FROM Vehiculos_1 v WHERE v.cilindraje = :cilindraje")})
public class Vehiculos_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculos")
    private Integer idVehiculos;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 45)
    @Column(name = "color")
    private String color;
    @Column(name = "cilindraje")
    private Integer cilindraje;

    public Vehiculos_1() {
    }

    public Vehiculos_1(Integer idVehiculos) {
        this.idVehiculos = idVehiculos;
    }

    public Integer getIdVehiculos() {
        return idVehiculos;
    }

    public void setIdVehiculos(Integer idVehiculos) {
        this.idVehiculos = idVehiculos;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(Integer cilindraje) {
        this.cilindraje = cilindraje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculos != null ? idVehiculos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculos_1)) {
            return false;
        }
        Vehiculos_1 other = (Vehiculos_1) object;
        if ((this.idVehiculos == null && other.idVehiculos != null) || (this.idVehiculos != null && !this.idVehiculos.equals(other.idVehiculos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Vehiculos_1[ idVehiculos=" + idVehiculos + " ]";
    }
    
}
