package models;

import enums.CustomerTypeEnum;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Booking {

    private CustomerTypeEnum customerTypeEnum;
    private ArrayList<LocalDate> bookingDates;
    private int weekendDays = 0;
    private int weekDays = 0;


    public Booking(CustomerTypeEnum customerTypeEnum, List<LocalDate> bookingDates) {

        for (LocalDate date: bookingDates) {
            if(isWeekDay(date)) {
                this.weekDays = this.weekendDays + 1;
            } else {
                this.weekendDays = this.weekendDays + 1;
            }
        }

        this.customerTypeEnum = customerTypeEnum;

    }

    public CustomerTypeEnum getCustomerTypeEnum() {
        return customerTypeEnum;
    }

    public void setCustomerTypeEnum(CustomerTypeEnum customerTypeEnum) {
        this.customerTypeEnum = customerTypeEnum;
    }

    public List<LocalDate> getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(List<LocalDate> bookingDates) {
        this.bookingDates = (ArrayList<LocalDate>) bookingDates;
    }

    public Integer getWeekendDays() {
        return weekendDays;
    }

    public void setWeekendDays(Integer weekendDays) {
        this.weekendDays = weekendDays;
    }

    public Integer getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(Integer weekDays) {
        this.weekDays = weekDays;
    }

    public boolean isWeekDay(LocalDate date) {

        Date date1 = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);
        return !((c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY));

    }
}
