package com.crud.ntds;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


import com.crud.ntds.interfaces.Iministro;

import com.crud.ntds.modelo.Ministros;
import com.crud.ntds.modelo.Presidente;



@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class MinistroTest {
	@Autowired
	private Iministro repositorioMinistro;
	
	@Autowired 
	private TestEntityManager entityManager;
	
	
	@Test
	@Rollback(false)
	public void testAgregarMinistro() throws ParseException {
		Date fecha;
		Presidente presidentePrueba=entityManager.find(Presidente.class, 2);
		System.out.println("PRUEBABAB" + presidentePrueba);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		
		fecha = formato.parse("23/11/2015");
		
	
		Ministros ministros=new Ministros();
		ministros.setCargo("Ministro de Salud");
		ministros.setPartido_politico("Partido Amarillo");
		ministros.setTitular("Rodirgo Cadena");
		ministros.setFecha_inicio(fecha);
		ministros.setPresidente(presidentePrueba);
		
		repositorioMinistro.save(ministros);
		
		
	}
	
	@Test
	@Rollback(false)
	public void testActualizarMinistro() {
		String nombreMinistro="Egner Eliecer";
		Presidente presidentePrueba=entityManager.find(Presidente.class, 2);
		Ministros ministro1=new Ministros("Ministro de Salud",nombreMinistro, "Partido Amarillo", presidentePrueba);
		ministro1.setId(9);
		
		repositorioMinistro.save(ministro1);
		
		Ministros ministroActualizado = repositorioMinistro.findByTitular(nombreMinistro);
		assertThat(ministroActualizado.getTitular().equals(nombreMinistro));
		
	}
	
	@Test
	@Rollback(false)
	public void testEliminarMinistro() {
		Integer id=9;
		
		boolean existeAntesDeEliminar=repositorioMinistro.findById(id).isPresent();
		
		repositorioMinistro.deleteById(id);
		
		boolean existeDespuesDeEliminar=repositorioMinistro.findById(id).isPresent();
		
		assertTrue(existeAntesDeEliminar);
		assertFalse(existeDespuesDeEliminar);
		
	}
}
