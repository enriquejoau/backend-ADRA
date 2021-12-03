package uc.us_security.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.us_security.entity.TBL_Modulo;
import uc.us_security.repository.ModuloRepository;
import uc.us_security.service.ModuloService;

@Service
public class ModuloServiceImpl implements ModuloService{
	@Autowired
	private ModuloRepository moduloRepository;

	@Override
	public List<TBL_Modulo> readAll() {
		// TODO Auto-generated method stub
		return moduloRepository.findAll();
	}

	@Override
	public TBL_Modulo create(TBL_Modulo modulo) {
		// TODO Auto-generated method stub
		return moduloRepository.save(modulo);
	}

	@Override
	public TBL_Modulo update(TBL_Modulo modulo) {
		// TODO Auto-generated method stub
		return moduloRepository.save(modulo);
	}

	@Override
	public TBL_Modulo read(int id) {
		// TODO Auto-generated method stub
		return moduloRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		moduloRepository.deleteById(id);
	}
	
}
