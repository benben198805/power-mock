package com.xxx.xxx.controller;

import com.xxx.xxx.domain.PersonRequest;
import org.mockito.ArgumentMatcher;

public class PersonRequestMatcher implements ArgumentMatcher<PersonRequest> {
    private PersonRequest left;

    public PersonRequestMatcher(PersonRequest left) {
        this.left = left;
    }

    @Override
    public boolean matches(PersonRequest right) {
        return left.getName().equals(right.getName());
    }
}
