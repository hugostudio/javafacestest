package br.com.mjv.controller;

import br.com.mjv.util.JSFUtil;

/**
 * 
 * @author Hugo Leonardo
 *
 * Classe controler abstrata com metodos para o gerenciamento de mensagens 
 */

public class AbstractController {

	public AbstractController() {
	}
	
	protected void displayErrorMessage(String message) {
		JSFUtil.sendErroMessage(message);
	}

	protected void displayInfoMessage(String message) {
		JSFUtil.sendInfoMessage(message);
	}
	
}
