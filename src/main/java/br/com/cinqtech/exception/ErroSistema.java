package br.com.cinqtech.exception;

/**
 * 
 * @author Hugo Leonardo
 *
 * Classe de excessão que representa erros nas interações basicas de um CRUD
 */
public class ErroSistema extends Exception {

	private static final long serialVersionUID = 1L;

	public ErroSistema(String message) {
        super(message);
    }

    public ErroSistema(String message, Throwable cause) {
        super(message, cause);
    }
    
}
