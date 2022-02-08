package com.jdev.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jdev.dao.ActividadDAO;
import com.jdev.model.Actividad;

@RestController
@RequestMapping("actividades")
public class ActividadRest {
	
	@Autowired
	private ActividadDAO actividadDAO;
	
	//Solicitudes al Servidor
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/grabar")
	public void grabar(@RequestBody Actividad actividad) {
		// Se crea un objeto nuevo para que no tenga el id
		// Y así no se actualice otro registro
		System.out.print(actividad);
		Actividad actividadFormat = new Actividad();
		actividadFormat.setDetalle(actividad.getDetalle());
		actividadFormat.setEstado(0);
		actividadDAO.save(actividadFormat);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/listar")
	public List<Actividad> listar() {
		return actividadDAO.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		actividadDAO.deleteById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Actividad actividad) {
		actividadDAO.save(actividad);
	}
		
}
