/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Paciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario
 */
public class pacientesDAODummy implements BaseDAO<Paciente>{
     
    private List<Paciente> pacientes = new ArrayList<Paciente>();

    @Override
    public void agregar(Paciente entidad) {
       entidad.setId((long)this.pacientes.size()+1);
       pacientes.add(entidad);
    }

    @Override
    public void eliminar(Paciente entidad) {
        pacientes.remove(entidad);
    }

    @Override
    public void actualizar(Paciente entidad) {
       int indice = this.pacientes.indexOf(entidad);
       if (indice ==-1){
           
       }else{
           Paciente pacienteGuardado = this.pacientes.get(indice);
           pacienteGuardado.setNombre(entidad.getNombre());
           pacienteGuardado.setCurp(entidad.getCurp());
       }
    }

    @Override
    public Paciente buscarPorId(Integer entidad) {
      int indice = this.pacientes.indexOf(entidad);
      if (indice ==-1){
          return null;
      }
      Paciente paciente = this.pacientes.get(indice);
      return paciente;
    }

    @Override
    public List<Paciente> mostrarTodas() {
       return pacientes;
    }
   
}
