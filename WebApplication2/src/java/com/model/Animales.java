/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Angel Córdova
 */
@Entity
@Table(name = "animales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animales.findAll", query = "SELECT a FROM Animales a")
    , @NamedQuery(name = "Animales.findByIdAnimal", query = "SELECT a FROM Animales a WHERE a.idAnimal = :idAnimal")
    , @NamedQuery(name = "Animales.findByNombre", query = "SELECT a FROM Animales a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Animales.findByNombreCientifico", query = "SELECT a FROM Animales a WHERE a.nombreCientifico = :nombreCientifico")
    , @NamedQuery(name = "Animales.findByExtincion", query = "SELECT a FROM Animales a WHERE a.extincion = :extincion")
    , @NamedQuery(name = "Animales.findByIdUsuarioRegistro", query = "SELECT a FROM Animales a WHERE a.idUsuarioRegistro = :idUsuarioRegistro")
    , @NamedQuery(name = "Animales.findByFechaHoraRegistro", query = "SELECT a FROM Animales a WHERE a.fechaHoraRegistro = :fechaHoraRegistro")
    , @NamedQuery(name = "Animales.findByVersion", query = "SELECT a FROM Animales a WHERE a.version = :version")
    , @NamedQuery(name = "Animales.findByEliminado", query = "SELECT a FROM Animales a WHERE a.eliminado = :eliminado")
    , @NamedQuery(name = "Animales.findByDetalleModificacion", query = "SELECT a FROM Animales a WHERE a.detalleModificacion = :detalleModificacion")})
public class Animales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_animal")
    private Integer idAnimal;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "nombre_cientifico")
    private String nombreCientifico;
    @Column(name = "extincion")
    private Short extincion;
    @Column(name = "id_usuario_registro")
    private Integer idUsuarioRegistro;
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;
    @Column(name = "version")
    private Integer version;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @Size(max = 45)
    @Column(name = "detalle_modificacion")
    private String detalleModificacion;

    public Animales() {
    }

    public Animales(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public Short getExtincion() {
        return extincion;
    }

    public void setExtincion(Short extincion) {
        this.extincion = extincion;
    }

    public Integer getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(Integer idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public String getDetalleModificacion() {
        return detalleModificacion;
    }

    public void setDetalleModificacion(String detalleModificacion) {
        this.detalleModificacion = detalleModificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnimal != null ? idAnimal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animales)) {
            return false;
        }
        Animales other = (Animales) object;
        if ((this.idAnimal == null && other.idAnimal != null) || (this.idAnimal != null && !this.idAnimal.equals(other.idAnimal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Animales[ idAnimal=" + idAnimal + " ]";
    }
    
}
