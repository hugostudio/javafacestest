package br.com.mjv.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@ApplicationScoped
@ManagedBean(name="recaptchaBean")
public class RecaptchaBean extends AbstractController{

    public static final String INJECTION_NAME = "#{recaptchaBean}";
    private String siteKey;
    private String secretKey;
    private static final String url = "https://www.google.com/recaptcha/api/siteverify";
    private static final String USER_AGENT = "Mozilla/5.0";
    
    public RecaptchaBean() {
        this.siteKey = "6LcYuLsUAAAAANWOItVLQHr81JeV4za2tMyKEPC4";
        this.secretKey = "6LcYuLsUAAAAAB9rQRMb4mCFwZWbGswKcyLoWFwx";
    }
    
    public boolean verify(final String gRecaptchaResponse) {
        if (gRecaptchaResponse == null || "".equals(gRecaptchaResponse)) {
            return false;
        }
        try {
            final URL obj = new URL(url);
            final HttpsURLConnection con = (HttpsURLConnection)obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            final String postParams = "secret=" + this.secretKey + "&response=" + gRecaptchaResponse;
            con.setDoOutput(true);
            final DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            final int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : https://www.google.com/recaptcha/api/siteverify");
            System.out.println("Post parameters : " + postParams);
            System.out.println("Response Code : " + responseCode);
            final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            final StringBuffer response = new StringBuffer();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
            final Gson gson = new Gson();
            final Map<String, Object> gsonRetorno = gson.fromJson(response.toString(), new TypeToken<Map<String, Object>>() {}.getType());
            return String.valueOf(gsonRetorno.get("success")).equals("true");
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
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