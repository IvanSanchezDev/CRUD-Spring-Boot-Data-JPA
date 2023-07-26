package com.crud.ntds.modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;



import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="leyes", uniqueConstraints = {@UniqueConstraint(columnNames= {"nombre"})})
public class Leyes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
    private String nombre;
	
	
    private String descripcion_ley;
    
    
    
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_ley;
    
    @ManyToMany
	@JoinTable(name="nombrePresidente_ley"
		,joinColumns=@JoinColumn(name= "id_ley")
	,inverseJoinColumns=@JoinColumn(name= "id_presidente")
	)
	private Set<Presidente> presidente=new HashSet<>();

    public Leyes() {
        
    }
    
	

	public Leyes(String nombre, String descripcion_ley, Set<Presidente> presidente, Date fecha_ley) {
		super();
		this.nombre= nombre;
		this.descripcion_ley = descripcion_ley;
		this.presidente = presidente;
		this.fecha_ley=fecha_ley;
	}



	public Leyes(int id, String nombre, String descripcion_ley, Set<Presidente> presidente, Date fecha_ley) {
		super();
		this.id = id;
		this.nombre= nombre;
		this.descripcion_ley = descripcion_ley;
		this.presidente =presidente;
		this.fecha_ley=fecha_ley;
	}
	
	public Leyes(String nombre, String descripcion_ley, Date fecha_ley) {
		this.nombre= nombre;
		this.descripcion_ley = descripcion_ley;
		this.fecha_ley=fecha_ley;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre_ley(String nombre_ley) {
		this.nombre = nombre_ley;
	}

	public String getDescripcion_ley() {
		return descripcion_ley;
	}

	public void setDescripcion_ley(String descripcion_ley) {
		this.descripcion_ley = descripcion_ley;
	}


	public Set<Presidente> getPresidente() {
		return presidente;
	}



	public void setPresidente(Set<Presidente> presidente) {
		this.presidente = presidente;
	}



	public Date getFecha_ley() {
		return fecha_ley;
	}



	public void setFecha_ley(Date fecha_ley) {
		this.fecha_ley = fecha_ley;
	}
	
	public void añadirPresidente(Presidente p) {
		this.presidente.add(p);
	}
	

	
    
    
    
}
