package com.nubank.services.impl;

import java.util.ArrayList;
import java.util.Scanner;

import com.nubank.mapper.JsonMapper;
import com.nubank.services.Execute;
import com.nubank.services.TaxCalculator;
import com.nubank.types.Operation;
import com.nubank.types.Tax;

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
