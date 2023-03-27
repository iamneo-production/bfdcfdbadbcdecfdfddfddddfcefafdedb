package services;

import java.time.temporal.ChronoUnit;

import model.Bus;
import model.Flight;
import model.Hotel;
import model.Train;

public class FareCalculator extends Booking{
//Enter code here...
    
    @Override
    public double booking(int noOfPersons, int rates) {
        return super.booking(noOfPersons, rates);
    }
    
    public double book(Hotel hotel) {
        double totalFare = 0.0;
        LocalDate checkInDate = hotel.getFromdate();
        LocalDate checkOutDate = hotel.getTodate();
        int noOfPersons = hotel.getNoOfPersons();
        String roomType = hotel.getRoomType();
        String occupancy = hotel.getOccupancy();
        int rates = hotel.getRates();
        
        if (checkInDate.isAfter(checkOutDate)) {
            System.out.println("Invalid check-in and check-out dates");
        } else if (noOfPersons == 1 && !occupancy.equals("Single")) {
            System.out.println("Single occupancy can be given only for 1 guest");
        } else if (noOfPersons == 3 && !(roomType.equals("Double Occupancy") && occupancy.equals("Single Occupancy"))) {
            System.out.println("If there are 3 guests then the rooms alloted should be 1 Double Occupancy room and 1 Single Occupancy");
        } else {
            totalFare = booking(noOfPersons, rates);
        }
        
        return totalFare;
    }
    
    public double book(Flight flight) {
        double totalFare = 0.0;
        int noOfPersons = flight.getNoOfPersons();
        int rates = flight.getRates();
        LocalDate fromDate = flight.getFrom();
        LocalDate toDate = flight.getTo();
        String tripType = flight.getTriptype();
        
        if (tripType.equalsIgnoreCase("Round")) {
            if (fromDate.isAfter(toDate)) {
                System.out.println("Invalid start date and return date");
            } else {
                totalFare = booking(noOfPersons, rates);
            }
        } else if (tripType.equalsIgnoreCase("One-way")) {
            totalFare = booking(noOfPersons, rates);
        } else {
            System.out.println("Invalid trip type");
        }
        
        return totalFare;
    }
    
    public double book(Train train) {
        int noOfPersons = train.getNoOfPersons();
        int rates = train.getRates();
        String berth = train.getBerth();
        LocalDate date = train.getDate();
        double totalFare = booking(noOfPersons, rates);
        return totalFare;
    }
    
    public double book(Bus bus) {
        int noOfPersons = bus.getNoOfPersons();
        int rates = bus.getRates();
        String busType = bus.getBusType();
        LocalDate date = bus.getDate();
        double totalFare = booking(noOfPersons, rates);
        return totalFare;
    }
}

