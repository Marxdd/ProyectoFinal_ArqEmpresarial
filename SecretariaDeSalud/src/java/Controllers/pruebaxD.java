/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import APIs.APIpacientes;
import APIs.doctoresAPI;
import APIs.pacientesAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class pruebaxD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        doctoresAPI doc = new doctoresAPI();
        String resultados = doc.findAll_JSON(String.class);
         ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        try {
            List<pruebaxD.Doctor> doctores = mapper.readValue(resultados, new TypeReference<List<pruebaxD.Doctor>>() {
            });
            for (Doctor doctore : doctores) {
                System.out.println(doctore.getIddoctor());
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(pruebaxD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

       

    }
    //kdjsadi,dasd
    //sadas,asd

    
    public static class Doctor 
    
    {
        String apellido;
        boolean cedula;
        String contraseña;
        String correo;
        String curp;
        int iddoctor;
        String telefono;
        String nombre;

      

        public Doctor() {
        }

        public Doctor(String apellido, boolean cedula, String contraseña, String correo, String curp, int iddoctor, String telefono, String nombre) {
            this.apellido = apellido;
            this.cedula = cedula;
            this.contraseña = contraseña;
            this.correo = correo;
            this.curp = curp;
            this.iddoctor = iddoctor;
            this.telefono = telefono;
            this.nombre = nombre;
        }

        public int getIddoctor() {
            return iddoctor;
        }

        public void setIddoctor(int iddoctor) {
            this.iddoctor = iddoctor;
        }
        

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public boolean isCedula() {
            return cedula;
        }

        public void setCedula(boolean cedula) {
            this.cedula = cedula;
        }

        public String getContraseña() {
            return contraseña;
        }

        public void setContraseña(String contraseña) {
            this.contraseña = contraseña;
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

   

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return "Doctor{" + "apellido=" + apellido + ", cedula=" + cedula + ", contrase\u00f1a=" + contraseña + ", correo=" + correo + ", curp=" + curp + ", idDoctor=" + iddoctor + ", telefono=" + telefono + ", nombre=" + nombre + '}';
        }
        
    }
    public static class Paciente{
        String apellidos;
        String contraseña;
        String correo;
        String curp;
        String doctorAsignado;
        String nombres;
        String telefono;
        int idpaciente;

        public Paciente() {
        }

        public Paciente(String apellidos, String contraseña, String correo, String curp, String doctorAsignado, String nombres, String telefono, int idpaciente) {
            this.apellidos = apellidos;
            this.contraseña = contraseña;
            this.correo = correo;
            this.curp = curp;
            this.doctorAsignado = doctorAsignado;
            this.nombres = nombres;
            this.telefono = telefono;
            this.idpaciente = idpaciente;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getContraseña() {
            return contraseña;
        }

        public void setContraseña(String contraseña) {
            this.contraseña = contraseña;
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

        public String getDoctorAsignado() {
            return doctorAsignado;
        }

        public void setDoctorAsignado(String doctorAsignado) {
            this.doctorAsignado = doctorAsignado;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public int getIdpaciente() {
            return idpaciente;
        }

        public void setIdpaciente(int idpaciente) {
            this.idpaciente = idpaciente;
        }

        @Override
        public String toString() {
            return "Paciente{" + "apellidos=" + apellidos + ", contrase\u00f1a=" + contraseña + ", correo=" + correo + ", curp=" + curp + ", doctorAsignado=" + doctorAsignado + ", nombres=" + nombres + ", telefono=" + telefono + ", idpaciente=" + idpaciente + '}';
        }
        
    }
    
    public static class DocumentosPacientes{
        private String documentoPath;
        private Date fechaCreacion;
        private int iddocumentoPaciente;
        private Paciente paciente;

        public DocumentosPacientes() {
        }

        public DocumentosPacientes(String documentoPath, Date fechaCreacion, int iddocumentoPaciente, Paciente paciente) {
            this.documentoPath = documentoPath;
            this.fechaCreacion = fechaCreacion;
            this.iddocumentoPaciente = iddocumentoPaciente;
            this.paciente = paciente;
        }

        public String getDocumentoPath() {
            return documentoPath;
        }

        public void setDocumentoPath(String documentoPath) {
            this.documentoPath = documentoPath;
        }

        public Date getFechaCreacion() {
            return fechaCreacion;
        }

        public void setFechaCreacion(Date fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
        }

        public int getIddocumentoPaciente() {
            return iddocumentoPaciente;
        }

        public void setIddocumentoPaciente(int iddocumentoPaciente) {
            this.iddocumentoPaciente = iddocumentoPaciente;
        }

        public Paciente getPaciente() {
            return paciente;
        }

        public void setPaciente(Paciente paciente) {
            this.paciente = paciente;
        }

        @Override
        public String toString() {
            return "DocumentosPacientes{" + "documentoPath=" + documentoPath + ", fechaCreacion=" + fechaCreacion + ", iddocumentoPaciente=" + iddocumentoPaciente + ", paciente=" + paciente + '}';
        }
        
    }

}
