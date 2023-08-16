package nauka.mapy.one;

import java.util.HashMap;
import java.util.Map;

public class Company {
    private Map<String,Employee> employeeMap = new HashMap<>();

    public boolean addEmployee(Employee employee){
        String key = employee.getFirstName() + "" + employee.getLastName();
        if (employeeMap.containsKey(key)){
            return false;
        }
        employeeMap.put(key,employee);
        return true;
    }

    public Employee getEmploye(String firstName, String lastName){
        String key = firstName+ ""+ lastName;
        return employeeMap.get(key);
    }

}
