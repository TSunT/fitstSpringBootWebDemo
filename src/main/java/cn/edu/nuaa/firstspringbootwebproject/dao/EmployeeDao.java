package cn.edu.nuaa.firstspringbootwebproject.dao;

import cn.edu.nuaa.firstspringbootwebproject.pojo.Department;
import cn.edu.nuaa.firstspringbootwebproject.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees =new HashMap<>();
        employees.put(1001,new Employee(1001,"a",1,new Department(101,"a"),new Date()));
        employees.put(1002,new Employee(1002,"b",1,new Department(101,"a"),new Date()));
        employees.put(1003,new Employee(1003,"c",1,new Department(101,"a"),new Date()));
    }

    private static Integer primeKey = 1000;

    private static Integer getPrimeKey(){
        return primeKey++;
    }

    public void saveEmployee(Employee employee){
        if(employee.getId()==null){
            employee.setId(getPrimeKey());
        }
        employee.setDepartment(departmentDao.findById(employee.getDepartment().getDepId()));
        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> findAllEmployee(){
        return employees.values();
    }

    public Employee findById(Integer id){
        return employees.get(id);
    }
}
