package uc.us_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uc.us_security.entity.TBL_Sesion;

public interface SesionRepository extends JpaRepository<TBL_Sesion, Integer> {

}
