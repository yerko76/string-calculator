package com.example.demo;


public class StringCalculator {

    int add(String numbers){
        if(numbers == null )
            throw new IllegalArgumentException("Invalid Request");
        if(numbers.length() == 0)
            return 0;
        if(numbers.length() == 1)
            return 1;

        return getSumForSplittedNumbers(numbers);

    }

    private int getSumForSplittedNumbers(String numbers) {
        String defaultDelimiter = ",|\n";
        if(numbers.contains("//")){
            String[] request = numbers.split("\n");
            String customDelimiter = request[0].replace("//","");
            return getSumWithDefaultDelimiters(request[1], customDelimiter);
        }
        return getSumWithDefaultDelimiters(numbers, defaultDelimiter);
    }

    private int getSumWithDefaultDelimiters(String numbers, String delimiters) {

        String[] splittedNumbers = numbers.split(delimiters);
        int sum =0;
        for(String number : splittedNumbers){
            try{
                sum += Integer.valueOf(number);
            }
            catch (NumberFormatException e){
                throw new IllegalArgumentException("Invalid Request");
            }

        }
        return sum;
    }
}
