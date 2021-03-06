package com.switchfully.spring.dependencyinjection;

import com.switchfully.spring.dependencyinjection.calculator.TaxCalculator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.inject.Inject;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final ApplicationContext applicationContext;

    @Inject
    public Application(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        TaxCalculator taxCalculator = applicationContext.getBean(TaxCalculator.class);
        double taxesToPay = taxCalculator.calculateTaxesForIncome(23000);
        System.out.println("\n\n\nTAX CALCULATION\n\n\n");
        System.out.println(String.format("You have %s taxes to pay!", taxesToPay));
        System.out.println("\n\n\n-------------------------------------------------");
    }
}
