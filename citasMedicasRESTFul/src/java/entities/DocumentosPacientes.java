/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "documentos_pacientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentosPacientes.findAll", query = "SELECT d FROM DocumentosPacientes d")
    , @NamedQuery(name = "DocumentosPacientes.findByIddocumentoPaciente", query = "SELECT d FROM DocumentosPacientes d WHERE d.iddocumentoPaciente = :iddocumentoPaciente")
    , @NamedQuery(name = "DocumentosPacientes.findByFechaCreacion", query = "SELECT d FROM DocumentosPacientes d WHERE d.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "DocumentosPacientes.findByDocumentoPath", query = "SELECT d FROM DocumentosPacientes d WHERE d.documentoPath = :documentoPath")})
public class DocumentosPacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddocumento_paciente")
    private Integer iddocumentoPaciente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "documento_path")
    private String documentoPath;
    @JoinColumn(name = "paciente", referencedColumnName = "idpaciente")
    @ManyToOne(optional = false)
    private Pacientes paciente;

    public DocumentosPacientes() {
    }

    public DocumentosPacientes(Integer iddocumentoPaciente) {
        this.iddocumentoPaciente = iddocumentoPaciente;
    }

    public DocumentosPacientes(Integer iddocumentoPaciente, Date fechaCreacion, String documentoPath) {
        this.iddocumentoPaciente = iddocumentoPaciente;
        this.fechaCreacion = fechaCreacion;
        this.documentoPath = documentoPath;
    }

    public Integer getIddocumentoPaciente() {
        return iddocumentoPaciente;
    }

    public void setIddocumentoPaciente(Integer iddocumentoPaciente) {
        this.iddocumentoPaciente = iddocumentoPaciente;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDocumentoPath() {
        return documentoPath;
    }

    public void setDocumentoPath(String documentoPath) {
        this.documentoPath = documentoPath;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddocumentoPaciente != null ? iddocumentoPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentosPacientes)) {
            return false;
        }
        DocumentosPacientes other = (DocumentosPacientes) object;
        if ((this.iddocumentoPaciente == null && other.iddocumentoPaciente != null) || (this.iddocumentoPaciente != null && !this.iddocumentoPaciente.equals(other.iddocumentoPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DocumentosPacientes[ iddocumentoPaciente=" + iddocumentoPaciente + " ]";
    }
    
}
