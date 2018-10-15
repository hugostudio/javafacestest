package br.com.cinqtech.controller;

/**
 * 
 * @author Hugo Leonardo
 *
 * Classe controler do estado de tela para implementação de Crud 
 */

public class CrudController extends AbstractController {
	private String estadoCrud = "buscar";
	
	public Boolean isStatusInserir() {
		return "inserir".equals(estadoCrud);
	}
	
	public Boolean isStatusAlterar() {
		return "alterar".equals(estadoCrud);
	}
	
	public Boolean isStatusBuscar() {
		return "buscar".equals(estadoCrud);
	}
	
	public void mudarStatusInserir() {
		estadoCrud = "inserir";
	}
	
	public void mudarStatusAlterar() {
		estadoCrud = "alterar";
	}
	
	public void mudarStatusBuscar() {
		estadoCrud = "buscar";
	}
}
