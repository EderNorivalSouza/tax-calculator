package com.bank;

import com.bank.mapper.JsonMapper;
import com.bank.mapper.impl.JsonMapperImpl;
import com.bank.services.Execute;
import com.bank.services.TaxCalculator;
import com.bank.services.impl.ExecuteImpl;
import com.bank.services.impl.TaxCalculatorImpl;

public class App {
    public static void main(String[] args) {
        JsonMapper mapper = new JsonMapperImpl();
        TaxCalculator taxCalculator = new TaxCalculatorImpl();
        Execute exec = new ExecuteImpl(mapper, taxCalculator);
        exec.execute();
    }
}