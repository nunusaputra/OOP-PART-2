package Login;

public abstract class Users<T, U> {
    private T id;
    private U name;
    private U email;
    private U password;

    public Users(T id, U name, U email, U password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public T getId() {
        return id;
    }

    public U getName() {
        return name;
    }

    public U getEmail() {
        return email;
    }

    public boolean validatePassword(U password) {
        return this.password.equals(password);
    }

    public abstract void showInfo();
}
