package org.example.LLDQuestions.ProxyDesignPattern;

public class EmployeeService implements IEmployee{
    @Override
    public void createEmployee(String client, Employee employee) {
        System.out.println("Creating Employee " + employee.id);
    }

    @Override
    public void getEmployee(String client, int id) {
        System.out.println("Getting Employee Details for " + id );
    }
}
