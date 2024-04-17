package com.targetindia.tests;

import com.targetindia.utils.BDD;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonDataClassTests {
    @Test
    public void PersonDataClassTest(){
        BDD.Person person = new BDD.Person("John Doe",44);
        assertEquals("John Doe",person.name);
        assertEquals(44,person.age);
    }
}
