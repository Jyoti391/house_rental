package rental;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CommercialArea extends JFrame {

    private Container background;
    private JButton submitButton, backButton;
    private JComboBox<String> spaceTypeComboBox;
    private JComboBox<String> roomComboBox;
    private JComboBox<String> durationComboBox;

    public CommercialArea() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 600); // Increased frame size
        setTitle("Commercial Area House Renting");
        setResizable(false);
        setLocationRelativeTo(null);
        initializeComponents();
    }

    void initializeComponents() {
        background = getContentPane();
        background.setLayout(null);
        background.setBackground(new Color(240, 248, 255)); // Alice blue background

        // Title Label
        JLabel titleLabel = new JLabel("Commercial Space Renting");
        titleLabel.setBounds(250, 30, 400, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 102, 204)); // Deep blue color
        background.add(titleLabel);

        // Space Type Panel
        JPanel spaceTypePanel = new JPanel();
        spaceTypePanel.setBounds(100, 100, 300, 200);
        spaceTypePanel.setBorder(BorderFactory.createTitledBorder("Select Space Type"));
        spaceTypePanel.setLayout(new FlowLayout());

        String[] spaceOptions = {"Office", "Shop", "Warehouse"};
        spaceTypeComboBox = new JComboBox<>(spaceOptions);
        spaceTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        spaceTypePanel.add(spaceTypeComboBox);
        background.add(spaceTypePanel);

        // Room Number Panel
        JPanel roomPanel = new JPanel();
        roomPanel.setBounds(400, 100, 300, 200);
        roomPanel.setBorder(BorderFactory.createTitledBorder("Select Room Number"));
        roomPanel.setLayout(new FlowLayout());

        String[] roomOptions = {"1 Room", "2 Rooms", "3 Rooms"};
        roomComboBox = new JComboBox<>(roomOptions);
        roomComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        roomPanel.add(roomComboBox);
        background.add(roomPanel);

        // Rental Duration Panel
        JPanel durationPanel = new JPanel();
        durationPanel.setBounds(100, 320, 600, 100);
        durationPanel.setBorder(BorderFactory.createTitledBorder("Select Rental Duration"));
        durationPanel.setLayout(new FlowLayout());

        String[] durationOptions = {"1 Month", "3 Months", "6 Months", "1 Year"};
        durationComboBox = new JComboBox<>(durationOptions);
        durationComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        durationPanel.add(durationComboBox);
        background.add(durationPanel);

        // Submit Button
        submitButton = new JButton("Calculate Total");
        submitButton.setBounds(100, 430, 200, 40);
        submitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        submitButton.addActionListener(this::handleSubmit);
        background.add(submitButton);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(400, 430, 200, 40);
        backButton.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton.addActionListener(this::handleBack);
        background.add(backButton);
    }

    private void handleSubmit(ActionEvent e) {
        String selectedSpace = (String) spaceTypeComboBox.getSelectedItem();
        String selectedRoom = (String) roomComboBox.getSelectedItem();
        String selectedDuration = (String) durationComboBox.getSelectedItem();

        int costPerRoom = 0;

        switch (selectedSpace) {
            case "Office":
                costPerRoom = 6000; // Office cost per room
                break;
            case "Shop":
                costPerRoom = 8000; // Shop cost per room
                break;
            case "Warehouse":
                costPerRoom = 10000; // Warehouse cost per room
                break;
        }

        int numberOfRooms = Integer.parseInt(selectedRoom.split(" ")[0]);
        int durationMultiplier = getDurationMultiplier(selectedDuration);
        int totalCost = costPerRoom * numberOfRooms * durationMultiplier;

        JOptionPane.showMessageDialog(this, "Total Cost for " + selectedDuration + ": " + totalCost + " Tk");
    }

    private int getDurationMultiplier(String duration) {
        switch (duration) {
            case "1 Month":
                return 1;
            case "3 Months":
                return 3;
            case "6 Months":
                return 6;
            case "1 Year":
                return 12;
            default:
                return 1;
        }
    }

    private void handleBack(ActionEvent e) {
        // Close the current ResidentialArea window and return to HomePage
        new HomePage().setVisible(true);
        dispose(); // Close the ResidentialArea window
    }

    public static void main(String[] args) {
        new CommercialArea().setVisible(true);
    }
}
