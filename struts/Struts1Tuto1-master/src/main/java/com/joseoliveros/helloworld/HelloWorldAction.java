package com.joseoliveros.helloworld;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class HelloWorldAction extends Action {


    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        AtomicBoolean test = new AtomicBoolean();
        StringBuilder cadena = new StringBuilder("cadena");
        HelloWorldForm helloWorldForm = (HelloWorldForm) form;
        helloWorldForm.setMessage("hola mundo desde struts jsjsj");
        System.out.println("test empieza con variable de clase en: " + test);
        test.set(true);
        System.out.println("Dentro del execute hago a test: " + test);
        System.out.println("llamo a validateTest");
        validateTest(test, cadena);
        System.out.println("El valor de test es: " + test);
        System.out.println("El valor de cadena despues de validateTest: " + cadena);

        if (test.get()) {
            System.out.println("La variable no fue modificada");
        } else {
            System.out.println("la variable fue modificada");
        }

        System.out.println("-------------------------------------------------------------------------");

        ResourceBundle bundle = ResourceBundle.getBundle("Mensajes", Locale.US);
        validateTest2(bundle);

        return mapping.findForward("success");
    }

    private void validateTest(AtomicBoolean test, StringBuilder cadena) {
        System.out.println("El valor de cadena dentro de validateTest: " + cadena);
        cadena.append(" mas cadena");
        test.set(false);
    }

    private void validateTest2(ResourceBundle bundle) {
        System.out.println("desde validateTest2: " + bundle.getString("mensaje"));
    }
}
