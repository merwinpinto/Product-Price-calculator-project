import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductRateCalculator extends JFrame implements ActionListener {
    private JTextField costField, oldWeightField, newWeightField, resultField;
    private JComboBox<String> typeComboBox;
    private JButton calculateButton;

    public ProductRateCalculator() {
        setTitle("Product Rate Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Product Rate Calculator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        JLabel typeLabel = new JLabel("Choose type (g/ml):");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(typeLabel, gbc);

        typeComboBox = new JComboBox<>(new String[]{"g", "ml"});
        typeComboBox.setSelectedIndex(0);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(typeComboBox, gbc);

        JLabel costLabel = new JLabel("Actual product cost:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(costLabel, gbc);

        costField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(costField, gbc);

        JLabel oldWeightLabel = new JLabel("Actual product weight:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(oldWeightLabel, gbc);

        oldWeightField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(oldWeightField, gbc);

        JLabel newWeightLabel = new JLabel("New product weight:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(newWeightLabel, gbc);

        newWeightField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(newWeightField, gbc);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(calculateButton, gbc);

        JLabel resultLabel = new JLabel("New price:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(resultLabel, gbc);

        resultField = new JTextField(10);
        resultField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(resultField, gbc);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        float cost = Float.parseFloat(costField.getText());
        float oldWeight = Float.parseFloat(oldWeightField.getText());
        float newWeight = Float.parseFloat(newWeightField.getText());
        float newAmount = (cost * newWeight) / oldWeight;
        resultField.setText(String.valueOf(newAmount));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductRateCalculator calculator = new ProductRateCalculator();
            calculator.setVisible(true);
        });
    }
}