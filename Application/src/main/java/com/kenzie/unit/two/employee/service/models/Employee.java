package com.kenzie.unit.two.employee.service.models;

import com.kenzie.ata.ExcludeFromJacocoGeneratedReport;
import com.kenzie.unit.two.iam.models.Department;
import com.kenzie.unit.two.iam.models.User;

import java.util.Objects;
import java.util.UUID;

@ExcludeFromJacocoGeneratedReport
public class Employee extends User {
    private final UUID id;
    private final String userName;
    private final String payCheck;
    private final Department department;

    public Employee(UUID id, String userName, Department department, String payCheck) {
        super(id,userName,department);
        this.id = id;
        this.userName = userName;
        this.department = department;
        this.payCheck = payCheck;
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPayCheck() {
        return payCheck;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + id + '\'' +
                ", employeeName='" + userName + '\'' +
                '}';
    }
}
