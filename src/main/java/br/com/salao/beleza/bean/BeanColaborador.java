package br.com.salao.beleza.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.salao.beleza.model.dao.ColaboradorDAO;
import br.com.salao.beleza.model.pojo.Colaborador;

@ManagedBean(name="beanColaborador")
@RequestScoped
public class BeanColaborador {
	
	private Colaborador colaborador = new Colaborador();
	private DataModel<Colaborador> colaboradores;
	
	@PostConstruct
	public void init() {
		this.listar();
	}
	
	private void listar() {
		ColaboradorDAO colaboradorDao = new ColaboradorDAO();
		List<Colaborador> colaboradores = colaboradorDao.listar();
		this.colaboradores = new ListDataModel<>(colaboradores);
	}

	public String salvar() {
		ColaboradorDAO colaboradorDao = new ColaboradorDAO();
		if (colaborador == null) {
			return "colaborador.xhtml";
		}
		if (colaborador.getId() != null) {
			colaboradorDao.atualizar(colaborador);
			this.listar();
			return "colaborador-lista.xhtml";
		}
		colaboradorDao.salvar(colaborador);
		this.listar();
		return "colaborador-lista.xhtml";
	}
	
	public void remover() {
		ColaboradorDAO colaboradorDao = new ColaboradorDAO();
		colaboradorDao.deletar(this.colaboradores.getRowData());
		this.listar();
	}
	
	public String novoColaborador() {
		this.colaborador = new Colaborador();
		return "colaborador.xhtml";
	}
	
	public String buscar() {
		this.colaborador = this.colaboradores.getRowData();
		return "colaborador.xhtml";
	}
	
	public DataModel<Colaborador> getColaboradores() {
		return this.colaboradores;
	}
	
	public Colaborador getColaborador() {
		return this.colaborador;
	}
	
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
	public void setColaboradores(DataModel<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}

}
