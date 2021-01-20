package br.com.leonardo.drogaria.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.leonardo.drogaria.dao.EstadoDAO;
import br.com.leonardo.drogaria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	
	private Estado estado;
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void novo() {
		estado = new Estado();
	}
	
	public void salvar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
		
		Messages.addGlobalInfo("Estado salvo com sucesso!");
	}	
}
