package com.inti.entities;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

//mport org.apache.tomcat.util.codec.binary.Base64;

@Entity
public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHotel;
	private String nomHotel;
	private int nbretoile;
	@Lob
	private byte[] image;
	@Transient
	private String imgUtility;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idDestination")
	private Destination destination;

	public Hotel() {

	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getNomHotel() {
		return nomHotel;
	}

	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}


	public int getNbretoile() {
		return nbretoile;
	}

	public void setNbretoile(int nbretoile) {
		this.nbretoile = nbretoile;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

		
	public String getImgUtility() throws UnsupportedEncodingException {
		byte[] encodebase64 = Base64.encodeBase64(getImage());
		String base64Encoded = new String(encodebase64, "UTF-8");
		return base64Encoded;
	}

	public void setImgUtility(String imgUtility) {
		this.imgUtility = imgUtility;
	}

	@Override
	public String toString() {
		return "Hotel [nomHotel=" + nomHotel + ", nbretoile=" + nbretoile + "]";
	}



}
