package com.udacity.jdnd.course3.critter.pet.entity;

import com.udacity.jdnd.course3.critter.pet.entity.children.PetType;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.user.customer.entity.Customer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Pet")
@Table(name = "pet")
public class Pet {

    @Id
    @SequenceGenerator(
            name= "pet_sequence",
            sequenceName = "pet_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pet_sequence"
    )

    @Column(
            name="id",
            nullable = false
    )
    private long id;

    @ManyToOne(
            cascade = CascadeType.MERGE,
            fetch =FetchType.EAGER
    )
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "owner_pet_fk"
            )
    )
    private Customer customer;
    @Column(
            name = "birth_date"
    )
    private LocalDate birthDate;

    @Column(
            name = "notes"
    )
    private String notes;

    @Column(
            name = "type"
    )
    private PetType type;

    @Column(
            name = "name"
    )
    private String name;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "petschedule",
            joinColumns = @JoinColumn(
                    name="pet_id",
                    foreignKey = @ForeignKey(name = "schedule_pet_id_fk")
            ),

            inverseJoinColumns = @JoinColumn(
                    name="schedule_id",
                    foreignKey = @ForeignKey(name = "schedule_id_fk")

            )
    )

    private List<Schedule> schedule_pet = new ArrayList<>();

    public Pet(Customer customer, LocalDate birthDate, String notes, PetType type, String name) {
        this.customer = customer;
        this.birthDate = birthDate;
        this.notes = notes;
        this.type = type;
        this.name = name;
    }

    public Pet(LocalDate birthDate, String notes, PetType type, String name) {
        this.birthDate = birthDate;
        this.notes = notes;
        this.type = type;
        this.name = name;
    }


    public Pet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer=customer;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Schedule> getSchedule_pet() {
        return schedule_pet;
    }

    public void addSchedulePet(Schedule schedulePet) {
        schedule_pet.add(schedulePet);
        schedulePet.getPetSchedule().add(this);
    }

    public void removeSchedulePet(Schedule schedulePet){
        schedule_pet.remove(schedulePet);
        schedulePet.getPetSchedule().remove(this);
    }


    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", birthDate=" + birthDate +
                ", notes='" + notes + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
