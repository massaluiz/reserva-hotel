package services;

import enums.CustomerTypeEnum;
import models.Booking;
import models.Hotel;

import java.util.*;

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

        Map<Double, Hotel> betterCostHashMap = new HashMap<>();

        for (Hotel hotel: this.hotels) {

            Double sumOfCost = Double.valueOf(0);

            if(booking.getCustomerTypeEnum().equals(CustomerTypeEnum.REGULAR)) {
                sumOfCost = CustomerTypeEnum.REGULAR.sumCost(booking, hotel, sumOfCost);
            } else {
                sumOfCost = CustomerTypeEnum.REWARD.sumCost(booking, hotel, sumOfCost);
            }

            betterCostHashMap.put(sumOfCost, hotel);
        }

        return orderBetterHotelCostAndRate(betterCostHashMap).get(0).getValue().getName();
    }

    public List<Map.Entry<Double, Hotel>> orderBetterHotelCostAndRate(Map<Double, Hotel> betterCostHashMap) {

        List<Map.Entry<Double, Hotel>> listOfCostAndHotels  = new ArrayList<>(betterCostHashMap.entrySet());
        Collections.sort(listOfCostAndHotels, new Comparator<Map.Entry<Double, Hotel>>() {
            @Override
            public int compare(Map.Entry<Double, Hotel> o1, Map.Entry<Double, Hotel> o2) {
                if(o1.getKey().equals(o2.getKey())) {
                    return o1.getValue().getRate().compareTo(o2.getValue().getRate());
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
        return listOfCostAndHotels;
    }

}
