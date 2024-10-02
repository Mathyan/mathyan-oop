package org.V1_Z1.Events;

import org.V1_Z1.Strategy.CalculationStrategy;

import java.awt.*;

public class CalculationEvent extends AWTEvent {
  public static final int CALCULATION_PERFORMED = AWTEvent.RESERVED_ID_MAX + 1;
  CalculationStrategy strategy;
  float first;
  float second;

  public CalculationEvent(Object source, CalculationStrategy strategy, float first, float second) {
    super(source, CALCULATION_PERFORMED);
    this.strategy = strategy;
    this.first = first;
    this.second = second;
  }

  public CalculationStrategy getStrategy() {
    return strategy;
  }

  public float getFirst() {
    return first;
  }

  public float getSecond() {
    return second;
  }

}
