/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author Mario
 */
public interface BaseDAO<T> {
     public abstract void agregar(T entidad);

    public abstract void eliminar(T entidad);

    public abstract void actualizar(T entidad);

    public abstract T buscarPorId(Integer entidad);

    public abstract List<T> mostrarTodas();

}
