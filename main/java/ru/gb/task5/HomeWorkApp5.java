package ru.gb.task5;

import java.util.ArrayList;

/**
 * 03.04.2022 22:48
 *
 * @author PetSoft
 */
public class HomeWorkApp5 {
    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5];

        employeeArray[0] = new Employee("Ivanov Ivan", "Manager", "ivanov@gmail.com", "89132456575", 75000, 35);
        employeeArray[1] = new Employee("Petrov Ptr", "Engineer", "petrov@gmail.com", "89132466570", 70000, 42);
        employeeArray[2] = new Employee("Sidorov Artur", "Marketer", "sidorov@gmail.com", "89132456075", 72000, 27);
        employeeArray[3] = new Employee("Pavlov Pavel", "Driver", "pavlov@gmail.com", "89139308607", 50000, 40);
        employeeArray[4] = new Employee("Sergeev Sergey", "Logistician", "sergeev@gmail.com", "89138651987", 75000, 46);

        for (Employee employee : employeeArray) {
            System.out.print(employee.getAge() > 40 ? employee + "\n" : "");
        }
    }
}
