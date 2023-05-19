package com.nubank.mapper.impl;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nubank.mapper.JsonMapper;
import com.nubank.types.Operation;
import com.nubank.types.Tax;

public class JsonMapperImpl implements JsonMapper {
  private ObjectMapper mapper = new ObjectMapper();

  public ArrayList<Operation> toOperations(String data) {

    ArrayList<Operation> list = new ArrayList<Operation>();
    try {
      list = mapper.readValue(data, new TypeReference<ArrayList<Operation>>() {
      });
    } catch (JsonProcessingException e) {
      throw new Error(e);
    }
    return list;
  }

  public String toString(ArrayList<Tax> data) {
    try {
      return mapper.writeValueAsString(data);
    } catch (JsonProcessingException e) {
      throw new Error(e);
    }
  }
}
