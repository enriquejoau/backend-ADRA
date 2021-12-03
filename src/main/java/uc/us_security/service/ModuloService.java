package uc.us_security.service;

import java.util.List;

import uc.us_security.entity.TBL_Modulo;

public interface ModuloService {
	List<TBL_Modulo> readAll();
	TBL_Modulo create(TBL_Modulo modulo);
	TBL_Modulo update(TBL_Modulo modulo);
	TBL_Modulo read(int id);
	void delete(int id);
}
