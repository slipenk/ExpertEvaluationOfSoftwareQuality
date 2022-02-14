package sample.models;

import java.util.Random;

public class ValidityTableData {
    private int number;
    private String title;
    private Random random = new Random();
    private int industryExpert = random.nextInt(5) + 5;
    private int usabilityExpert = random.nextInt(5) + 5;
    private int programmingExpert = random.nextInt(5) + 5;
    private int usersExpert = random.nextInt(5) + 5;

    public ValidityTableData(int number, String validityTitle) {
        this.number = number;
        title = validityTitle;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIndustryExpert() {
        return industryExpert;
    }

    public void setIndustryExpert(int industryExpert) {
        this.industryExpert = industryExpert;
    }

    public int getUsabilityExpert() {
        return usabilityExpert;
    }

    public void setUsabilityExpert(int usabilityExpert) {
        this.usabilityExpert = usabilityExpert;
    }

    public int getProgrammingExpert() {
        return programmingExpert;
    }

    public void setProgrammingExpert(int programmingExpert) {
        this.programmingExpert = programmingExpert;
    }

    public int getUsersExpert() {
        return usersExpert;
    }

    public void setUsersExpert(int usersExpert) {
        this.usersExpert = usersExpert;
    }
}
