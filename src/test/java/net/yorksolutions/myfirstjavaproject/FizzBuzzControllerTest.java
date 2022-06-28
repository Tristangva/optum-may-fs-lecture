package net.yorksolutions.myfirstjavaproject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // allows you to test your controller and run it on a random port
@ExtendWith(MockitoExtension.class) // Tell Mockito to perform all of its setup when this class is instantiated
class FizzBuzzControllerTest {
    @LocalServerPort// assigns our variable to the first available random port
    int port;

    // Tell Mockito to mock this field
    //      mock - to fake something by replacing contents of field with something else
    @Mock // creates a fake instance of this field to test
    FizzBuzz mockFizzBuzz;

    // Spring, please give me object that you created of type: FIzzBuzzController
    @Autowired
    FizzBuzzController controller;

    private static class  GenericTest<T>{
        final T object;

        private GenericTest(T object){
            this.object = object;
        }
    }

    @Test
    void itShouldCallFizzBuzzAndReturnItsValue(){
        final GenericTest<String> g = new GenericTest<String>("hello");
        System.out.println(g.object);
        final GenericTest<Integer> i = new GenericTest<Integer>(9);
        System.out.println(i.object);
        // If anywhere in the app, fizzbuzz is called on the butterfly object w/ an input of 4.
            //then simply return the string "it was called"
        when(mockFizzBuzz.fizzbuzz(4)).thenReturn("it was called"); // three calls, when(), fizzbuzz.fizzbuzz, thenReturn()
        // to mock fizzbuzz we just return it was called whenever the function with 4 is called
        controller.setFizzBuzz(mockFizzBuzz);
        final RestTemplate rest = new RestTemplate();
        ResponseEntity<String> actual = rest.getForEntity("http://localhost:"+port+"/fizzbuzz?input=4", String.class);
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        assertEquals("it was called", actual.getBody());
    }
    // get for object doesn't care about metadata, wants direct object
}