package br.com.salao.beleza.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.salao.beleza.model.dao.ClienteDAO;
import br.com.salao.beleza.model.pojo.Cliente;

@ManagedBean(name="beanCliente")
@RequestScoped
public class BeanCliente {
	
	private Cliente cliente = new Cliente();
	private DataModel<Cliente> clientes;
	
	@ManagedProperty("#{beanAgendamento}")
	private BeanAgendamento beanAgendamento;
	
	@PostConstruct
	public void init() {
		this.listar();
	}
	
	private void listar() {
		ClienteDAO clienteDao = new ClienteDAO();
		List<Cliente> clientes = clienteDao.listar();
		this.clientes = new ListDataModel<>(clientes);
	}

	public String salvar() {
		ClienteDAO clienteDao = new ClienteDAO();
		if (cliente == null) {
			return "cliente.xhtml";
		}
		if (cliente.getId() != null) {
			clienteDao.atualizar(cliente);
			this.listar();
			return "cliente-list.xhtml";
		}
		clienteDao.salvar(cliente);
		this.listar();
		return "cliente-list.xhtml";
	}
	
	public void remover() {
		ClienteDAO clienteDao = new ClienteDAO();
		clienteDao.deletar(this.clientes.getRowData());
		this.listar();
	}
	
	public String novoCliente() {
		this.cliente = new Cliente();
		return "cliente.xhtml";
	}
	
	public String buscar() {
		this.cliente = this.clientes.getRowData();
		return "cliente.xhtml";
	}
	
	public String agendar() {
		String email = this.cliente.getEmail();
		ClienteDAO clienteDao = new ClienteDAO();
		Cliente cliente = clienteDao.buscarPorEmail(email);
		return this.beanAgendamento.agendarCliente(cliente);
	}
	
	public DataModel<Cliente> getClientes() {
		return this.clientes;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setC(DataModel<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public BeanAgendamento getBeanAgendamento() {
		return beanAgendamento;
	}
	
	public void setBeanAgendamento(BeanAgendamento beanAgendamento) {
		this.beanAgendamento = beanAgendamento;
	}

}
