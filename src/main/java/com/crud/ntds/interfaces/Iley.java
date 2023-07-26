package com.crud.ntds.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.crud.ntds.modelo.Leyes;


@Repository
public interface Iley extends JpaRepository<Leyes, Integer> {

	Leyes findByNombre(String nombre);
}
