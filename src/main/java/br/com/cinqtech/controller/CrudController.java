package br.com.cinqtech.controller;

/**
 * 
 * @author Hugo Leonardo
 *
 * Classe controler do estado de tela para implementação de Crud 
 */

public class CrudController extends AbstractController {
	private String estadoCrud = "buscar";
	
	public Boolean isInserir() {
		return "inserir".equals(estadoCrud);
	}
	
	public Boolean isAlterar() {
		return "alterar".equals(estadoCrud);
	}
	
	public Boolean isBuscar() {
		return "buscar".equals(estadoCrud);
	}
	
	public void mudarParaInserir() {
		estadoCrud = "inserir";
	}
	
	public void mudarParaAlterar() {
		estadoCrud = "alterar";
	}
	
	public void mudarParaBuscar() {
		estadoCrud = "buscar";
	}
}
