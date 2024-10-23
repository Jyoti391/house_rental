package rental;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

    private Container background;

    public HomePage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500, 400);
        setTitle("Home Page");
        setResizable(false);
        setLocationRelativeTo(null);
        initializeComponents();
    }

    void initializeComponents() {
        background = getContentPane();
        background.setLayout(null);
        background.setBackground(new Color(240, 240, 240)); // Light gray background

        // Title
        JLabel titleLabel = new JLabel("Choose a House Type");
        titleLabel.setBounds(100, 30, 300, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(50, 50, 150)); // Dark blue color
        background.add(titleLabel);

        // Residential Area House Button
        JButton residentialButton = new JButton("Residential Area House");
        residentialButton.setBounds(100, 100, 300, 40);
        residentialButton.setFont(new Font("Arial", Font.PLAIN, 18));
        residentialButton.setBackground(new Color(50, 150, 50)); // Green background
        residentialButton.setForeground(Color.WHITE);
        residentialButton.setBorder(BorderFactory.createEmptyBorder());
        residentialButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        residentialButton.addActionListener(this::openResidentialArea);

        // Commercial Area House Button
        JButton commercialButton = new JButton("Commercial Area House");
        commercialButton.setBounds(100, 160, 300, 40);
        commercialButton.setFont(new Font("Arial", Font.PLAIN, 18));
        commercialButton.setBackground(new Color(50, 150, 150)); // Teal background
        commercialButton.setForeground(Color.WHITE);
        commercialButton.setBorder(BorderFactory.createEmptyBorder());
        commercialButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        commercialButton.addActionListener(this::openCommercialArea);

        // Tourist Area House Button
        JButton touristButton = new JButton("Tourist Area House");
        touristButton.setBounds(100, 220, 300, 40);
        touristButton.setFont(new Font("Arial", Font.PLAIN, 18));
        touristButton.setBackground(new Color(150, 50, 150)); // Purple background
        touristButton.setForeground(Color.WHITE);
        touristButton.setBorder(BorderFactory.createEmptyBorder());
        touristButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        touristButton.addActionListener(this::openTouristArea);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(100, 280, 300, 40);
        exitButton.setFont(new Font("Arial", Font.BOLD, 18));
        exitButton.setBackground(new Color(255, 50, 50)); // Red background
        exitButton.setForeground(Color.WHITE);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exitButton.addActionListener(e -> System.exit(0)); // Exit the program on click

        // Add buttons to background
        background.add(residentialButton);
        background.add(commercialButton);
        background.add(touristButton);
        background.add(exitButton); // Add the Exit button to the interface
    }

    private void openResidentialArea(ActionEvent e) {
        new ResidentialArea().setVisible(true);
        dispose(); // Close the HomePage window
    }

    private void openCommercialArea(ActionEvent e) {
        new CommercialArea().setVisible(true);
        dispose(); // Close the HomePage window
    }

    private void openTouristArea(ActionEvent e) {
        new TouristArea().setVisible(true);
        dispose(); // Close the HomePage window
    }

    public static void main(String[] args) {
        new HomePage().setVisible(true);
    }
}
