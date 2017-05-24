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
@Table(name = "casa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casa.findAll", query = "SELECT c FROM Casa c")
    , @NamedQuery(name = "Casa.findByIdCasa", query = "SELECT c FROM Casa c WHERE c.idCasa = :idCasa")
    , @NamedQuery(name = "Casa.findByLote", query = "SELECT c FROM Casa c WHERE c.lote = :lote")
    , @NamedQuery(name = "Casa.findByManzana", query = "SELECT c FROM Casa c WHERE c.manzana = :manzana")
    , @NamedQuery(name = "Casa.findByCallePrincipal", query = "SELECT c FROM Casa c WHERE c.callePrincipal = :callePrincipal")
    , @NamedQuery(name = "Casa.findByCalleSecundaria", query = "SELECT c FROM Casa c WHERE c.calleSecundaria = :calleSecundaria")})
public class Casa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_casa")
    private Integer idCasa;
    @Column(name = "lote")
    private Integer lote;
    @Column(name = "manzana")
    private Integer manzana;
    @Size(max = 100)
    @Column(name = "calle_principal")
    private String callePrincipal;
    @Size(max = 100)
    @Column(name = "calle_secundaria")
    private String calleSecundaria;

    public Casa() {
    }

    public Casa(Integer idCasa) {
        this.idCasa = idCasa;
    }

    public Integer getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(Integer idCasa) {
        this.idCasa = idCasa;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public Integer getManzana() {
        return manzana;
    }

    public void setManzana(Integer manzana) {
        this.manzana = manzana;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCasa != null ? idCasa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casa)) {
            return false;
        }
        Casa other = (Casa) object;
        if ((this.idCasa == null && other.idCasa != null) || (this.idCasa != null && !this.idCasa.equals(other.idCasa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Casa[ idCasa=" + idCasa + " ]";
    }
    
}
