package br.com.leonardo.drogaria.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.leonardo.drogaria.util.HibernateUtil;

public class GenericDAO<Entidade> {
	
	private Class<Entidade> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			
			transacao.commit();
		} catch (Exception e) {
			if(transacao != null) transacao.rollback();
			throw e;
		}finally {
			sessao.close();
		}
	}
	
	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			
			transacao.commit();
		} catch (Exception e) {
			if(transacao != null) transacao.rollback();
			throw e;
		}finally {
			sessao.close();
		}
	}
	
	public void editar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			
			transacao.commit();
		} catch (Exception e) {
			if(transacao != null) transacao.rollback();
			throw e;
		}finally {
			sessao.close();
		}
	}
	
	public List<Entidade> listar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		List<Entidade> resultado = null;
		
		try {
			Criteria consulta = sessao.createCriteria(classe);
			resultado = consulta.list();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sessao.close();
		}
		
		return resultado;
	}
	
	public Entidade buscar(Long codigo){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		Entidade resultado = null;
		
		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			resultado = (Entidade) consulta.uniqueResult();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sessao.close();
		}
		
		return resultado;
	}
	
	public void merge(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
			
			transacao.commit();
		} catch (Exception e) {
			if(transacao != null) transacao.rollback();
			throw e;
		}finally {
			sessao.close();
		}
	}
}
