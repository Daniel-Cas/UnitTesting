package models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("Verify the adition")
    void test(){
        var calculator = new Calculator();

        Integer actual = calculator.add(3,3);

        assertEquals(6,actual);
    }

    @Test
    @DisplayName("Verify the degree")
    void degree() {
         var calculator = new Calculator();

         Integer actual = calculator.degree(3,3);
         assertEquals(0, actual);
    }

    @Test
    @DisplayName("Verify the product")
    void product() {
        var calculator = new Calculator();

        Integer actual = calculator.product(3,3);
        assertEquals(9, actual);
    }

    @Test
    @DisplayName("Verify the divition")
    void divition() {
        var calculator = new Calculator();

        Integer actual = calculator.divition(10,0);
        assertEquals(2, actual);
    }
}