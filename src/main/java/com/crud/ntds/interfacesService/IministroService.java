package com.crud.ntds.interfacesService;

import java.util.List;
import java.util.Optional;

import com.crud.ntds.modelo.*;

public interface IministroService {

	public List<Ministros>listar();//LiStaR
	public Optional<Ministros>listarId(int id); //LISTAR id
	public int save(Ministros m); //GUARDAR
	public void delete(int id); //ELIMINAR
}
