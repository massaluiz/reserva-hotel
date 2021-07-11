package models;

import enums.CustomerTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
public class Booking {

    private CustomerTypeEnum customerTypeEnum;
    private ArrayList<Calendar> bookingDates;
    private int weekendDays = 0;
    private int weekDays = 0;

    public Booking(CustomerTypeEnum customerTypeEnum, List<Calendar> bookingDates) throws Exception {

        if (verifyBookingCustomerType(customerTypeEnum) && verifyBookingHasDates(bookingDates)) {

            for (Calendar date : bookingDates) {
                if (isWeekDay(date)) {
                    this.weekDays = this.weekDays + 1;
                } else {
                    this.weekendDays = this.weekendDays + 1;
                }
            }

            this.bookingDates = (ArrayList<Calendar>) bookingDates;
            this.customerTypeEnum = customerTypeEnum;

        } else {
            throw new Exception("Booking is invalid");
        }

    }

    public boolean isWeekDay(Calendar date) {
        return !(date.get(Calendar.DAY_OF_WEEK) == 7 || date.get(Calendar.DAY_OF_WEEK) == 1);
    }

    public boolean verifyBookingCustomerType(CustomerTypeEnum customerTypeEnum) {
        return customerTypeEnum != null;
    }

    public boolean verifyBookingHasDates(List<Calendar> bookingDates) {
        return !bookingDates.isEmpty();
    }

}
