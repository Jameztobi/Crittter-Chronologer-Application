package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.DTO.PetDTO;
import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.service.PetService;
import com.udacity.jdnd.course3.critter.schedule.DTO.ScheduleDTO;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.schedule.service.ScheduleService;
import com.udacity.jdnd.course3.critter.user.customer.CustomerService;
import com.udacity.jdnd.course3.critter.user.customer.entity.Customer;
import com.udacity.jdnd.course3.critter.user.employee.entity.Employee;
import com.udacity.jdnd.course3.critter.user.employee.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
@Transactional
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private PetService petService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleService.saveSchedule(convertScheduleDTOToSchedule(scheduleDTO));
        List<Pet> petList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();

        for(Long pet: scheduleDTO.getPetIds()){
            Pet pet1 = petService.getPetById(pet);
            pet1.addSchedulePet(schedule);
        }

        for (Long employee: scheduleDTO.getEmployeeIds()){
            Employee employee1=employeeService.getEmployee(employee);
            employee1.addEmployeeSchedule(schedule);
        }


        return convertScheduleToScheduleDTO(schedule);
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();
        for(Schedule schedule: schedules){
            scheduleDTOS.add(convertScheduleToScheduleDTO(schedule));
        }
        return scheduleDTOS;
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
         Pet pet = petService.getPetById(petId);
         List<Schedule> schedules = pet.getSchedule_pet();
         List<ScheduleDTO> scheduleDTOS = new ArrayList<>();

         for(Schedule schedule: schedules){
            scheduleDTOS.add(convertScheduleToScheduleDTO(schedule));
         }

        return scheduleDTOS;
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
        List<Schedule> schedules = employee.getSchedule_employees();
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();
        for(Schedule schedule: schedules){
            scheduleDTOS.add(convertScheduleToScheduleDTO(schedule));
        }

        return scheduleDTOS;
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();
        List<Pet> pets = customer.getPets();
        List<Schedule> schedules = new ArrayList<>();
        for(Pet pet: pets){
            pet.getSchedule_pet().forEach(schedule -> {
                schedules.add(schedule);
            });
        }

        for(Schedule schedule: schedules){
            scheduleDTOS.add(convertScheduleToScheduleDTO(schedule));
        }

        return scheduleDTOS;


    }

    private ScheduleDTO convertScheduleToScheduleDTO(Schedule schedule){
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        BeanUtils.copyProperties(schedule, scheduleDTO);
        scheduleDTO.setActivities(schedule.getActivities());
        List<Long> petList = new ArrayList<>();
        List<Long> employeeList = new ArrayList<>();
        for(Pet pet: schedule.getPetSchedule()){
            petList.add(pet.getId());
        }

        for(Employee employee: schedule.getEmployees()){
            employeeList.add(employee.getId());
        }
        scheduleDTO.setPetIds(petList);
        scheduleDTO.setEmployeeIds(employeeList);
        return scheduleDTO;
    }

    private Schedule convertScheduleDTOToSchedule(ScheduleDTO scheduleDTO){
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(scheduleDTO, schedule);
        return schedule;
    }

    private List<ScheduleDTO> convertScheduleToScheduleDTO(List<Schedule> schedule){
        List<ScheduleDTO> scheduleDTO = new ArrayList<>();
        BeanUtils.copyProperties(schedule, scheduleDTO);
        return scheduleDTO;
    }
}
