package com.sparta.grr.worldbuilderapi;

import com.sparta.grr.worldbuilderapi.entities.Person;
import com.sparta.grr.worldbuilderapi.entities.Settlement;
import com.sparta.grr.worldbuilderapi.repositories.PersonRepository;
import com.sparta.grr.worldbuilderapi.repositories.SettlementRepository;
import com.sparta.grr.worldbuilderapi.services.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private SettlementRepository settlementRepository;

    @Test
    public void testPersonRepository(){
        Person newDude = new Person();
        newDude.setFirstName("John");
        newDude.setLastName("Doe");

        Settlement settlement = new Settlement();
        settlement.setName("New York");
        settlement.setDescription("lorum ipsum ispum lorm");

        settlementRepository.save(settlement);
        newDude.setSettlement(settlement);

        personRepository.save(newDude);


        List<Person> people = personRepository.findAll();

        for(Person person : people){
            System.out.println(person);
        }
    }
}
