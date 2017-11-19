package br.com.salao.beleza.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.salao.beleza.model.dao.ClienteDAO;
import br.com.salao.beleza.model.pojo.Cliente;

@ManagedBean(name="customerList")
@RequestScoped
public class CustomerListController {
	
	private List<Cliente> customers;
	
	@PostConstruct
	public void init(){
		ClienteDAO customerDao = new ClienteDAO();
		this.customers = customerDao.listar();
	}
	
	public List<Cliente> getCustomers() {
		return customers;
	}

}
