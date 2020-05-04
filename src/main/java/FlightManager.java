import java.lang.reflect.Array;
import java.util.ArrayList;

public class FlightManager {

    public int baggagePerPassenger(Flight flight) {
        return (flight.getPlane().getPlaneType().getTotalWeight()) / (flight.getPlane().getPlaneType().getCapacity());
    }

    public int totalBaggageWeight(Flight flight) {
        int totalBaggageWeight = 0;
        for ( Passenger passenger : flight.getBookedPassengers() ){
            totalBaggageWeight += passenger.getNumberOfBags();
        }
        return totalBaggageWeight;
    }

    public int remainingBaggageWeight(Flight flight) {
        return ((flight.getPlane().getPlaneType().getTotalWeight())/2) - (this.totalBaggageWeight(flight));
    }

    public void bubbleSortPassengerSeats(Flight flight){
        ArrayList<Passenger> passengerList = flight.getBookedPassengers();

        int n = passengerList.size();
        for ( int i = 0; i < n - 1; i++ ){
            for ( int j = 0; j < n - i - 1; j++){
                if ( passengerList.get(j).getSeatNumber() > passengerList.get(j + 1).getSeatNumber() ){
                    Passenger temp = passengerList.get(j);
                    passengerList.set(j, passengerList.get(j + 1));
                    passengerList.set(j + 1, temp);
                }
            }
        }

    }

//    public Passenger searchForPassengerBySeat(Flight flight, int passengerSeatNumber) {
//        bubbleSortPassengerSeats(flight);
//        ArrayList<Passenger> passengerList = flight.getBookedPassengers();
//
//        int rightPointer = passengerList.size();
//        int leftPointer = 0;
//
//        while (leftPointer <= rightPointer){
//            int midpoint = (leftPointer + (rightPointer - leftPointer))/2;
//
//            if (passengerList.get(midpoint).getSeatNumber() == passengerSeatNumber){
//                return passengerList.get(midpoint);
//            }
//
//            if (passengerList.get(midpoint).getSeatNumber() > passengerSeatNumber){
//                leftPointer = midpoint + 1;
//            } else {
//                leftPointer = midpoint - 1;
//            }
//        }
//        Passenger noPassenger = new Passenger("NONE", -1);
//        return noPassenger;
//    }


}
