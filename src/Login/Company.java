package Login;

import java.util.ArrayList;

import ApplyJob.ApplicantRecord;

public class Company extends Users {
    private String address;
    private String telphone;

    public Company(int id, String name, String email, String password, String address, String telphone) {
        super(id, name, email, password);
        this.address = address;
        this.telphone = telphone;
    }

    public String getAddress() {
        return address;
    }

    public String getTelphone() {
        return telphone;
    }

    @Override
    public void showInfo() {
        System.out.println("Name\t\t: " + getName());
        System.out.println("Email\t\t: " + getEmail());
        System.out.println("Address\t: " + getAddress());
        System.out.println("Telphone\t: " + getTelphone());
    }

    // @Override
    // public Object findByName(String name, ArrayList<ApplicantRecord>
    // applicantRecords) {
    // for (ApplicantRecord applicantRecord : applicantRecords) {
    // if (applicantRecord.getJob().getJobTitle().equalsIgnoreCase(name)) {
    // return applicantRecord.getJob();
    // }
    // }
    // return null;
    // }

    // public Object findByName(String name, String company,
    // ArrayList<ApplicantRecord> applicantRecords) {
    // for (ApplicantRecord applicantRecord : applicantRecords) {
    // if (applicantRecord.getJob().getJobTitle().equalsIgnoreCase(name)
    // && applicantRecord.getJob().getCompanyName().equalsIgnoreCase(company)) {
    // return applicantRecord.getJob();
    // }
    // }
    // return null;
    // }
}
