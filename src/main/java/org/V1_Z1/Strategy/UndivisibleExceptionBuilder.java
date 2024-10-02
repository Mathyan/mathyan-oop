package org.V1_Z1.Strategy;

public class UndivisibleExceptionBuilder {
  private String message;

  public UndivisibleExceptionBuilder setMessage(String message) {
    this.message = message;
    return this;
  }

  public UndivisibleException createUndivisibleException() {
    return new UndivisibleException(message);
  }
}
