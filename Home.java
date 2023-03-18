import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Home extends JFrame implements ActionListener {
    private JButton MorseCodeConverter;
    private JButton UnitConverter;
    private JLabel lbl, lbl2;
    private JTextArea lblGroep;

    public Home() {
        setTitle("Home Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 260);
        setLocation(450, 200);

        // create and add Welkom label
        JPanel topPanel = new JPanel();
        lbl = new JLabel("Welkom bij de verschillende converters. Kies een converter aan.");
        topPanel.add(lbl);
        add(topPanel, BorderLayout.NORTH);

        // create and add buttons
        JPanel buttonPanel = new JPanel();
        MorseCodeConverter = new JButton("Morse Code Converter");
        UnitConverter = new JButton("Unit Converter");
        buttonPanel.add(MorseCodeConverter);
        buttonPanel.add(UnitConverter);
        add(buttonPanel, BorderLayout.CENTER);
        MorseCodeConverter.addActionListener(this);
        UnitConverter.addActionListener(this);

        // create and add groepsleden label
        JPanel bottomPanel = new JPanel(new GridLayout(0, 1));
        lblGroep = new JTextArea(Arrays.stream(new MorseCodeConverter().groepsleden())
                .collect(Collectors.joining("\n")));
        lblGroep.setLineWrap(true);
        lblGroep.setWrapStyleWord(true);
        lblGroep.setEditable(false);
        lblGroep.setFocusable(false);
        lblGroep.setFont(new Font("Arial", Font.PLAIN, 12));
        bottomPanel.add(new JLabel("De groepsleden zijn:"));
        bottomPanel.add(lblGroep);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // werking van de buttons
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == MorseCodeConverter) {
            //maak de home frame uit
            dispose();
            MorseCodeConverter morse = new MorseCodeConverter();
            morse.MorseCodeConverter();
        } else if (event.getSource() == UnitConverter) {
            //maak de home frame uit
            dispose();
            UnitConverter unit = new UnitConverter();
        }
    }

    public static void main(String[] args) {
        Home converter = new Home();
    }
}
