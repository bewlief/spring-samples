package com.joseoliveros.parametermap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OngetParameterMap extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        Map m = request.getParameterMap();
        Set s = m.entrySet();
        Iterator it = s.iterator();

        while (it.hasNext()) {

            Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) it.next();

            String key = entry.getKey();
            String[] value = entry.getValue();

            pw.println("Key is " + key + "<br>");

            if (value.length > 1) {
                for (int i = 0; i < value.length; i++) {
                    pw.println("<li>" + value[i].toString() + "</li><br>");
                }
            } else
                pw.println("Value is " + value[0].toString() + "<br>");

            pw.println("-------------------<br>");
        }

        pw.close();

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
