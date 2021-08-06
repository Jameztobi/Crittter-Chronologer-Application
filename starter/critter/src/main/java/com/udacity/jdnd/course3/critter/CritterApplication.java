package com.udacity.jdnd.course3.critter;

import com.github.javafaker.Faker;
import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.entity.children.PetType;
import com.udacity.jdnd.course3.critter.pet.repository.PetRepository;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.schedule.repository.ScheduleRepository;
import com.udacity.jdnd.course3.critter.user.customer.entity.Customer;
import com.udacity.jdnd.course3.critter.user.customer.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.user.employee.DTO.EmployeeResponseDTO;
import com.udacity.jdnd.course3.critter.user.employee.entity.Employee;
import com.udacity.jdnd.course3.critter.user.employee.entity.EmployeeSkill;
import com.udacity.jdnd.course3.critter.user.employee.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

/**
 * Launches the Spring application. Unmodified from starter code.
 */
@SpringBootApplication
public class CritterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CritterApplication.class, args);
	}

    @Bean
	CommandLineRunner commandLineRunner(ScheduleRepository scheduleRepository,
										CustomerRepository customerRepository,
										PetRepository petRepository,
										EmployeeRepository employeeRepository){
		return args -> {

//			Faker faker = new Faker();
//			String name = faker.name().name();
//			String number = faker.phoneNumber().phoneNumber();
//			String notes = "I love this comapny";
//			Customer customer = new Customer(name, number, notes);
//
//
//			Pet pet = new Pet(LocalDate.now().plusMonths(2L), "I am the first Dog", PetType.SNAKE, faker.name().name());
//			Pet pet2 = new Pet(LocalDate.now(), notes, PetType.LIZARD, faker.name().name());
//			pet.setCustomer(customer);
//			pet2.setCustomer(customer);
//			List <Pet> pets =List.of(pet, pet2);
//			Set<EmployeeSkill> skills = new HashSet<>();
//			skills.add(EmployeeSkill.MEDICATING);
//			Set<DayOfWeek> daysAvailable = new HashSet<>();
//			daysAvailable.add(DayOfWeek.MONDAY);
//			daysAvailable.add(DayOfWeek.SATURDAY);
//			daysAvailable.add(DayOfWeek.THURSDAY);
//			Employee employee = new Employee(faker.name().name(), skills, daysAvailable);
//
//			Set<EmployeeSkill> activities = new HashSet<>();
//			activities.add(EmployeeSkill.FEEDING);
//			activities.add(EmployeeSkill.MEDICATING);
//			Schedule schedule = new Schedule(LocalDate.now(), activities);
//			schedule.addCustomer(customer);
//
//			scheduleRepository.save(schedule);

//			List<Schedule> mySchedule = scheduleRepository.findAllSchedules();
//			mySchedule.forEach(System.out::println);
//
//			Schedule petSchedule = scheduleRepository.findPetScheduleById(1L);
//			System.out.print(petSchedule);

//			Schedule customerSchedule = scheduleRepository.findCustomerScheduleById(1L);
//			System.out.println(customerSchedule);


//			Schedule employeeSchedule = scheduleRepository.findScheduleEmployeeAndEmployeeSkillById(1L);
//			System.out.println(employeeSchedule);
//			Customer customer1 =new Customer("Tobi", number, notes);
//			customer1.addPet(pet);
//			customerRepository.save(customer1);
//			customer1=customerRepository.findCustomerByPetId(2L);
//			System.out.println(customer1);

			//petRepository.save(pet2);
//			List<EmployeeSkill> skills1 =  new ArrayList<>();
//			skills1.add(EmployeeSkill.MEDICATING);
//
//			System.out.println(employeeRepository.findAllEmployeeByskillsAndDaysAvailable(skills1, DayOfWeek.MONDAY));
//
















		};
	}

}
