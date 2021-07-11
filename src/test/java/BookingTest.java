import enums.CustomerTypeEnum;
import models.Booking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Util;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BookingTest {

    ArrayList<Calendar> genericDatesForTest;

    @BeforeEach
    void init() {

        Calendar date1 = Util.getCalendar(5, 7,2021);
        Calendar date2 = Util.getCalendar(6, 7,2021);
        Calendar date3 = Util.getCalendar(7, 7,2021);
        Calendar date4 = Util.getCalendar(8, 7,2021);
        Calendar date5 = Util.getCalendar(9, 7,2021);
        Calendar date6 = Util.getCalendar(10, 7,2021);

        genericDatesForTest = new ArrayList<>();
        genericDatesForTest.add(date1);
        genericDatesForTest.add(date2);
        genericDatesForTest.add(date3);
        genericDatesForTest.add(date4);
        genericDatesForTest.add(date5);
        genericDatesForTest.add(date6);

    }

    @Test
    void shouldThrowExceptionWhenCustomerTypeBookingIsNull() {

        String expectedMessage = "Booking is invalid";
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            Booking booking = new Booking(null, genericDatesForTest);
        });

        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void shouldThrowExceptionWhenBookingDatesIsEmpty() {

        List<Calendar> bookingDates = new ArrayList<>();
        String expectedMessage = "Booking is invalid";

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            Booking booking = new Booking(CustomerTypeEnum.REGULAR, bookingDates);
        });

        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void shouldBuildBookingWithRegularCustomerType() throws Exception {

        Booking booking = new Booking(CustomerTypeEnum.REGULAR, genericDatesForTest);

        Assertions.assertEquals(CustomerTypeEnum.REGULAR, booking.getCustomerTypeEnum());
        Assertions.assertEquals(5, booking.getWeekDays());
        Assertions.assertEquals(1, booking.getWeekendDays());

    }

    @Test
    void shouldBuildBookingWithVipCustomerType() throws Exception {

        Booking booking = new Booking(CustomerTypeEnum.REWARD, genericDatesForTest);

        Assertions.assertEquals(CustomerTypeEnum.REWARD, booking.getCustomerTypeEnum());
        Assertions.assertEquals(5, booking.getWeekDays());
        Assertions.assertEquals(1, booking.getWeekendDays());

    }

    @Test
    void shouldReturnIsAWeekendDay() throws Exception {

        Calendar date = Util.getCalendar(11, 7, 2021);

        Booking booking = new Booking(CustomerTypeEnum.REWARD, genericDatesForTest);

        Assertions.assertFalse(booking.isWeekDay(date));

    }

    @Test
    void shouldReturnIsAWeekendDay2() throws Exception {

        Calendar date = Util.getCalendar(10, 7, 2021);

        Booking booking = new Booking(CustomerTypeEnum.REWARD, genericDatesForTest);

        Assertions.assertFalse(booking.isWeekDay(date));

    }

    @Test
    void shouldReturnIsAWeekDay() throws Exception {

        Calendar date = Util.getCalendar(6, 7, 2021);

        Booking booking = new Booking(CustomerTypeEnum.REWARD, genericDatesForTest);

        Assertions.assertTrue(booking.isWeekDay(date));

    }

    @Test
    void shouldReturnIsAWeekDay2() throws Exception {

        Calendar date = Util.getCalendar(5, 7, 2021);

        Booking booking = new Booking(CustomerTypeEnum.REWARD, genericDatesForTest);

        Assertions.assertTrue(booking.isWeekDay(date));

    }
}
