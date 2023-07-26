package com.crud.ntds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.crud.ntds.interfaces.Iley;
import com.crud.ntds.interfacesService.IleyService;
import com.crud.ntds.modelo.Leyes;

@Service
public class leyService implements IleyService {
	
	//HEREDAR LOS METODOS PROPIOS DE CRUDREPOSITORY
	@Autowired
	private Iley data;

	@Override
	public List<Leyes> listar() {
		// TODO Auto-generated method stub
		return (List<Leyes>) data.findAll();
	}

	@Override
	public Optional<Leyes> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Leyes l) {
		int res = 0;
		Leyes leyes = data.save(l);
		
		if (!leyes.equals(null)) {
			res = 1;
		}
		
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

}
