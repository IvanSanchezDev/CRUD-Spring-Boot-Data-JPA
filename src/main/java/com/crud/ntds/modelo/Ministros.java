package com.crud.ntds.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;


import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="ministros", uniqueConstraints = {@UniqueConstraint(columnNames= {"titular"})} )
public class Ministros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	private String cargo;
	
	@NotEmpty
	private String titular;
	

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_inicio;
	
	@NotEmpty
	private String partido_politico;
	
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="presidente_id")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Presidente presidente;

	

	public Ministros() {
		
	}

	public Ministros(int id, @NotEmpty String cargo, @NotEmpty String titular, Date fecha_inicio,
			@NotEmpty String partido_politico, Presidente presidente) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.titular = titular;
		this.fecha_inicio = fecha_inicio;
		this.partido_politico = partido_politico;
		this.presidente = presidente;
	}
	
	
	
	
	

	public Ministros(@NotEmpty String titular) {
		super();
		this.titular = titular;
	}

	public Ministros(@NotEmpty String cargo, @NotEmpty String titular, @NotEmpty String partido_politico,
			Presidente presidente) {
		super();
		this.cargo = cargo;
		this.titular = titular;
		this.partido_politico = partido_politico;
		this.presidente = presidente;
	}

	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getPartido_politico() {
		return partido_politico;
	}

	public void setPartido_politico(String partido_politico) {
		this.partido_politico = partido_politico;
	}

	public Presidente getPresidente() {
		return presidente;
	}

	public void setPresidente(Presidente presidente) {
		this.presidente = presidente;
	}
	
	
	
	
	
}
