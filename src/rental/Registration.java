package rental;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import server.DataStore; // Make sure to import the DataStore class

public class Registration extends JFrame {

    private Container background;
    private JLabel nameLabel, emailLabel, passwordLabel, confirmPasswordLabel, addressLabel, phoneLabel;
    private JTextField nameField, emailField, phoneField, addressField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton;
    private DataStore dataStore; // Declare DataStore instance

    public Registration() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500, 650);
        setTitle("Registration Form");
        setResizable(false);
        setLocationRelativeTo(null);
        dataStore = new DataStore(); // Initialize DataStore
        initializeComponents();
    }

    void initializeComponents() {
        background = getContentPane();
        background.setLayout(null);
        background.setBackground(new Color(240, 240, 240)); // Light gray background

        // Title
        JLabel titleLabel = new JLabel("Registration Form");
        titleLabel.setBounds(100, 20, 300, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(50, 50, 150)); // Dark blue color
        background.add(titleLabel);

        // Name Label
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(100, 70, 250, 30);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Name Text Field
        nameField = new JTextField();
        nameField.setBounds(100, 110, 300, 30);
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        nameField.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 150), 2));

        // Email Label
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(100, 150, 250, 30);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Email Text Field
        emailField = new JTextField();
        emailField.setBounds(100, 190, 300, 30);
        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        emailField.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 150), 2));

        // Phone Number Label
        phoneLabel = new JLabel("Phone Number");
        phoneLabel.setBounds(100, 230, 250, 30);
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Phone Number Text Field
        phoneField = new JTextField();
        phoneField.setBounds(100, 270, 300, 30);
        phoneField.setFont(new Font("Arial", Font.PLAIN, 16));
        phoneField.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 150), 2));

        // Address Label
        addressLabel = new JLabel("Address");
        addressLabel.setBounds(100, 310, 250, 30);
        addressLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Address Text Field
        addressField = new JTextField();
        addressField.setBounds(100, 350, 300, 30);
        addressField.setFont(new Font("Arial", Font.PLAIN, 16));
        addressField.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 150), 2));

        // Password Label
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100, 390, 250, 30);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 430, 300, 30);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 150), 2));

        // Confirm Password Label
        confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setBounds(100, 470, 250, 30);
        confirmPasswordLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Confirm Password Field
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(100, 510, 300, 30);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
        confirmPasswordField.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 150), 2));

        // Register Button
        registerButton = new JButton("Register");
        registerButton.setBounds(100, 550, 300, 40);
        registerButton.setFont(new Font("Arial", Font.BOLD, 18));
        registerButton.setBackground(new Color(50, 150, 50)); // Green background
        registerButton.setForeground(Color.WHITE);
        registerButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Register Button Mouse Click Event
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerUser();
            }
        });

        // Action when the user presses "Enter" in the password field
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    registerUser();
                }
            }
        });

        // Add components to background
        background.add(nameLabel);
        background.add(nameField);
        background.add(emailLabel);
        background.add(emailField);
        background.add(phoneLabel);
        background.add(phoneField);
        background.add(addressLabel);
        background.add(addressField);
        background.add(passwordLabel);
        background.add(passwordField);
        background.add(confirmPasswordLabel);
        background.add(confirmPasswordField);
        background.add(registerButton);
    }

    private void registerUser() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Save user data to the datastore
        dataStore.saveUserData(name, email, phone, address, password);

        JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Navigate back to Login
        new Login().setVisible(true);
        this.dispose(); // Close the registration window
    }

    public static void main(String[] args) {
        new Registration().setVisible(true);
    }
}
