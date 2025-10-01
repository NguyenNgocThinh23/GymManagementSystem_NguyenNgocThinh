package GymManagement;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtil {

    public static void exportToCSV(List<Member> members) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Members Data");
        fileChooser.setSelectedFile(new java.io.File("members.csv"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try (FileWriter writer = new FileWriter(fileChooser.getSelectedFile())) {
                writer.write("ID,Name,Gender,Phone,Register Date,Package,Start Date,Trainer,Status\n");
                for (Member m : members) {
                    writer.write(m.getId() + ","
                            + m.getName() + ","
                            + m.getGender() + ","
                            + m.getPhone() + ","
                            + m.getRegisterDate() + ","
                            + m.getPackageType() + ","
                            + m.getStartDate() + ","
                            + m.getTrainer() + ","
                            + m.getStatus() + "\n");
                }
                JOptionPane.showMessageDialog(null, "Export successful!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error exporting file: " + e.getMessage());
            }
        }
    }
}
