package com.bank.mapper;

import java.util.ArrayList;

import com.bank.types.Operation;
import com.bank.types.Tax;

public interface JsonMapper {
  ArrayList<Operation> toOperations(String data);

  String toString(ArrayList<Tax> data);
}
