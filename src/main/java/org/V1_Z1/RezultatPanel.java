package org.V1_Z1;

import org.V1_Z1.Events.CalculationEvent;
import org.V1_Z1.Strategy.UndivisibleException;

import javax.swing.*;

public class RezultatPanel extends JPanel {
  private JLabel rezultatLabel;
  private JLabel lastResultLabel;
  private JTextField lastResultTextField;
  private JTextArea rezultatArea;
  private JScrollPane scrollPane;

  RezultatPanel() {
    initiateComp();
    placeComp();
  }

  private void initiateComp() {
    rezultatLabel = new JLabel("Rezultat");
    lastResultLabel = new JLabel("Posljednji rezultat");
    lastResultTextField = new JTextField(10);
    lastResultTextField.setEditable(false);
    rezultatArea = new JTextArea(10, 20);
    rezultatArea.setEditable(false);
    scrollPane = new JScrollPane(rezultatArea);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
  }

  private void placeComp() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    add(lastResultLabel);
    add(lastResultTextField);
    add(rezultatLabel);
    add(scrollPane);
  }

  public void passTheEvent(CalculationEvent e) {
    updateData(dataBuilder(e));
  }

  private String dataBuilder(CalculationEvent e) {
    return e.getFirst() + " " + e.getStrategy().znakOperacije() + " " + e.getSecond() + " = " + calculationPerformed(e)
        + "\n";
  }

  private void updateData(String data) {
    rezultatArea.append(data);
    lastResultTextField.setText(data);
  }

  private String calculationPerformed(CalculationEvent e) {
    String calcu = "";
    try {
      calcu = String.valueOf(e.getStrategy().calculation(e.getFirst(), e.getSecond()));
    } catch (UndivisibleException undivisibleException) {
      calcu = "Neodredjen rezultat";
    }
    return calcu;
  }
}
