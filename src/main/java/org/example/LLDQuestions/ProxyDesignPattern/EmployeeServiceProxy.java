package org.example.LLDQuestions.ProxyDesignPattern;

import lombok.SneakyThrows;

public class EmployeeServiceProxy implements IEmployee{

    IEmployee employeeService = new EmployeeService();

    @Override
    @SneakyThrows
    public void createEmployee(String client, Employee employee) {
        if(client == Client.ADMIN.name())
            employeeService.createEmployee(client, employee);
        else
            throw new Exception("Not Authorized");
    }

    @Override
    public void getEmployee(String client, int id) {
        employeeService.getEmployee(client, id);
    }
}
