package GymManagement;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JDialog {

    private boolean isLoggedIn = false;

    public LoginForm(Frame parent) {
        super(parent, "Login", true);
        setSize(300, 150);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(3, 2, 5, 5));

        JLabel lblUser = new JLabel("Username:");
        JTextField txtUser = new JTextField();
        JLabel lblPass = new JLabel("Password:");
        JPasswordField txtPass = new JPasswordField();

        JButton btnLogin = new JButton("Login"), btnCancel = new JButton("Cancel");
        add(lblUser);
        add(txtUser);
        add(lblPass);
        add(txtPass);
        add(btnLogin);
        add(btnCancel);

        btnLogin.addActionListener(e -> {
            if (txtUser.getText().equals("admin") && new String(txtPass.getPassword()).equals("123456")) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                isLoggedIn = true;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password!");
            }
        });

        btnCancel.addActionListener(e -> dispose());
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}
