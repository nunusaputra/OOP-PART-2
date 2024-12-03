package Login;

import java.util.ArrayList;
import java.util.Scanner;

import ApplyJob.ApplyJob;

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

    public void loginUsers(Scanner input, ApplyJob applyJob) {
        System.out.println("\n-- SILAHKAN MELAKUKAN LOGIN TERLEBIH DAHULU! --");
        System.out.print("Masukan email anda: ");
        String email = input.nextLine();
        System.out.print("Masukan password anda: ");
        String password = input.nextLine();

        String result = checkValidate(email, password);
        String userId = result;
        if (result.equals("Email atau pasword salah!")) {
            System.out.println(result);
            System.out.println("Login Failed!");
            return;
        } else {
            System.out.println("Login Berhasil");
            applyJob.menu(input, applyJob);
            applyJob.applyJob(input, userId, applyJob);
        }

    }

}
