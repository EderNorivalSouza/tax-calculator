package com.nubank.services;

import java.util.ArrayList;

import com.nubank.types.Operation;
import com.nubank.types.Tax;

public interface TaxCalculator {

  ArrayList<Tax> calculate(ArrayList<Operation> data);
}
