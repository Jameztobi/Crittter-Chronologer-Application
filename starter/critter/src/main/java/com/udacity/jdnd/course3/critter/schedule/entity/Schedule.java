package com.udacity.jdnd.course3.critter.schedule.entity;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.user.customer.entity.Customer;
import com.udacity.jdnd.course3.critter.user.employee.entity.Employee;
import com.udacity.jdnd.course3.critter.user.employee.entity.EmployeeSkill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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


}
