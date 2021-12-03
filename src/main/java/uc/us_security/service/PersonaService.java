package uc.us_security.service;

import java.util.List;

import uc.us_security.entity.TBL_Persona;

public interface PersonaService {
	List<TBL_Persona> readAll();
	TBL_Persona create(TBL_Persona persona);
	TBL_Persona update(TBL_Persona persona);
	TBL_Persona read(int id);
	void delete(int id);
}
