package com.crud.ntds.interfacesService;

import java.util.List;
import java.util.Optional;

import com.crud.ntds.modelo.*;

public interface IpresidenteService {
	public List<Presidente>listar();//LiStaR
	public Optional<Presidente>listarId(int id); //LISTAR id
	public int save(Presidente p); //GUARDAR
	public void delete(int id); //ELIMINAR
}
