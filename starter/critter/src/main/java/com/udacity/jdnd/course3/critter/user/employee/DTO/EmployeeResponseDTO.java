package com.udacity.jdnd.course3.critter.user.employee.DTO;

import com.udacity.jdnd.course3.critter.user.employee.entity.EmployeeSkill;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Embeddable
public class EmployeeResponseDTO implements Serializable {
    private int employeeId;
    private Set<EmployeeSkill> skill;

    public EmployeeResponseDTO(int employeeId, Set<EmployeeSkill> skill) {
        this.employeeId = employeeId;
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeResponseDTO that = (EmployeeResponseDTO) o;
        return employeeId == that.employeeId && Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, skill);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Set<EmployeeSkill> getSkill() {
        return skill;
    }

    public void setSkill(Set<EmployeeSkill> skill) {
        this.skill = skill;
    }
}
