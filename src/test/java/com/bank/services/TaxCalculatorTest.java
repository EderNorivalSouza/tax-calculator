package com.bank.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.bank.services.TaxCalculator;
import com.bank.services.impl.TaxCalculatorImpl;
import com.bank.types.Operation;
import com.bank.types.Tax;

public class TaxCalculatorTest {

  TaxCalculator taxCalculator = new TaxCalculatorImpl();

  private ArrayList<Operation> operations = new ArrayList<Operation>();

  @Test
  public void shouldCalculateSuccess() {
    operations.add(new Operation("buy", 10.00, 10000));
    operations.add(new Operation("sell", 2.00, 5000));
    operations.add(new Operation("sell", 20.00, 2000));
    operations.add(new Operation("sell", 20.00, 2000));
    operations.add(new Operation("sell", 25.00, 1000));
    operations.add(new Operation("buy", 20.00, 10000));
    operations.add(new Operation("sell", 15.00, 5000));
    operations.add(new Operation("sell", 30.00, 4350));
    operations.add(new Operation("sell", 30.00, 650));
    ArrayList<Tax> taxes = taxCalculator.calculate(operations);

    assertEquals(0.0, taxes.get(0).getTax(), 0);
    assertEquals(0.0, taxes.get(1).getTax(), 0);
    assertEquals(0.0, taxes.get(2).getTax(), 0);
    assertEquals(0.0, taxes.get(3).getTax(), 0);
    assertEquals(3000.0, taxes.get(4).getTax(), 0);
    assertEquals(0.0, taxes.get(5).getTax(), 0);
    assertEquals(0.0, taxes.get(6).getTax(), 0);
    assertEquals(3700.0, taxes.get(7).getTax(), 0);
    assertEquals(0.0, taxes.get(8).getTax(), 0);
  }
}
