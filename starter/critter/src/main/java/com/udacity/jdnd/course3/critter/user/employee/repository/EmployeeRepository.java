package com.udacity.jdnd.course3.critter.user.employee.repository;

import com.udacity.jdnd.course3.critter.user.employee.DTO.EmployeeResponseDTO;
import com.udacity.jdnd.course3.critter.user.employee.entity.Employee;
import com.udacity.jdnd.course3.critter.user.employee.entity.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeById(Long id);


    List<Employee> findAllEmployeeByskillsInAndDaysAvailable(Set<EmployeeSkill> mainSkills, DayOfWeek dayOfWeek);


}
