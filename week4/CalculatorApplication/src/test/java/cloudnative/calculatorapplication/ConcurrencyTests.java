package cloudnative.calculatorapplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ConcurrencyTests {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void testConcurrentOperations() throws ExecutionException, InterruptedException {
        CompletableFuture<Double> additionFuture = calculatorService.add(1, 2);
        CompletableFuture<Double> subtractionFuture = calculatorService.subtract(5, 3);
        CompletableFuture<Double> multiplicationFuture = calculatorService.multiply(4, 2);
        CompletableFuture<Double> divisionFuture = calculatorService.divide(10, 2);

        CompletableFuture.allOf(additionFuture, subtractionFuture, multiplicationFuture, divisionFuture).join();

        assertEquals(3, additionFuture.get());
        assertEquals(2, subtractionFuture.get());
        assertEquals(8, multiplicationFuture.get());
        assertEquals(5, divisionFuture.get());
    }

    @Test
    public void testDivideByZero() {
        CompletableFuture<Double> future = calculatorService.divide(1, 0);
        assertThrows(ExecutionException.class, future::get);
    }
}