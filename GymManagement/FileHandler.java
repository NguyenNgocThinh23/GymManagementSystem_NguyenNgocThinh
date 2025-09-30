package GymManagement;

import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String FILE_NAME = "members.csv";

    public static void exportToCSV(List<Member> members) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write("ID,Name,Gender,Phone,RegisterDate,Package,StartDate,Trainer,Status\n");
            for (Member m : members) {
                writer.write(String.join(",", m.getId(), m.getName(), m.getGender(),
                        m.getPhone(), m.getRegisterDate(), m.getPackageType(),
                        m.getStartDate(), m.getTrainer(), m.getStatus()) + "\n");
            }
        }
    }

    public static List<Member> importFromCSV() throws IOException {
        List<Member> members = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return members;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr.length == 9) {
                    members.add(new Member(arr[0], arr[1], arr[2], arr[3], arr[4],
                                           arr[5], arr[6], arr[7], arr[8]));
                }
            }
        }
        return members;
    }
}
