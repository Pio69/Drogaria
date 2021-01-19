package br.com.leonardo.drogaria;

import org.hibernate.Session;
import org.junit.Test;

import br.com.leonardo.drogaria.util.HibernateUtil;

public class HibernateUtilTest {
	
	@Test
	public void conectar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
