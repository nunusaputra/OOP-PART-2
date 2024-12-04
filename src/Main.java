import java.util.Scanner;
import Login.Applicant;
import Login.Company;
import Login.LoginValidate;
import ApplyJob.ApplyJob;
import ApplyJob.Job;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Applicant applicant = new Applicant(1, "Wisnu Saputra", "wisnu@gmail.com", "wisnu123", "Universitas Indonesia",
                "Fasilkom", 3.90);

        Company company = new Company(2, "PT Amartek", "amartek@gmail.com", "amartek123", "Jakarta Selatan",
                "083815499134");

        ApplyJob applyJob = new ApplyJob();
        applyJob.addApplicant(applicant);
        applyJob.addJob(new Job(1, "Frontend Developer", "PT Amartek"));
        applyJob.addJob(new Job(2, "Backend Developer", "PT Amartek"));
        applyJob.addJob(new Job(3, "UI/UX Designer", "PT Amartek"));

        LoginValidate login = new LoginValidate();
        login.addUsers(applicant);
        login.addUsers(company);

        loginUsers(input, applyJob, login);
    }

    public static void menu(Scanner input, ApplyJob applyJob) {
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
                applyJob.displayJob();
                break;
            case 2:
                applyJob.displayApplicantRecord();
                break;
            case 3:
                applyJob.manageStatus(input, applyJob);
                break;
            default:
                System.out.println("Yang bener aje kocak!");
                break;
        }
    }

    public static void loginUsers(Scanner input, ApplyJob applyJob, LoginValidate login) {
        System.out.println("\n-- SILAHKAN MELAKUKAN LOGIN TERLEBIH DAHULU! --");
        System.out.print("Masukan email anda: ");
        String email = input.nextLine();
        System.out.print("Masukan password anda: ");
        String password = input.nextLine();

        String result = login.checkValidate(email, password);
        String userId = result;
        if (result.equals("Email atau pasword salah!")) {
            System.out.println(result);
            System.out.println("Login Failed!");
            return;
        } else {
            System.out.println("Login Berhasil");
            menu(input, applyJob);
            applyJob.applyJob(input, userId, applyJob);
        }

    }
}
