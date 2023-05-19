package com.nubank;

import com.nubank.mapper.JsonMapper;
import com.nubank.mapper.impl.JsonMapperImpl;
import com.nubank.services.Execute;
import com.nubank.services.TaxCalculator;
import com.nubank.services.impl.ExecuteImpl;
import com.nubank.services.impl.TaxCalculatorImpl;

public class App {
    public static void main(String[] args) {
        JsonMapper mapper = new JsonMapperImpl();
        TaxCalculator taxCalculator = new TaxCalculatorImpl();
        Execute exec = new ExecuteImpl(mapper, taxCalculator);
        exec.execute();
    }
}