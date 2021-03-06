package cn.edu.nuaa.firstspringbootwebproject.dao;

import cn.edu.nuaa.firstspringbootwebproject.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments;

    static {
        departments=new HashMap<>();
        departments.put(101,new Department(101,"Productions Development Department"));
        departments.put(102,new Department(102,"Productions Marketing Department"));
        departments.put(103,new Department(103,"Human Resource Department"));
    }

    public Collection<Department> findAllDepartment(){
        return departments.values();
    }

    public void save(Department department){
        departments.put(department.getDepId(),department);
    }

    public Department findById(Integer depId){
        return departments.get(depId);
    }
}
