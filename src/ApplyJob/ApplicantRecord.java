package ApplyJob;

import Login.Applicant;

public class ApplicantRecord {
    private Applicant<String, Double> applicant;
    private Job<Integer, String> job;
    private String status;

    public ApplicantRecord(Applicant<String, Double> applicant, Job<Integer, String> job) {
        this.applicant = applicant;
        this.job = job;
        this.status = "waiting";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Applicant<String, Double> getApplicant() {
        return applicant;
    }

    public Job<Integer, String> getJob() {
        return job;
    }
}
