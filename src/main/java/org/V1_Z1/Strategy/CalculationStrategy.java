package org.V1_Z1.Strategy;

public interface CalculationStrategy {
  float calculation(float a, float b) throws UndivisibleException;

  @Override
  String toString();

  String znakOperacije();

}
