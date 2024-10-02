package org.V1_Z1;

import org.V1_Z1.Events.CalculationEvent;
import org.V1_Z1.Events.CalculationListener;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
  private UnosPanel unosPanel;
  private RezultatPanel rezultatPanel;

  MainFrame() {
    super("Calculator");
    // size of the window
    setSize(400, 300);
    setLayout(new BorderLayout());
    unosPanel = new UnosPanel();
    rezultatPanel = new RezultatPanel();
    add(unosPanel, BorderLayout.WEST);
    add(rezultatPanel, BorderLayout.EAST);
    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    unosPanel.plugInListener(new CalculationListener() {
      @Override
      public void calculationPerformed(CalculationEvent e) {
        rezultatPanel.passTheEvent(e);
      }
    });
  }

}
