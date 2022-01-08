package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void test(){
        var calculator = new Calculator();

        Integer actual = calculator.add(2,3);

        assertEquals(5,actual);
    }

}