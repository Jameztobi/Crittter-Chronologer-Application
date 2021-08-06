package com.udacity.jdnd.course3.critter.user.customer.entity;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Customer")
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(
            name="customer_name",
            nullable = false
    )
    private String name;
    @Column(
            name="phone_number",
            nullable = false
    )
    private String phoneNumber;
    @Column(
            name="notes",
            nullable = true
    )
    private String notes;


    @OneToMany(
            mappedBy = "customer",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )

    private List<Pet> petIds = new ArrayList<>();

   @ManyToOne
   @JoinColumn(
           name="schedule_id",
           referencedColumnName = "id",
           foreignKey = @ForeignKey(
           name = "schedule_customer_fk"
   )
   )
   private Schedule schedule;

    public Customer(String name, String phoneNumber, String notes, List<Pet> pets) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
        this.petIds = pets;
    }

    public Customer(String name, String phoneNumber, String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
    }

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }





    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Pet> getPetIds() {
        return petIds;
    }


    public void addPet(Pet pet){
        if(!petIds.contains(pet)){
            petIds.add(pet);
        }
    }

    public void removePet(Pet pet){
        if(petIds.contains(pet)){
            petIds.remove(pet.getId());
            pet.setCustomer(null);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", notes='" + notes + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}
