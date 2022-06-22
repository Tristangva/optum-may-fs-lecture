package net.yorksolutions.myfirstjavaproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    // Annotation is a marker that gives info to a framework
    //      always starts w/ an @
    //      can be applied to a method, class, field, argument, local var

    // in TDD - Test driven design
    //      1. Make test compile
    //      2. Make test fail - test your tests
    //      3. Make test pass


    // Write a method that implements FizzBuzz
    // input is a number
    // output is a string
    // if the number input is a multiple of 3 then output fizz
    // if the number is a multiple of 5, output buzz
    // if number is a multiple of 3 and 5, output FizzBuzz
    //Otherwise output number as string
    @Test
    void itShouldOutputAStringVersionOfTheNumberInput() {
        final String actual = FizzBuzz.fizzbuzz(4);
        assertEquals("4", actual);
    }

    @Test
    void itShouldOutputFizzWhenTheInputIsAMultipleOf3(){
        final String actual = FizzBuzz.fizzbuzz(9);
        assertEquals("Fizz", actual);
    }

    @Test
    void itShouldOutputBuzzWhenTheInputIsAMultipleOf5(){
        final String actual = FizzBuzz.fizzbuzz(10);
        assertEquals("Buzz", actual);
    }

    @Test
    void itShouldOutputFizzBuzzWhenTheInputIsAMultipleOf5and3(){
        final String actual = FizzBuzz.fizzbuzz(15);
        assertEquals("FizzBuzz", actual);
    }
}