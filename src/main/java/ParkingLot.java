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
//       THIS BLOCK OF CODES ARE FOR STORY 1 CASE 4 AND 5 (IF YOU WISH TO MAKE IT RUN COMMENT THE REMAINING CODES BELOW AND UNCOMMENT THIS BLOCK
//        if(ticket == null)
//        {
//            return null;
//        }
//        else {
//            ticketList.add(car);
//        }
//        return parkedPosition.get(parkingTicket);

        if(isUnrecognizedTicket(parkingTicket))
        {
            throw new UnrecognizedParkingTicketException();
        }
        final Car car = parkedPosition.get(parkingTicket);
        parkedPosition.remove(parkingTicket);
        return car;
    }

    private boolean isUnrecognizedTicket(ParkingTicket parkingTicket) {
        return !parkedPosition.containsKey(parkingTicket);
    }
}
