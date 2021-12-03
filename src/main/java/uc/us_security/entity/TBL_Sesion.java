package uc.us_security.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TBL_SESION")
public class TBL_Sesion implements Serializable {
	private static final long serialVersionUID = -1457358047095434317L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idsesion")
	
	private int id;
	private String ti_pregunta;
	private String valoracion;

}
