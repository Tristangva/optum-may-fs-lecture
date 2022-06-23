package net.yorksolutions.myfirstjavaproject;

public class FizzBuzz {
    // Write a method that implements FizzBuzz
    // input is a number
    // output is a string
    // if the number input is a multiple of 3 then output fizz
    // if the number is a multiple of 5, output buzz
    // if number is a multiple of 3 and 5, output FizzBuzz
    //Otherwise output number as string

    public  String fizzbuzz(int input){
        if (input % 3 == 0 && input % 5 == 0) return  "FizzBuzz";

        if (input % 3 == 0) return "Fizz";

        if (input % 5 == 0) return "Buzz";

        return String.valueOf(input);
    }
}
