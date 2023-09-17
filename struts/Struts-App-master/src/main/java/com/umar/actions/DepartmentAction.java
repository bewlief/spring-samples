package com.umar.actions;

import com.umar.actionforms.DepartmentForm;
import com.umar.model.Employee;
import com.umar.service.EmployeeService;
import com.umar.service.EmployeeServiceImpl;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DepartmentAction extends Action {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        String query = request.getQueryString();
        if(null != query && query.equals("LOAD")) {
            forward = loadEmployees(mapping, form, request, response);
        }

        return forward;
    }

    private ActionForward loadEmployees(ActionMapping mapping,
                                        ActionForm form,
                                        HttpServletRequest request,
                                        HttpServletResponse response) throws Exception {
        List<Employee> employees = employeeService.findAll();
        DepartmentForm departmentForm = (DepartmentForm) form;
        departmentForm.setEmployees(employees);
        return mapping.findForward("loaded");
    }
}
