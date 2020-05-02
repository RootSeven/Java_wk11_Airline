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

//    public int seatingArrangementBubbleSort(Flight flight){
//        ArrayList<Passenger> flightPassengers = flight.getBookedPassengers();
//
//        // set pointerA at 1
//        // set pointerB at 2
//        // IF pointerA > pointerB
//        // swap
//        // move both on
//    }

}
