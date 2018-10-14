package br.com.cinqtech.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.cinqtech.model.Usuario;

/**
 * 
 * @author Hugo Leonardo
 *
 * Classe que representa o Controler do Usuário
 */

@SessionScoped
@ManagedBean(name="usuarioController")
public class UsuarioController extends AbstractController{
	
	public static final String INJECTION_NAME = "#{usuarioController}";
	
	private Usuario user;

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	
	public String logOut() {
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
		return "index.xhtml?faces-redirect=true";
	}

}
