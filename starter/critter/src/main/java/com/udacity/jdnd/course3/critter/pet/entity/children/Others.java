package com.udacity.jdnd.course3.critter.pet.entity.children;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.user.customer.entity.Customer;

import java.time.LocalDate;

public class Others extends Pet {
    private PetType type = PetType.OTHER;
    private String name;

    public Others(Customer customer, LocalDate birthDate, String notes, PetType type, String name, PetType type1) {
        super(customer, birthDate, notes, type, name);
    }
}
