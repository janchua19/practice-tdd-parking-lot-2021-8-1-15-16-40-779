import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    private Car car = new Car();
    private int capacity;
    private int occupied;
    private int available;
    private final int MAX_CAPACITY = 10;

    public ParkingLot()
    {
        this.capacity = MAX_CAPACITY;
        this.available = available;
        this.occupied = occupied;
    }

    public ParkingLot(int capacity){
        this.capacity = capacity;
        this.available = available;
        this.occupied = occupied;
    }

    public ParkingLot(int capacity, int occupied){
        this.capacity = capacity;
        this.occupied = occupied;
        this.available = available;
    }


    public ParkingTicket park(Car car){
        ParkingTicket parkingTicket = new ParkingTicket();
        available = getAvailable();

        if(parkedPosition.size() == capacity || occupied == capacity) {
            throw new NoAvailablePosition();
        }
        else {
                parkedPosition.put(parkingTicket, car);
        }
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket){
        car = parkedPosition.get(parkingTicket);

        if(isUnrecognizedTicket(parkingTicket))
        {
            throw new UnrecognizedParkingTicketException();
        }
        final Car car = parkedPosition.get(parkingTicket);
        parkedPosition.remove(parkingTicket);
        return car;
    }

    public int getAvailable(){
        return capacity - occupied;
    }

    public boolean isUnrecognizedTicket(ParkingTicket parkingTicket) {
        return !parkedPosition.containsKey(parkingTicket);
    }
}
