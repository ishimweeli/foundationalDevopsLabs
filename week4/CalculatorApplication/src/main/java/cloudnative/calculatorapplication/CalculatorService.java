package cloudnative.calculatorapplication;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class CalculatorService {

    @Async
    public CompletableFuture<Double> add(double a, double b) {
        return CompletableFuture.completedFuture(a + b);
    }

    @Async
    public CompletableFuture<Double> subtract(double a, double b) {
        return CompletableFuture.completedFuture(a - b);
    }

    @Async
    public CompletableFuture<Double> multiply(double a, double b) {
        return CompletableFuture.completedFuture(a * b);
    }

    @Async
    public CompletableFuture<Double> divide(double a, double b) {
        if (b == 0 ) throw new IllegalArgumentException("Cannot divide by zeroddddddddddd.");
        return CompletableFuture.completedFuture(a / b);
    }
}
