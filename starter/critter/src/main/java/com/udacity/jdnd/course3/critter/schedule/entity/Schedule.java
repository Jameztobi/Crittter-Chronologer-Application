package com.udacity.jdnd.course3.critter.schedule.entity;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.user.customer.entity.Customer;
import com.udacity.jdnd.course3.critter.user.employee.entity.Employee;
import com.udacity.jdnd.course3.critter.user.employee.entity.EmployeeSkill;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name="Schedule")
@Table(name="schedule")
public class Schedule {
    @Id
    @SequenceGenerator(
            name= "schedule_sequence",
            sequenceName = "schedule_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "schedule_sequence"
    )

    @Column(
            name="id",
            nullable = false
    )
    private long id;
    @ManyToMany(
            mappedBy = "schedule_pet"
    )
    private List<Pet> petSchedule = new ArrayList<>();
    @Column(
            name="date",
            nullable = false
    )
     private LocalDate date;


    @ElementCollection(targetClass = EmployeeSkill.class)
    @Enumerated(EnumType.STRING)
    @Column(
            name="activities",
            nullable = false,
            insertable = true,
            updatable = true
    )
    private Set<EmployeeSkill> activities = new HashSet<>();

    @ManyToMany(
            mappedBy = "schedule_employees"
    )
    private List<Employee> employeeIds = new ArrayList<>();

    @OneToMany(
            mappedBy = "schedule",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )

    private List<Customer> customers = new ArrayList<>();

    public Schedule(long id, List<Pet> petSchedule, LocalDate date, Set<EmployeeSkill> activities, List<Employee> employeesSchedule, List<Customer> customers) {
        this.id = id;
        this.petSchedule = petSchedule;
        this.date = date;
        this.activities = activities;
        this.employeeIds = employeesSchedule;
        this.customers = customers;
    }

    public Schedule(List<Pet> pets, LocalDate date, Set<EmployeeSkill> activities) {
        this.petSchedule = pets;
        this.date = date;
        this.activities = activities;
    }

    public Schedule(LocalDate date, Set<EmployeeSkill> activities) {
        this.date = date;
        this.activities = activities;
    }

    public Schedule(List<Pet> petSchedule, LocalDate date, Set<EmployeeSkill> activities, List<Employee> employeeIds) {
        this.petSchedule = petSchedule;
        this.date = date;
        this.activities = activities;
        this.employeeIds = employeeIds;
    }

    public Schedule() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Pet> getPetSchedule() {
        return petSchedule;
    }

    public void setPetSchedule(List<Pet> petSchedule) {
        this.petSchedule = petSchedule;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<EmployeeSkill> getActivities() {
        return activities;
    }



    public void setActivities(Set<EmployeeSkill> activities) {
        this.activities = activities;
    }


    public List<Employee> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<Employee> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public void addCustomer(Customer customer){
        if(!customers.contains(customer)){
            customers.add(customer);
        }
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", pets=" + petSchedule +
                ", date=" + date +
                '}';
    }
}
