package cloudnative.calculatorapplication;

import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public CompletableFuture<Double> add(@RequestParam double a, @RequestParam double b) {
        return calculatorService.add(a, b);
    }

    @GetMapping("/subtract")
    public CompletableFuture<Double> subtract(@RequestParam double a, @RequestParam double b) {
        return calculatorService.subtract(a, b);
    }

    @GetMapping("/multiply")
    public CompletableFuture<Double> multiply(@RequestParam double a, @RequestParam double b) {
        return calculatorService.multiply(a, b);
    }

    @GetMapping("/divide")
    public CompletableFuture<Double> divide(@RequestParam double a, @RequestParam double b) {
        return calculatorService.divide(a, b);
    }
}
