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
