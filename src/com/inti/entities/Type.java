package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Type implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idType;
	private String libelle;
	@OneToMany(mappedBy = "type")
	private Set<Reservation> listReservation = new HashSet<Reservation>();
	public Type() {
		
	}
	public Long getIdType() {
		return idType;
	}
	public void setIdType(Long idType) {
		this.idType = idType;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Set<Reservation> getListReservation() {
		return listReservation;
	}
	public void setListReservation(Set<Reservation> listReservation) {
		this.listReservation = listReservation;
	}
	@Override
	public String toString() {
		return "Type [libelle=" + libelle + "]";
	}
	
	
}
