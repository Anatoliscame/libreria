package com.example.libreria.Enity;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.example.libreria.DTO.Autore_DTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@NamedQueries({@NamedQuery(name = "cognomeAutore",query="SELECT a FROM Autore a WHERE a.cognome = :cognome")})

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property ="id")

@Getter
@Setter 
//@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode

public class Autore  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column(name="nome")
	private String nome;
	@Column(name="cognome")
	private String cognome;
	@Column(name="tipo_autore")
	private String tipo_autore;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	//@Column(name="date")
	//private Date date;

	
	
	
	@OneToMany(mappedBy="autore")
	private Set<Libro> libri;
	

	public Autore(Autore_DTO dto) {
		this.id=dto.getId_dto();
		this.nome=dto.getNome();
		this.cognome=dto.getCognome();
		this.tipo_autore=dto.getTipo_autore();
		//this.date=dto.getDate();
		this.libri = new HashSet<>();
		this.libri=dto.getLibri();

	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
    public String toString() {
        return "Autore id: " + id + 
               ", nome: " + nome +
               ", cognome: " + cognome +
               ", tipo_autore: " +tipo_autore;
    }
}
