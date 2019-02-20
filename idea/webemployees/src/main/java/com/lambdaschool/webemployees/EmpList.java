package com.lambdaschool.webemployees;

import java.util.ArrayList;

public class EmpList
{
    public ArrayList<Employee> empList = new ArrayList<Employee>();

    public EmpList()
    {
        empList.add(new Employee("Jane", "Doe", 45000, true, 1, 1));
        empList.add(new Employee("John", "Doe", 45000, true, 2, 1));
        empList.add(new Employee("Bonn", "W", 64000, true, 1337, 1));
    }

    public Employee findEmployee(CheckEmployee tester)
    {
        for (Employee e : empList)
        {
            if(tester.test(e))
            {
                return e;
            }
        }
        return null;
    }


}
