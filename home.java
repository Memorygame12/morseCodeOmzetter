import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;


public class home extends JFrame implements ActionListener {
    private JButton MorseCodeConverter = new JButton("Play");
    private JButton UnitConverter = new JButton("Exit");
    private JPanel pane = new JPanel();
    private JLabel lbl;

    public home() {
        super();
        JPanel pane = new JPanel();
        setTitle("Home Screen");
        JFrame frame = new JFrame("");

        setVisible(true);
        setSize(380, 260);
        setLocation(450, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());
        MorseCodeConverter = new JButton("MorseCodeConverter");
        UnitConverter = new JButton("UnitConverter");
        lbl = new JLabel("Welkom bij de verschillende converters");

        add(lbl);
        add(MorseCodeConverter, BorderLayout.CENTER);
        MorseCodeConverter.addActionListener(this);
        add(UnitConverter, BorderLayout.CENTER);
        UnitConverter.addActionListener(this);
    }


    // werking van de buttons
    @Override
    public void actionPerformed(ActionEvent event) {
        // TODO Auto-generated method stub



        if (event.getSource() == MorseCodeConverter) {
            //maak de home frame uit
           dispose();
            MorseCodeConverter morse = new MorseCodeConverter();
        } else if (event.getSource() == UnitConverter) {
            //maak de home frame uit
            dispose();
            UnitConverter unit = new UnitConverter();
        }
    }

    public static void main(String[] args) {
      home converter = new home();
   }
}