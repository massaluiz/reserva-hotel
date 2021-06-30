package services;

import enums.CustomerTypeEnum;
import models.Booking;
import models.Hotel;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HotelBusiness {

    private ArrayList<Hotel> hotels = new ArrayList<>();
    private Hotel betterCostHotel = new Hotel();
    private Double bookingCost = Double.valueOf(0);;

    public HotelBusiness() {

        //Abstração de uma consulta no banco de dados (ORM or DAO Layer):
        //Lakewood
        Hotel lakeWood = new Hotel();
        lakeWood.setName("Lakewood");
        lakeWood.setRate(3);
        lakeWood.setWeekdayRegularTax(Double.valueOf(110));
        lakeWood.setWeekdayRewardTax(Double.valueOf(80));
        lakeWood.setWeekendRegularTax(Double.valueOf(90));
        lakeWood.setWeekendRewardTax(Double.valueOf(80));

        //Bridgewood
        Hotel bridgeWood = new Hotel();
        bridgeWood.setName("Bridgewood");
        bridgeWood.setRate(4);
        bridgeWood.setWeekdayRegularTax(Double.valueOf(160));
        bridgeWood.setWeekdayRewardTax(Double.valueOf(110));
        bridgeWood.setWeekendRegularTax(Double.valueOf(60));
        bridgeWood.setWeekendRewardTax(Double.valueOf(50));

        //Ridgewood
        Hotel ridgewood = new Hotel();
        ridgewood.setName("Ridgewood");
        ridgewood.setRate(5);
        ridgewood.setWeekdayRegularTax(Double.valueOf(220));
        ridgewood.setWeekdayRewardTax(Double.valueOf(100));
        ridgewood.setWeekendRegularTax(Double.valueOf(150));
        ridgewood.setWeekendRewardTax(Double.valueOf(40));

        this.hotels.add(lakeWood);
        this.hotels.add(bridgeWood);
        this.hotels.add(ridgewood);

    }

    public String verifyBetterCost(Booking booking) {


        for (Hotel hotel: this.hotels) {

            Double sumOfCost = Double.valueOf(0);

            if(booking.getCustomerTypeEnum().equals(CustomerTypeEnum.REGULAR)) {

                for (LocalDate date: booking.getBookingDates()) {

                    if(isWeekDay(date)) {
                        sumOfCost =+ hotel.getWeekdayRegularTax();
                    } else {
                        sumOfCost =+ hotel.getWeekendRegularTax();
                    }

                }

            } else {

                for (LocalDate date: booking.getBookingDates()) {

                    if(isWeekDay(date)) {
                        sumOfCost =+ hotel.getWeekdayRewardTax();
                    } else {
                        sumOfCost =+ hotel.getWeekendRewardTax();
                    }

                }

            }

            if(this.bookingCost.equals(Double.valueOf(0))) {
                this.betterCostHotel = hotel;
                this.bookingCost = sumOfCost;
            } else {
                if(this.bookingCost > sumOfCost) {
                    this.betterCostHotel = hotel;
                    this.bookingCost = sumOfCost;
                } else if (this.bookingCost.equals(sumOfCost)) {
                    if(this.betterCostHotel.getRate() > hotel.getRate()) {
                        this.betterCostHotel = hotel;
                        this.bookingCost = sumOfCost;
                    }
                }
            }

        }

        return this.betterCostHotel.getName();
    }

    private boolean isWeekDay(LocalDate date) {

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
