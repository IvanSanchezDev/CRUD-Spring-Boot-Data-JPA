package com.crud.ntds.modelo;



import java.util.Date;

//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;





@Entity
@Table(name="presidente", uniqueConstraints = {@UniqueConstraint(columnNames= {"cedula"})})
public class Presidente {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id_presidente;
	
		
	    private int cedula;
		
		
	    private String nombres;
	    
		
	    @Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date fecha_nacimiento;
		
		
	    private int fecha_inicio;
	    private int fecha_fin;
	    
	   /* @JsonIgnore
	    @OneToMany(mappedBy= "presidente", cascade=CascadeType.ALL)
	    private Set<Ministros> ministros;*/

		public Presidente() {
			super();
		}



		public Presidente(int id_presidente, @NotNull int cedula, @NotEmpty String nombres, @Past Date fecha_nacimiento,
				@NotNull int fecha_inicio, int fecha_fin) { //Set<Ministros> ministros
			super();
			this.id_presidente = id_presidente;
			this.cedula = cedula;
			this.nombres = nombres;
			this.fecha_nacimiento = fecha_nacimiento;
			this.fecha_inicio = fecha_inicio;
			this.fecha_fin = fecha_fin;
			
		}
		
		
		
		



		public Presidente(String nombres) {
			super();
			this.nombres = nombres;
		}



		public Presidente(int cedula, String nombres, int fecha_inicio, int fecha_fin
				) { 
			super();
			this.cedula = cedula;
			this.nombres = nombres;
			this.fecha_inicio = fecha_inicio;
			this.fecha_fin = fecha_fin;
			
		}



		public int getId_presidente() {
			return id_presidente;
		}


		public void setId_presidente(int id_presidente) {
			this.id_presidente = id_presidente;
		}


		public int getCedula() {
			return cedula;
		}


		public void setCedula(int cedula) {
			this.cedula = cedula;
		}


		public String getNombres() {
			return nombres;
		}


		public void setNombres(String nombres) {
			this.nombres = nombres;
		}



		public Date getFecha_nacimiento() {
			return fecha_nacimiento;
		}


		public void setFecha_nacimiento(Date fecha) {
			this.fecha_nacimiento = fecha;
		}


		public int getFecha_inicio() {
			return fecha_inicio;
		}


		public void setFecha_inicio(int fecha_inicio) {
			this.fecha_inicio = fecha_inicio;
		}


		public int getFecha_fin() {
			return fecha_fin;
		}


		public void setFecha_fin(int fecha_fin) {
			this.fecha_fin = fecha_fin;
		}



		/*public Set<Ministros> getMinistros() {
			return ministros;
		}



		public void setMinistros(Set<Ministros> ministros) {
			this.ministros = ministros;
		}*/






		



		/*
		public void setMinistros(Set<Ministros> ministros) {
			this.ministros = ministros;
			for(Ministros ministro: ministros) {
				ministro.setPresidente(this);
			}
		}*/
		
		


		
	    
		
		
	    
	    
	    
	    
}
