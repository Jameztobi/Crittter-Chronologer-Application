package com.udacity.jdnd.course3.critter.pet.entity.children;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.user.customer.entity.Customer;

import java.time.LocalDate;

public class Cat extends Pet {
    private PetType type = PetType.CAT;
    private String name;

    public Cat(Customer customer, LocalDate birthDate, String notes, PetType type, String name) {
        super(customer, birthDate, notes, type, name);
    }
}
