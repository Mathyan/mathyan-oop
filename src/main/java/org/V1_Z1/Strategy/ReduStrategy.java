package org.V1_Z1.Strategy;

public class ReduStrategy implements CalculationStrategy {
  @Override
  public float calculation(float a, float b) throws UndivisibleException {
    return a - b;
  }

  @Override
  public String toString() {
    return "Oduzimanje";
  }

  @Override
  public String znakOperacije() {
    return "-";
  }
}
