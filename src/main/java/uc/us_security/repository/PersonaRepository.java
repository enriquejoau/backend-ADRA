package uc.us_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uc.us_security.entity.TBL_Persona;

public interface PersonaRepository extends JpaRepository<TBL_Persona, Integer> {

}
