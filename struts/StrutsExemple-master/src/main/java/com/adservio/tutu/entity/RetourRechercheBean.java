package com.adservio.tutu.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public class RetourRechercheBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String erreur;
	private List<ElementCourseBean> listCourses;

	/*
	 * Constructor
	 */
	/**
	 * 
	 */
	public RetourRechercheBean() {
		super();
	}

	/**
	 * @param erreur
	 * @param listCourses
	 */
	public RetourRechercheBean(String erreur, List<ElementCourseBean> listCourses) {
		super();
		this.erreur = erreur;
		this.listCourses = listCourses;
	}

	/*
	 * Getter and setter
	 */
	/**
	 * @return the erreur
	 */
	public String getErreur() {
		return erreur;
	}

	/**
	 * @param erreur
	 *            the erreur to set
	 */
	public void setErreur(String erreur) {
		this.erreur = erreur;
	}

	/**
	 * @return the listCourses
	 */
	public List<ElementCourseBean> getListCourses() {
		return listCourses;
	}

	/**
	 * @param listCourses
	 *            the listCourses to set
	 */
	public void setListCourses(List<ElementCourseBean> listCourses) {
		this.listCourses = listCourses;
	}

}
