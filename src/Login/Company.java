package Login;

public class Company extends Users {
    private String address;
    private String telphone;

    public Company(int id, String name, String email, String password, String address, String telphone) {
        super(id, name, email, password);
        this.address = address;
        this.telphone = telphone;
    }

    public String getAddress() {
        return address;
    }

    public String getTelphone() {
        return telphone;
    }

    @Override
    public void showInfo() {
        System.out.println("Name\t\t: " + getName());
        System.out.println("Address\t: " + getAddress());
        System.out.println("Telphone\t: " + getTelphone());
    }
}
