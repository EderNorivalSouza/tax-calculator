package com.bank.services.impl;

import java.util.ArrayList;

import com.bank.services.TaxCalculator;
import com.bank.types.Operation;
import com.bank.types.Tax;

public class TaxCalculatorImpl implements TaxCalculator {

  public ArrayList<Tax> calculate(ArrayList<Operation> data) {

    Integer amount = 0;
    Double avg = 0d;
    Double loss = 0d;
    ArrayList<Tax> response = new ArrayList<Tax>();

    for (Operation op : data) {
      if (op.getOperation().equals("buy")) {
        avg = ((amount * avg) + (op.getQuantity() * op.getUnitCost())) / (amount + op.getQuantity());
        amount += op.getQuantity();
        response.add(new Tax(0.00));

      } else {
        Double sale = (op.getUnitCost() * op.getQuantity());
        Double profit = sale - (avg * op.getQuantity());
        profit += loss;
        amount -= op.getQuantity();

        if (profit > 0) {
          if (sale > 20000) {
            response.add(new Tax(profit * (20d / 100d)));
          } else {
            response.add(new Tax(0.00));
          }
        } else {
          loss = profit;
          response.add(new Tax(0.00));
        }
        ;
      }
      if (amount == 0)
        avg = 0d;
    }
    ;
    return response;
  }
}
