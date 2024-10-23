package rental;

import server.DataStore; // Ensure to import the DataStore class
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class Login extends JFrame {

    private Container background;
    private JLabel emailLabel, passwordLabel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton submit, registration;

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500, 400);
        setTitle("Login System");
        setResizable(false);
        setLocationRelativeTo(null);
        initializeComponents();
    }

    void initializeComponents() {
        background = getContentPane();
        background.setLayout(null);
        background.setBackground(new Color(240, 240, 240)); // Light gray background

        // Title
        JLabel titleLabel = new JLabel("Welcome to Rental System");
        titleLabel.setBounds(50, 10, 400, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(50, 50, 150)); // Dark blue color
        background.add(titleLabel);

        // Email Label
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(100, 60, 250, 30);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Email Text Field
        emailField = new JTextField();
        emailField.setBounds(100, 100, 300, 30);
        emailField.setFont(new Font("Arial", Font.PLAIN, 18));
        emailField.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 150), 2));

        // Password Label
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100, 140, 250, 30);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 180, 300, 30);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 150), 2));

        // Action when the user presses "Enter" in the password field
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submitLogin();
                }
            }
        });

        // Submit Button
        submit = new JButton("Login");
        submit.setBounds(100, 220, 140, 40);
        submit.setFont(new Font("Arial", Font.BOLD, 18));
        submit.setBackground(new Color(50, 150, 50)); // Green background
        submit.setForeground(Color.WHITE);
        submit.setBorder(BorderFactory.createEmptyBorder());
        submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submit.addActionListener(e -> submitLogin());

        // Registration Button
        registration = new JButton("Registration");
        registration.setBounds(260, 220, 140, 40);
        registration.setFont(new Font("Arial", Font.BOLD, 18));
        registration.setBackground(new Color(50, 150, 150)); // Teal background
        registration.setForeground(Color.WHITE);
        registration.setBorder(BorderFactory.createEmptyBorder());
        registration.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registration.addActionListener(e -> {
            // Open the Registration form
            new Registration().setVisible(true);
            this.dispose(); // Close the Login window
        });

        // Add components to background
        background.add(emailLabel);
        background.add(emailField);
        background.add(passwordLabel);
        background.add(passwordField);
        background.add(submit);
        background.add(registration);
    }

    private void submitLogin() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in both fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate login credentials
        if (validateLogin(email, password)) {
            JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            // Open the HomePage and dispose of the login window
            new HomePage().setVisible(true);
            this.dispose(); // Close the login window
        } else {
            JOptionPane.showMessageDialog(this, "Invalid email or password.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Clear fields after submission
        emailField.setText("");
        passwordField.setText("");
    }

    private boolean validateLogin(String email, String password) {
        DataStore dataStore = new DataStore();
        List<String[]> userDataList = dataStore.readUserData();

        for (String[] userData : userDataList) {
            // Assuming userData[1] is email and userData[4] is password
            if (userData.length > 4 && userData[1].equals(email) && userData[4].equals(password)) {
                return true; // Login successful
            }
        }
        return false; // Login failed
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
