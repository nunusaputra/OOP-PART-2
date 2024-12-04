package ApplyJob;

import Login.Applicant;

interface ApplyJobInterfaces {
    public void displayJob();

    public void addApplicant(Applicant applicant);

    public void addJob(Job job);

    public void addApplicantRecord(Applicant applicant, Job job);

    public void updateStatus(Applicant applicant, Job job, String newStatus);

}