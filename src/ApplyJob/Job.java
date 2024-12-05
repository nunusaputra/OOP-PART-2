package ApplyJob;

public class Job<T, U> {
    private T id;
    private U jobTitle;
    private U companyName;

    public Job() {
        super();
    }

    public Job(T id, U jobTitle, U companyName) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
    }

    public T getId() {
        return id;
    }

    public U getJobTitle() {
        return jobTitle;
    }

    public U getCompanyName() {
        return companyName;
    }

}
