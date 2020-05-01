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
        return (flight.getPlane().getPlaneType().getTotalWeight()) - (this.totalBaggageWeight(flight));
    }
}
