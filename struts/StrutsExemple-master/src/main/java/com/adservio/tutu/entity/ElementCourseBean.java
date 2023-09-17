package com.adservio.tutu.entity;

import java.io.Serializable;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public class ElementCourseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String libelle;
	private Integer quantite;

	/*
	 * Constructor
	 */
	/**
	 * 
	 */
	public ElementCourseBean() {
		super();
	}

	/**
	 * @param libelle
	 * @param quantite
	 */
	public ElementCourseBean(String libelle, Integer quantite) {
		super();
		this.libelle = libelle;
		this.quantite = quantite;
	}

	/*
	 * Getter and setter
	 */

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the quantite
	 */
	public Integer getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite
	 *            the quantite to set
	 */
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

}
