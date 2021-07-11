package services;

import enums.CustomerTypeEnum;
import models.Booking;
import models.Hotel;

import java.util.*;

public class HotelBusiness {

    private ArrayList<Hotel> hotels = new ArrayList<>();

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

        for (Hotel hotel : this.hotels) {
            betterCostHashMap.put(sumTax(hotel, booking), hotel);
        }

        return orderBetterHotelCostAndRate(betterCostHashMap).get(0).getValue().getName();
    }

    public Double sumTax(Hotel hotel, Booking booking) {

        Double sumOfCost = Double.valueOf(0);

        for (CustomerTypeEnum customerTypeEnum : CustomerTypeEnum.values()) {
            if (booking.getCustomerTypeEnum().equals(customerTypeEnum)) {
                sumOfCost = customerTypeEnum.sumByCustomerType(hotel, booking);
            }
        }

        return sumOfCost;
    }

    public List<Map.Entry<Double, Hotel>> orderBetterHotelCostAndRate(Map<Double, Hotel> betterCostHashMap) {

        List<Map.Entry<Double, Hotel>> listOfCostAndHotels = new ArrayList<>(betterCostHashMap.entrySet());

        Collections.sort(listOfCostAndHotels, new Comparator<Map.Entry<Double, Hotel>>() {
            @Override
            public int compare(Map.Entry<Double, Hotel> actualValue, Map.Entry<Double, Hotel> nextValue) {
                if (actualValue.getKey().equals(nextValue.getKey())) {
                    return actualValue.getValue().getRate().compareTo(nextValue.getValue().getRate());
                } else {
                    return actualValue.getKey().compareTo(nextValue.getKey());
                }
            }
        });

        return listOfCostAndHotels;
    }

}
