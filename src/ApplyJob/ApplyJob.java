package ApplyJob;

import java.util.ArrayList;
import java.util.Scanner;

import Login.Applicant;

public class ApplyJob extends ValidateChoice {
    private ArrayList<Applicant> applicants;
    private ArrayList<Job> jobs;
    private ArrayList<ApplicantRecord> applicantRecords;

    public ApplyJob() {
        jobs = new ArrayList<>();
        applicants = new ArrayList<>();
        applicantRecords = new ArrayList<>();
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    public void addApplicant(Applicant applicant) {
        applicants.add(applicant);
    }

    public void addApplicantRecord(Applicant applicant, Job job) {
        applicantRecords.add(new ApplicantRecord(applicant, job));
    }

    public ArrayList<ApplicantRecord> gApplicantRecords() {
        return applicantRecords;
    }

    public void menu(Scanner input) {
        System.out.println("--- SELAMAT DATANG DI APLIKASI JOB PORTAL ---");
        System.out.println("\nSilahkan Pilih Menu Berikut ini\t: ");
        System.out.println("1. Lamar Pekerjaan");
        System.out.println("2. Melihat Daftar Pelamar");
        System.out.println("3. Manage Status Pelamar");
        System.out.println("4. Exit");
        System.out.print("\nSilahkan masukan pilihan anda\t: ");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                displayJob();
                break;
            case 2:
                displayApplicantRecord();
                break;
            case 3:
                System.out.println("babi");
                break;
            default:
                System.out.println("Yang bener aje kocak!");
                break;
        }
    }

    public void displayJob() {
        System.out.println("-- BERIKUT DAFTAR PEKERJAAN YANG DAPAT ANDA LAMAR --");

        for (int i = 0; i < jobs.size(); i++) {
            Job job = jobs.get(i);
            System.out.println((i + 1) + ". " + job.getJobTitle() + " - " + job.getCompanyName());
        }
    }

    public void applyJob(Scanner input, String userId) {
        boolean continueApply = true;
        String status = "waiting";

        while (continueApply) {
            System.out.print("Silahkan masukan pilihan anda: ");
            int numbers = input.nextInt();
            input.nextLine();

            String result = checkChoice(numbers);
            if (!result.isEmpty()) {
                System.out.println(result);
                return;
            }

            if (numbers > 0 && numbers <= jobs.size()) {
                Job selectedJob = jobs.get(numbers - 1);

                Applicant applicant = findApplicant(userId);
                if (applicant != null) {

                    addApplicantRecord(applicant, selectedJob);

                    System.out.println("\n-- Informasi Pelamar --");
                    System.out.println("Nama\t\t: " + applicant.getName());
                    System.out.println("Universitas\t: " + applicant.getUniversity());
                    System.out.println("Fakultas\t: " + applicant.getFaculty());
                    System.out.println("GPA\t\t: " + applicant.getGpa());
                } else {
                    System.out.println("Applicant tidak ditemukan!");
                }

                System.out.println("Job Title\t: " + selectedJob.getJobTitle());
                System.out.println("Company\t\t: " + selectedJob.getCompanyName());
                System.out.println("Status\t\t: " + status);
            }

            System.out.print("\nApakah anda ingin melamar pekerjaan lagi? (ya/tidak)\t: ");
            String choice = input.nextLine();

            if (!choice.equalsIgnoreCase("ya")) {
                continueApply = false;
                menu(input);
            } else {
                displayJob();
            }
        }

    }

    private Applicant findApplicant(String userId) {
        int userIdInt = Integer.parseInt(userId);
        for (Applicant applicant : applicants) {
            if (applicant.getId() == userIdInt) {
                return applicant;
            }
        }
        return null;
    }

    public void displayApplicantRecord() {
        System.out.println("\n-- DAFTAR PELAMAR KERJA --");
        for (ApplicantRecord applicantRecord : applicantRecords) {
            Applicant applicant = applicantRecord.getApplicant();
            Job job = applicantRecord.getJob();

            System.out.println("\nName\t\t: " + applicant.getName());
            System.out.println("University\t: " + applicant.getUniversity());
            System.out.println("Faculty\t\t: " + applicant.getFaculty());
            System.out.println("GPA\t\t: " + applicant.getGpa());
            System.out.println("Job Title\t: " + job.getJobTitle());
            System.out.println("Company\t\t: " + job.getCompanyName());
            System.out.println("Status\t\t: " + applicantRecord.getStatus());
        }
    }

    @Override
    public String checkChoice(int numbers) {
        String result = "";
        if (numbers < 1 || numbers > jobs.size()) {
            result = "Pekerjaan yang anda pilih tidak valid!";
        }

        return result;
    }

}
