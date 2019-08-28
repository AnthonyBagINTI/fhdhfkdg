package com.inti.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Avis implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAvis;
	@Temporal(TemporalType.DATE)
	private Date datePublication;
	private String commentaire;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idVoyageur")
	private Voyageur voyageur;
	public Avis() {
		
	}
	public Long getIdAvis() {
		return idAvis;
	}
	public void setIdAvis(Long idAvis) {
		this.idAvis = idAvis;
	}
	public Date getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Voyageur getVoyageur() {
		return voyageur;
	}
	public void setVoyageur(Voyageur voyageur) {
		this.voyageur = voyageur;
	}
	@Override
	public String toString() {
		return "Avis [datePublication=" + datePublication + ", commentaire=" + commentaire + ", voyageur=" + voyageur
				+ "]";
	}
	
	
}
