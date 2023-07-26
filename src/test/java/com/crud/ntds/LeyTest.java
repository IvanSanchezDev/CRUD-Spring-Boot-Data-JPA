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

import com.crud.ntds.interfaces.Iley;

import com.crud.ntds.modelo.Leyes;

import com.crud.ntds.modelo.Presidente;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class LeyTest {
	@Autowired
	private Iley repositorioley;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	@Rollback(false)
	public void testAgregarLey() throws ParseException {

	
		Date fecha_ley;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		fecha_ley = formato.parse("23/11/2015");	//CREAMOS LA LEY

		//USAMOS ENTITY MANAGER PARA EXTRAER EL PRESIDENTE DEL ID QUE LE ESPECIFICAMOS EN ESTE CAS0 2
		Presidente p = entityManager.find(Presidente.class, 2);
		
		Leyes ley = new Leyes("Reforma PRUEBAXD", "Impuesto a todos los productos", fecha_ley);//LLENAMOS LA NUEVA LEY CON LOS DATOS DEL CONSTRUCTOR
		
		//CREAMOS UN METODO EN LA CLASE LEY YA QUE ES DE TIPO SET Y LE ENVIAMOS EL ID PARA RELACIONAR
		ley.añadirPresidente(p);
		
		//CREAMOS LA LEY
		repositorioley.save(ley);

	}
	
	
	@Test
	@Rollback(false)
	public void testActualizarLey() throws ParseException {
		Date fecha_ley;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		fecha_ley = formato.parse("23/11/2018");
		
		String nombreLey="REFORMA TRIBUTARIA DE PRUEBA";
		Presidente presidentePrueba=entityManager.find(Presidente.class, 2);
		Leyes ley1=new Leyes(nombreLey,"Impuesto a todos los productos",  fecha_ley);
		
		
		ley1.añadirPresidente(presidentePrueba);
		
		ley1.setId(2);
		
		repositorioley.save(ley1);
		
		Leyes leyActualizada = repositorioley.findByNombre(nombreLey);
		assertThat(leyActualizada.getNombre().equals(nombreLey));
		
	}
	
	
	@Test
	public void testEliminarLey() {
		Integer id=2;
		
		boolean existeAntesDeEliminar=repositorioley.findById(id).isPresent();
		
		repositorioley.deleteById(id);
		
		boolean existeDespuesDeEliminar=repositorioley.findById(id).isPresent();
		
		assertTrue(existeAntesDeEliminar);
		assertFalse(existeDespuesDeEliminar);
	
	}
}
