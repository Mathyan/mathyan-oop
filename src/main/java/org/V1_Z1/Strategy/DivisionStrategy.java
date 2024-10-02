package org.V1_Z1.Strategy;

public class DivisionStrategy implements CalculationStrategy {
  @Override
  public float calculation(float brojnik, float nazivnik) throws UndivisibleException {
    if (isZero(nazivnik)) {
      throw new UndivisibleExceptionBuilder().setMessage("Division by zero").createUndivisibleException();
    }
    return brojnik / nazivnik;
  }

  private boolean isZero(float b) {
    return b == 0;
  }

  @Override
  public String toString() {
    return "Dijeljenje";
  }

  @Override
  public String znakOperacije() {
    return "/";
  }
}
