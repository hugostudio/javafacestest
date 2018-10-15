package br.com.cinqtech.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.cinqtech.model.dao.UsuarioDao;

/**
 * 
 * @author Hugo Leonardo
 *
 * Classe que representa o Controler do Usuário
 */

@SessionScoped
@ManagedBean(name="usuarioController")
public class UsuarioController extends CrudController{
	
	public static final String INJECTION_NAME = "#{usuarioController}";
	
	private UsuarioDao usuarioDao = UsuarioDao.getInstace();

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public String navegarNovoUsuario() {
		mudarStatusInserir();
		return "/pages/cadastroUsuario.xhtml?faces-redirect=true";
	}
	
	public String navegarListarAlbum() {
		return "/pages/listarAlbum.xhtml?faces-redirect=true";
	}
	
	public String navegarHome() {
		mudarStatusBuscar();
		return "/pages/index.xhtml?faces-redirect=true";
	}	
	
}
