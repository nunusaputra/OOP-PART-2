package Login;

import java.util.ArrayList;

import ApplyJob.ApplicantRecord;

public abstract class Users {
    private int id;
    private String name;
    private String email;
    private String password;

    public Users(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public abstract void showInfo();

    // public abstract Object findByName(String name, ArrayList<ApplicantRecord>
    // applicantRecords);
}
