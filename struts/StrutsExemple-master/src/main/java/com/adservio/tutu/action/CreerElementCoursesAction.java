package com.adservio.tutu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.DynaValidatorForm;

import com.adservio.tutu.dao.ListeCoursesDAO;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public class CreerElementCoursesAction extends Action {

	/*
	 * Constructor
	 */
	public CreerElementCoursesAction() {
	}

	/**
	 * override execute method
	 */
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequete,
			final HttpServletResponse pReponse) {
			// Récupère les informations du formulaire
			final DynaValidatorForm lForm = (DynaValidatorForm) pForm;
			final String lLibelle = lForm.getString("libelle");
			System.err.println("Quantite : :::::::::::::::::>  " + lForm.getString("quantite"));
			System.err
					.println("Quantite INTEGER : :::::::::::::::::>  " + Integer.valueOf(lForm.getString("quantite")));
			final Integer lQuantite = Integer.valueOf(lForm.getString("quantite"));
			// Création en base du nouvel enregistrement
			final ListeCoursesDAO lListeCoursesDAO = new ListeCoursesDAO();
			final String lErreur = lListeCoursesDAO.creerElementCourse(lLibelle, lQuantite);
			if (lErreur == null) {
				// S'il n'y a pas d'erreurs, on retourne le forward "succes"
				return pMapping.findForward("succes");
			} else {
				final ActionMessages lErreurs = getErrors(pRequete);
				final ActionMessage lActionMessage = new ActionMessage(lErreur, false);
				lErreurs.add(Globals.ERROR_KEY, lActionMessage);
				saveErrors(pRequete, lErreurs);
				// S'il y a des erreurs, on retourne le forward "erreur"
				return pMapping.findForward("erreur");
			}

	}
}
