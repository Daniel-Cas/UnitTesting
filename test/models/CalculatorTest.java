package models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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

        Integer actual = calculator.divition(10,1);
        assertEquals(10, actual);
    }

    @Test()
    @Timeout( value = 100, unit = TimeUnit.MILLISECONDS)
    void testTiemOutExample(){
        var number = Duration.ofSeconds(1).toMillis();
        //GIVEN
        var calculator = new Calculator();
        Integer actual = calculator.divition(44444444,2);
        assertEquals(22222222, actual);


    }

    //TEst for see if the current station of execution is especific

    @Test
    void testForEspecificSystemEnviroment(){
        assumeTrue("daniel".equals(System.getenv("LOGNAME")),
                () -> "Aborting test.");
        var calculator = new Calculator();
        Integer actual = calculator.add(10,1);

        assertEquals(11,actual);
    }

    // TEsts with parameters
    @ParameterizedTest
    @ValueSource( ints = {1,2,3,4,-3})
    void parametrizedTEstExample(int number){

        assumeTrue( number > 2, () -> "Número debe ser mayor que 2");

        var calculator = new Calculator();
        Integer actual = calculator.add(number,2);

        assertEquals(5, actual);

    }


    // Parameters null and empty for test
    @ParameterizedTest
    @NullSource
    @EmptySource
    @NullAndEmptySource
    void nullAndEmptySources(String text){
        assumeTrue( text == null || text.trim().isEmpty() );
    }

    @ParameterizedTest
    @MethodSource("sourceMethod")
    void testMethodSource(String arg){
        assertNotNull(arg);
    }

    static Stream<String> sourceMethod() {
        return Stream.of("John", "Walter", "Derek");
    }

    @ParameterizedTest
    @CsvSource({
            "apple,         1",
            "banana,        2",
            "'lemon, lime', 0xF1"
    })
//	@Ignore
//	@Disabled
//	@Disabled("Disabled until Defect #11 will be fixed")
    void testWithCsvSource(String fruit, int rank) {
        assertNotNull(fruit);
        assertNotEquals(0, rank);
    }


}