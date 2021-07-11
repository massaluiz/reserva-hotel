import enums.CustomerTypeEnum;
import models.Booking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.HotelBusiness;
import util.Util;

import java.util.ArrayList;
import java.util.Calendar;


class HotelBusinessTest {

    @Test
    void shouldReturnLakewood() throws Exception {

        Calendar date1 = Util.getCalendar(16, 03,2020);
        Calendar date2 = Util.getCalendar(17, 03,2020);
        Calendar date3 = Util.getCalendar(18, 03,2020);

        ArrayList<Calendar> bookingDates = new ArrayList<>();
        bookingDates.add(date1);
        bookingDates.add(date2);
        bookingDates.add(date3);

        Booking booking = new Booking(CustomerTypeEnum.REGULAR, bookingDates);

        HotelBusiness hotelBusiness = new HotelBusiness();

        Assertions.assertEquals("Lakewood", hotelBusiness.verifyBetterCost(booking));
    }

    @Test
    void shouldReturnBridgewood() throws Exception {

        Calendar date1 = Util.getCalendar(20, 03,2020);
        Calendar date2 = Util.getCalendar(21, 03,2020);
        Calendar date3 = Util.getCalendar(22, 03,2020);

        ArrayList<Calendar> bookingDates = new ArrayList<>();
        bookingDates.add(date1);
        bookingDates.add(date2);
        bookingDates.add(date3);

        Booking booking = new Booking(CustomerTypeEnum.REGULAR, bookingDates);


        HotelBusiness hotelBusiness = new HotelBusiness();
        Assertions.assertEquals("Bridgewood", hotelBusiness.verifyBetterCost(booking));
    }

    @Test
    void shouldReturnRidgewood() throws Exception {

        Calendar date1 = Util.getCalendar(26, 03,2020);
        Calendar date2 = Util.getCalendar(27, 03,2020);
        Calendar date3 = Util.getCalendar(28, 03,2020);

        ArrayList<Calendar> bookingDates = new ArrayList<>();
        bookingDates.add(date1);
        bookingDates.add(date2);
        bookingDates.add(date3);

        Booking booking = new Booking(CustomerTypeEnum.REWARD, bookingDates);

        HotelBusiness hotelBusiness = new HotelBusiness();
        Assertions.assertEquals("Ridgewood", hotelBusiness.verifyBetterCost(booking));

    }

    @Test
    void shouldReturnRidgewoodForVipCustomerType() throws Exception {

        Calendar date1 = Util.getCalendar(8, 7,2021);
        Calendar date2 = Util.getCalendar(9, 7,2021);
        Calendar date3 = Util.getCalendar(10, 7,2021);
        Calendar date4 = Util.getCalendar(11, 7,2021);

        ArrayList<Calendar> bookingDates = new ArrayList<>();
        bookingDates.add(date1);
        bookingDates.add(date2);
        bookingDates.add(date3);
        bookingDates.add(date4);

        Booking booking = new Booking(CustomerTypeEnum.REWARD, bookingDates);

        HotelBusiness hotelBusiness = new HotelBusiness();
        Assertions.assertEquals("Ridgewood", hotelBusiness.verifyBetterCost(booking));

    }
}
