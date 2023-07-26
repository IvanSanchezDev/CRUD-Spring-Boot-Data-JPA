package com.crud.ntds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.ntds.interfaces.Iministro;
import com.crud.ntds.interfacesService.IministroService;

import com.crud.ntds.modelo.Ministros;

@Service
public class ministroService implements IministroService {
	
	//HEREDAR LOS METODOS PROPIOS DE CRUDREPOSITORY
		@Autowired
		private Iministro data;

	@Override
	public List<Ministros> listar() {
		return (List<Ministros>) data.findAll();
	}

	@Override
	public Optional<Ministros> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Ministros m) {
		int res = 0;
		Ministros ministros = data.save(m);
		
		if (!ministros.equals(null)) {
			res = 1;
		}
		
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

}
