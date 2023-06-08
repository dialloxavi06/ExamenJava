package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizaTest {
    @Test
    void tester() {

        pizza pizza1 = new pizza ("margarita", 20,4 ) ;

        String nom1 = pizza1.getNom();
        int nb_ing1 = pizza1.getNbIngredients();
        float prix1= pizza1.getPrix();


        // verfication getter & setter
        assertEquals("margarita",nom1);
        assertEquals(5,nb_ing1);
        assertEquals(10,prix1);


    }
    @Test
    void verfication() {

        pizza p = new pizza ("s", 15 , 3);
         final String nom = p.getNom();

        // verfication getter & setter
        assertEquals("s",nom);



    }

}