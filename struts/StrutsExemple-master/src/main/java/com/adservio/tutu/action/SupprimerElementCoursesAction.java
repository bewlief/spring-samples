package com.adservio.tutu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
/**
 * 
 * @author Skander.Bachouche
 *
 */
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
public class SupprimerElementCoursesAction extends Action {

	/**
	 * 
	 */
	public SupprimerElementCoursesAction() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.
	 * ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		// Récupère l'identifiant de l'élément dans le formulaire
		final DynaValidatorForm lForm = (DynaValidatorForm) form;
		final Long lIdObjet = new Long(lForm.getString("idobjet"));
		// Suppression en base de l'enregistrement
		final ListeCoursesDAO lListeCoursesDAO = new ListeCoursesDAO();
		final String lErreur = lListeCoursesDAO.supprimerElementCourse(lIdObjet);
		if (lErreur == null) {
			// S'il n'y a pas d'erreurs, on retourne le forward "succes"
			return mapping.findForward("succes");
		} else {
			final ActionMessages lErreurs = getErrors(request);
			final ActionMessage lActionMessage = new ActionMessage(lErreur, false);
			lErreurs.add(Globals.ERROR_KEY, lActionMessage);
			saveErrors(request, lErreurs);
		}
		// S'il y a des erreurs, on retourne le forward "erreur"
		return mapping.findForward("erreur");
	}
}
