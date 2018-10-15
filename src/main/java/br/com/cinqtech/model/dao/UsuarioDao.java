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

import br.com.cinqtech.exception.ErroSistema;
import br.com.cinqtech.model.Usuario;
/**
 * 
 * @author Hugo Leonardo
 *
 * Classe que representa as interações de manipulação de dados do Usuario
 */

public class UsuarioDao implements CrudDao<Usuario>{

	private static final String nomeArq = "Usuario.json";
	
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

		ClassLoader classLoader = getClass().getClassLoader();
		String realPath= classLoader.getResource(nomeArq).getFile();
			
		try {
			br = new BufferedReader( new FileReader(realPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		this.users = ((List<Usuario>) gson.fromJson(br, new TypeToken<List<Usuario>>(){}.getType() ));
         
        //Imprime no console o Objeto JSON para vizualização
        System.out.println(users.toString());
	}
	

	@Override
	public Boolean incluir(Usuario entidade) throws ErroSistema {
		try {
			if(entidade != null) {
				if(!users.contains(entidade)) {
					users.add(entidade);
					gravarArquivo();
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar incluir !", ex);
        }
	}

	@Override
	public Boolean excluir(Usuario entidade) throws ErroSistema {
		try {
			if(entidade != null) {
				if(users.contains(entidade) ) {
					users.remove(entidade);
					gravarArquivo();
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception ex) {
		    throw new ErroSistema("Erro ao tentar excluir !", ex);
		}	
	}

	@Override
	public Boolean alterar(Usuario entidade) throws ErroSistema {
		try {
			if(entidade != null) {
				if(users.contains(entidade) ) {
					users.remove(entidade);
					users.add(entidade);
					gravarArquivo();
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception ex) {
		    throw new ErroSistema("Erro ao tentar excluir !", ex);
		}	
	}

	@Override
	public Usuario buscar(Usuario entidade) throws ErroSistema {
		try {
			if(entidade != null) {
				if(users.contains(entidade) ) {
					return users.get(users.indexOf(entidade));
				} else {
					return null;
				}
			} else {
				return null;
			}
		} catch (Exception ex) {
		    throw new ErroSistema("Erro ao tentar excluir !", ex);
		}
	}
}
