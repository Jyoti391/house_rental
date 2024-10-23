package rental;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ResidentialArea extends JFrame {

    private Container background;
    private JButton submitButton, backButton;
    private JComboBox<String> apartmentComboBox;
    private JComboBox<String> roomComboBox;

    public ResidentialArea() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 400); // Increased frame size
        setTitle("Residential Area");
        setResizable(false);
        setLocationRelativeTo(null);
        initializeComponents();
    }

    void initializeComponents() {
        background = getContentPane();
        background.setLayout(null);
        background.setBackground(new Color(230, 230, 250)); // Light lavender background

        // Title Label
        JLabel titleLabel = new JLabel("Residential Area House Renting");
        titleLabel.setBounds(250, 30, 400, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(72, 61, 139)); // Dark slate blue color
        background.add(titleLabel);

        // Apartment Type Panel
        JPanel apartmentPanel = new JPanel();
        apartmentPanel.setBounds(100, 100, 300, 200);
        apartmentPanel.setBorder(BorderFactory.createTitledBorder("Apartment Type"));
        apartmentPanel.setLayout(new FlowLayout());

        String[] apartmentOptions = {"3 Star Apartment", "4 Star Apartment", "5 Star Apartment"};
        apartmentComboBox = new JComboBox<>(apartmentOptions);
        apartmentComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        apartmentPanel.add(apartmentComboBox);
        background.add(apartmentPanel);

        // Room Number Panel
        JPanel roomPanel = new JPanel();
        roomPanel.setBounds(400, 100, 300, 200);
        roomPanel.setBorder(BorderFactory.createTitledBorder("Room Number"));
        roomPanel.setLayout(new FlowLayout());

        String[] roomOptions = {"1 Room", "2 Rooms", "3 Rooms"};
        roomComboBox = new JComboBox<>(roomOptions);
        roomComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        roomPanel.add(roomComboBox);
        background.add(roomPanel);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setBounds(100, 320, 200, 40);
        submitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        submitButton.addActionListener(this::handleSubmit);
        background.add(submitButton);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(400, 320, 200, 40);
        backButton.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton.addActionListener(this::handleBack);
        background.add(backButton);
    }

    private void handleSubmit(ActionEvent e) {
        String selectedApartment = (String) apartmentComboBox.getSelectedItem();
        String selectedRoom = (String) roomComboBox.getSelectedItem();

        int costPerRoom = 0;
        switch (selectedApartment) {
            case "3 Star Apartment":
                costPerRoom = 3000;
                break;
            case "4 Star Apartment":
                costPerRoom = 4000;
                break;
            case "5 Star Apartment":
                costPerRoom = 5000;
                break;
        }

        int numberOfRooms = Integer.parseInt(selectedRoom.split(" ")[0]);
        int totalCost = costPerRoom * numberOfRooms;

        JOptionPane.showMessageDialog(this, "Total Cost: " + totalCost + " Tk");
    }

    private void handleBack(ActionEvent e) {
        // Close the current ResidentialArea window and return to HomePage
        new HomePage().setVisible(true);
        dispose(); // Close the ResidentialArea window
    }

    public static void main(String[] args) {
        new ResidentialArea().setVisible(true);
    }
}
