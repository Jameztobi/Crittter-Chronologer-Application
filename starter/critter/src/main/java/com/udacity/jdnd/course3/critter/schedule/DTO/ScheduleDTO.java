package com.udacity.jdnd.course3.critter.schedule.DTO;

import com.udacity.jdnd.course3.critter.user.employee.entity.EmployeeSkill;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Represents the form that schedule request and response data takes. Does not map
 * to the database directly.
 */
public class ScheduleDTO implements Serializable {
    private long id;
    private List<Long> employeeIds;
    private List<Long> petIds;
    private LocalDate date;
    private Set<EmployeeSkill> activities;

    public ScheduleDTO(List<Long> employeeIds, List<Long> petIds, LocalDate date, Set<EmployeeSkill> activities) {
        this.employeeIds = employeeIds;
        this.petIds = petIds;
        this.date = date;
        this.activities = activities;
    }

    public ScheduleDTO() {
    }

    public List<Long> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public List<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
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
}
