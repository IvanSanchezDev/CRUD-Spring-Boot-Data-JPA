package com.crud.ntds.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.ntds.interfacesService.IpresidenteService;
import com.crud.ntds.modelo.Presidente;

@Controller
@RequestMapping
public class ControladorPresidente {

	@Autowired
	private IpresidenteService service;

	@GetMapping("/listarPresidente")
	public String listar(Model model) {
		// LISTA DEL OBEJTO PERSONAS LA LISTA SE LLAMA "PERSONAS"
		List<Presidente> ListaPresidente = service.listar();
		// ENVIAMOS A LA BASE DE DATOS LA LISTA PERSONAS QUE VIENE DE PERSONAS
		model.addAttribute("presidente", ListaPresidente);
		return "listarPresidente";
	}

	@GetMapping("/newPresidente")
	public String agregar(Model model) {
		model.addAttribute("presidente", new Presidente());
		return "agregarPresidente";
	}

	@PostMapping("/guardarPresidente")
	public String save( Presidente p, BindingResult result, Model model) {
		
		
		
		// GUARDA EN LA BASE DE DATOS
		service.save(p);
		// REDIRECCION A LISTAR
		return "redirect:/listarPresidente";
	}

	@GetMapping("/editarPresidente/{id_presidente}")
	public String editar(@PathVariable int id_presidente, Model model) {
		Optional<Presidente> presidente = service.listarId(id_presidente);
		model.addAttribute("presidente", presidente);
		return "agregarPresidente";
	}

	// LA RUTA Y DEBE CONTENER UN PARAMETRO
	@GetMapping("/eliminarPresidente/{id_presidente}")
	public String delete(Model model, @PathVariable int id_presidente) {
		service.delete(id_presidente);
		return "redirect:/listarPresidente";
	}

	// INICIO
	@GetMapping("/inicio")
	public String inicioo(Model model) {
		model.addAttribute("titulo", "Inicio");
		return "index";
	}

}
