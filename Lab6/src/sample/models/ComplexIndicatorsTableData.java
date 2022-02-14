package sample.models;

public class ComplexIndicatorsTableData {
    private String evaluationCriteria;
    private int industryExpertMark;
    private int usabilityExpertMark;
    private int programmingExpertMark;
    private double userMark;
    private double avgSum;
    private double avgXi;

    public ComplexIndicatorsTableData(String evaluationCriteria, int industryExpertMark, int usabilityExpertMark, int programmingExpertMark, double userMark, double avgSum, double avgXi) {
        this.evaluationCriteria = evaluationCriteria;
        this.industryExpertMark = industryExpertMark;
        this.usabilityExpertMark = usabilityExpertMark;
        this.programmingExpertMark = programmingExpertMark;
        this.userMark = userMark;
        this.avgSum = avgSum;
        this.avgXi = avgXi;
    }

    public String getEvaluationCriteria() {
        return evaluationCriteria;
    }

    public void setEvaluationCriteria(String evaluationCriteria) {
        this.evaluationCriteria = evaluationCriteria;
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

    public double getUserMark() {
        return userMark;
    }

    public void setUserMark(double userMark) {
        this.userMark = userMark;
    }

    public double getAvgSum() {
        return avgSum;
    }

    public void setAvgSum(double avgSum) {
        this.avgSum = avgSum;
    }

    public double getAvgXi() {
        return avgXi;
    }

    public void setAvgXi(double avgXi) {
        this.avgXi = avgXi;
    }
}
