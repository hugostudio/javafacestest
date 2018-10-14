package br.com.cinqtech.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.cinqtech.model.Usuario;

/**
 * 
 * @author Hugo Leonardo
 *
 * Classe que representa o Controler do Login
 */
@SessionScoped
@ManagedBean(name="loginController")
public class LoginController extends AbstractController {
	
	@ManagedProperty(value=UsuarioController.INJECTION_NAME)
	private UsuarioController usuarioController;
	
	private String login;
	private String senha;
	private Integer tentativaLogin = 3;
	
	public Integer getTentativaLogin() {
		return tentativaLogin;
	}

	public void setTentativaLogin(Integer tentativaLogin) {
		this.tentativaLogin = tentativaLogin;
	}

	public UsuarioController getUsuarioController() {
		return usuarioController;
	}

	public void setUsuarioController(UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	private Usuario isValidLogin(String login, String senha) {
		/*
		 * TODO Implementar a busca do usuario no arquivo json
		 */
		tentativaLogin = tentativaLogin -1;
		System.out.println("tentativaLogin : " + tentativaLogin);
		
		Usuario user;
		if(login.equals("admin@mail.com")) {
			user = new Usuario("Administrador","admin@mail.com","masterkey");
		}else {
			user = null;
		}
		
		if(user == null || !senha.equals(user.getSenha())) {
			return null;
		}
		
		return user;
	}

	public String entrar() {
		if(tentativaLogin.equals(0)) {
			tentativaLogin = 3;
			System.out.println("tentativaLogin : " + tentativaLogin);
			return "/acessoNegado.xhtml?faces-redirect=true";
			
		} else {
			
			Usuario user = isValidLogin(login, senha);
			
			if(user != null) {
				usuarioController.setUser(user);	
				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
				request.getSession().setAttribute("user", user);
				return "index.xhtml?faces-redirect=true";
			}
			displayErrorMessage("Verifique o usuário e senha !");
		}
		
		return null;
	}
	
}
