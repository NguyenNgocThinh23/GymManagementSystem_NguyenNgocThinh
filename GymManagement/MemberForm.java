package GymManagement;

import javax.swing.*;
import java.awt.*;

public class MemberForm extends JDialog {

    private final JTextField txtId, txtName, txtPhone, txtRegisterDate, txtStartDate, txtTrainer;
    private final JComboBox<String> cbGender, cbPackage, cbStatus;
    private boolean isOk = false;

    public MemberForm(Frame parent, Member m) {
        super(parent, true);
        setTitle("Member Information");
        setSize(400, 400);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(10, 2, 5, 5));

        add(new JLabel("ID:"));
        txtId = new JTextField();
        add(txtId);
        add(new JLabel("Name:"));
        txtName = new JTextField();
        add(txtName);
        add(new JLabel("Gender:"));
        cbGender = new JComboBox<>(new String[]{"Male", "Female"});
        add(cbGender);
        add(new JLabel("Phone:"));
        txtPhone = new JTextField();
        add(txtPhone);
        add(new JLabel("Register Date:"));
        txtRegisterDate = new JTextField("dd/MM/yyyy");
        add(txtRegisterDate);
        add(new JLabel("Package:"));
        cbPackage = new JComboBox<>(new String[]{"1 month", "3 months", "6 months", "12 months"});
        add(cbPackage);
        add(new JLabel("Start Date:"));
        txtStartDate = new JTextField("dd/MM/yyyy");
        add(txtStartDate);
        add(new JLabel("Trainer:"));
        txtTrainer = new JTextField();
        add(txtTrainer);
        add(new JLabel("Status:"));
        cbStatus = new JComboBox<>(new String[]{"Active", "Expired", "Paused"});
        add(cbStatus);

        JButton btnOk = new JButton("OK"), btnCancel = new JButton("Cancel");
        btnOk.addActionListener(e -> {
            isOk = true;
            dispose();
        });
        btnCancel.addActionListener(e -> dispose());
        add(btnOk);
        add(btnCancel);

        if (m != null) {
            txtId.setText(m.getId());
            txtId.setEditable(false);
            txtName.setText(m.getName());
            cbGender.setSelectedItem(m.getGender());
            txtPhone.setText(m.getPhone());
            txtRegisterDate.setText(m.getRegisterDate());
            cbPackage.setSelectedItem(m.getPackageType());
            txtStartDate.setText(m.getStartDate());
            txtTrainer.setText(m.getTrainer());
            cbStatus.setSelectedItem(m.getStatus());
        }
    }

    public Member showDialog() {
        setVisible(true);
        if (isOk) {
            return new Member(
                    txtId.getText(), txtName.getText(),
                    (String) cbGender.getSelectedItem(),
                    txtPhone.getText(), txtRegisterDate.getText(),
                    (String) cbPackage.getSelectedItem(),
                    txtStartDate.getText(), txtTrainer.getText(),
                    (String) cbStatus.getSelectedItem()
            );
        }
        return null;
    }
}
