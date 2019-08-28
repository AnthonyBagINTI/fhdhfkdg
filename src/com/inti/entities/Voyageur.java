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
public class Voyageur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idVoyageur;
	private String nomVoyageur;
	private String prenomVoyageur;
	
	@OneToMany(mappedBy = "voyageur")
	private Set<Reservation> listReservation = new HashSet<Reservation>();
	
	@OneToMany(mappedBy = "voyageur")
	private Set<Avis> listAvis = new HashSet<Avis>();

	public Voyageur() {
		
	}

	public Long getIdVoyageur() {
		return idVoyageur;
	}

	public void setIdVoyageur(Long idVoyageur) {
		this.idVoyageur = idVoyageur;
	}

	public String getNomVoyageur() {
		return nomVoyageur;
	}

	public void setNomVoyageur(String nomVoyageur) {
		this.nomVoyageur = nomVoyageur;
	}

	public String getPrenomVoyageur() {
		return prenomVoyageur;
	}

	public void setPrenomVoyageur(String prenomVoyageur) {
		this.prenomVoyageur = prenomVoyageur;
	}

	public Set<Reservation> getListReservation() {
		return listReservation;
	}

	public void setListReservation(Set<Reservation> listReservation) {
		this.listReservation = listReservation;
	}

	public Set<Avis> getListAvis() {
		return listAvis;
	}

	public void setListAvis(Set<Avis> listAvis) {
		this.listAvis = listAvis;
	}

	@Override
	public String toString() {
		return "Voyageur [nomVoyageur=" + nomVoyageur + ", prenomVoyageur=" + prenomVoyageur + "]";
	}
	
	
	
}
