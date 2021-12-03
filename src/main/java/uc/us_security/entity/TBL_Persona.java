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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name="TBL_PERSONA")
public class TBL_Persona implements Serializable {
	
	private static final long serialVersionUID = -1457358047095434317L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpersona")
	private int id;
	private String no_persona;
	private String ap_paterno;
	private String ap_materno;
	private String no_correo;
	private int nu_telefono;


}
