package Employee_Importance_690;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }

    public static int getImportance(List<Employee> employees, int id) {

        Employee[] idToEmployee = new Employee[2001];
        for (int i = 0; i < employees.size(); i++) {
            idToEmployee[employees.get(i).id] = employees.get(i);
        }

        return getImportance(idToEmployee, id);
    }

    private static int getImportance(Employee[] idToEmployee, int id){

        Employee emp = idToEmployee[id];
        int imp = emp.importance;
        List<Integer> subordinates = emp.subordinates;
        for (int i = 0; i < subordinates.size(); i++) {
            imp += getImportance(idToEmployee, subordinates.get(i));
        }
        return imp;
    }


    private class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

}
