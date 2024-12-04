package Login;

public class Applicant extends Users {
    private String university;
    private String faculty;
    private double gpa;

    public Applicant(int id, String name, String email, String password, String university, String faculty,
            double gpa) {
        super(id, name, email, password);
        this.university = university;
        this.faculty = faculty;
        this.gpa = gpa;
    }

    public String getUniversity() {
        return university;
    }

    public String getFaculty() {
        return faculty;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public void showInfo() {
        System.out.println("Name\t\t: " + getName());
        System.out.println("Name\t\t: " + getEmail());
        System.out.println("University\t: " + getUniversity());
        System.out.println("Faculty\t\t: " + getFaculty());
        System.out.println("GPA\t\t: " + getGpa());
    }

}
