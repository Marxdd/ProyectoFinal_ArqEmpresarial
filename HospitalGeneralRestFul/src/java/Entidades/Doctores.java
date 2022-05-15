/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "doctores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctores.findAll", query = "SELECT d FROM Doctores d")
    , @NamedQuery(name = "Doctores.findByIddoctor", query = "SELECT d FROM Doctores d WHERE d.iddoctor = :iddoctor")
    , @NamedQuery(name = "Doctores.findByNombre", query = "SELECT d FROM Doctores d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Doctores.findByApellido", query = "SELECT d FROM Doctores d WHERE d.apellido = :apellido")
    , @NamedQuery(name = "Doctores.findByCedula", query = "SELECT d FROM Doctores d WHERE d.cedula = :cedula")
    , @NamedQuery(name = "Doctores.findByTelefono", query = "SELECT d FROM Doctores d WHERE d.telefono = :telefono")
    , @NamedQuery(name = "Doctores.findByCorreo", query = "SELECT d FROM Doctores d WHERE d.correo = :correo")
    , @NamedQuery(name = "Doctores.findByCurp", query = "SELECT d FROM Doctores d WHERE d.curp = :curp")
    , @NamedQuery(name = "Doctores.findByContrase\u00f1a", query = "SELECT d FROM Doctores d WHERE d.contrase\u00f1a = :contrase\u00f1a")})
public class Doctores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddoctor")
    private Integer iddoctor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private boolean cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 320)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "curp")
    private String curp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "contrase\u00f1a")
    private String contraseña;

    public Doctores() {
    }

    public Doctores(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }

    public Doctores(Integer iddoctor, String nombre, String apellido, boolean cedula, String telefono, String correo, String curp, String contraseña) {
        this.iddoctor = iddoctor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.curp = curp;
        this.contraseña = contraseña;
    }

    public Integer getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean getCedula() {
        return cedula;
    }

    public void setCedula(boolean cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddoctor != null ? iddoctor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctores)) {
            return false;
        }
        Doctores other = (Doctores) object;
        if ((this.iddoctor == null && other.iddoctor != null) || (this.iddoctor != null && !this.iddoctor.equals(other.iddoctor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Doctores[ iddoctor=" + iddoctor + " ]";
    }
    
}
