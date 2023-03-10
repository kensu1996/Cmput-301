package com.example.a301lab8;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class CustomListTest {
    public City city1 = new City("Edmonton", "Alberta");

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     * list
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());

        return list;
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

        assertFalse(list.hasCity(city));

    }
    @Test
    public void testDelete(){
        list = MockCityList();
        list.addCity(city1);
        list.delete(city1);
        assertFalse(list.hasCity((city1)));
        City city2 = new City("Vancouver", "BC");
        assertThrows( IllegalArgumentException.class, () -> {
            list.delete(city2); });

    }

    @Test
    void testCountCities(){
        list = MockCityList();

        City city2 = new City("Vancouver", "BC");
        list.addCity(city2);
        assertEquals(list.countCities(),1);


    }
}
