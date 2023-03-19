import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UnitConverter extends JFrame {
    JFrame frame;
    JComboBox<String> fromComboBox;
    JComboBox<String> toComboBox;
    JTextField fromField;
    JTextField toField;
    JButton convertButton;
    private JButton homeButton;


    //create frame and buttons
    public UnitConverter() {
        frame = new JFrame("Unit Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));
        fromComboBox = new JComboBox<String>(new String[]{"Centimeters", "Meters", "Kilometers"});
        fromField = new JTextField();
        toComboBox = new JComboBox<String>(new String[]{"Centimeters", "Meters", "Kilometers"});
        toField = new JTextField();
        homeButton = new JButton("Home");

        convertButton = new JButton("Convert");
        frame.add(new JLabel("From:"));
        frame.add(fromComboBox);
        frame.add(new JLabel("Value:"));
        frame.add(fromField);
        frame.add(new JLabel("To:"));
        frame.add(toComboBox);
        frame.add(new JLabel("Value:"));
        frame.add(toField);
        frame.add(new JLabel(""));
        frame.add(convertButton);
        frame.add(homeButton);



        //function of the buttons

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(fromField.getText());
                String fromUnit = (String) fromComboBox.getSelectedItem();
                String toUnit = (String) toComboBox.getSelectedItem();
                double convertedValue = convert(value, fromUnit, toUnit);
                toField.setText(Double.toString(convertedValue));


            }
        });

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Home();

            }

        });


        frame.pack();
        frame.setVisible(true);
    }

    double convert(double value, String fromUnit, String toUnit) {
        double result;
        switch (fromUnit) {
            case "Centimeters":
                if (toUnit.equals("Meters")) {
                    result = value / 100.0;
                } else if (toUnit.equals("Kilometers")) {
                    result = value / 100000.0;
                } else {
                    result = value;
                }
                break;
            case "Meters":
                if (toUnit.equals("Centimeters")) {
                    result = value * 100.0;
                } else if (toUnit.equals("Kilometers")) {
                    result = value / 1000.0;
                } else {
                    result = value;
                }
                break;
            case "Kilometers":
                if (toUnit.equals("Centimeters")) {
                    result = value * 100000.0;
                } else if (toUnit.equals("Meters")) {
                    result = value * 1000.0;
                } else {
                    result = value;
                }
                break;
            default:
                result = 0;
        }
        return result;
    }

//    public static void main(String[] args) {
//        UnitConverter converter = new UnitConverter();
//    }
}