package enums;

import models.Booking;
import models.Hotel;

public enum CustomerTypeEnum {

    REGULAR() {
        @Override
        public Double sumByCustomerType(Hotel hotel, Booking booking) {
            return (hotel.getWeekdayRegularTax() * booking.getWeekDays()) + (hotel.getWeekendRegularTax() * booking.getWeekendDays());
        }
    },
    REWARD() {
        @Override
        public Double sumByCustomerType(Hotel hotel, Booking booking) {
            return (hotel.getWeekdayRewardTax() * booking.getWeekDays()) + (hotel.getWeekendRewardTax() * booking.getWeekendDays());
        }
    };

    public abstract Double sumByCustomerType(Hotel hotel, Booking booking);
}