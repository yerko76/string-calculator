package com.example.demo

import spock.lang.Specification


class DemoTestSpec extends Specification {

    def "sum 2 numbers" (){
        given: "a"
            def a =1
        and: "b"
            def b =2
        when: "I sum a + b"
            def sum = a+b
        then: "the result should be 3"
            assert sum == 1
    }
}
