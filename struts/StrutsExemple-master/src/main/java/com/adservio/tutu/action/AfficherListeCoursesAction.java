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

import com.adservio.tutu.dao.ListeCoursesDAO;
import com.adservio.tutu.entity.RetourRechercheBean;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public class AfficherListeCoursesAction extends Action {

	/**
	 * 
	 */
	public AfficherListeCoursesAction() {
	}

	/**
	 * Override execute method
	 */
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequete,
			final HttpServletResponse pReponse) {
		// Récupère les informations dans la base
		final ListeCoursesDAO lListeCoursesDAO = new ListeCoursesDAO();
		final RetourRechercheBean lRetourRechercher = lListeCoursesDAO.rechercherElementsCourses();
		if (lRetourRechercher.getErreur() == null) {
			// Stocke les informations dans la requête
			pRequete.setAttribute("LISTE_COURSES", lRetourRechercher.getListCourses());
			// S'il n'y a pas d'erreurs, on retourne le forward "succes"
			return pMapping.findForward("succes");
		} else {
			final ActionMessages lErreurs = getErrors(pRequete);
			final ActionMessage lActionMessage = new ActionMessage(lRetourRechercher.getErreur(), false);
			lErreurs.add(Globals.ERROR_KEY, lActionMessage);
			saveErrors(pRequete, lErreurs);
			// S'il y a des erreurs, on retourne le forward "erreur"
			return pMapping.findForward("erreur");
		}
	}
}
