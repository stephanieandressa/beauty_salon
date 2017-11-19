package br.com.salao.beleza.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.salao.beleza.model.dao.AgendamentoDAO;
import br.com.salao.beleza.model.dao.ColaboradorDAO;
import br.com.salao.beleza.model.pojo.Agenda;
import br.com.salao.beleza.model.pojo.Cliente;
import br.com.salao.beleza.model.pojo.Colaborador;

@ManagedBean(name="beanAgendamento", eager=true)
@RequestScoped
public class BeanAgendamento {
	
	private Cliente cliente = new Cliente();
	private List<Agenda> agendas = new ArrayList<>();
	private Colaborador colaborador = new Colaborador();
	private List<Colaborador> colaboradores = new ArrayList<>();
	private Date data = new Date();
	
	public String agendarCliente(Cliente cliente) {
		this.cliente = cliente;
		ColaboradorDAO colaboradorDao = new ColaboradorDAO();
		colaboradores = colaboradorDao.listar();
		return "agendamento.xhtml";
	}
	
	public void buscaAgendaColaborador() {
		if (this.colaborador.getId() != null) {
			AgendamentoDAO agendamentoDao = new AgendamentoDAO();
			this.agendas = agendamentoDao.buscaAgendaColaborador(this.colaborador.getId(), this.data);
		}
	}
	
	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}
	
	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}
	
	public Colaborador getColaborador() {
		return colaborador;
	}
	
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
	public List<Agenda> getAgendas() {
		return agendas;
	}
	
	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	

}
