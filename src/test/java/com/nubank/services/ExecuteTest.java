package com.nubank.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nubank.mapper.JsonMapper;
import com.nubank.services.impl.ExecuteImpl;
import com.nubank.types.Operation;
import com.nubank.types.Tax;

public class ExecuteTest {

  TaxCalculator taxCalculator;
  JsonMapper jsonMapper;

  private ArrayList<Operation> operations = new ArrayList<Operation>();
  private ArrayList<Tax> taxes = new ArrayList<Tax>();

  Execute exec;

  @BeforeEach
  public void setData() {
    taxCalculator = Mockito.mock(TaxCalculator.class);
    jsonMapper = Mockito.mock(JsonMapper.class);

    exec = new ExecuteImpl(jsonMapper, taxCalculator);
    operations.add(new Operation("buy", 10.00, 100));
    operations.add(new Operation("sell", 20.00, 5000));
    operations.add(new Operation("sell", 5.00, 5000));

    taxes.add(new Tax(0.00));
    taxes.add(new Tax(10000.00));
    taxes.add(new Tax(0.00));
  }

  @Test
  public void shouldExecuteSuccess() {
    StringBuilder readLine = new StringBuilder();
    String str = "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000},{\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 5000},{\"operation\":\"sell\", \"unit-cost\":5.00, \"quantity\": 5000}]";
    readLine.append(str);
    readLine.append("\n");
    readLine.append("");
    readLine.append("\n");
    ByteArrayInputStream bais = new ByteArrayInputStream(readLine.toString().getBytes());
    System.setIn(bais);

    Mockito.when(jsonMapper.toOperations(any())).thenReturn(operations);
    Mockito.when(taxCalculator.calculate(any())).thenReturn(taxes);

    exec.execute();

    Mockito.verify(jsonMapper, times(1)).toOperations(str);
    Mockito.verify(jsonMapper, times(1)).toString(taxes);
    Mockito.verify(taxCalculator, times(1)).calculate(operations);
  }

  @Test
  public void shouldExecuteSuccessWithoutLines() {
    StringBuilder readLine = new StringBuilder();
    readLine.append("");
    readLine.append("\n");
    ByteArrayInputStream bais = new ByteArrayInputStream(readLine.toString().getBytes());
    System.setIn(bais);

    Mockito.when(jsonMapper.toOperations(any())).thenReturn(operations);
    Mockito.when(taxCalculator.calculate(any())).thenReturn(taxes);

    exec.execute();

    Mockito.verifyNoInteractions(jsonMapper);
    Mockito.verifyNoInteractions(taxCalculator);
  }
}
