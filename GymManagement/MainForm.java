package GymManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainForm extends JFrame {
    private final JTable table;
    private final DefaultTableModel model;
    private final List<Member> members;

    public MainForm() {
        setTitle("Gym Management System");
        setSize(950, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        members = new ArrayList<>();
        String[] cols = {"ID", "Name", "Gender", "Phone", "Register Date", "Package", "Start Date", "Trainer", "Status"};
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 5, 10, 10)); // 2 hàng, 5 cột

        JButton btnAdd = new JButton("Add");
        JButton btnEdit = new JButton("Edit");
        JButton btnDelete = new JButton("Delete");
        JButton btnSearch = new JButton("Search");
        JButton btnRefresh = new JButton("Refresh");   // ✅ NEW BUTTON
        JButton btnExport = new JButton("Export");
        JButton btnReport = new JButton("Report");
        JButton btnDetails = new JButton("Details");
        JButton btnExit = new JButton("Exit");

        panel.add(btnAdd);
        panel.add(btnEdit);
        panel.add(btnDelete);
        panel.add(btnSearch);
        panel.add(btnRefresh);   // ✅
        panel.add(btnExport);
        panel.add(btnReport);
        panel.add(btnDetails);
        panel.add(btnExit);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        // ==== EVENT HANDLERS ====

        // Add
        btnAdd.addActionListener(e -> {
            MemberForm form = new MemberForm(this, null);
            Member m = form.showDialog();
            if (m != null) {
                members.add(m);
                loadTable();
            }
        });

        // Edit
        btnEdit.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                MemberForm form = new MemberForm(this, members.get(row));
                Member m = form.showDialog();
                if (m != null) {
                    members.set(row, m);
                    loadTable();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a member to edit!");
            }
        });

        // Delete
        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                members.remove(row);
                loadTable();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a member to delete!");
            }
        });

        // Search
        btnSearch.addActionListener(e -> {
            String keyword = JOptionPane.showInputDialog("Enter name or ID to search:");
            if (keyword != null && !keyword.isEmpty()) {
                model.setRowCount(0);
                for (Member m : members) {
                    if (m.getName().toLowerCase().contains(keyword.toLowerCase())
                            || m.getId().equalsIgnoreCase(keyword)) {
                        model.addRow(new Object[]{
                                m.getId(), m.getName(), m.getGender(), m.getPhone(),
                                m.getRegisterDate(), m.getPackageType(),
                                m.getStartDate(), m.getTrainer(), m.getStatus()
                        });
                    }
                }
            }
        });

        // ✅ Refresh
        btnRefresh.addActionListener(e -> loadTable());

        // Export
        btnExport.addActionListener(e -> FileUtil.exportToCSV(members));

        // Report
        btnReport.addActionListener(e -> {
            ReportForm rf = new ReportForm(this, members);
            rf.setVisible(true);
        });

        // Details
        btnDetails.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                Member m = members.get(row);
                JOptionPane.showMessageDialog(this,
                        "ID: " + m.getId() + "\n" +
                                "Name: " + m.getName() + "\n" +
                                "Gender: " + m.getGender() + "\n" +
                                "Phone: " + m.getPhone() + "\n" +
                                "Register Date: " + m.getRegisterDate() + "\n" +
                                "Package: " + m.getPackageType() + "\n" +
                                "Start Date: " + m.getStartDate() + "\n" +
                                "Trainer: " + m.getTrainer() + "\n" +
                                "Status: " + m.getStatus(),
                        "Member Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a member first!");
            }
        });

        // Exit
        btnExit.addActionListener(e -> System.exit(0));
    }

    private void loadTable() {
        model.setRowCount(0);
        for (Member m : members) {
            model.addRow(new Object[]{
                    m.getId(), m.getName(), m.getGender(), m.getPhone(),
                    m.getRegisterDate(), m.getPackageType(),
                    m.getStartDate(), m.getTrainer(), m.getStatus()
            });
        }
    }

    // ✅ Run with login first
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
