package ApplyJob;

import java.util.ArrayList;
import java.util.Scanner;

import Login.Applicant;

public class ApplyJob implements ApplyJobInterfaces {
    private ArrayList<Applicant> applicants;
    private ArrayList<Job> jobs;
    private ArrayList<ApplicantRecord> applicantRecords;

    public ApplyJob() {
        jobs = new ArrayList<>();
        applicants = new ArrayList<>();
        applicantRecords = new ArrayList<>();
    }

    public ArrayList<ApplicantRecord> gApplicantRecords() {
        return applicantRecords;
    }

    public void applyJob(Scanner input, String userId, ApplyJob applyJob) {
        String status = "waiting";

        System.out.print("Silahkan masukan pilihan anda: ");
        int numbers = input.nextInt();
        input.nextLine();

        utils.ValidateChoice validateChoice = new utils.ValidateChoice();
        String result = validateChoice.checkChoice(numbers, jobs);

        if (!result.isEmpty()) {
            System.out.println(result);
            return;
        }

        if (numbers > 0 && numbers <= jobs.size()) {
            Job selectedJob = jobs.get(numbers - 1);

            int id = Integer.parseInt(userId);
            Applicant applicant = findApplicant(id);
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
    }

    public Applicant findApplicant(String name) {
        for (Applicant applicant : applicants) {
            if (applicant.getName().equalsIgnoreCase(name)) {
                return applicant;
            }
        }
        return null;
    }

    public Applicant findApplicant(int id) {
        for (Applicant applicant : applicants) {
            if (applicant.getId() == id) {
                return applicant;
            }
        }
        return null;
    }

    public Applicant findApplicant(String name, String university) {
        for (Applicant applicant : applicants) {
            if (applicant.getName().equalsIgnoreCase(name) && applicant.getUniversity().equalsIgnoreCase(university)) {
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

    public void manageStatus(Scanner input, ApplyJob applyJob) {
        System.out.println("-- MANAGE STATUS APPLICANT --");
        displayApplicantRecord();

        System.out.print("\nMasukan nama pelamar\t: ");
        String name = input.nextLine();
        Applicant applicant = findApplicant(name);
        if (applicant == null) {
            System.out.println("Pelamar tidak ditemukan!");
            return;
        }

        System.out.print("Masukan nama pekerjaan\t: ");
        String jobName = input.nextLine();
        System.out.print("Masukan nama perusahaan\t: ");
        String company = input.nextLine();
        Job job = findByName(jobName, company);
        if (job == null) {
            System.out.println("Pekerjaan atau Perusahaan tidak ditemukan!");
            return;
        }

        System.out.println("\nMasukan status baru (accepted/rejected)\t: ");
        String newStatus = input.nextLine();
        updateStatus(applicant, job, newStatus);

        displayApplicantRecord();
    }

    private Job findByName(String name, String company) {
        for (ApplicantRecord record : applicantRecords) {
            if (record.getJob().getJobTitle().equalsIgnoreCase(name)
                    && record.getJob().getCompanyName().equalsIgnoreCase(company)) {
                return record.getJob();
            }
        }
        return null;
    }

    @Override
    public void updateStatus(Applicant applicant, Job job, String newStatus) {
        for (ApplicantRecord record : applicantRecords) {
            if (record.getApplicant().equals(applicant) && record.getJob().equals(job)) {
                record.setStatus(newStatus);
                System.out.println("Successfully update status applicant");
                return;
            }
        }
        System.out.println("No data found!");
    }

    @Override
    public void displayJob() {
        System.out.println("-- BERIKUT DAFTAR PEKERJAAN YANG DAPAT ANDA LAMAR --");

        for (int i = 0; i < jobs.size(); i++) {
            Job job = jobs.get(i);
            System.out.println((i + 1) + ". " + job.getJobTitle() + " - " + job.getCompanyName());
        }
    }

    @Override
    public void addApplicant(Applicant applicant) {
        applicants.add(applicant);
    }

    @Override
    public void addJob(Job job) {
        jobs.add(job);
    }

    @Override
    public void addApplicantRecord(Applicant applicant, Job job) {
        applicantRecords.add(new ApplicantRecord(applicant, job));
    }

}
