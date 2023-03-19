import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Assert;

class UnitConverterTest extends UnitConverter {

    UnitConverter unitConverter = new UnitConverter();

    @Test
    public void testWindowCreation() {
        assertEquals("Unit Converter", unitConverter.frame.getTitle());

        assertEquals(3, unitConverter.frame.getContentPane().

                getComponentCount());
        Assert.assertTrue(unitConverter.frame.isVisible());

        assertEquals(JFrame.EXIT_ON_CLOSE, unitConverter.frame.getDefaultCloseOperation());
    }

    @Test
    public void testConvertCentimetersToMeters() {
        UnitConverter converter = new UnitConverter();
        double result = converter.convert(1000.0, "Centimeters", "Meters");
        assertEquals(10.0, result, 0.01);
    }

    @Test
    public void testConvertMetersToCentimeters() {
        UnitConverter converter = new UnitConverter();
        double result = converter.convert(1.0, "Meters", "Centimeters");
        assertEquals(100.0, result, 0.01);
    }

    @Test
    public void testConvertKilometersToCentimeters() {
        UnitConverter converter = new UnitConverter();
        double result = converter.convert(1.0, "Kilometers", "Centimeters");
        assertEquals(100000.0, result, 0.01);
    }

    @Test
    public void testConvertInvalidUnit() {
        UnitConverter converter = new UnitConverter();
        double result = converter.convert(1.0, "InvalidUnit", "Meters");
        assertEquals(0.0, result, 0.01);
    }

    @Test
    public void testConvertButton() {
        UnitConverter unitConverter = new UnitConverter();
        unitConverter.fromField.setText("1000");
        unitConverter.fromComboBox.setSelectedItem("Centimeters");
        unitConverter.toComboBox.setSelectedItem("Meters");
        simulateButtonClick(unitConverter.convertButton);
        assertEquals("10.0", unitConverter.toField.getText());
        unitConverter.fromField.setText("1000");
        unitConverter.fromComboBox.setSelectedItem("Meters");
        unitConverter.toComboBox.setSelectedItem("Kilometers");
        simulateButtonClick(unitConverter.convertButton);
        assertEquals("1.0", unitConverter.toField.getText());

    }

    // simulate button click
    private void simulateButtonClick(JButton button) {
        for (ActionListener listener : button.getActionListeners()) {
            listener.actionPerformed(new ActionEvent(button, ActionEvent.ACTION_PERFORMED, null));
        }
    }

}