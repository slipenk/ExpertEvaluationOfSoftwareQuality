package sample.models;

import java.util.Random;

public class ExpertsMarksData {
    private String criteriaTitle;
    private Random random = new Random();
    private int industryExpertMark = random.nextInt(10 - 3) + 3;
    private int usabilityExpertMark = random.nextInt(10 - 3) + 3;
    private int programmingExpertMark = random.nextInt(10 - 3) + 3;
    private String usersMark;



    public ExpertsMarksData(String criteriaTitle,String usersMark) {
        this.criteriaTitle = criteriaTitle;
        this.usersMark = usersMark;
    }

    public String getCriteriaTitle() {
        return criteriaTitle;
    }

    public void setCriteriaTitle(String criteriaTitle) {
        this.criteriaTitle = criteriaTitle;
    }

    public int getIndustryExpertMark() {
        return industryExpertMark;
    }

    public void setIndustryExpertMark(int industryExpertMark) {
        this.industryExpertMark = industryExpertMark;
    }

    public int getUsabilityExpertMark() {
        return usabilityExpertMark;
    }

    public void setUsabilityExpertMark(int usabilityExpertMark) {
        this.usabilityExpertMark = usabilityExpertMark;
    }

    public int getProgrammingExpertMark() {
        return programmingExpertMark;
    }

    public void setProgrammingExpertMark(int programmingExpertMark) {
        this.programmingExpertMark = programmingExpertMark;
    }

    public String getUsersMark() {
        return usersMark;
    }

    public void setUsersMark(String usersMark) {
        this.usersMark = usersMark;
    }
}
