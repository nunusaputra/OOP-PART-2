package ApplyJob;

import Login.Applicant;

interface JobInterfaces {
    public void displayJob();

    public void updateStatus(Applicant applicant, Job job, String newStatus);

}