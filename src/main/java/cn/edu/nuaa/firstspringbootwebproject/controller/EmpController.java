package cn.edu.nuaa.firstspringbootwebproject.controller;

import cn.edu.nuaa.firstspringbootwebproject.dao.DepartmentDao;
import cn.edu.nuaa.firstspringbootwebproject.dao.EmployeeDao;
import cn.edu.nuaa.firstspringbootwebproject.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @RequestMapping("/findAll")
    public String findAllEmp(Model model){
        model.addAttribute("employees",employeeDao.findAllEmployee());
        return "emp/list";
    }
    @RequestMapping("/addEmp")
    public String addEmp(Model model){
        model.addAttribute("departnemts",departmentDao.findAllDepartment());
        return "emp/add";
    }
    @PostMapping("/insertEmp")
    public String insertEmp(Employee employee){
        employeeDao.saveEmployee(employee);
        return "redirect:/emp/findAll";
    }
    @RequestMapping("/changeEmp")
    public String changeEmp(@RequestParam Integer id, Model model){
        model.addAttribute("emp",employeeDao.findById(id));
        model.addAttribute("departnemts",departmentDao.findAllDepartment());
        return "emp/edit";
    }
    @RequestMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.saveEmployee(employee);
        return "redirect:/emp/findAll";
    }
}
