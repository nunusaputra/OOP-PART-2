package ApplyJob;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import Login.Applicant;

public class ApplyJob implements ApplyJobInterfaces {
    private ArrayList<Applicant<String, Double>> applicants;
    private ArrayList<Job<Integer, String>> jobs;
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
        boolean cekAgain = true;
        String status = "waiting";

        while (cekAgain) {
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
                Job<Integer, String> selectedJob = jobs.get(numbers - 1);

                int id = Integer.parseInt(userId);
                Applicant<String, Double> applicant = findApplicant(id);
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

                System.out.print("\nApakah anda ingin melamar lagi? (ya/tidak): ");
                String choice = input.nextLine();

                if (choice.equalsIgnoreCase("ya")) {
                    displayJob();
                } else {
                    cekAgain = false;
                    menu(input);
                }
            }
        }
    }

    public Applicant<String, Double> findApplicant(String name) {
        for (Applicant<String, Double> applicant : applicants) {
            if (applicant.getName().equalsIgnoreCase(name)) {
                return applicant;
            }
        }
        return null;
    }

    public Applicant<String, Double> findApplicant(int id) {
        for (Applicant<String, Double> applicant : applicants) {
            if (applicant.getId() == id) {
                return applicant;
            }
        }
        return null;
    }

    public Applicant<String, Double> findApplicant(String name, String university) {
        for (Applicant<String, Double> applicant : applicants) {
            if (applicant.getName().equalsIgnoreCase(name) && applicant.getUniversity().equalsIgnoreCase(university)) {
                return applicant;
            }
        }
        return null;
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
                manageStatus(input);
                break;
            default:
                System.out.println("Yang bener aje kocak!");
                break;
        }
    }

    public void displayApplicantRecord() {
        System.out.println("\n-- DAFTAR PELAMAR KERJA --");
        for (ApplicantRecord applicantRecord : applicantRecords) {
            Applicant<String, Double> applicant = applicantRecord.getApplicant();
            Job<Integer, String> job = applicantRecord.getJob();

            System.out.println("\nName\t\t: " + applicant.getName());
            System.out.println("University\t: " + applicant.getUniversity());
            System.out.println("Faculty\t\t: " + applicant.getFaculty());
            System.out.println("GPA\t\t: " + applicant.getGpa());
            System.out.println("Job Title\t: " + job.getJobTitle());
            System.out.println("Company\t\t: " + job.getCompanyName());
            System.out.println("Status\t\t: " + applicantRecord.getStatus());
        }
    }

    public void manageStatus(Scanner input) {
        boolean cekAgain = true;

        while (cekAgain) {
            System.out.println("-- MANAGE STATUS APPLICANT --");
            displayApplicantRecord();

            System.out.print("\nMasukan nama pelamar\t: ");
            String name = input.nextLine();
            Applicant<String, Double> applicant = findApplicant(name);
            if (applicant == null) {
                System.out.println("Pelamar tidak ditemukan!");
                return;
            }

            System.out.print("Masukan nama pekerjaan\t: ");
            String jobName = input.nextLine();
            System.out.print("Masukan nama perusahaan\t: ");
            String company = input.nextLine();
            Job<Integer, String> job = findByName(jobName, company);
            if (job == null) {
                System.out.println("Pekerjaan atau Perusahaan tidak ditemukan!");
                return;
            }

            System.out.println("\nMasukan status baru (accepted/rejected)\t: ");
            String newStatus = input.nextLine();
            updateStatus(applicant, job, newStatus);

            getApplicantResult();

            System.out.println("Apakah ada yang ingin anda lakukan lagi? (ya/tidak): ");
            String cekChoice = input.nextLine();

            if (cekChoice.equalsIgnoreCase("ya")) {
                manageStatus(input);
            } else {
                cekAgain = false;
                menu(input);
            }
        }
    }

    private Job<Integer, String> findByName(String name, String company) {
        for (ApplicantRecord record : applicantRecords) {
            if (record.getJob().getJobTitle().equalsIgnoreCase(name)
                    && record.getJob().getCompanyName().equalsIgnoreCase(company)) {
                return record.getJob();
            }
        }
        return null;
    }

    @Override
    public void updateStatus(Applicant<String, Double> applicant, Job<Integer, String> job, String newStatus) {
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
        IntStream.range(0, jobs.size())
                .forEach(job -> {
                    Job<Integer, String> jobList = jobs.get(job);
                    System.out.println((job + 1) + ". " + jobList.getJobTitle() + " - " + jobList.getCompanyName());
                });
    }

    @Override
    public void getApplicantResult() {
        List<ApplicantRecord> saveApplicant = applicantRecords.stream()
                .filter(status -> status.getStatus().equals("accepted")).collect(Collectors.toList());

        IntStream.range(0, saveApplicant.size()).forEach(applicant -> {
            ApplicantRecord applicantRecord = applicantRecords.get(applicant);
            System.out.println("\nName\t\t: " + applicantRecord.getApplicant().getName());
            System.out.println("University\t: " + applicantRecord.getApplicant().getUniversity());
            System.out.println("Faculty\t\t: " + applicantRecord.getApplicant().getFaculty());
            System.out.println("GPA\t\t: " + applicantRecord.getApplicant().getGpa());
            System.out.println("Job Title\t: " + applicantRecord.getJob().getJobTitle());
            System.out.println("Company Name\t: " + applicantRecord.getJob().getCompanyName());
            System.out.println("Status\t\t: " + applicantRecord.getStatus());
        });
    }

    @Override
    public void addApplicant(Applicant<String, Double> applicant) {
        applicants.add(applicant);
    }

    @Override
    public void addJob(Job<Integer, String> job) {
        jobs.add(job);
    }

    @Override
    public void addApplicantRecord(Applicant<String, Double> applicant, Job<Integer, String> job) {
        applicantRecords.add(new ApplicantRecord(applicant, job));
    }

}
