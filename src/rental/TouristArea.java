package rental;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TouristArea extends JFrame {

    private Container background;
    private JButton submitButton, backButton;
    private JComboBox<String> accommodationTypeComboBox;
    private JComboBox<String> roomComboBox;
    private JComboBox<String> durationComboBox;

    public TouristArea() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 650); // Set frame size
        setTitle("Tourist Area House Renting");
        setResizable(false);
        setLocationRelativeTo(null);
        initializeComponents();
    }

    void initializeComponents() {
        background = getContentPane();
        background.setLayout(null);
        background.setBackground(new Color(255, 239, 204)); // Light peach background

        // Title Label
        JLabel titleLabel = new JLabel("Tourist Area House Renting");
        titleLabel.setBounds(200, 30, 400, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(204, 51, 0)); // Dark red color
        background.add(titleLabel);

        // Accommodation Type Panel
        JPanel accommodationTypePanel = new JPanel();
        accommodationTypePanel.setBounds(100, 100, 300, 200);
        accommodationTypePanel.setBorder(BorderFactory.createTitledBorder("Select Accommodation Type"));
        accommodationTypePanel.setLayout(new FlowLayout());

        String[] accommodationOptions = {"Beach House", "Mountain Cabin", "City Apartment"};
        accommodationTypeComboBox = new JComboBox<>(accommodationOptions);
        accommodationTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        accommodationTypePanel.add(accommodationTypeComboBox);
        background.add(accommodationTypePanel);

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

        String[] durationOptions = {"1 Night", "3 Nights", "1 Week", "2 Weeks"};
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
        String selectedAccommodation = (String) accommodationTypeComboBox.getSelectedItem();
        String selectedRoom = (String) roomComboBox.getSelectedItem();
        String selectedDuration = (String) durationComboBox.getSelectedItem();

        int costPerRoom = 0;

        switch (selectedAccommodation) {
            case "Beach House":
                costPerRoom = 7000; // Beach house cost per room
                break;
            case "Mountain Cabin":
                costPerRoom = 5000; // Mountain cabin cost per room
                break;
            case "City Apartment":
                costPerRoom = 6000; // City apartment cost per room
                break;
        }

        int numberOfRooms = Integer.parseInt(selectedRoom.split(" ")[0]);
        int durationMultiplier = getDurationMultiplier(selectedDuration);
        int totalCost = costPerRoom * numberOfRooms * durationMultiplier;

        JOptionPane.showMessageDialog(this, "Total Cost for " + selectedDuration + ": " + totalCost + " Tk");
    }

    private int getDurationMultiplier(String duration) {
        switch (duration) {
            case "1 Night":
                return 1;
            case "3 Nights":
                return 3;
            case "1 Week":
                return 7;
            case "2 Weeks":
                return 14;
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
        new TouristArea().setVisible(true);
    }
}
