package utils;

import java.util.ArrayList;

import ApplyJob.Job;

public class ValidateChoice {
    private String result;

    public ValidateChoice() {
        this.result = "";
    }

    public String checkChoice(int numbers, ArrayList<Job> jobs) {
        if (numbers < 1 || numbers > jobs.size()) {
            result = "Pekerjaan yang anda pilih tidak valid!";
        }

        return result;
    }
}
