package javafacestest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cinqtech.exception.ErroSistema;
import br.com.cinqtech.model.Usuario;
import br.com.cinqtech.model.dao.UsuarioDao;

public class UsuarioDaoTest {
	
	private UsuarioDao userDAO;
	private Integer totalUsuarios;

	@Before
	public void setUp() throws Exception {
		userDAO = UsuarioDao.getInstace();
		totalUsuarios = userDAO.getUsers().size();
	}

	@Test
	public void testIncluirUsuario() throws ErroSistema {
		Usuario user = new Usuario("Teste1","teste1@mail.com","teste123");
		userDAO.incluir(user);		
		Assert.assertEquals(totalUsuarios+1, userDAO.getUsers().size());		
	}
	
	@Test
	public void testAlterarUsuario() throws ErroSistema {
		Usuario user = new Usuario("Teste12","teste1@mail.com","teste123");		
		userDAO.alterar(user);
		Assert.assertEquals(totalUsuarios.intValue(), userDAO.getUsers().size());
	}
	
	@Test
	public void testBuscarUsuario() throws ErroSistema {		
		Usuario user = userDAO.buscar(new Usuario(null,"admin@mail.com",null));
		Assert.assertEquals("Administrador", user.getNome() );
	}
	
	@Test
	public void testExcluirUsuario() throws ErroSistema {		
		Usuario user = new Usuario("Teste12","teste1@mail.com","teste123");
		Assert.assertEquals(true, userDAO.excluir(user));
	}

}
