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
}
