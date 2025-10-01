package GymManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DisplayAllMembers extends JDialog {

    public DisplayAllMembers(Frame parent, List<Member> members) {
        super(parent, "All Members", true);
        setSize(800, 400);
        setLocationRelativeTo(parent);

        // Column headers
        String[] columnNames = {"ID", "Name", "Gender", "Phone", "Registration Date",
            "Package", "Start Date", "Trainer", "Status"};

        // Table model
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Add rows from members list
        for (Member m : members) {
            model.addRow(new Object[]{
                m.getId(),
                m.getName(),
                m.getGender(),
                m.getPhone(),
                m.getRegistrationDate(),
                m.getPackageType(),
                m.getStartDate(),
                m.getTrainer(),
                m.getStatus()
            });
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(e -> dispose());
        add(btnClose, BorderLayout.SOUTH);
    }
}
