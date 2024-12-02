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

        loginUsers(input, login, applyJob);
    }

    public static void loginUsers(Scanner input, LoginValidate login, ApplyJob applyJob) {
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
            applyJob.menu(input);
            applyJob.applyJob(input, userId);
        }

    }

    // public static void login(Scanner input, ArrayList<Users> users, ApplyJob
    // applyJob) {
    // System.out.print("\nMasukan email anda\t: ");
    // String loginEmail = input.nextLine();
    // System.out.print("Masukan password anda\t: ");
    // String loginPassword = input.nextLine();

    // String result = checkValidate(users, loginEmail, loginPassword);
    // String userId = result;
    // if (result.equals("Email atau password salah!")) {
    // System.out.println(result);
    // System.out.println("Login Failed");
    // return;
    // } else {
    // System.out.println("Login Berhasil, ID anda - " + userId);
    // applyJob.menu(input);
    // applyJob.applyJob(input);
    // }
    // }

    // public static String checkValidate(ArrayList<Users> data, String email,
    // String password) {
    // String result = "Email atau password salah!";

    // for (Users user : data) {
    // if (user.getEmail().equals(email)) {
    // if (user.validatePassword(password)) {
    // result = String.valueOf(user.getId());
    // }
    // break;
    // }
    // }

    // return result;
    // }

    // public static List<String[]> UsersList(ArrayList<Users> users, String userId)
    // {
    // List<String[]> userDetails = new ArrayList<>();

    // int userIdInt = Integer.parseInt(userId);
    // for (Users user : users) {
    // if (user.getId() == userIdInt) {
    // if (user instanceof Applicant) {
    // Applicant applicant = (Applicant) user;
    // userDetails.add(new String[] {
    // String.valueOf(applicant.getId()),
    // applicant.getName(),
    // applicant.getEmail(),
    // applicant.getUniversity(),
    // applicant.getFaculty(),
    // String.valueOf(applicant.getGpa())
    // });
    // }
    // }
    // }

    // return userDetails;
    // }

    // public static void menu(Scanner input, ArrayList<Job> jobs, String userId,
    // ArrayList<Users> users) {
    // System.out.println("--- SELAMAT DATANG DI APLIKASI JOB PORTAL ---");
    // System.out.println("\nSilahkan Pilih Menu Berikut ini\t: ");
    // System.out.println("1. Lamar Pekerjaan");
    // System.out.println("2. Melihat Daftar Pelamar");
    // System.out.println("2. Manage Status Pelamar");
    // System.out.print("\nSilahkan masukan pilihan anda\t: ");
    // int choice = input.nextInt();
    // input.nextLine();

    // while (true) {
    // switch (choice) {
    // case 1:

    // case 2:
    // System.out.println("Terimakasih sudah menggunakan layanan kami");
    // input.close();
    // return;
    // default:
    // System.out.println("Pilihan yang anda masukan tidak valid!");
    // break;
    // }
    // }
    // }

    // public static void applyJob(Scanner input, ArrayList<Job> jobs, String
    // userId, ArrayList<Users> users) {
    // System.out.println("-- BERIKUT DAFTAR PEKERJAAN YANG DAPAT ANDA LAMAR --");

    // for (int i = 0; i < jobs.size(); i++) {
    // Job job = jobs.get(i);
    // System.out.println((i + 1) + ". " + job.getJobTitle() + " - " +
    // job.getCompanyName());
    // }

    // System.out.print("\nSilahkan masukan pilihan anda: ");
    // int choice = input.nextInt();
    // input.nextLine();

    // List<String[]> userDetail = UsersList(users, userId);
    // if (userDetail.size() > 0) {
    // System.out.println("\n--Hasil Lamaran Anda--");
    // for (String[] user : userDetail) {
    // System.out.println("Name\t\t: " + user[1]);
    // System.out.println("University\t: " + user[3]);
    // System.out.println("Faculty\t\t: " + user[4]);
    // System.out.println("GPA\t\t: " + user[5]);
    // }
    // }

    // if (choice > 0 && choice <= jobs.size()) {
    // Job selectedJob = jobs.get(choice - 1);
    // System.out.println("Job Title\t: " + selectedJob.getJobTitle());
    // System.out.println("Company\t\t: " + selectedJob.getCompanyName());
    // }
    // }

}