package com.crud.ntds.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.crud.ntds.interfacesService.IministroService;
import com.crud.ntds.interfacesService.IpresidenteService;
//import com.crud.ntds.interfacesService.IpresidenteService;
import com.crud.ntds.modelo.*;

@Controller
@RequestMapping
public class controladorMinistro {
	
	@Autowired
	private IministroService service;
	
	
	@Autowired
	private IpresidenteService servicePresidente;
	
	
	@GetMapping("/listarMinistros")
	public String listar(Model model) {
		
		// LISTA DEL OBEJTO PERSONAS LA LISTA SE LLAMA "PERSONAS"
		List<Ministros> ListaMinistros = service.listar();
		// ENVIAMOS A LA BASE DE DATOS LA LISTA PERSONAS QUE VIENE DE PERSONAS
		model.addAttribute("ministros",ListaMinistros);
		model.addAttribute("titulo", "Listar Ministros");
		
		return "ministros/ListarMinistro";
	}
	
	@GetMapping("/newMinistro")
	public String agregar(Model model) {
		
		List<Presidente> presidente =  servicePresidente.listar();
		
			
		model.addAttribute("ministros", new Ministros());
		model.addAttribute("presidente", presidente);
		
		return "ministros/agregarMinistro";
	}
	
	@PostMapping("/guardarMinistro")
	public String save(@Valid Ministros m, BindingResult result, Model model) {
		
		
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "agregar ministro");
			return "ministros/agregarMinistro";
		}
		// GUARDA EN LA BASE DE DATOS
		
		service.save(m);
		// REDIRECCION A LISTAR
		return "redirect:/listarMinistros";
	}
	
	@GetMapping("/editarMinistro/{id}")
	public String editar(@PathVariable int id, Model model) {
		
		Optional<Ministros> ministros = service.listarId(id);
		model.addAttribute("ministros", ministros);
		
		List<Presidente> presidente =  servicePresidente.listar();
		model.addAttribute("presidente", presidente);
		
		model.addAttribute("titulo", "Editar Ministro");
		
		return "ministros/agregarMinistro";
	}

	// LA RUTA Y DEBE CONTENER UN PARAMETRO
	@GetMapping("/eliminarMinistro/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listarMinistros";
	}
	
	
}
