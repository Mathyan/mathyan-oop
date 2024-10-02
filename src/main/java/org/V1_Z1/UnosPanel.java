package org.V1_Z1;

import org.V1_Z1.Events.CalculationEvent;
import org.V1_Z1.Events.CalculationListener;
import org.V1_Z1.Strategy.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class UnosPanel extends JPanel {
  private JLabel prviLabel;
  private JLabel drugiLabel;
  private JTextField prviTextField;
  private JTextField drugiTextField;
  private JLabel operacijaLabel;
  private final ArrayList<CalculationStrategy> strategije = new ArrayList<>(Arrays.asList(new AdditionStrategy(),
      new ReduStrategy(), new MultiStrategy(), new DivisionStrategy(), new PowerStrategy()));
  private final JComboBox<CalculationStrategy> operacijaComboBox = new JComboBox<>(
      strategije.toArray(new CalculationStrategy[0]));
  private JButton izracunajButton;

  public UnosPanel() {
    initiateComp();
    placeComp();
  }

  private void initiateComp() {
    Border innerBorder = BorderFactory.createTitledBorder("Programmer data");
    Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    prviLabel = new JLabel("Prvi broj");
    drugiLabel = new JLabel("Drugi broj");
    prviTextField = new JTextField(10);
    drugiTextField = new JTextField(10);
    operacijaLabel = new JLabel("Izaberite matematičku operaciju");
    izracunajButton = new JButton("Izračunaj");
  }

  private void placeComp() {
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.fill = GridBagConstraints.NONE;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.LINE_END;
    add(prviLabel, gbc);
    gbc.gridx++;
    gbc.anchor = GridBagConstraints.LINE_START;
    add(prviTextField, gbc);
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.anchor = GridBagConstraints.LINE_END;
    add(drugiLabel, gbc);
    gbc.gridx++;
    gbc.anchor = GridBagConstraints.LINE_START;
    add(drugiTextField, gbc);
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.anchor = GridBagConstraints.LINE_END;
    add(operacijaLabel, gbc);
    gbc.gridx++;
    gbc.anchor = GridBagConstraints.LINE_START;
    add(operacijaComboBox, gbc);
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.anchor = GridBagConstraints.LINE_END;
    add(izracunajButton, gbc);
  }

  public void plugInListener(CalculationListener calculationListener) {
    izracunajButton.addActionListener(e -> {
      if (prviTextField.getText().isEmpty() || drugiTextField.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Unesite brojeve", "Error", JOptionPane.ERROR_MESSAGE);
        return;
      }
      float prviBroj = Float.parseFloat(prviTextField.getText());
      float drugiBroj = Float.parseFloat(drugiTextField.getText());
      CalculationEvent calculationEvent = new CalculationEvent(this,
          (CalculationStrategy) operacijaComboBox.getSelectedItem(), prviBroj, drugiBroj);
      calculationListener.calculationPerformed(calculationEvent);
    });
  }

}
