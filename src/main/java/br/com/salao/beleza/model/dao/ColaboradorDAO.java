package br.com.salao.beleza.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.salao.beleza.model.PersistenceManager;
import br.com.salao.beleza.model.pojo.Colaborador;

public class ColaboradorDAO {
	
private EntityManager entityManager;
	
	public ColaboradorDAO() {
		this.entityManager = new PersistenceManager().getEntityManager();
	}
	
	public void salvar(Colaborador colaborador) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(colaborador);
		transaction.commit();
		entityManager.close();
	}
	
	public void deletar(Colaborador colaborador) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Colaborador e = entityManager.find(Colaborador.class, colaborador.getId());
		entityManager.remove(e);
		transaction.commit();
		entityManager.close();
	}

	public List<Colaborador> listar() {
		this.entityManager = new PersistenceManager().getEntityManager();
		Query query = this.entityManager.createQuery("from Colaborador");
		return query.getResultList();
	}

	public Colaborador buscar(Long id) {
		this.entityManager = new PersistenceManager().getEntityManager();
		Colaborador colaborador = this.entityManager.find(Colaborador.class, id);
		return colaborador;
	}

	public void atualizar(Colaborador colaborador) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(colaborador);
		transaction.commit();
		entityManager.close();
	}

}
