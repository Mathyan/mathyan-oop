package org.V1_Z1.Strategy;

public class AdditionStrategy implements CalculationStrategy {
  @Override
  public float calculation(float prvi, float drugi) {
    return prvi + drugi;
  }

  @Override
  public String toString() {
    return "Zbrajanje";
  }

  @Override
  public String znakOperacije() {
    return "+";
  }

}
