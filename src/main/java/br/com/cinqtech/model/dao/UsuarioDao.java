package br.com.cinqtech.model.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.cinqtech.model.Usuario;

public class UsuarioDao {
	
	private static final String nomeArq = "src\\main\\resources\\Usuario.json";
	
	private static UsuarioDao INSTANCE;
	
	private List<Usuario> users = new ArrayList<Usuario>();
	
	public List<Usuario> getUsers() {
		return users;
	}

	public void setUsers(List<Usuario> users) {
		this.users = users;
	}

	public static UsuarioDao getInstace() {
		if(INSTANCE == null) {
			INSTANCE = new UsuarioDao();	
			INSTANCE.lerArquivo();
		} 
		return INSTANCE;
	}
	
	public void gravarArquivo() {
		FileWriter writeFile = null;
    	Gson gson = new Gson();    	
       // users.add(new Usuario("Administrador","admin@mail.com","masterkey"));
        
        try{
        	writeFile = new FileWriter(nomeArq);
        	gson.toJson(users, writeFile);
            writeFile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
	}

	@SuppressWarnings("unchecked")
	private  void lerArquivo() {
		Gson gson = new Gson(); 
		BufferedReader br = null;
		try {
			br = new BufferedReader( new FileReader(nomeArq));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		this.users = ((List<Usuario>) gson.fromJson(br, new TypeToken<List<Usuario>>(){}.getType() ));
         
        //Imprime no console o Objeto JSON para vizualização
        System.out.println(users.toString());
	}
	
	public Boolean incluirUsuario(Usuario user) {	
		if(user != null) {
			if(!users.contains(user)) {
				users.add(user);
				gravarArquivo();
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public Boolean excluirUsuario(Usuario user) {	
		if(user != null) {
			if(users.contains(user) ) {
				users.remove(user);
				gravarArquivo();
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public Boolean alterarUsuario(Usuario user) {	
		if(user != null) {
			if(users.contains(user) ) {
				users.remove(user);
				users.add(user);
				gravarArquivo();
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
