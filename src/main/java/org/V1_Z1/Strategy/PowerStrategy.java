package org.V1_Z1.Strategy;

public class PowerStrategy implements CalculationStrategy {
  @Override
  public float calculation(float a, float b) throws UndivisibleException {
    return (float) Math.pow(a, (int) b);
  }

  @Override
  public String toString() {
    return "Potenciranje";
  }

  @Override
  public String znakOperacije() {
    return "^";
  }
}
