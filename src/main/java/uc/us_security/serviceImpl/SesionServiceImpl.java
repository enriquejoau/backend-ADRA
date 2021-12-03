package uc.us_security.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import uc.us_security.entity.TBL_Sesion;
import uc.us_security.repository.SesionRepository;
import uc.us_security.service.SesionService;

public class SesionServiceImpl implements SesionService {
	@Autowired
	private SesionRepository sesionRepository;

	@Override
	public List<TBL_Sesion> readAll() {
		// TODO Auto-generated method stub
		return sesionRepository.findAll();
	}

	@Override
	public TBL_Sesion create(TBL_Sesion sesion) {
		// TODO Auto-generated method stub
		return sesionRepository.save(sesion);
	}

	@Override
	public TBL_Sesion update(TBL_Sesion sesion) {
		// TODO Auto-generated method stub
		return sesionRepository.save(sesion);
	}

	@Override
	public TBL_Sesion read(int id) {
		// TODO Auto-generated method stub
		return sesionRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sesionRepository.deleteById(id);
	}
}
