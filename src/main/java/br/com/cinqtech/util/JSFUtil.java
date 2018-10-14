package br.com.cinqtech.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * 
 * @author Hugo Leonardo
 *
 * Classe utilitaria para gerenciamento de mensagens
 */


public class JSFUtil {

	public static void sendInfoMessage(String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_INFO, message);
		addMessageToJsfContext(facesMessage);
	} 
	
	public static void sendErroMessage(String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_ERROR, message);
		addMessageToJsfContext(facesMessage);
	} 
	
	private static FacesMessage createMessage(FacesMessage.Severity severity, String message) {
		return new FacesMessage(severity, message, message);
	} 	
		
	private static void addMessageToJsfContext(FacesMessage facesMessage) {
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
}
