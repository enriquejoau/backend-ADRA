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

import uc.us_security.entity.TBL_Modulo;
import uc.us_security.service.ModuloService;

@RestController
@RequestMapping("/api/modulos")
public class ModuloController {
	@Autowired
	private ModuloService moduloService;
	@GetMapping("/all")
	public ResponseEntity<List<TBL_Modulo>> getTBL_Modulo(){
		try {
			List<TBL_Modulo> lista = new ArrayList<>();
			lista = moduloService.readAll();
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
	public ResponseEntity<TBL_Modulo> save(@Validated @RequestBody TBL_Modulo modulo){
		try {
			TBL_Modulo modu = moduloService.create(modulo);  
			return new ResponseEntity<>(modu, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<TBL_Modulo> getTBL_Modulo(@PathVariable("id") int id){
		TBL_Modulo modu = moduloService.read(id);
			if(modu.getIdModulo()>0) {
				return new ResponseEntity<>(modu, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			moduloService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<TBL_Modulo> update(@RequestBody TBL_Modulo mo, @PathVariable("id") int id){
		try {
			TBL_Modulo modu = moduloService.read(id);
			if(modu.getIdModulo()>0) {
				modu.setNo_modulo(mo.getNo_modulo());
				return new ResponseEntity<>(moduloService.create(modu),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
