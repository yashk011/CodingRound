package org.example.designPattern.ProxyDesignPattern;

public class ProxyDesignDemo {
    public static void main(String[] args) {
        IEmployee employeService = new EmployeeServiceProxy();

        employeService.createEmployee("ADMIN" , new Employee("123","Yash"));
        employeService.getEmployee("USER", 123);
    }
}
