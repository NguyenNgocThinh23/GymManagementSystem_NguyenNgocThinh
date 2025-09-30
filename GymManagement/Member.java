package GymManagement;

public class Member {
    private String id;
    private String name;
    private String gender;
    private String phone;
    private String registerDate;
    private String packageType;
    private String startDate;
    private String trainer;
    private String status;

    public Member(String id, String name, String gender, String phone, String registerDate,
                  String packageType, String startDate, String trainer, String status) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.registerDate = registerDate;
        this.packageType = packageType;
        this.startDate = startDate;
        this.trainer = trainer;
        this.status = status;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getPhone() { return phone; }
    public String getRegisterDate() { return registerDate; }
    public String getPackageType() { return packageType; }
    public String getStartDate() { return startDate; }
    public String getTrainer() { return trainer; }
    public String getStatus() { return status; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setRegisterDate(String registerDate) { this.registerDate = registerDate; }
    public void setPackageType(String packageType) { this.packageType = packageType; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public void setTrainer(String trainer) { this.trainer = trainer; }
    public void setStatus(String status) { this.status = status; }
}
