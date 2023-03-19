import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionsMorseConvert extends JFrame {

    private JFrame frame;
    private JButton homeButton;

    public InstructionsMorseConvert() {

        MorseCodeConverter Instruct = new MorseCodeConverter();
        String output = Instruct.explain();
        JLabel myLabel = new JLabel(output);

        frame = new JFrame("Morse Code Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JLabel title = new JLabel("Morse Code Converter Instructions");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setHorizontalAlignment(JLabel.CENTER);
        frame.add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(myLabel, BorderLayout.CENTER);

        JLabel instructionLabel = new JLabel("Instructions:");
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 14));
        instructionLabel.setHorizontalAlignment(JLabel.LEFT);
        panel.add(instructionLabel, BorderLayout.NORTH);

        JTextArea instructionArea = new JTextArea(output);
        instructionArea.setLineWrap(true);
        instructionArea.setWrapStyleWord(true);
        instructionArea.setEditable(false);
        instructionArea.setFocusable(false);
        instructionArea.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(instructionArea, BorderLayout.CENTER);

        frame.add(panel, BorderLayout.CENTER);

        homeButton = new JButton("Go back to Morse code converter");
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MorseCodeConverter Morse = new MorseCodeConverter();
                Morse.MorseCodeConverter();

            }
        });

        frame.add(homeButton, BorderLayout.SOUTH);

        frame.setVisible(true);

    }

}
