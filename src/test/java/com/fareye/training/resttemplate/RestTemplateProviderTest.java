package com.fareye.training.resttemplate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestTemplateProviderTest {

    @Test
    void twoPlusTwoIsFour(){

        RestTemplateProvider res = new RestTemplateProvider();
        assertEquals(4,res.addNumber(2,2));

    }

}