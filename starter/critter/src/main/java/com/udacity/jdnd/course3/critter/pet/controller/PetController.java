package com.udacity.jdnd.course3.critter.pet.controller;

import com.udacity.jdnd.course3.critter.pet.DTO.PetDTO;
import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.exception.PetException;
import com.udacity.jdnd.course3.critter.pet.service.PetService;
import com.udacity.jdnd.course3.critter.user.customer.CustomerService;
import com.udacity.jdnd.course3.critter.user.customer.entity.Customer;
import com.udacity.jdnd.course3.critter.user.customer.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
@Transactional
public class PetController {
    @Autowired
    private PetService petService;
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
       Customer customer = customerRepository.getOne(petDTO.getOwnerId());

        Pet mainPet = convertPetDTOToPet(petDTO);
        mainPet.setCustomer(customer);
        mainPet.setOwnerId(petDTO.getOwnerId());

        return convertPetToPetDTO(petService.createPet(mainPet));
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
       return convertPetToPetDTO(petService.getPetById(petId));
    }

    @GetMapping
    public List<PetDTO> getPets(){
        List<PetDTO> petDTOS = new ArrayList<>();
        List<Pet> Pets = petService.getAllPet();
        for(Pet p : Pets){
            petDTOS.add(convertPetToPetDTO(p));
        }

        return petDTOS;
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {

        List<Pet> pets = petService.getAllPet();
        List<Pet> ownersPet = new ArrayList<>();
        for(Pet pet: pets){
            if(pet.getOwnerId()==ownerId){
                ownersPet.add(pet);
            }
        }

        List<PetDTO> petDTOS = new ArrayList<>();
        for(Pet p : ownersPet){
            petDTOS.add(convertPetToPetDTO(p));
        }

        return petDTOS;

    }

    private PetDTO convertPetToPetDTO(Pet pet){
        PetDTO petDTO = new PetDTO();
        BeanUtils.copyProperties(pet, petDTO);
        return petDTO;
    }

    private Pet convertPetDTOToPet(PetDTO petDTO){
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDTO, pet);
        return pet;
    }



}
