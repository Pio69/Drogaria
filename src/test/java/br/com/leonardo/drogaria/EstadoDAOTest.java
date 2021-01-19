package br.com.leonardo.drogaria;

import org.junit.Test;

import br.com.leonardo.drogaria.dao.EstadoDAO;
import br.com.leonardo.drogaria.domain.Estado;

public class EstadoDAOTest {
	@Test
	public void salvar(){
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}
}
