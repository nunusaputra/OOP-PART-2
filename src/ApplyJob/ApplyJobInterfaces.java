package ApplyJob;

import Login.Applicant;

interface ApplyJobInterfaces {
    public void displayJob();

    public void addApplicant(Applicant<String, Double> applicant);

    public void addJob(Job<Integer, String> job);

    public void addApplicantRecord(Applicant<String, Double> applicant, Job<Integer, String> job);

    public void getApplicantResult();

    public void updateStatus(Applicant<String, Double> applicant, Job<Integer, String> job, String newStatus);

}