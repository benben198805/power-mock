package com.xxx.xxx.controller;

import com.xxx.xxx.domain.Person;
import com.xxx.xxx.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {
    @Test
    public void should_return_first_and_last_name() {
        // given
        Person person = new Person("first", "last", BigDecimal.ONE);
        PersonService personService = Mockito.mock(PersonService.class);
        given(personService.find(any())).willReturn(person);
        PersonController personController = new PersonController(personService);

        // when
        String result = personController.getName("name");

        // then
        Assert.assertEquals(result, "first,last");
    }
}
