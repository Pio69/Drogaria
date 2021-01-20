package br.com.leonardo.drogaria;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.leonardo.drogaria.dao.EstadoDAO;
import br.com.leonardo.drogaria.domain.Estado;

public class EstadoDAOTest {
	@Test
	@Ignore
	public void salvar(){
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}
	
	@Test
	@Ignore
	public void listar(){
		
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		
		for(Estado estado : resultado) {
			System.out.println(estado.getNome() + " - " + estado.getSigla());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado resultado = estadoDAO.buscar(codigo);

	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado resultado = estadoDAO.buscar(codigo);
		estadoDAO.excluir(resultado);

	}
}


