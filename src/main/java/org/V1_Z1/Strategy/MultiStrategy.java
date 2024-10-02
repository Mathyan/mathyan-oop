package org.V1_Z1.Strategy;

public class MultiStrategy implements CalculationStrategy {
  @Override
  public float calculation(float a, float b) throws UndivisibleException {
    return a * b;
  }

  @Override
  public String toString() {
    return "Mnozenje";
  }

  @Override
  public String znakOperacije() {
    return "*";
  }
}
