package GymManagement;

import javax.swing.*;

public class GymManagement {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginForm login = new LoginForm(null);
            login.setVisible(true);
            if (login.isLoggedIn()) {
                new MainForm().setVisible(true);
            } else {
                System.exit(0);
            }
        });
    }
}
