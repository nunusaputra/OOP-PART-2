package ApplyJob;

public class Job {
    private int id;
    private String jobTitle;
    private String companyName;

    public Job(int id, String jobTitle, String companyName) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

}
