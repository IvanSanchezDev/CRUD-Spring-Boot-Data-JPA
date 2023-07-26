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


import com.crud.ntds.interfacesService.IleyService;
import com.crud.ntds.interfacesService.IpresidenteService;
import com.crud.ntds.modelo.Leyes;
import com.crud.ntds.modelo.Presidente;


@Controller
@RequestMapping
public class controladorLey {

	
	@Autowired
	private IleyService service;
	
	@Autowired
	private IpresidenteService servicePresidente;
	
	@GetMapping("/listarLeyes")
	public String listar(Model model) {
		// LISTA DEL OBEJTO PERSONAS LA LISTA SE LLAMA "PERSONAS"
		List<Leyes> ListaLeyes = service.listar();
		// ENVIAMOS A LA BASE DE DATOS LA LISTA PERSONAS QUE VIENE DE PERSONAS
		model.addAttribute("leyes",ListaLeyes);
		model.addAttribute("titulo", "Listar Leyes");
		return "leyes/listarLey";
	}
	
	@GetMapping("/newLey")
	public String agregar(Model model) {
		
		List<Presidente> presidente =  servicePresidente.listar();
		model.addAttribute("presidente", presidente);
		
		model.addAttribute("leyes", new Leyes());
		return "leyes/crearLey";
	}

	@PostMapping("/guardarLey")
	public String save(@Valid Leyes l, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "agregar ley");
			return "leyes/crearLey";
		}
		// GUARDA EN LA BASE DE DATOS
		service.save(l);
		// REDIRECCION A LISTAR
		return "redirect:/listarLeyes";
	}
	
	
	@GetMapping("/editarLey/{id}")
	public String editar(@PathVariable int id, Model model) {
		
		Optional<Leyes> leyes = service.listarId(id);
		model.addAttribute("leyes", leyes);
		
		List<Presidente> presidente =  servicePresidente.listar();
		model.addAttribute("presidente", presidente);
		
		model.addAttribute("titulo", "Editar Ley");
		
		return "leyes/crearLey";
	}

	// LA RUTA Y DEBE CONTENER UN PARAMETRO
	@GetMapping("/eliminarLey/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listarLeyes";
	}
	
}
