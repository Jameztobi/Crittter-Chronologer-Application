package com.udacity.jdnd.course3.critter.user.customer.repository;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.user.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    //Customer findBypetI(Long id);

    @Query(value = "select * from customer", nativeQuery = true)
    List<Customer> findAllCustomer();
}
