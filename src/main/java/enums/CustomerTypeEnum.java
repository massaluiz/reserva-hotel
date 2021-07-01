package enums;

import models.Booking;
import models.Hotel;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public enum CustomerTypeEnum {

    REGULAR("Regular") {
        @Override
        public double sumCost(Booking booking, Hotel hotel, double actualCost) {

            double sumOfCost = actualCost;

            for (LocalDate date: booking.getBookingDates()) {

                if(isWeekDay(date)) {
                    sumOfCost =+ hotel.getWeekdayRegularTax();
                } else {
                    sumOfCost =+ hotel.getWeekendRegularTax();
                }

            }
            return sumOfCost;
        }
    },
    REWARD("Reward") {
        @Override
        public double sumCost(Booking booking, Hotel hotel, double actualCost) {

            double sumOfCost = actualCost;

            for (LocalDate date: booking.getBookingDates()) {

                if(isWeekDay(date)) {
                    sumOfCost =+ hotel.getWeekdayRewardTax();
                } else {
                    sumOfCost =+ hotel.getWeekendRewardTax();
                }

            }
            return sumOfCost;
        }
    };

    private String descricao;

    CustomerTypeEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract double sumCost(Booking booking, Hotel hotel, double actualCost);

    public boolean isWeekDay(LocalDate date) {

        Date date1 = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);
        if ((c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
            return false;
        }else {
            return true;
        }

    }

}