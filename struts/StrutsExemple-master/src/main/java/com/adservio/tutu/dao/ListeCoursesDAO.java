package com.adservio.tutu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.adservio.tutu.entity.ElementCourseBean;
import com.adservio.tutu.entity.RetourRechercheBean;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public class ListeCoursesDAO {

	private static final String NOM_RESOURCE_JDBC = "java:comp/env/jdbc/dsMonApplication";

	/**
	 * 
	 */
	public ListeCoursesDAO() {
	}

	/**
	 * 
	 * @return
	 */
	public RetourRechercheBean rechercherElementsCourses() {
		final RetourRechercheBean lRetourRechercher = new RetourRechercheBean();
		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(NOM_RESOURCE_JDBC);
			final List<ElementCourseBean> lListeCourses = new LinkedList<ElementCourseBean>();
			final Connection lConnection = lDataSource.getConnection();
			final Statement lStatement = lConnection.createStatement();
			final ResultSet lResultSet = lStatement.executeQuery("SELECT * FROM LISTECOURSES");
			while (lResultSet.next()) {
				final ElementCourseBean lElementCourse = new ElementCourseBean();
				final Long lIdObjet = lResultSet.getLong("ID");
				final String lLibelle = lResultSet.getString("LIBELLE");
				final Integer lQuantite = lResultSet.getInt("QUANTITE");
				lElementCourse.setId(lIdObjet);
				lElementCourse.setQuantite(lQuantite);
				lElementCourse.setLibelle(lLibelle);
				lListeCourses.add(lElementCourse);
			}
			lRetourRechercher.setListCourses(lListeCourses);
		} catch (NamingException e) {
			// Trace l'erreur dans la log du serveur e.printStackTrace();
			// Stocke l'erreur dans le retour
			lRetourRechercher.setErreur("NamingException : " + e.getMessage());
		} catch (SQLException e) {
			// Trace l'erreur dans la log du serveur e.printStackTrace();
			// Stocke l'erreur dans le retour
			lRetourRechercher.setErreur("SQLException : " + e.getMessage());
		}
		return lRetourRechercher;
	}

	/**
	 * * Crée un nouvel élément dans la liste des courses * @param pLibelle
	 * Libellé du nouvel élément
	 * 
	 * @param pQuantite
	 *            Quantité du nouvel élément * @return Erreur s'il y a lieu
	 */
	public String creerElementCourse(final String pLibelle, final Integer pQuantite) {
		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(NOM_RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			// Insertion du nouvel enregistrement

			final PreparedStatement lPreparedStatementCreation = lConnection
					.prepareStatement("INSERT INTO LISTECOURSES(LIBELLE, QUANTITE) VALUES(?, ?)");
			lPreparedStatementCreation.setString(1, pLibelle);
			lPreparedStatementCreation.setInt(2, pQuantite);
			lPreparedStatementCreation.executeUpdate();
			return null;
		} catch (NamingException e) {
			return "NamingException : " + e.getMessage();
		} catch (SQLException e) {
			return "SQLException : " + e.getMessage();
		}
	}

	/**
	 * * Supprime un nouvel élément dans la liste des courses * @param pIdObjet
	 * Identifiant de l'élément * @return Erreur s'il y a lieu
	 */
	public String supprimerElementCourse(final Long pIdObjet) {
		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(NOM_RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			// Insertion du nouvel enregistrement
			final PreparedStatement lPreparedStatementCreation = lConnection
					.prepareStatement("DELETE FROM LISTECOURSES WHERE IDOBJET = ?");
			lPreparedStatementCreation.setLong(1, pIdObjet);
			lPreparedStatementCreation.executeUpdate();
			return null;
		} catch (NamingException e) {
			return "NamingException : " + e.getMessage();
		} catch (SQLException e) {
			return "SQLException : " + e.getMessage();
		}
	}

}
