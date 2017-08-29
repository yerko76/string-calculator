package com.example.demo

import spock.lang.Specification


class StringCalculatorSpec extends Specification{

    StringCalculator stringCalculator

    def setup(){
        stringCalculator = new StringCalculator()
    }


    def "String vacio deberia retornar 0" (){
        given: "Tengo un String vacio"
            String numbers = ""
        when: "Cuando ejecuto la funcion sumar"
            def result = stringCalculator.add(numbers)
        then: "Deberia retornar 0"
            assert result == 0
    }

    def "String 1 deberia retornar 1" (){
        given: "Tengo un String con valor 1"
            String numbers = "1"
        when: "Cuando ejecuto la funcion sumar"
            def result = stringCalculator.add(numbers)
        then: "Deberia retornar 1"
            assert result == 1
    }

    def "String 2 deberia retornar 2" (){
        given: "Tengo un String con valor 2"
            String numbers = "2"
        when: "Cuando ejecuto la funcion sumar"
            def result = stringCalculator.add(numbers)
        then: "Deberia retornar 2"
            assert result == 2
    }

    def "String 1,2 deberia retornar la suma de los numeros" (){
        given: "Tengo un String con valor 1,2"
            String numbers = "1,2"
        when: "Cuando ejecuto la funcion sumar"
            def result = stringCalculator.add(numbers)
        then: "Deberia retornar 3"
            assert result == 3
    }

    def "String 1,2,3,4,5,6,7 deberia retornar la suma de los numeros" (){
        given: "Tengo un String con valor 1,2"
            String numbers = "1,2,3,4,5,6,7"
        when: "Cuando ejecuto la funcion sumar"
            def result = stringCalculator.add(numbers)
        then: "Deberia retornar 28"
            assert result == 28
    }

    def "String -1,-2 deberia retornar la suma de los numeros" (){
        given: "Tengo un String con valor -1,-2"
            String numbers = "-1,-2"
        when: "Cuando ejecuto la funcion sumar"
            def result = stringCalculator.add(numbers)
        then: "Deberia retornar 3"
            assert result == -3
    }

    def "String no numerico deberia arrojar una excepcion" (){
        given: "Tengo un String con valor aaaaaa"
            String numbers = "aaaa"
        when: "Cuando ejecuto la funcion sumar"
            def result = stringCalculator.add(numbers)
        then: "Deberia arrojar ilegal argument exception"
            final IllegalArgumentException exception = thrown()
            exception.message == "Invalid Request"
    }

    def "Deberia retornar invalid argument exception para un string no numerico" (){
        given: "Tengo un string no numerico"
            String numbers = "a"
        when: "Cuando ejecuto la funcion sumar"
            def result = stringCalculator.add(numbers)
        then: "Deberia arrojar ilegal argument exception"
            final IllegalArgumentException exception = thrown()
            exception.message == "Invalid Request"
    }

    def "Deberia retornar invalid argument exception for null" (){
        given: "Tengo null"
            String numbers = null
        when: "Cuando ejecuto la funcion sumar"
            def result = stringCalculator.add(numbers)
        then: "Deberia arrojar ilegal argument exception"
            final IllegalArgumentException exception = thrown()

            exception.message == "Invalid Request"
    }

    def "String 1,2\n3 deberia retornar la suma de los numeros para multiples delimitadores" (){
        given: "Tengo un String con valor "
            String numbers = "1,2\n" + "3"
        when: "Cuando ejecuto la funcion sumar"
            def result = stringCalculator.add(numbers)
        then: "Deberia retornar "
            assert result == 6
    }

    def "Cambio de delimitador" (){
        given: "Tengo un String con valor "
             String numbers = "//;\n" + "1;2"
        when: "Cuando ejecuto la funcion sumar"
            def result = stringCalculator.add(numbers)
        then: "Deberia retornar "
            assert result == 3
    }




}
