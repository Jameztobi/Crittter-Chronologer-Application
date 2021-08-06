package com.udacity.jdnd.course3.critter.pet.entity.children;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.user.customer.entity.Customer;

import java.time.LocalDate;

public class Dog extends Pet {
    private PetType type = PetType.DOG;
    private String name;

    public Dog(Customer customer, LocalDate birthDate, String notes, PetType type, String name) {
        super(customer, birthDate, notes, type, name);
    }
}
