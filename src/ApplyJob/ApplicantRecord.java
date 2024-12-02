package ApplyJob;

import Login.Applicant;

public class ApplicantRecord {
    private Applicant applicant;
    private Job job;
    private String status;

    public ApplicantRecord(Applicant applicant, Job job) {
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

    public Applicant getApplicant() {
        return applicant;
    }

    public Job getJob() {
        return job;
    }
}
