package uc.us_security.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import uc.us_security.entity.TBL_Persona;
import uc.us_security.repository.PersonaRepository;
import uc.us_security.service.PersonaService;

public class PersonaServiceImpl implements PersonaService{
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public List<TBL_Persona> readAll() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}

	@Override
	public TBL_Persona create(TBL_Persona persona) {
		// TODO Auto-generated method stub
		return personaRepository.save(persona);
	}

	@Override
	public TBL_Persona update(TBL_Persona persona) {
		// TODO Auto-generated method stub
		return personaRepository.save(persona);
	}

	@Override
	public TBL_Persona read(int id) {
		// TODO Auto-generated method stub
		return personaRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		personaRepository.deleteById(id);
	}
}
