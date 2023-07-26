package com.crud.ntds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.ntds.interfaces.Ipresidente;
import com.crud.ntds.interfacesService.IpresidenteService;
import com.crud.ntds.modelo.Presidente;

@Service
public class preesidenteService implements IpresidenteService {

	@Autowired
	private Ipresidente data;
	
	@Override
	public List<Presidente> listar() {
		// TODO Auto-generated method stub
		return (List<Presidente>) data.findAll();
	}

	@Override
	public Optional<Presidente> listarId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int save(Presidente p) {
		int res=0;
		Presidente presidente=data.save(p);
		
		if(!presidente.equals(null)) {
			res=1;
		}
		
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

}
