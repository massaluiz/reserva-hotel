package models;

import java.math.BigDecimal;

public class Hotel {

    private String name;
    private Integer rate;
    private Double weekdayRegularTax;
    private Double weekendRegularTax;
    private Double weekdayRewardTax;
    private Double weekendRewardTax;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Double getWeekdayRegularTax() {
        return weekdayRegularTax;
    }

    public void setWeekdayRegularTax(Double weekdayRegularTax) {
        this.weekdayRegularTax = weekdayRegularTax;
    }

    public Double getWeekendRegularTax() {
        return weekendRegularTax;
    }

    public void setWeekendRegularTax(Double weekendRegularTax) {
        this.weekendRegularTax = weekendRegularTax;
    }

    public Double getWeekdayRewardTax() {
        return weekdayRewardTax;
    }

    public void setWeekdayRewardTax(Double weekdayRewardTax) {
        this.weekdayRewardTax = weekdayRewardTax;
    }

    public Double getWeekendRewardTax() {
        return weekendRewardTax;
    }

    public void setWeekendRewardTax(Double weekendRewardTax) {
        this.weekendRewardTax = weekendRewardTax;
    }
}
