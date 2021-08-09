package com.udacity.jdnd.course3.critter.user.customer;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.repository.PetRepository;
import com.udacity.jdnd.course3.critter.user.customer.DTO.CustomerDTO;
import com.udacity.jdnd.course3.critter.user.customer.entity.Customer;
import com.udacity.jdnd.course3.critter.user.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PetRepository petRepository;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAllCustomer();
    }

    public Customer getCustomerById(Long customerId){
        Optional<Customer> customer=customerRepository.findById(customerId);
        if(customer.isPresent()){
            return customer.get();
        }
        return null;
    }

}
