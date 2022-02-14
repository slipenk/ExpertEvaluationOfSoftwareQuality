package sample.models;

import java.util.Random;

public class QCoefficientTableData {
    private String expertType;
    Random random = new Random();
    private int absoluteValue = random.nextInt(5) + 5;
    private double relativeValue = absoluteValue / 10.0;

    public QCoefficientTableData(String expertType) {
        this.expertType = expertType;
    }

    public String getExpertType() {
        return expertType;
    }

    public void setExpertType(String expertType) {
        this.expertType = expertType;
    }

    public int getAbsoluteValue() {
        return absoluteValue;
    }

    public void setAbsoluteValue(int absoluteValue) {
        this.absoluteValue = absoluteValue;
    }

    public double getRelativeValue() {
        return relativeValue;
    }

    public void setRelativeValue(double relativeValue) {
        this.relativeValue = relativeValue;
    }
}
