import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MorseCodeConverter extends JFrame implements Requirements {
    private JFrame frame;
    private JPanel inputPanel, outputPanel, buttonPanel;
    private JTextArea inputArea, outputArea;
    private JButton convertButton, swapButton, clearButton, homeButton;

    public MorseCodeConverter() {

        //Create the main frame
        frame = new JFrame("Morse Code Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        // Create the input panel
        inputPanel = new JPanel(new BorderLayout());
        JLabel inputLabel = new JLabel("Input:");
        inputArea = new JTextArea(5, 20);
        JScrollPane inputScrollPane = new JScrollPane(inputArea);
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(inputScrollPane, BorderLayout.CENTER);

        // Create the output panel
        outputPanel = new JPanel(new BorderLayout());
        JLabel outputLabel = new JLabel("Output:");
        outputArea = new JTextArea(5, 20);
        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        outputPanel.add(outputLabel, BorderLayout.NORTH);
        outputPanel.add(outputScrollPane, BorderLayout.CENTER);

        // Create the button panel
        buttonPanel = new JPanel(new FlowLayout());
        convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });
        swapButton = new JButton("Swap");
        swapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                swap();
            }
        });
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        homeButton = new JButton("Home");
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
               home home = new home();
            }
        });

        buttonPanel.add(convertButton);
        buttonPanel.add(swapButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(homeButton);


        // Add the panels to the frame
        frame.add(inputPanel, BorderLayout.WEST);
        frame.add(outputPanel, BorderLayout.EAST);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(homeButton, BorderLayout.NORTH);

        // Show the frame
        frame.setVisible(true);
    }

    @Override
    public String[] groepsleden() {
        return new String[]{"Member 1", "Member 2", "Member 3"};
    }

    @Override
    public String abs2morse(char inputChar) {
        switch (Character.toLowerCase(inputChar)) {
            case 'a':
                return ".-";
            case 'b':
                return "-...";
            case 'c':
                return "-.-.";
            case 'd':
                return "-..";
            case 'e':
                return ".";
            case 'f':
                return "..-.";
            case 'g':
                return "--.";
            case 'h':
                return "....";
            case 'i':
                return "..";
            case 'j':
                return ".---";
            case 'k':
                return "-.-";
            case 'l':
                return ".-..";
            case 'm':
                return "--";
            case 'n':
                return "-.";
            case 'o':
                return "---";
            case 'p':
                return ".--.";
            case 'q':
                return "--.-";
            case 'r':
                return ".-.";
            case 's':
                return "...";
            case 't':
                return "-";
            case 'u':
                return "..-";
            case 'v':
                return "...-";
            case 'w':
                return ".--";
            case 'x':
                return "-..-";
            case 'y':
                return "-.--";
            case 'z':
                return "--";
        }
        return null;
    }

    @Override
    public char morse2abc(String inputString) {
        switch (inputString) {
            case ".-":
                return 'a';
            case "-...":
                return 'b';
            case "-.-.":
                return 'c';
            case "-..":
                return 'd';
            case ".":
                return 'e';
            case "..-.":
                return 'f';
            case "--.":
                return 'g';
            case "....":
                return 'h';
            case "..":
                return 'i';
            case ".---":
                return 'j';
            case "-.-":
                return 'k';
            case ".-..":
                return 'l';
            case "--":
                return 'm';
            case "-.":
                return 'n';
            case "---":
                return 'o';
            case ".--.":
                return 'p';
            case "--.-":
                return 'q';
            case ".-.":
                return 'r';
            case "...":
                return 's';
            case "-":
                return 't';
            case "..-":
                return 'u';
            case "...-":
                return 'v';
            case ".--":
                return 'w';
            case "-..-":
                return 'x';
            case "-.--":
                return 'y';
            case "--..":
                return 'z';
            default:
                return ' ';
        }
    }

    @Override
    public void convert() {
        String input = inputArea.getText();
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ') {
                output += " ";
            } else {
                output += abs2morse(c) + " ";
            }
        }
        outputArea.setText(output);
    }



    @Override
    public void swap() {
        String input = inputArea.getText();
        String output = outputArea.getText();
        inputArea.setText(output);
        outputArea.setText(input);
    }

    @Override
    public void clear() {
        inputArea.setText("");
        outputArea.setText("");
    }

    @Override
    public String exampleMorseCode() {
        return "-.-- --- ..-";
    }

    @Override
    public String exampleString() {
        return "you";
    }

    @Override
    public String explain() {
        return "This program allows you to convert text to Morse code and vice versa.";
    }

//    public static void main(String[] args) {
//        new MorseCodeConverter();
//    }
}