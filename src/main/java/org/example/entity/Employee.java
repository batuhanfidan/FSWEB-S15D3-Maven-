package org.example.entity;

import java.util.Objects;

public class Employee {
    private int id;
    private String firstname;
    private String lastname;

    public Employee(int id, String name, String surname) {
        this.id = id;
        this.firstname = name;
        this.lastname = surname;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(firstname, employee.firstname) &&
                Objects.equals(lastname, employee.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }

}
