package nauka.mapy.one;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private double salare;

    public Employee(String firstName, String lastName, double salare) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salare = salare;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalare() {
        return salare;
    }

    public void setSalare(double salare) {
        this.salare = salare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salare, salare) == 0 && Objects.equals(firstName, employee.firstName)
                && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salare);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salare=" + salare +
                '}';
    }
}
