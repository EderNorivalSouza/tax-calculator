package com.nubank.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nubank.mapper.impl.JsonMapperImpl;
import com.nubank.types.Operation;
import com.nubank.types.Tax;

public class JsonMapperTest {

  private ArrayList<Operation> operations = new ArrayList<Operation>();
  private ArrayList<Tax> taxes = new ArrayList<Tax>();
  private JsonMapper jsonMapper = new JsonMapperImpl();

  @Test
  public void shouldToOperationsSuccess() throws JsonMappingException, JsonProcessingException {
    operations.add(new Operation("buy", 10.00, 100));
    operations.add(new Operation("sell", 15.00, 50));
    operations.add(new Operation("sell", 15.00, 50));
    String request = "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 100},{\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 50},{\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 50}]";
    ArrayList<Operation> response = jsonMapper.toOperations(request);

    assertEquals(operations.get(0).getOperation(), response.get(0).getOperation());
    assertEquals(operations.get(0).getQuantity(), response.get(0).getQuantity());
    assertEquals(operations.get(0).getUnitCost(), response.get(0).getUnitCost());
  }

  @Test
  public void shouldToStringSuccess() {
    taxes.add(new Tax(0.00));
    taxes.add(new Tax(80000.00));
    taxes.add(new Tax(0.00));
    taxes.add(new Tax(60000.00));
    String ref = "[{\"tax\":0.0},{\"tax\":80000.0},{\"tax\":0.0},{\"tax\":60000.0}]";
    String response = jsonMapper.toString(taxes);
    assertEquals(response, ref);
  }

}
