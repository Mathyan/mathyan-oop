package org.V1_Z1.Events;

import java.util.EventListener;

public interface CalculationListener extends EventListener {
  void calculationPerformed(CalculationEvent e);
}
