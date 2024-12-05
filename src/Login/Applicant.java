package Login;

public class Applicant<V, W> extends Users<Integer, String> {
    private V university;
    private V faculty;
    private W gpa;

    public Applicant(Integer id, String name, String email, String password, V university, V faculty,
            W gpa) {
        super(id, name, email, password);
        this.university = university;
        this.faculty = faculty;
        this.gpa = gpa;
    }

    public V getUniversity() {
        return university;
    }

    public V getFaculty() {
        return faculty;
    }

    public W getGpa() {
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
