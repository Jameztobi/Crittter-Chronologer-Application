package com.udacity.jdnd.course3.critter.schedule.service;

import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.schedule.repository.ScheduleRepository;
import com.udacity.jdnd.course3.critter.user.employee.entity.Employee;
import com.udacity.jdnd.course3.critter.user.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Schedule createSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules(){
        return scheduleRepository.findAll();
    }

    public List<Schedule> getPetScheduleById(Long id){
        return scheduleRepository.findPetScheduleById(id);
    }

    public List<Schedule> getEmployeeScheduleById(Long id){
        Employee employee = employeeRepository.findEmployeeById(id);
        return scheduleRepository.findScheduleByEmployeeIds(employee);
    }

    public List<Schedule> getCustomerScheduleById(Long id){
        return scheduleRepository.findCustomerScheduleById(id);
    }

}
