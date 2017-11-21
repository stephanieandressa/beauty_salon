package br.com.salao.beleza.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	
	private EntityManagerFactory factory;
	
	public PersistenceManager() {
		//Busca a unidade de persistencia configurada no arquivo persistence.xml
		factory = Persistence.createEntityManagerFactory("salao_beleza");
	}
	
	public EntityManager getEntityManager() {
		return this.factory.createEntityManager();
	}
	
	public void close() {
		factory.close();
	}
	

}
