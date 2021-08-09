package com.udacity.jdnd.course3.critter.pet.service;

import com.udacity.jdnd.course3.critter.pet.DTO.PetDTO;
import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.exception.PetException;
import com.udacity.jdnd.course3.critter.pet.repository.PetRepository;
import com.udacity.jdnd.course3.critter.user.customer.CustomerService;
import com.udacity.jdnd.course3.critter.user.customer.entity.Customer;
import com.udacity.jdnd.course3.critter.user.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PetService {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public Pet createPet(Pet pet){
        Pet mainPet = petRepository.save(pet);
        Customer customer = mainPet.getCustomer();
        customer.setPets(mainPet);
        customerRepository.save(customer);

        return mainPet;
    }

    public Pet getPetById(Long id){
        return petRepository.findPetById(id);
    }

    public List<Pet> getAllPet(){
        return petRepository.findAllPets();
    }

    public List<Pet> getPetByownerId(Long customerId){
        List<Pet> pet = petRepository.findByCustomer(customerId);

        return pet;
    }

}
