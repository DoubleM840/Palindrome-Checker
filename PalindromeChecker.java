//package com.mycompany.palindromechecker;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Group A
 */
public class PalindromeChecker {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Palindrome Checker");
        frame.setSize(500, 400);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create a label
        JLabel label = new JLabel("Enter a number:");
        label.setBounds(50, 30, 100, 30);
        frame.add(label);

        // Create a text field
        JTextField textField = new JTextField();
        textField.setBounds(160, 30, 150, 30);
        frame.add(textField);

        // Create a button
        JButton button = new JButton("Check");
        button.setBounds(150, 80, 100, 30);
        frame.add(button);

        // Create a label to display the result
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(50, 120, 300, 30);
        frame.add(resultLabel);

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                if (input.isEmpty()) {
                    resultLabel.setText("Please enter a number.");
                    return;
                }

                try {
                    int number = Integer.parseInt(input);
                    if (isPalindrome(number)) {
                        resultLabel.setText("The number " + number + " is a palindrome.");
                    } else {
                        resultLabel.setText("The number " + number + " is not a palindrome.");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Please enter a valid number.");
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reverseNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            reverseNumber = reverseNumber * 10 + digit;
            number /= 10;
        }

        return originalNumber == reverseNumber;
    }
}
