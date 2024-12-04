package Login;

import java.util.ArrayList;

public class LoginValidate {
    private ArrayList<Users> users;

    public LoginValidate() {
        users = new ArrayList<>();
    }

    public void addUsers(Users user) {
        users.add(user);
    }

    public String checkValidate(String email, String password) {
        String result = "Email atau password anda salah!";
        for (Users user : users) {
            if (user.getEmail().equals(email)) {
                if (user.validatePassword(password)) {
                    result = String.valueOf(user.getId());
                }
                break;
            }
        }
        return result;
    }

}
