package com.bank.services;

import java.util.ArrayList;

import com.bank.types.Operation;
import com.bank.types.Tax;

public interface TaxCalculator {

  ArrayList<Tax> calculate(ArrayList<Operation> data);
}
