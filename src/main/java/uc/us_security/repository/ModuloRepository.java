package uc.us_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uc.us_security.entity.TBL_Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<TBL_Modulo, Integer>{

}
