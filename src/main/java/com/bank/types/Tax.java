package com.bank.types;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tax {
  private Double tax;

  public Tax() {
  };

  public Tax(Double tax) {
    BigDecimal bd = new BigDecimal(tax).setScale(2, RoundingMode.FLOOR);
    this.tax = bd.doubleValue();
  }

  public Double getTax() {
    return tax;
  }

  public void setTax(Double tax) {
    BigDecimal db = new BigDecimal(tax).setScale(2, RoundingMode.FLOOR);
    this.tax = db.doubleValue();
  }
}
