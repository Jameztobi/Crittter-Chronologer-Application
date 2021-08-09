package com.udacity.jdnd.course3.critter.user.employee.entity;


import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name="Employee")
@Table(name="employee")
public class Employee {
    @Id
    @SequenceGenerator(
            name= "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )

    @Column(
            name="id",
            nullable = false
    )
    private long id;
    @Column(
            name="employee_name",
            nullable = false
    )
    private String name;

    @ElementCollection(targetClass =  EmployeeSkill.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "EmployeeSkills",
            joinColumns = @JoinColumn(name = "id"),
            foreignKey = @ForeignKey(name = "employee_skills_fk")
    )
    @Column(name="skills")
    private Set<EmployeeSkill> skills = new HashSet<>();



    @ElementCollection(targetClass = DayOfWeek.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "DaysAvailable",
            joinColumns = @JoinColumn(name = "id"),
            foreignKey = @ForeignKey(name = "employee_availability_fk")
    )
    @Column(name="days_available")
    private Set<DayOfWeek> daysAvailable = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "employeeschedule",
            joinColumns = @JoinColumn(
                    name="employee_id",
                    foreignKey = @ForeignKey(name = "employee_pet_id_fk")
            ),

            inverseJoinColumns = @JoinColumn(
                    name="schedule_id",
                    foreignKey = @ForeignKey(name = "schedule_id_fk")

            )
    )
    private List<Schedule> schedule_employees = new ArrayList<>();

    public Employee(String name, Set<EmployeeSkill> skills, Set<DayOfWeek> daysAvailable, List<Schedule> schedule_employees) {
        this.name = name;
        this.skills = skills;
        this.daysAvailable = daysAvailable;
        this.schedule_employees = schedule_employees;
    }

    public Employee(String name, Set<EmployeeSkill> skills, Set<DayOfWeek> daysAvailable) {
        this.name = name;
        this.skills = skills;
        this.daysAvailable = daysAvailable;
    }

    public Employee(String name, Set<EmployeeSkill> skills) {
        this.name = name;
        this.skills = skills;
    }

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public Set<DayOfWeek> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }


    public void addSchedule(Set<DayOfWeek> daysAvailable){
        daysAvailable.addAll(daysAvailable);
    }

    public List<Schedule> getSchedule_employees() {
        return schedule_employees;
    }

    public void setSchedule_employees(List<Schedule> schedule_employees) {
        this.schedule_employees = schedule_employees;
    }

    public void addEmployeeSchedule(Schedule schedule){
        this.schedule_employees.add(schedule);
        schedule.getEmployees().add(this);

    }

    public void removeEmployeeSchedule(Schedule schedule){
        this.schedule_employees.remove(schedule);
        schedule.getEmployees().remove(this);

    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
