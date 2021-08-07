package com.udacity.jdnd.course3.critter.user.customer.entity;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Customer")
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    private List<Pet> pets;

   @ManyToOne
   @JoinColumn(
           name="schedule_id",
           referencedColumnName = "id",
           foreignKey = @ForeignKey(
           name = "schedule_customer_fk"
   )
   )
   private Schedule schedule;

    public void setPets(Pet pet){
       if(pets==null){
           pets=new ArrayList<>();
           pets.add(pet);
       }
       pets.add(pet);

   }


}
