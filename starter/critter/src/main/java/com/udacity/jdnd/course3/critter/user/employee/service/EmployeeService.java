package com.udacity.jdnd.course3.critter.user.employee.service;
import com.udacity.jdnd.course3.critter.user.employee.DTO.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.user.employee.entity.Employee;
import com.udacity.jdnd.course3.critter.user.employee.entity.EmployeeSkill;
import com.udacity.jdnd.course3.critter.user.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(Long id){
        return employeeRepository.findEmployeeById(id);
    };


    public Employee setAvailability(Set<DayOfWeek> daysAvailable, long employeeId){
        Employee employee = employeeRepository.findEmployeeById(employeeId);
        employee.setDaysAvailable(daysAvailable);
        return employeeRepository.save(employee);
    };

    public List<Employee> getAvailableEmployeeForService(Set<EmployeeSkill> skills, LocalDate date){
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        List<Employee> employeeList = new ArrayList<>();
        List<Employee> employeesAvailable = employeeRepository.findAllEmployeeByskillsInAndDaysAvailable(skills, dayOfWeek);

        for(Employee employee: employeesAvailable){
            if(employee.getSkills().containsAll(skills)){
                employeeList.add(employee);
            }
        }
        return employeeList;

    }
}
