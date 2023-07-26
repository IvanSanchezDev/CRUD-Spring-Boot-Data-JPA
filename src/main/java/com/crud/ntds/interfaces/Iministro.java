package com.crud.ntds.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.ntds.modelo.Ministros;


@Repository
public interface Iministro extends CrudRepository<Ministros, Integer>  {

	Ministros findByTitular(String titular);
}
