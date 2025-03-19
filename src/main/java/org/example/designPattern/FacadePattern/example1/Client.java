package org.example.designPattern.FacadePattern.example1;

public class Client {
    public static void main(String[] args) {
        EmployeeFacade employeeFacade = new EmployeeFacade();
        employeeFacade.getEmployeeDetailsByEmail("test@test.com");
    }
}
