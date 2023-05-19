package com.nubank.mapper;

import java.util.ArrayList;
import com.nubank.types.Operation;
import com.nubank.types.Tax;

public interface JsonMapper {
  ArrayList<Operation> toOperations(String data);

  String toString(ArrayList<Tax> data);
}
