package com.example.a301lab8;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {
    public City city1 = new City("Edmonton", "Alberta");

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     * list
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>()); return list;
    }


    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity(){
        list = MockCityList();
        City city  = new City("Edmonton", "BC");
        assertTrue(list.hasCity(city1));
        assertFalse(list.hasCity(city));

    }
}
