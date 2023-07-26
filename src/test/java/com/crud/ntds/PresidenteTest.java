package com.crud.ntds;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.crud.ntds.interfaces.Ipresidente;
import com.crud.ntds.modelo.Presidente;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class PresidenteTest {
	
	
	@Autowired
	private Ipresidente repositorioPresidente;
	
	@Test
	@Rollback(false)
	public void testAgregarPresidente() {
		//CREAMOS UN NUEVO PRESIDENTE
		Presidente presidente=new Presidente();
		presidente.setNombres("Juan Manuel Santos");
		presidente.setCedula(91548672);
		presidente.setFecha_inicio(2010);
		presidente.setFecha_fin(2014);
		
		//LLAMAMOS EL METODO GUARDAR DEL REPOSITIORIO
		Presidente presidenteGuardado=repositorioPresidente.save(presidente);
		
		assertNotNull(presidenteGuardado);
	}
	
	@Test
	@Rollback(false)
	public void testActualizarPresidente() {
		
		String nombrePresidente="Ivan Duque"; //CREAMOS EL CAMPO A ACTUALIZAR	
		Presidente presidente=new Presidente(91548672, nombrePresidente,2018,2022); //PASAMOS LOS DATOS CORRESPONDIENTES EN EL CONSTURCTOR		
		presidente.setId_presidente(21);//LE ESPECIFICAMOS EL ID	
		repositorioPresidente.save(presidente);//LLAMOS EL METODO
		
		Presidente presidenteActualizado = repositorioPresidente.findByNombres(nombrePresidente);//GUARDAMOS EN UN CAMPO EL PRESIDENTE CON EL NUEVO CAMPO
		
		//EXTRAEMOS DEL PRESIDENTE ACTUALIZADO EL NOMBRE Y LO COMPARAMOS CON EL CAMPO QUE ACTUALIZAMOS PARA VERIFICAR
		//QUE SEA VERDADERO
		assertThat(presidenteActualizado.getNombres().equals(nombrePresidente));
		
	}
	
	@Test
	@Rollback(false)
	public void testEliminarPresidente() {
		//ESPECIFICAMOS EL ID A ELIMINAR
		Integer id=21;
		
		//VERIFICAR SI ESTA PRESENTE UN PRESIDENTE CON ESE ID
		boolean existeAntesDeEliminar=repositorioPresidente.findById(id).isPresent();
		
		//SI ESTA PRESENTE LO ELIMINAMOS
		repositorioPresidente.deleteById(id);
		
		//VERIFICAMOS QUE YA NO EXISTA
		boolean existeDespuesDeEliminar=repositorioPresidente.findById(id).isPresent();
		
		assertTrue(existeAntesDeEliminar);// OBRTENER UN TRUE SI EXISTIA ANTES DE ELIMINAR
		assertFalse(existeDespuesDeEliminar);//OBTENER UN FALSE SI NO EXISTE DESPUES DE ELIMINAR
		
	}
	
	

}
