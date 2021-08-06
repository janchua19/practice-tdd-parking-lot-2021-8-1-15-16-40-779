import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    private int occupiedSlot = 0;
    private final int maximumCapacity = 10;

    public ParkingTicket park(Car car) {
        if(maximumCapacity < occupiedSlot) {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkedPosition.put(parkingTicket, car);
            return parkingTicket;
        }
        return null;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkedPosition.remove(parkingTicket);
    }
}
