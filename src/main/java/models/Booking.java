package models;

import enums.CustomerTypeEnum;

import java.time.LocalDate;
import java.util.ArrayList;

public class Booking {

    private CustomerTypeEnum customerTypeEnum;
    private ArrayList<LocalDate> bookingDates;

    public CustomerTypeEnum getCustomerTypeEnum() {
        return customerTypeEnum;
    }

    public void setCustomerTypeEnum(CustomerTypeEnum customerTypeEnum) {
        this.customerTypeEnum = customerTypeEnum;
    }

    public ArrayList<LocalDate> getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(ArrayList<LocalDate> bookingDates) {
        this.bookingDates = bookingDates;
    }
}
