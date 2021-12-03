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

import uc.us_security.entity.TBL_Sesion;
import uc.us_security.service.SesionService;

@RestController
@RequestMapping("/api/sesion")
public class SesionController {
	@Autowired
	private SesionService sesionService;
	
	@GetMapping("/all")
	public ResponseEntity<List<TBL_Sesion>> getTBL_Sesion(){
		try {
			List<TBL_Sesion> lista = new ArrayList<>();
			lista = sesionService.readAll();
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
	public ResponseEntity<TBL_Sesion> save(@Validated @RequestBody TBL_Sesion persona){
		try {
			TBL_Sesion ses = sesionService.create(persona);
			return new ResponseEntity<>(ses, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<TBL_Sesion> getTBL_Persona(@PathVariable("id") int id){
		TBL_Sesion sesi = sesionService.read(id);
			if(sesi.getId()>0) {
				return new ResponseEntity<>(sesi, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			sesionService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<TBL_Sesion> update(@RequestBody TBL_Sesion sesi, @PathVariable("id") int id){
		try {
			TBL_Sesion sesio = sesionService.read(id);
			if(sesio.getId()>0) {
				sesio.setti_pregunta(sesi.getti_pregunta());
				sesio.setvaloracion(sesi.getvaloracion());
				return new ResponseEntity<>(sesionService.create(sesio),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
