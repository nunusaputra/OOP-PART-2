package Login;

public class Company<U> extends Users<Integer, String> {
    private U address;
    private U telphone;

    public Company(int id, String name, String email, String password, U address, U telphone) {
        super(id, name, email, password);
        this.address = address;
        this.telphone = telphone;
    }

    public U getAddress() {
        return address;
    }

    public U getTelphone() {
        return telphone;
    }

    @Override
    public void showInfo() {
        System.out.println("Name\t\t: " + getName());
        System.out.println("Email\t\t: " + getEmail());
        System.out.println("Address\t: " + getAddress());
        System.out.println("Telphone\t: " + getTelphone());
    }

}
