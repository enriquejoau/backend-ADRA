package uc.us_security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import uc.us_security.entity.TBL_Persona;
import uc.us_security.service.PersonaService;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/all")
	public ResponseEntity<List<TBL_Persona>> getTBL_Persona(){
		try {
			List<TBL_Persona> lista = new ArrayList<>();
			lista = personaService.readAll();
			if(lista.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(lista, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/create")
	public ResponseEntity<TBL_Persona> save(@Validated @RequestBody TBL_Persona persona){
		try {
			TBL_Persona per = personaService.create(persona);
			return new ResponseEntity<>(per, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<TBL_Persona> getTBL_Persona(@PathVariable("id") int id){
		TBL_Persona pers = personaService.read(id);
			if(pers.getId()>0) {
				return new ResponseEntity<>(pers, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			personaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<TBL_Persona> update(@RequestBody TBL_Persona pers, @PathVariable("id") int id){
		try {
			TBL_Persona perso = personaService.read(id);
			if(perso.getId()>0) {
				perso.setno_persona(pers.getno_persona());
				perso.setape_paterno(pers.getape_paterno());
				perso.setape_materno(pers.getape_materno());
				perso.setno_correo(pers.getno_correo());
				perso.setnu_telefono(pers.getni_telefono());
				return new ResponseEntity<>(personaService.create(pers),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
