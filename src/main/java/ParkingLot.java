import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    private ArrayList<Car> ticketList = new ArrayList<Car>();
    private Car car = new Car();
    private Car ticket = new Car();
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public ParkingLot()
    {
        this.capacity = DEFAULT_CAPACITY;
    }

    public ParkingLot(int capacity){
        this.capacity = capacity;
    }

    public ParkingTicket park(Car car){
        ParkingTicket parkingTicket = new ParkingTicket();

        if(parkedPosition.size() == capacity) {
            return null;
        }
        else {
            parkedPosition.put(parkingTicket, car);
        }
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket){
        car = parkedPosition.get(parkingTicket);
        ticket = ticketList.contains(car) ? null : parkedPosition.get(parkingTicket);

        if(ticket == null)
        {
            return null;
        }
        else {
            ticketList.add(car);
        }

        return parkedPosition.get(parkingTicket);
    }


//    private Car car;
//    private Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
//    private int occupiedSlot = 0;
//    private final int maximumCapacity = 10;
//
//    public ParkingTicket park(Car car) {
//        if(maximumCapacity < occupiedSlot) {
//            ParkingTicket parkingTicket = new ParkingTicket();
//            parkedPosition.put(parkingTicket, car);
//            return parkingTicket;
//        }
//        return null;
//    }
//
//    public Car fetch(ParkingTicket parkingTicket) {
//        return parkedPosition.remove(parkingTicket);
//    }
}
