package com.udacity.jdnd.course3.critter.schedule.repository;

import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.user.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("SELECT s FROM Schedule s")
    List<Schedule> findAllSchedules();

    List<Schedule> findPetScheduleById(Long id);

    List<Schedule> findCustomerScheduleById(Long id);
    //@Query("SELECT s FROM Schedule s JOIN Employee e WHERE s.id = :id")
    List<Schedule> findEmployeeScheduleById(Long id);

    List<Schedule> findScheduleEmployeeAndEmployeeSkillById(Long id);

    List<Schedule> findScheduleByEmployeeIds(Employee employee);
}
