import enums.CustomerTypeEnum;
import models.Booking;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.HotelBusiness;

import java.time.LocalDate;
import java.util.ArrayList;

public class HotelBusinessTest {

    private Booking simpleBooking = new Booking();
    private Booking isBridgewoodBooking = new Booking();
    private Booking isRidgewoodBooking = new Booking();



    @Before
    public void init() {

        //Mock Dates
        LocalDate date1 = LocalDate.of(2009, 03, 16);
        LocalDate date2 = LocalDate.of(2009, 03, 17);
        LocalDate date3 = LocalDate.of(2009, 03, 18);

        LocalDate date4 = LocalDate.of(2009, 03, 20);
        LocalDate date5 = LocalDate.of(2009, 03, 21);
        LocalDate date6 = LocalDate.of(2009, 03, 22);

        LocalDate date7 = LocalDate.of(2009, 03, 26);
        LocalDate date8 = LocalDate.of(2009, 03, 27);
        LocalDate date9 = LocalDate.of(2009, 03, 28);


        //Simple Booking
        simpleBooking.setCustomerTypeEnum(CustomerTypeEnum.REGULAR);
        ArrayList<LocalDate> bookingDates = new ArrayList<>();
        bookingDates.add(date1);
        bookingDates.add(date2);
        bookingDates.add(date3);
        simpleBooking.setBookingDates(bookingDates);


        //Is Bridgewood Booking
        isBridgewoodBooking.setCustomerTypeEnum(CustomerTypeEnum.REGULAR);
        ArrayList<LocalDate> bridgewoodBookingDates = new ArrayList<>();
        bridgewoodBookingDates.add(date4);
        bridgewoodBookingDates.add(date5);
        bridgewoodBookingDates.add(date6);
        isBridgewoodBooking.setBookingDates(bridgewoodBookingDates);

        //Is Ridgewood Booking
        isRidgewoodBooking.setCustomerTypeEnum(CustomerTypeEnum.REWARD);
        ArrayList<LocalDate> ridgewoodBookingDates = new ArrayList<>();
        ridgewoodBookingDates.add(date7);
        ridgewoodBookingDates.add(date8);
        ridgewoodBookingDates.add(date9);
        isRidgewoodBooking.setBookingDates(ridgewoodBookingDates);

    }


    @Test
    public void isLakewood() {
        HotelBusiness hotelBusiness = new HotelBusiness();
        Assert.assertEquals("Lakewood", hotelBusiness.verifyBetterCost(simpleBooking));
    }

    @Test
    public void isBridgewood() {
        HotelBusiness hotelBusiness = new HotelBusiness();
        Assert.assertEquals("Bridgewood", hotelBusiness.verifyBetterCost(isBridgewoodBooking));
    }

    @Test
    public void isRidgewood() {
        HotelBusiness hotelBusiness = new HotelBusiness();
        Assert.assertEquals("Ridgewood", hotelBusiness.verifyBetterCost(isRidgewoodBooking));
    }



}
