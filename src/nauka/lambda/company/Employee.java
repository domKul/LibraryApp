package nauka.lambda.company;

class Employee {
    private String firstName;
    private String lastName;
    private double salary;
    private Employment employment;

    public Employee(String firstName, String lastName, double salary, Employment employment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.employment = employment;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employment getEmployment() {
        return employment;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

     static boolean isFullTimeEmployee(Employee employee){
        return employee.getEmployment() == Employment.FULL_TIME;
    }
    static void salaryUp(Employee employee){
        employee.setSalary(employee.getSalary() * 1.1);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", employment=" + employment +
                '}';
    }
}