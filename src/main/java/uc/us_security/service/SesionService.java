package uc.us_security.service;

import java.util.List;

import uc.us_security.entity.TBL_Sesion;

public interface SesionService {
	List<TBL_Sesion> readAll();
	TBL_Sesion create(TBL_Sesion sesion);
	TBL_Sesion update(TBL_Sesion sesion);
	TBL_Sesion read(int id);
	void delete(int id);
}
