package com.crud.ntds.interfacesService;

import java.util.List;
import java.util.Optional;

import com.crud.ntds.modelo.Leyes;



public interface IleyService {
	public List<Leyes>listar();//LiStaR
	public Optional<Leyes>listarId(int id); //LISTAR id
	public int save(Leyes l); //GUARDAR
	public void delete(int id); //ELIMINAR
}
