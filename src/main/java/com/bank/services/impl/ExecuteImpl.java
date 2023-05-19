package com.bank.services.impl;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.mapper.JsonMapper;
import com.bank.services.Execute;
import com.bank.services.TaxCalculator;
import com.bank.types.Operation;
import com.bank.types.Tax;

public class ExecuteImpl implements Execute {

  JsonMapper mapper;
  TaxCalculator taxCalculator;

  public ExecuteImpl(JsonMapper mapper, TaxCalculator taxCalculator) {
    this.mapper = mapper;
    this.taxCalculator = taxCalculator;
  }

  public void execute() {
    Scanner scanner = new Scanner(System.in);
    StringBuilder data = new StringBuilder();

    Boolean keepReading = true;

    System.out.println("Hi, Let's get started!!");

    while (keepReading.equals(true)) {
      String line = scanner.nextLine();
      if (line.isEmpty()) {
        keepReading = false;
        scanner.close();
        break;
      }

      ArrayList<Operation> list = mapper.toOperations(line);
      ArrayList<Tax> tx = taxCalculator.calculate(list);
      data.append(mapper.toString(tx));
      data.append("\n");

    }

    System.out.println("Your taxes are:");
    System.out.println(data);
    System.out.println("Good bye!!");
  }
}
