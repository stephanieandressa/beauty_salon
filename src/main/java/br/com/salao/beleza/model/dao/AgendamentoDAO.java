package br.com.salao.beleza.model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.salao.beleza.model.PersistenceManager;
import br.com.salao.beleza.model.pojo.Agenda;

public class AgendamentoDAO {
	
	private EntityManager entityManager;
	
	public AgendamentoDAO() {
		this.entityManager = new PersistenceManager().getEntityManager();
	}

	public List<Agenda> buscaAgendaColaborador(Long id, Date data) {
		this.entityManager = new PersistenceManager().getEntityManager();
		String sql = "select h.id as horario.id, h.hora as horario.hora, a.id_cliente as idCliente from horario_funcionamento h "
					+ "left join agenda a on h.id = a.id_hora where a.id_colaborador = :id "
					+ "and a.data_agendamento = :data";
		Query query = this.entityManager.createNativeQuery(sql, Agenda.class);
		query.setParameter("id", id);
		query.setParameter("data", data);
		return query.getResultList();
	}

}
