package net.yorksolutions.myfirstjavaproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController // spring will instanciate controller
@RequestMapping("/")
public class FizzBuzzController {

    FizzBuzz fizzBuzz;

    final CacheRepository repository;
    // Production

    @Autowired // automatically makes one
    FizzBuzzController(CacheRepository repository){
        this.repository = repository; // spring makes this for us
        fizzBuzz = new FizzBuzz();
    }

    // testing
    // injection site
    void setFizzBuzz(FizzBuzz fizzBuzz){
        this.fizzBuzz = fizzBuzz;
    }

    @GetMapping("/fizzbuzz")
    String fizzbuzz(@RequestParam int input){
        final Optional<Cache> result =repository.findByInput(input);

        if (result.isPresent()){
            return result.get().output;
        }
        String output = fizzBuzz.fizzbuzz(input);
        Cache cache = new Cache();
        cache.input = input;
        cache.output = output;
        repository.save(cache);
        return output;
    }
}
