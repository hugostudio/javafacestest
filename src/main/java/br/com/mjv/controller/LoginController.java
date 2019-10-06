package br.com.mjv.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.mjv.exception.ErroSistema;
import br.com.mjv.model.Usuario;
import br.com.mjv.model.dao.UsuarioDao;

/**
 * 
 * @author Hugo Leonardo
 *
 *         Classe que representa o Controler do Login
 */
@SessionScoped
@ManagedBean(name = "loginController")
public class LoginController extends AbstractController {

	@ManagedProperty(value = UsuarioController.INJECTION_NAME)
	private UsuarioController usuarioController;

	@ManagedProperty(value = RecaptchaBean.INJECTION_NAME)
	private RecaptchaBean recaptchaBean;
	
	private String login;
	private String senha;
	private Integer tentativaLogin = 3;

	private Usuario usuarioLogado;

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario user) {
		this.usuarioLogado = user;
	}
	
	public String logOut() {
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
		return "index.xhtml?faces-redirect=true";
	}
	
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

	private Usuario isValidLogin(String login, String senha) throws ErroSistema {
		tentativaLogin = tentativaLogin - 1;
		System.out.println("tentativaLogin : " + tentativaLogin);

		Usuario user = UsuarioDao.getInstace().buscar(new Usuario(null, login, null));

		if (user == null || !senha.toUpperCase().equals(user.getSenha().toUpperCase())) {
			return null;
		}

		return user;
	}

	public String entrar() throws ErroSistema {
		if (tentativaLogin.equals(0)) {
			tentativaLogin = 3;
			System.out.println("tentativaLogin : " + tentativaLogin);
			return "/acessoNegado.xhtml?faces-redirect=true";

		} else {

			String gRecaptchaResponse = FacesContext.getCurrentInstance().
				        getExternalContext().getRequestParameterMap().get("g-recaptcha-response");
			boolean verify = recaptchaBean.verify(gRecaptchaResponse);
			
	        if(verify){	             
	             usuarioLogado = isValidLogin(login, senha);

	 			if (usuarioLogado != null) {
	 				FacesContext context = FacesContext.getCurrentInstance();
	 				HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
	 				request.getSession().setAttribute("user", usuarioLogado);
	 				return "index.xhtml?faces-redirect=true";
	 			}
	 			displayErrorMessage("Verifique o usuário e senha !");
	        } else {
	        	displayErrorMessage("Select Captcha !");	             	             
	            return null;
	        }				        			
		}
		return null;
	}

	public RecaptchaBean getRecaptchaBean() {
		return recaptchaBean;
	}

	public void setRecaptchaBean(RecaptchaBean recaptchaBean) {
		this.recaptchaBean = recaptchaBean;
	}
}
