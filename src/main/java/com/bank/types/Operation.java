package com.bank.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Operation {

  @JsonProperty
  private String operation;
  @JsonProperty("unit-cost")
  private Double unitCost;
  @JsonProperty
  private Integer quantity;

  public Operation() {
  };

  public Operation(String operation, Double unitCost, Integer quantity) {
    this.operation = operation;
    this.unitCost = unitCost;
    this.quantity = quantity;
  }

  public String getOperation() {
    return operation;
  }

  public Double getUnitCost() {
    return unitCost;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public void setUnitCost(Double unitCost) {
    this.unitCost = unitCost;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "operation: " + this.getOperation()
        + " unit-cost: " + this.getUnitCost()
        + " quantity: " + this.getQuantity();
  }
}
