package new_lab;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginRegistrationPage 
{
    private static final String URL = "jdbc:mysql://localhost:3306/UserDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Tarachand@2005";

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(LoginRegistrationPage::new);
    }

    public LoginRegistrationPage() 
    {
    	
        JFrame frame = new JFrame("Login & Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        frame.setLocationRelativeTo(null);

        
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        
        JPanel loginPanel = createLoginPanel(cardLayout, cardPanel);
        cardPanel.add(loginPanel, "Login");

        
        JPanel registerPanel = createRegisterPanel(cardLayout, cardPanel);
        cardPanel.add(registerPanel, "Register");

        frame.add(cardPanel);
        frame.setVisible(true);
        
    }

    private JPanel createLoginPanel(CardLayout cardLayout, JPanel cardPanel) 
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton goToRegisterButton = new JButton("Go to Registration");

        loginButton.addActionListener(e -> 
        {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (validateLogin(username, password)) 
            {
                JOptionPane.showMessageDialog(panel, "Login Successful!");
            } 
            else 
            {
                JOptionPane.showMessageDialog(panel, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        goToRegisterButton.addActionListener(e -> cardLayout.show(cardPanel, "Register"));

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(goToRegisterButton);

        return panel;
    }

    private JPanel createRegisterPanel(CardLayout cardLayout, JPanel cardPanel) 
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JButton registerButton = new JButton("Register");
        JButton goToLoginButton = new JButton("Go to Login");

        registerButton.addActionListener(e -> 
        {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String email = emailField.getText();

            if (registerUser(username, password, email)) 
            {
                JOptionPane.showMessageDialog(panel, "Registration Successful!");
                cardLayout.show(cardPanel, "Login");
            } 
            else 
            {
                JOptionPane.showMessageDialog(panel, "Registration Failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        goToLoginButton.addActionListener(e -> cardLayout.show(cardPanel, "Login"));

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(registerButton);
        panel.add(goToLoginButton);

        return panel;
    }

    private boolean validateLogin(String username, String password) 
    {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        		
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM users WHERE username = ? AND password = ?")) {
            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) 
            {
                return resultSet.next();
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }

    private boolean registerUser(String username, String password, String email) 
    {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO users (username, password, email) VALUES (?, ?, ?)")) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);

            statement.executeUpdate();
            return true;
        } 
        catch (SQLIntegrityConstraintViolationException e) 
        {
            JOptionPane.showMessageDialog(null, "Username or Email already exists!", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }
}
