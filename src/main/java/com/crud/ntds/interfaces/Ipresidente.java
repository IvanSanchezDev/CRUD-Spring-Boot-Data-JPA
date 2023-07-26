package com.crud.ntds.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.ntds.modelo.Presidente;

@Repository
public interface Ipresidente extends CrudRepository<Presidente, Integer> {

	Presidente findByNombres(String nombres);

}
