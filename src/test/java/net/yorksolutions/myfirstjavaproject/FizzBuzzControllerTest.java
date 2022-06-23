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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class) // Tell Mockito to perform all of its setup when this class is instantiated
class FizzBuzzControllerTest {
    @LocalServerPort
    int port;

    // Tell Mockito to mock this field
    //      mock - to fake something by replacing contents of field with something else
    @Mock
    FizzBuzz fizzBuzz;

    // Spring, please give me object that you created of type: FIzzBuzzController
    @Autowired
    FizzBuzzController controller;

    @Test
    void itShouldCallFizzBuzzAndReturnItsValue(){
        // If anywhere in the app, fizzbuzz is called on the butterfly object w/ an input of 4.
            //then simply return the string "it was called"
        when(fizzBuzz.fizzbuzz(4)).thenReturn("it was called");
        controller.setFizzBuzz(fizzBuzz);
        final RestTemplate rest = new RestTemplate();
        ResponseEntity<String> actual = rest.getForEntity("http://localhost:"+port+"/fizzbuzz?input=4", String.class);
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        assertEquals("it was called", actual.getBody());
    }
}