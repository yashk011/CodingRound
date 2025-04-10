package org.example.LLDQuestions.FacadePattern.example1;

public class EmployeeFacade {

    EmployeeDAO employeeDAO;

    public EmployeeFacade() {
        employeeDAO = new EmployeeDAO();
    }

    public void getEmployeeDetailsByEmail(String emailId) {
        employeeDAO.getDetailsByEmailId(emailId);
    }
}
