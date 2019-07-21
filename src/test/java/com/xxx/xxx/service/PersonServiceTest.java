package com.xxx.xxx.service;

import com.xxx.xxx.domain.Person;
import com.xxx.xxx.domain.PersonRequest;
import com.xxx.xxx.utils.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.anyLong;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TimeUnit.class)
@SuppressStaticInitializationFor("com.xxx.xxx.utils.SalaryCalculator")
public class PersonServiceTest {
    @InjectMocks
    private PersonService personService;

    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(TimeUnit.class);
        PowerMockito.doNothing().when(TimeUnit.class, "sleep", anyLong());
    }

    @Test
    public void should_return_none_person() {
        // given
        PersonRequest personRequest = new PersonRequest("name");

        // when
        Person result = personService.find(personRequest);

        // then
        Assert.assertEquals(result.getFirstName(), "None");
        Assert.assertEquals(result.getLastName(), "None");
        Assert.assertEquals(result.getSalary(), BigDecimal.ZERO);
    }

    @Test
    public void should_return_James_person() {
        // given
        PersonRequest personRequest = new PersonRequest("James");

        // when
        Person result = personService.find(personRequest);

        // then
        Assert.assertEquals(result.getFirstName(), "Merson");
        Assert.assertEquals(result.getLastName(), "James");
        Assert.assertEquals(result.getSalary(), BigDecimal.TEN.add(BigDecimal.TEN));
    }
}
