/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.dao;

import java.util.List;
import org.haftrust.verifier.model.Country;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Murali Mohan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class CountryDaoImplTest{
    
    @Autowired
    CountryDAO countryDAO;
    
    String[] expectedCountries = new String[]{"tanzania", "colombia", "uganda"};
    
    @Test
    public void getAddress() throws Exception {
        System.out.println("getAddress()");
        List<Country> countriesFromDB = countryDAO.getCountries();
        System.out.println(countriesFromDB.size());
        int matchedCount = 0;
        for (Country c: countriesFromDB){
            System.out.println(c.getDescription());
            for (String exp: expectedCountries){
                if (c.getTitle().equals(exp)){
                    assertEquals(exp.toLowerCase(), c.getDescription().toLowerCase());
                    matchedCount++;
                }
            }
        }
        assertEquals(3, matchedCount);
    }
    
    
}