import enums.CustomerTypeEnum;
import models.Booking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.HotelBusiness;

import java.time.LocalDate;
import java.util.ArrayList;

public class HotelBusinessTest {

    private Booking booking;

    @BeforeEach
    void setUp(){
         booking = new Booking();
    }

    @Test
    public void isLakewood() {

        LocalDate date1 = LocalDate.of(2009, 03, 16);
        LocalDate date2 = LocalDate.of(2009, 03, 17);
        LocalDate date3 = LocalDate.of(2009, 03, 18);

        booking.setCustomerTypeEnum(CustomerTypeEnum.REGULAR);
        ArrayList<LocalDate> bookingDates = new ArrayList<>();
        bookingDates.add(date1);
        bookingDates.add(date2);
        bookingDates.add(date3);
        booking.setBookingDates(bookingDates);

        HotelBusiness hotelBusiness = new HotelBusiness();

        Assertions.assertEquals("Lakewood", hotelBusiness.verifyBetterCost(booking));
    }

    @Test
    public void isBridgewood() {

        LocalDate date1 = LocalDate.of(2009, 03, 20);
        LocalDate date2 = LocalDate.of(2009, 03, 21);
        LocalDate date3 = LocalDate.of(2009, 03, 22);

        booking.setCustomerTypeEnum(CustomerTypeEnum.REGULAR);
        ArrayList<LocalDate> bookingDates = new ArrayList<>();
        bookingDates.add(date1);
        bookingDates.add(date2);
        bookingDates.add(date3);
        booking.setBookingDates(bookingDates);


        HotelBusiness hotelBusiness = new HotelBusiness();
        Assertions.assertEquals("Bridgewood", hotelBusiness.verifyBetterCost(booking));
    }

    @Test
    public void isRidgewoodReward() {

        LocalDate date1 = LocalDate.of(2009, 03, 26);
        LocalDate date2 = LocalDate.of(2009, 03, 27);
        LocalDate date3 = LocalDate.of(2009, 03, 28);

        booking.setCustomerTypeEnum(CustomerTypeEnum.REWARD);
        ArrayList<LocalDate> bookingDates = new ArrayList<>();
        bookingDates.add(date1);
        bookingDates.add(date2);
        bookingDates.add(date3);
        booking.setBookingDates(bookingDates);

        HotelBusiness hotelBusiness = new HotelBusiness();
        Assertions.assertEquals("Ridgewood", hotelBusiness.verifyBetterCost(booking));

    }
}
