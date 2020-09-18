package com.ecodeup.api.apirest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecodeup.api.apirest.model.Estudiante;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteServices;
	
	@GetMapping("api/estudiante")
	public List<Estudiante> obtenerEstudiantes(){
		List<Estudiante> listaEstudiantes= new ArrayList<>();
		
		Estudiante e = new Estudiante();	
		e.setId(1);
		e.setNombres("Elivar");
		e.setApellidos("Largo");
		e.setEmail("elargor@gmail.com");
		//e.setNota(5D);
		
		
		Estudiante e1 = new Estudiante();
		e1.setId(1);
		e1.setNombres("Luis");
		e1.setApellidos("Paredes");
		e1.setEmail("lparedes@gmail.com");
		//e1.setNota(8D);
		
		listaEstudiantes.add(e);
		listaEstudiantes.add(e1);
		
		
		
		return listaEstudiantes;
	}
	
	@PostMapping("api/estudiantes")
	public Estudiante guardarEstudiante(@RequestBody Estudiante estudiante) {
		System.out.println(estudiante);
		estudianteServices.guardar(estudiante);
		return estudiante; 
	}
	
	@GetMapping("api/estudiantes")
	public List<Estudiante> obtener(){
		return estudianteServices.obtenerTodos();
	}
	
	@GetMapping("api/estudiantes/{id}")
	public Estudiante obtenerEstudiante(@PathVariable("id") Integer id) {
		return estudianteServices.obtenerEstudiante(id);
	}
	
	@PutMapping("api/estudiantes")
	public void actualizarEstudiante(@RequestBody Estudiante estudiante) {
		estudianteServices.actualizar(estudiante);
	}
	
	@DeleteMapping("api/estudiantes/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		estudianteServices.eliminar(id);
	}
	
}
