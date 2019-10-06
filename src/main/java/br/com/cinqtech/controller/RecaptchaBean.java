package br.com.cinqtech.controller;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean(name="recaptchaBean")
public class RecaptchaBean extends AbstractController{

	private String siteKey = "6LcYuLsUAAAAANWOItVLQHr81JeV4za2tMyKEPC4";
	private String secretKey = "6LcYuLsUAAAAAB9rQRMb4mCFwZWbGswKcyLoWFwx";
	
	public String getSiteKey() {
		return siteKey;
	}
	
	public void setSiteKey(String siteKey) {
		this.siteKey = siteKey;
	}
	
	public String getSecretKey() {
		return secretKey;
	}
	
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
}
