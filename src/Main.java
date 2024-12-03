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

        login.loginUsers(input, applyJob);
    }
}
