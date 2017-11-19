package br.com.salao.beleza.model.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="agenda")
public class Agenda {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_colaborador")
	private Colaborador colaborador;
	
	@Column(name="id_cliente")
	private Long idCliente;
	
	@ManyToOne
	@JoinColumn(name="id_horario_funcionamento")
	private HorarioFuncionamento horario;
	
	@Column(name="data_agendamento")
	private Date dataAgendamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}
	
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public HorarioFuncionamento getHorario() {
		return horario;
	}

	public void setHorario(HorarioFuncionamento horario) {
		this.horario = horario;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	
	

}
