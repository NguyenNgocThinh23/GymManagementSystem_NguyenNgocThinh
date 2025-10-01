package GymManagement;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ReportForm extends JDialog {

    public ReportForm(Frame parent, List<Member> members) {
        super(parent, "Reports", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(0, 1, 5, 5));

        int total = members.size();
        long active = members.stream().filter(m -> m.getStatus().equals("Active")).count();
        long expired = members.stream().filter(m -> m.getStatus().equals("Expired")).count();
        long paused = members.stream().filter(m -> m.getStatus().equals("Paused")).count();

        long pkg1 = members.stream().filter(m -> m.getPackageType().equals("1 month")).count();
        long pkg3 = members.stream().filter(m -> m.getPackageType().equals("3 months")).count();
        long pkg6 = members.stream().filter(m -> m.getPackageType().equals("6 months")).count();
        long pkg12 = members.stream().filter(m -> m.getPackageType().equals("12 months")).count();

        add(new JLabel("Total members: " + total));
        add(new JLabel("Active: " + active));
        add(new JLabel("Expired: " + expired));
        add(new JLabel("Paused: " + paused));
        add(new JLabel("1 month package: " + pkg1));
        add(new JLabel("3 months package: " + pkg3));
        add(new JLabel("6 months package: " + pkg6));
        add(new JLabel("12 months package: " + pkg12));

        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(e -> dispose());
        add(btnClose);
    }
}
