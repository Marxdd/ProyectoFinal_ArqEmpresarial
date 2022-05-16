/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "pacientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p")
    , @NamedQuery(name = "Pacientes.findByIdpaciente", query = "SELECT p FROM Pacientes p WHERE p.idpaciente = :idpaciente")
    , @NamedQuery(name = "Pacientes.findByNombres", query = "SELECT p FROM Pacientes p WHERE p.nombres = :nombres")
    , @NamedQuery(name = "Pacientes.findByApellidos", query = "SELECT p FROM Pacientes p WHERE p.apellidos = :apellidos")
    , @NamedQuery(name = "Pacientes.findByCurp", query = "SELECT p FROM Pacientes p WHERE p.curp = :curp")
    , @NamedQuery(name = "Pacientes.findByCorreo", query = "SELECT p FROM Pacientes p WHERE p.correo = :correo")
    , @NamedQuery(name = "Pacientes.findByContrase\u00f1a", query = "SELECT p FROM Pacientes p WHERE p.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "Pacientes.findByTelefono", query = "SELECT p FROM Pacientes p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Pacientes.findByDoctorAsignado", query = "SELECT p FROM Pacientes p WHERE p.doctorAsignado = :doctorAsignado")})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpaciente")
    private Integer idpaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "curp")
    private String curp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 320)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "doctor_asignado")
    private String doctorAsignado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Collection<DocumentosPacientes> documentosPacientesCollection;

    public Pacientes() {
    }

    public Pacientes(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Pacientes(Integer idpaciente, String nombres, String apellidos, String curp, String correo, String contraseña, String telefono, String doctorAsignado) {
        this.idpaciente = idpaciente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.curp = curp;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.doctorAsignado = doctorAsignado;
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDoctorAsignado() {
        return doctorAsignado;
    }

    public void setDoctorAsignado(String doctorAsignado) {
        this.doctorAsignado = doctorAsignado;
    }

    @XmlTransient
    public Collection<DocumentosPacientes> getDocumentosPacientesCollection() {
        return documentosPacientesCollection;
    }

    public void setDocumentosPacientesCollection(Collection<DocumentosPacientes> documentosPacientesCollection) {
        this.documentosPacientesCollection = documentosPacientesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaciente != null ? idpaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.idpaciente == null && other.idpaciente != null) || (this.idpaciente != null && !this.idpaciente.equals(other.idpaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pacientes[ idpaciente=" + idpaciente + " ]";
    }
    
}
