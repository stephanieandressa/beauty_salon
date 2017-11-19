package br.com.salao.beleza.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.salao.beleza.model.PersistenceManager;
import br.com.salao.beleza.model.pojo.Cliente;

public class ClienteDAO {
	
	private EntityManager entityManager;
	
	public ClienteDAO() {
		this.entityManager = new PersistenceManager().getEntityManager();
	}
	
	public void salvar(Cliente cliente) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(cliente);
		transaction.commit();
		entityManager.close();
	}
	
	public void deletar(Cliente cliente) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Cliente c = entityManager.find(Cliente.class, cliente.getId());
		entityManager.remove(c);
		transaction.commit();
		entityManager.close();
	}

	public List<Cliente> listar() {
		this.entityManager = new PersistenceManager().getEntityManager();
		Query query = this.entityManager.createQuery("from Cliente");
		return query.getResultList();
	}

	public Cliente buscar(Long id) {
		this.entityManager = new PersistenceManager().getEntityManager();
		Cliente cliente = this.entityManager.find(Cliente.class, id);
		return cliente;
	}

	public void atualizar(Cliente cliente) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(cliente);
		transaction.commit();
		entityManager.close();
	}

	public Cliente buscarPorEmail(String email) {
		this.entityManager = new PersistenceManager().getEntityManager();
		Query query = this.entityManager.createQuery("from Cliente c where c.email like :email");
		query.setParameter("email", email);
		return (Cliente) query.getResultList().get(0);
	}

}
