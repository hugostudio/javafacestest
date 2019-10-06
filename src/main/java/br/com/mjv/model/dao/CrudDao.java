package br.com.mjv.model.dao;

import br.com.mjv.exception.ErroSistema;

/**
 * 
 * @author Hugo Leonardo
 *
 * Interface que representa as interações basicas de um CRUD
 */

public interface CrudDao<E> {
    
    public Boolean incluir(E entidade) throws ErroSistema;
    public Boolean excluir(E entidade) throws ErroSistema;
    public Boolean alterar(E entidade) throws ErroSistema;
    public E buscar(E entidade) throws ErroSistema;
    
}
