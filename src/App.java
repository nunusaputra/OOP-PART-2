import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Login.Applicant;
import Login.Company;
import Login.Users;
import ApplyJob.Job;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        ArrayList<Users> users = new ArrayList<>();
        Applicant applicant = new Applicant(1, "Wisnu Saputra", "wisnu@gmail.com", "wisnu123", "Universitas Indonesia",
                "Fasilkom", 3.90);

        Company company = new Company(2, "PT Amartek", "amartek@gmail.com", "amartek123", "Jakarta Selatan",
                "083815499134");

        users.add(applicant);
        users.add(company);

        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, "Frontend Developer", "PT Amartek"));
        jobs.add(new Job(2, "Backend Developer", "PT Amartek"));
        jobs.add(new Job(3, "UI/UX Designer", "PT Amartek"));

        // applicant.showInfo();
        login(input, users, jobs);
    }

    public static void login(Scanner input, ArrayList<Users> users, ArrayList<Job> jobs) {
        System.out.print("\nMasukan email anda\t: ");
        String loginEmail = input.nextLine();
        System.out.print("Masukan password anda\t: ");
        String loginPassword = input.nextLine();

        String result = checkValidate(users, loginEmail, loginPassword);
        String userId = result;
        if (result.equals("Email atau password salah!")) {
            System.out.println(result);
            System.out.println("Login Failed");
            return;
        } else {
            System.out.println("Login Berhasil, ID anda - " + userId);
            menu(input, jobs, userId, users);
        }
    }

    public static String checkValidate(ArrayList<Users> data, String email, String password) {
        String result = "Email atau password salah!";

        for (Users user : data) {
            if (user.getEmail().equals(email)) {
                if (user.validatePassword(password)) {
                    result = String.valueOf(user.getId());
                }
                break;
            }
        }

        return result;
    }

    public static List<String[]> UsersList(ArrayList<Users> users, String userId) {
        List<String[]> userDetails = new ArrayList<>();

        int userIdInt = Integer.parseInt(userId);
        // Iterasi melalui daftar pengguna
        for (Users user : users) {
            // Bandingkan userId dengan ID pengguna
            if (user.getId() == userIdInt) {
                // Tambahkan detail pengguna ke daftar (array String)
                if (user instanceof Applicant) {
                    Applicant applicant = (Applicant) user;
                    userDetails.add(new String[] {
                            String.valueOf(applicant.getId()),
                            applicant.getName(),
                            applicant.getEmail(),
                            applicant.getUniversity(),
                            applicant.getFaculty(),
                            String.valueOf(applicant.getGpa())
                    });
                }
            }
        }

        return userDetails;
    }

    public static void menu(Scanner input, ArrayList<Job> jobs, String userId, ArrayList<Users> users) {
        System.out.println("--- SELAMAT DATANG DI APLIKASI JOB PORTAL ---");
        System.out.println("\nSilahkan Pilih Menu Berikut ini\t: ");
        System.out.println("1. Lamar Pekerjaan");
        System.out.println("2. Melihat Daftar Pelamar");
        System.out.println("2. Manage Status Pelamar");
        System.out.print("\nSilahkan masukan pilihan anda\t: ");
        int choice = input.nextInt();
        input.nextLine();

        while (true) {
            switch (choice) {
                case 1:
                    applyJob(input, jobs, userId, users);
                    return;

                case 2:
                    System.out.println("Terimakasih sudah menggunakan layanan kami");
                    input.close();
                    return;
                default:
                    System.out.println("Pilihan yang anda masukan tidak valid!");
                    break;
            }
        }
    }

    public static void applyJob(Scanner input, ArrayList<Job> jobs, String userId, ArrayList<Users> users) {
        System.out.println("-- BERIKUT DAFTAR PEKERJAAN YANG DAPAT ANDA LAMAR --");

        for (int i = 0; i < jobs.size(); i++) {
            Job job = jobs.get(i);
            System.out.println((i + 1) + ". " + job.getJobTitle() + " - " + job.getCompanyName());
        }

        System.out.print("\nSilahkan masukan pilihan anda: ");
        int choice = input.nextInt();
        input.nextLine();

        List<String[]> userDetail = UsersList(users, userId);
        if (userDetail.size() > 0) {
            System.out.println("\n--Hasil Lamaran Anda--");
            for (String[] user : userDetail) {
                System.out.println("Name\t\t: " + user[1]);
                System.out.println("University\t: " + user[3]);
                System.out.println("Faculty\t\t: " + user[4]);
                System.out.println("GPA\t\t: " + user[5]);
            }
        }

        if (choice > 0 && choice <= jobs.size()) {
            Job selectedJob = jobs.get(choice - 1);
            System.out.println("Job Title\t: " + selectedJob.getJobTitle());
            System.out.println("Company\t\t: " + selectedJob.getCompanyName());
        }
    }

}
